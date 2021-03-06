package curso.java.tienda.controller;


import java.util.Formatter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.model.Configuracion;
import curso.java.tienda.service.ConfiguracionService;


@Controller
@RequestMapping("")
public class ConfiguracionController {
	
	@Autowired
	private ConfiguracionService sc;
	
	@GetMapping("/configuracion")
	public String mostrar(Model model) {
		
		model.addAttribute("lista_configuraciones", sc.getLista());
		model.addAttribute("titulo", "Configuración");
		
		return "Listado_Configuracion";
	}
	
	@GetMapping("/configuracion/edit")
	public String editar(Model model, @RequestParam String id) {
		
		model.addAttribute("configuracion", sc.get(Long.parseLong(id)));
		model.addAttribute("titulo", "Editar configuración");
		
		return "Configuracion";
	}
	@PostMapping("/configuracion/edit/editar")
	public String editarSubmit(Model model, @ModelAttribute Configuracion configuracion) {
		
		sc.add(configuracion);
		
		return "redirect:/configuracion";
	}
	
	@GetMapping("/datos_tienda")
	public String registrar(HttpSession session) {
		
		String nombre = sc.getListaByClave(Configuracion.NOMBRE).get(0).getValor();
		String cif = sc.getListaByClave(Configuracion.CIF).get(0).getValor();
		String direccion = sc.getListaByClave(Configuracion.DIRECCION).get(0).getValor();
		String numFactura = sc.getListaByClave(Configuracion.NUM_FACTURA).get(0).getValor();
		
		session.setAttribute("datos_tienda_nombre", nombre);
		session.setAttribute("datos_tienda_cif", cif);
		session.setAttribute("datos_tienda_direccion", direccion);
		session.setAttribute(Configuracion.NUM_FACTURA, numFactura);
		
		return "redirect:/productos";
	}

	
	@GetMapping("/actualizar/num_factura")
	public String actualizarNumFactura(HttpSession session) {
		
		String num = (String)session.getAttribute(Configuracion.NUM_FACTURA);
		num = numeroFactura(num);
		
		session.setAttribute(Configuracion.NUM_FACTURA, num);
		Configuracion c = sc.getListaByClave(Configuracion.NUM_FACTURA).get(0);
		c.setValor(num);
		sc.edit(c);
		
		return "redirect:/pedidos";
	}
	
	public String numeroFactura(String num){
		
		String factura = num.substring(0, 5);
		
		int n = Integer.parseInt(num.substring(5));
		n = n+1;
		
		Formatter fmt = new Formatter();
		factura += fmt.format("%04d",n);
		fmt.close();
		
		//factura+= Integer.toString(n);
		
		return factura;
	}
	
}
