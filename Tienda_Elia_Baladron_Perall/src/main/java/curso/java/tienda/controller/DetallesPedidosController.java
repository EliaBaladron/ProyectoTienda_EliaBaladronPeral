package curso.java.tienda.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.model.DetallesPedido;
import curso.java.tienda.service.DetallesPedidosService;


@Controller
@RequestMapping("")
public class DetallesPedidosController {
	
	@Autowired
	private DetallesPedidosService sc;
	
	@GetMapping("/detalles_pedido/mostrar")
	public String index(Model model, @RequestParam String id) {
		Long idPedido = Long.parseLong(id);
		model.addAttribute("lista_detalles_pedido", sc.getListaDetallesPedidosXPedido(idPedido));
		model.addAttribute("titulo", "Detalles pedido");
		return "Listado_DetallesPedidos";
	}
	
	@GetMapping("/detalles_pedido/registro")
	public String getRegistro(Model model) {
		
		model.addAttribute("detalles_pedido", new DetallesPedido());
		model.addAttribute("titulo", "Detalles pedido");
		
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
		model.addAttribute("titulo", "Detalles pedido");
		
		return "DetallesPedidos";
	}
	@PostMapping("/detalles_pedido/edit/editar")
	public String editSubmit(Model model, @ModelAttribute DetallesPedido detallesPedido) {
		sc.editDetallePedido(detallesPedido);
		
		return "redirect:/";
	}
	
	
	@GetMapping("/detalles_pedido/registrar_detalles_carrito")
	public String registrarDetallesPedidoCarrito(HttpSession session) {
		
		@SuppressWarnings("unchecked")
		ArrayList<DetallesPedido> detalles = (ArrayList<DetallesPedido>)session.getAttribute("carrito_detalles");
		Long idPedido = (Long)session.getAttribute("idPedido");
		
		for(DetallesPedido d: detalles) {
			d.setIdPedido(idPedido);
			sc.addDetallePedido(d);
		}
		
		session.removeAttribute("carrito_detalles");
		session.removeAttribute("idPedido");
		session.removeAttribute("login_carrito");
		
		return "redirect:/";
	}
	
}
