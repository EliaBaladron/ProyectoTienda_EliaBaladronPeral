package tienda.proyecto_final.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tienda.proyecto_final.model.Pedidos;
import tienda.proyecto_final.model.Roles;
import tienda.proyecto_final.model.Usuarios;
import tienda.proyecto_final.service.PedidosService;


@Controller
@RequestMapping("")
public class PedidosController {
	
	@Autowired
	private PedidosService sc;
	
	@GetMapping("/pedidos")
	public String indexPedidos(Model model, HttpSession session) {
		Long rol = (Long)session.getAttribute("rol");
		if(rol == Roles.ADMIN)
			return indexPedidosAdmin(model);
			//return "redirect:/pedidos_admin";
		else if(rol == Roles.EMPLEADO)
			return indexPedidosEmple(model);
			//return "redirect:/pedidos_emple";
		else
			return indexPedidosCliente(model, session);
			//return "redirect:/pedidos_cliente";
	}
	@GetMapping("/pedidos_admin")
	public String indexPedidosAdmin(Model model) {
		model.addAttribute("lista_pedidos", sc.getListaPedidos());
		return "Listado_Pedidos";
	}
	@GetMapping("/pedidos_emple")
	public String indexPedidosEmple(Model model) {
		model.addAttribute("lista_pedidos", sc.getListaPedidos());
		return "Listado_Pedidos";
	}
	@GetMapping("/pedidos_cliente")
	public String indexPedidosCliente(Model model, HttpSession session) {
		
		Usuarios usuario = (Usuarios)session.getAttribute("usuarioLogeado");
		
		model.addAttribute("lista_pedidos", sc.getListaPedidosCliente(usuario.getId()));
		return "Listado_Pedidos";
	}
	
	@GetMapping("/pedidos/registro")
	public String getRegistro(Model model) {
		
		model.addAttribute("pedido", new Pedidos());
		
		return "Pedidos";
	}
	@PostMapping("/pedidos/registro/registrar")
	public String registrar(Model model, @ModelAttribute Pedidos pedido) {
		
		sc.addPedido(pedido);
		
		return "redirect:/pedidos";
	}
	
	@GetMapping("/pedidos/delete")
	public String borrar(Model model, @RequestParam String id) {
		
		sc.deletePedido(Long.parseLong(id));
		
		return "redirect:/pedidos";
	}
	
	@GetMapping("/pedidos/edit")
	public String editar(Model model, @RequestParam String id) {
		
		model.addAttribute("pedido", sc.getPedido(Long.parseLong(id)));
		
		return "Pedidos";
	}
	@PostMapping("/pedidos/edit/editar")
	public String editSubmit(Model model, @ModelAttribute Pedidos pedido) {
		sc.editPedido(pedido);
		
		return "redirect:/pedidos";
	}
	
	@GetMapping("/pedidos/cancelar")
	public String cancelar(Model model, @RequestParam String id) {
		
		Pedidos pedido = sc.getPedido(Long.parseLong(id));
		pedido.setEstado(Pedidos.CANCELADO);
		
		sc.editPedido(pedido);
		
		return "redirect:/pedidos";
	}
	@GetMapping("/pedidos/enviar")
	public String enviar(Model model, @RequestParam String id) {
		
		Pedidos pedido = sc.getPedido(Long.parseLong(id));
		pedido.setEstado(Pedidos.ENVIADO);
		
		sc.editPedido(pedido);
		
		return "redirect:/pedidos";
	}
	@GetMapping("/pedidos/solicitar_cancelacion")
	public String solicitarCancelación(Model model, @RequestParam String id) {
				
		Pedidos pedido = sc.getPedido(Long.parseLong(id));
		pedido.setEstado(Pedidos.PENDIENTE_CANCELAR);
		
		sc.editPedido(pedido);
		
		return "redirect:/pedidos";
	}
}
