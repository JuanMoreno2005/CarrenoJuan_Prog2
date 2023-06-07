package co.edu.unbosque.CarrenoJuan_Prog2.controller;

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

import co.edu.unbosque.CarrenoJuan_Prog2.model.Investigador;
import co.edu.unbosque.CarrenoJuan_Prog2.repository.InvestigadorRepository;

@Controller
@RequestMapping
public class InvestigadorController {
	@Autowired
	private InvestigadorRepository irep;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Investigador> investigadores = irep.findAll();
		model.addAttribute("investigadores", investigadores);
		return "investigador";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("investigador", new Investigador());
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@Valid Investigador i, Model model) {
		irep.save(i);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{cedula}")
	public String editar(@PathVariable int cedula, Model model) {
		Optional<Investigador> investigador = irep.findById(cedula);
		model.addAttribute("investigador", investigador);
		return "form";
	}
	
	@GetMapping("/eliminar/{cedula}")
	public String delete(Model model, @PathVariable int cedula) {
		irep.deleteById(cedula);
		return "redirect:/listar";
	}
}
