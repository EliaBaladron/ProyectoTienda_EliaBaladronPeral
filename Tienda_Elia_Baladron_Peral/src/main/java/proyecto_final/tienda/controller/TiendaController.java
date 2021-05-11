package proyecto_final.tienda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import proyecto_final.tienda.model.Usuarios;
import proyecto_final.tienda.service.OpcionesMenuService;


@Controller
@RequestMapping("")
public class TiendaController {
	
	//Login
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		
		model.addAttribute("usuario", new Usuarios());
		
		return "login_form";
	}
	
	@GetMapping("/login/login")
	public String loginSaludo(HttpSession session, Model  model, @ModelAttribute Usuarios usuario) {
		
		//Comprobar usuario
		//Añadir datos a la sesion
		session.setAttribute("Rol", usuario.getIdRol());
		session.setAttribute("Usuario", usuario);
		
		
		return "index";
	}
	
	public void iniciarRol(Model model, HttpSession session) {
		int idRol = 4;
		if(session.getAttribute("rol") == null)
			idRol = Integer.getInteger(session.getAttribute("rol").toString());
		model.addAttribute("opciones_menu", OpcionesMenuService.getRoles(idRol));
	}
	
}
