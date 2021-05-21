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

import curso.java.tienda.model.Productos;
import curso.java.tienda.model.Usuarios;
import curso.java.tienda.model.Valoraciones;
import curso.java.tienda.service.ValoracionService;



@Controller
@RequestMapping("/valoracion")
public class ValoracionController {
	
	@Autowired
	private ValoracionService sc;
	
	@GetMapping("/mostrar")
	public String registrar(HttpSession session, Model model) {
		
		Productos p = (Productos)session.getAttribute("producto");
		model.addAttribute("producto", p);
		session.removeAttribute("producto");
		
		model.addAttribute("titulo", "Producto");
		model.addAttribute("listado_valoraciones", sc.getListaByIdProducto(p.getId()));
		
		return "ProductosMostrar";
	}
	
	@GetMapping("/add")
	public String add(HttpSession session, Model model, @RequestParam String idProducto) {
		
		Valoraciones valoracion = new Valoraciones();
		valoracion.setIdProducto(Long.parseLong(idProducto));
		Usuarios usuario = (Usuarios)session.getAttribute("usuarioLogeado");
		valoracion.setIdUsuario(usuario.getId());
		
		model.addAttribute("valoracion", valoracion);
		
		model.addAttribute("titulo", "Valoración");
		
		return "Valoracion";
	}
	@PostMapping("/add/registrar")
	public String registrar(@ModelAttribute Valoraciones valoracion) {
		
		//ArrayList<Valoraciones> v = sc.getLista();
		sc.add(valoracion);
		//v = sc.getLista();
		
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
	
	@GetMapping("/delete")
	public String delete(Model model, @RequestParam String id) {
		
		sc.delete(Long.parseLong(id));
		
		return "redirect:/";
	}
}
