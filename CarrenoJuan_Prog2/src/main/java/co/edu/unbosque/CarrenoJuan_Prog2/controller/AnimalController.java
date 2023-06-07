package co.edu.unbosque.CarrenoJuan_Prog2.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.edu.unbosque.CarrenoJuan_Prog2.model.Animal;
import co.edu.unbosque.CarrenoJuan_Prog2.repository.AnimalRepository;

@Controller
@RequestMapping
public class AnimalController {
	@Autowired
	private AnimalRepository arep;
	
	@GetMapping("/listanimales")
	public String listar(Model model) {
		List<Animal> animales = (List<Animal>) arep.findAll();
		model.addAttribute("animales", animales);
		return "animal";
	}
	
	@GetMapping("/newanimal")
	public String agregar(Model model) {
		model.addAttribute("animal", new Animal());
		return "formanimal";
	}
	
	@PostMapping("/saveanimal")
	public String save(@Valid Animal a, Model model, @RequestParam("file") MultipartFile foto) {
		if(!foto.isEmpty()) {
			Path directorio = Paths.get("src//main//resources//static/images");
			String ruta_absoluta = directorio.toFile().getAbsolutePath();
			
			try {
				byte[] bytes_foto = foto.getBytes();
				Path ruta_completa = Paths.get(ruta_absoluta + "//" + foto.getOriginalFilename());
				Files.write(ruta_completa, bytes_foto);
				a.setFoto(foto.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		arep.save(a);
		return "redirect:/listanimales";
	}
	
	@GetMapping("/editaranimal/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Animal> animal = arep.findById(id);
		model.addAttribute("animal", animal);
		return "formanimal";
	}
	
	@GetMapping("/eliminaranimal/{id}")
	public String delete(Model model, @PathVariable int id) {
		arep.deleteById(id);
		return "redirect:/listaanimales";
	}
}
