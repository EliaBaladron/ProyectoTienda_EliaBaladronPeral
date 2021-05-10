package proyecto_final.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import proyecto_final.tienda.model.Pedidos;
import proyecto_final.tienda.service.PedidosService;

@Controller
@RequestMapping("")
public class PedidosController {
	
	@GetMapping("/pedidos")
	public String index(Model model) {
		model.addAttribute("lista_pedidos", PedidosService.getPedidos());
		return "listado_pedidos";
	}
	
	@GetMapping("/pedidos/registro")
	public String getRegistro(Model model) {
		
		model.addAttribute("pedido", new Pedidos());
		
		return "pedidos_registro";
	}
	@PostMapping("/pedidos/registro/registrar")
	public String registrar(Model model, @ModelAttribute Pedidos pedido) {
		
		PedidosService.addPedido(pedido);
		
		return "redirect:/";
	}
	
	@GetMapping("/pedidos/delete")
	public String borrar(Model model, @RequestParam String id) {
		
		PedidosService.deletePedido(PedidosService.getPedido(Integer.parseInt(id)));
		
		return "redirect:/";
	}
	
	@GetMapping("/pedidos/edit")
	public String editar(Model model, @RequestParam String id) {
		
		model.addAttribute("pedido", PedidosService.getPedido(Integer.parseInt(id)));
		
		return "productos_editar";
	}
	@PostMapping("/pedidos/edit/editar")
	public String editSubmit(Model model, @ModelAttribute Pedidos pedido) {
		
		PedidosService.updatePedido(pedido);
		
		return "redirect:/";
	}
}
