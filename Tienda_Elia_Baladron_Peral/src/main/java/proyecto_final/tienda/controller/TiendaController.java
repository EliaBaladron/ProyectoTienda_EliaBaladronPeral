package proyecto_final.tienda.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import proyecto_final.tienda.model.OpcionesMenu;
import proyecto_final.tienda.model.Usuarios;
import proyecto_final.tienda.service.OpcionesMenuService;


@Controller
@RequestMapping("")
public class TiendaController {
	
	//Login
	
	
	@GetMapping("")
	public String index(HttpSession session) {
		
		iniciarRol(session, 0);
		
		//return "redirect:/productos";
		return "index";
	}
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		
		model.addAttribute("usuario", new Usuarios());
		
		return "login_form";
	}
	
	@GetMapping("/login/login")
	public String loginSaludo(HttpSession session, Model  model, @ModelAttribute Usuarios usuario) {
		
		//Comprobar usuario
		//Añadir datos a la sesion
		session.setAttribute("usuario", usuario);
		iniciarRol(session, usuario.getIdRol());
		
		return "index";
	}

	
	public void iniciarRol(HttpSession session, int rol) {
		int idRol = 4;
		if(rol == 0) {
			
			Object r = session.getAttribute("rol");
			
			if(r != null)
				//idRol = Integer.getInteger(r.toString());
				idRol = (int)r;
			else
				session.setAttribute("rol", idRol);
		}else {
			idRol = rol;
			session.setAttribute("rol", idRol);
		}
		/*ArrayList<OpcionesMenu> op = OpcionesMenuService.getRoles(4);
		for(OpcionesMenu o: op)
			System.out.println(o.toString());*/
		session.setAttribute("opciones_menu", OpcionesMenuService.getRoles(idRol));
	}
	
	public static void main(String[] args) {

		ArrayList<OpcionesMenu> op = OpcionesMenuService.getRoles(4);
		for(OpcionesMenu o: op)
			System.out.println(o.toString());
	}
}
