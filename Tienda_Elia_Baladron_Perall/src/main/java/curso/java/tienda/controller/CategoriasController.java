package curso.java.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.java.tienda.model.Categorias;
import curso.java.tienda.service.CategoriasService;



@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	CategoriasService sc;
	
	@GetMapping("")
	public String carrito(Model model) {
		
		model.addAttribute("lista_categorias", sc.getLista());
		model.addAttribute("titulo", "Categorias");
		
		return "Listado_Categorias";
	}

	@GetMapping("/add")
	public String add(Model model) {
		
		model.addAttribute("categoria", new Categorias());
		model.addAttribute("titulo", "Categoria");
		
		return "Categorias";
	}
	@PostMapping("/add/registrar")
	public String registrar(@ModelAttribute Categorias categoria) {
		
		sc.add(categoria);
		
		return "redirect:/categorias";
	}
	
}
