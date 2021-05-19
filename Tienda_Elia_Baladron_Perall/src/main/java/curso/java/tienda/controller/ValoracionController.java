package curso.java.tienda.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.model.Valoraciones;
import curso.java.tienda.service.ValoracionService;



@Controller
@RequestMapping("/valoracion")
public class ValoracionController {
	
	@Autowired
	private ValoracionService sc;
	
	@GetMapping("/add")
	public String add(HttpSession session, Model model) {
		
		model.addAttribute("valoracion", new Valoraciones());
		model.addAttribute("titulo", "Valoracion");
		
		return "Valoracion";
	}
	@PostMapping("/add/registrar")
	public String registrar(@ModelAttribute Valoraciones valoracion) {
		
		sc.add(valoracion);
		
		return "redirect:/";
	}
	
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam String id) {
		
		model.addAttribute("valoracion", sc.get(Long.parseLong(id)));
		model.addAttribute("titulo", "Valoracion");
		
		return "Valoracion";
	}
	@PostMapping("/edit/editar")
	public String editar(@ModelAttribute Valoraciones valoracion) {
		
		sc.edit(valoracion);
		
		return "redirect:/";
	}
}
