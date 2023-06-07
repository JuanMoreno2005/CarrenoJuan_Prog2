package co.edu.unbosque.CarrenoJuan_Prog2.Pdf;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import co.edu.unbosque.CarrenoJuan_Prog2.model.Animal;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("/listanimales")
public class ListarPdf extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		@SuppressWarnings("unchecked")
		List<Animal> animales = (List<Animal>) model.get("animales");
		
		
		PdfPTable tablaAnimal = new PdfPTable (7);
		animales.forEach(animal -> {
			
			tablaAnimal.addCell(animal.getId().toString());
			tablaAnimal.addCell(animal.getInvest1().toString());
			tablaAnimal.addCell(animal.getInvest2().toString());
			tablaAnimal.addCell(animal.getNombre());
			tablaAnimal.addCell(animal.getAlimentacion());
			tablaAnimal.addCell(animal.getEnlaces());
			tablaAnimal.addCell(animal.getFoto());
			
		});
		document.add(tablaAnimal);
	}

}
