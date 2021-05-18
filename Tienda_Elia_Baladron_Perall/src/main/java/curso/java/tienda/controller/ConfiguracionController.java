package curso.java.tienda.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.java.tienda.model.Configuracion;
import curso.java.tienda.service.ConfiguracionService;


@Controller
@RequestMapping("/")
public class ConfiguracionController {
	
	@Autowired
	private ConfiguracionService sc;
	
	@GetMapping("/datos_tienda")
	public String registrar(HttpSession session) {
		
		String nombre = sc.getListaByClave(Configuracion.NOMBRE).get(0).getValor();
		String cif = sc.getListaByClave(Configuracion.CIF).get(0).getValor();
		String direccion = sc.getListaByClave(Configuracion.DIRECCION).get(0).getValor();
		
		session.setAttribute("datos_tienda_nombre", nombre);
		session.setAttribute("datos_tienda_cif", cif);
		session.setAttribute("datos_tienda_direccion", direccion);
		
		return "redirect:/productos";
	}
	
}
