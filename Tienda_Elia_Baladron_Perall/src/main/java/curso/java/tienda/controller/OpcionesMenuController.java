package curso.java.tienda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.java.tienda.model.OpcionesMenu;
import curso.java.tienda.model.Usuarios;
import curso.java.tienda.service.OpcionesMenuService;

@Controller
@RequestMapping("")
public class OpcionesMenuController {
	
	@Autowired
	private OpcionesMenuService sc;
	
	@GetMapping("")
	public String index(Model model, HttpSession session) {
		
		if(session.getAttribute("usuarioLogeado") == null) {
			iniciarRol(session, 0l);
		}else {
			Usuarios usuarioLogeado = (Usuarios)session.getAttribute("usuarioLogeado");
			iniciarRol(session, usuarioLogeado.getIdRol());
		}
		
		CarritoController.iniciarCarrito(session, model);
		
		return "redirect:/datos_tienda";
	}
	@GetMapping("/Tienda_Elia_Baladron_Peral")
	public String index() {
		return "redirect:/";
	}
	
	public void iniciarRol(HttpSession session, Long rol) {
		Long idRol = 4l;
		if(rol == 0) {
			
			Object r = session.getAttribute("rol");
			
			if(r != null) {
				idRol = (Long)r;
			}
			else
				session.setAttribute("rol", idRol);
		}else {
			idRol = rol;
			session.setAttribute("rol", idRol);
		}
		
		Iterable<OpcionesMenu> op = sc.getListaOpcionesMenuRol(idRol);
		
		session.setAttribute("opciones_menu", op);
	}
}
