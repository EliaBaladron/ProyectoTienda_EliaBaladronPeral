package tienda.proyecto_final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tienda.proyecto_final.model.Pedidos;
import tienda.proyecto_final.service.PedidosService;


@Controller
@RequestMapping("")
public class PedidosController {
	@Autowired
	private PedidosService sc;
	
	/*@GetMapping("")
	public String index(Model model) {
		model.addAttribute("lista_pedidos", sc.getListaPedidos());
		return "index";
	}*/
	
	@GetMapping("/pedidos/registro")
	public String getRegistro(Model model) {
		
		model.addAttribute("pedido", new Pedidos());
		
		return "Pedidos";
	}
	@PostMapping("/pedidos/registro/registrar")
	public String registrar(Model model, @ModelAttribute Pedidos pedido) {
		
		sc.addPedido(pedido);
		
		return "redirect:/";
	}
	
	@GetMapping("/pedidos/delete")
	public String borrar(Model model, @RequestParam String id) {
		
		sc.deletePedido(Long.parseLong(id));
		
		return "redirect:/";
	}
	
	@GetMapping("/pedidos/edit")
	public String editar(Model model, @RequestParam String id) {
		
		model.addAttribute("pedido", sc.getPedido(Long.parseLong(id)));
		
		return "Pedidos";
	}
	@PostMapping("/pedidos/edit/editar")
	public String editSubmit(Model model, @ModelAttribute Pedidos pedido) {
		sc.editPedido(pedido);
		
		return "redirect:/";
	}
}
