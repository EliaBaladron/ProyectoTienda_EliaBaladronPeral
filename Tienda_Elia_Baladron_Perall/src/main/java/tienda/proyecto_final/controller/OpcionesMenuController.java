package tienda.proyecto_final.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tienda.proyecto_final.model.OpcionesMenu;
import tienda.proyecto_final.service.OpcionesMenuService;

@Controller
@RequestMapping("")
public class OpcionesMenuController {
	
	@Autowired
	private OpcionesMenuService sc;
	
	/*@GetMapping("")
	public String index(Model model, HttpSession session) {
		
		iniciarRol(session, 0l);
		
		return "index";
	}*/
	
	public void iniciarRol(HttpSession session, Long rol) {
		Long idRol = 4l;
		if(rol == 0) {
			
			Object r = session.getAttribute("rol");
			
			if(r != null)
				//idRol = Integer.getInteger(r.toString());
				idRol = (Long)r;
			else
				session.setAttribute("rol", idRol);
		}else {
			idRol = rol;
			session.setAttribute("rol", idRol);
		}
		/*ArrayList<OpcionesMenu> op = OpcionesMenuService.getRoles(4);
		for(OpcionesMenu o: op)
			System.out.println(o.toString());*/
		
		Iterable<OpcionesMenu> op = sc.getListaOpcionesMenuRol(idRol);
		
		session.setAttribute("opciones_menu", op);
	}
}
