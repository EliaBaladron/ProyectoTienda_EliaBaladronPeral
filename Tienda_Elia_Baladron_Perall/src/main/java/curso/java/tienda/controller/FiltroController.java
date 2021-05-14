package curso.java.tienda.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/filtro")
public class FiltroController {
	

	@GetMapping("/precio")
	public String registrar(HttpSession session) {
		
		session.setAttribute("orden", "precio");
		
		return "redirect:/productos";
	}
	@GetMapping("/categoria")
	public String categoria(HttpSession session) {
		session.setAttribute("orden", "categoria");
		
		return "redirect:/productos";
	}
	/*@GetMapping("/mejor_valorados")
	public String mejor_valorados(HttpSession session) {
		session.setAttribute("orden", "mejor_valorados");
		
		return "redirect:/productos";
	}*/
	/*@GetMapping("/mas_comprados")
	public String mas_comprados(HttpSession session) {
		session.setAttribute("orden", "mas_comprados");
		
		return "redirect:/productos";
	}*/
	@GetMapping("/stock")
	public String stock(HttpSession session) {
		session.setAttribute("orden", "stock");
		
		return "redirect:/productos";
	}
	
	
}
