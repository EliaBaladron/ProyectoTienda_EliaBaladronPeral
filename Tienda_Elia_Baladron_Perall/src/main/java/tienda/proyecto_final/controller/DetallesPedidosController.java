package tienda.proyecto_final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tienda.proyecto_final.model.DetallesPedido;
import tienda.proyecto_final.service.DetallesPedidosService;


@Controller
@RequestMapping("")
public class DetallesPedidosController {
	
	@Autowired
	private DetallesPedidosService sc;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("lista_detalles_pedido", sc.getListaDetallesPedidos());
		return "index";
	}
	
	@GetMapping("/detalles_pedido/registro")
	public String getRegistro(Model model) {
		
		model.addAttribute("detalles_pedido", new DetallesPedido());
		
		return "DetallesPedidos";
	}
	@PostMapping("/detalles_pedido/registro/registrar")
	public String registrar(Model model, @ModelAttribute DetallesPedido detallesPedido) {
		
		sc.addDetallePedido(detallesPedido);
		
		return "redirect:/";
	}
	
	@GetMapping("/detalles_pedido/delete")
	public String borrar(Model model, @RequestParam String id) {
		
		sc.deleteDetallePedido(Long.parseLong(id));
		
		return "redirect:/";
	}
	
	@GetMapping("/detalles_pedido/edit")
	public String editar(Model model, @RequestParam String id) {
		
		model.addAttribute("detalles_pedido", sc.getDetallePedido(Long.parseLong(id)));
		
		return "DetallesPedidos";
	}
	@PostMapping("/detalles_pedido/edit/editar")
	public String editSubmit(Model model, @ModelAttribute DetallesPedido detallesPedido) {
		sc.editDetallePedido(detallesPedido);
		
		return "redirect:/";
	}
}
