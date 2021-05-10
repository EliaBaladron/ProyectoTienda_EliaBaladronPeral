package proyecto_final.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import proyecto_final.tienda.model.DetallesPedido;
import proyecto_final.tienda.service.DetallesPedidosService;

@Controller
@RequestMapping("")
public class DetallesPedidoController {
	
	@GetMapping("/detalles_pedido")
	public String index(Model model) {
		model.addAttribute("lista_detalles_pedido", DetallesPedidosService.getDetallesPedidos());
		return "listado_detalles_pedido";
	}
	
	@GetMapping("/detalles_pedido/registro")
	public String getRegistro(Model model) {
		
		model.addAttribute("detalles_pedido", new DetallesPedido());
		
		return "detalles_pedido_registro";
	}
	@PostMapping("/detalles_pedido/registro/registrar")
	public String registrar(Model model, @ModelAttribute DetallesPedido detallesPedido) {
		
		DetallesPedidosService.addDetallesPedido(detallesPedido);
		
		return "redirect:/";
	}
	
	@GetMapping("/detalles_pedido/delete")
	public String borrar(Model model, @RequestParam String id) {
		
		DetallesPedidosService.deleteDetallesPedido(DetallesPedidosService.getDetallesPedido(Integer.parseInt(id)));
		
		return "redirect:/";
	}
	
	@GetMapping("/detalles_pedido/edit")
	public String editar(Model model, @RequestParam String id) {
		
		model.addAttribute("detalles_pedido", DetallesPedidosService.getDetallesPedido(Integer.parseInt(id)));
		
		return "detalles_pedido_editar";
	}
	@PostMapping("/detalles_pedido/edit/editar")
	public String editSubmit(Model model, @ModelAttribute DetallesPedido detallesPedido) {
		
		DetallesPedidosService.updateDetallesPedido(detallesPedido);
		
		return "redirect:/";
	}
}
