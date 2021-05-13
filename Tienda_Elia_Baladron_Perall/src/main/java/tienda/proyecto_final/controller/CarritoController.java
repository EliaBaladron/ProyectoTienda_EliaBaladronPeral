package tienda.proyecto_final.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tienda.proyecto_final.model.DetallesPedido;
import tienda.proyecto_final.model.MetodosPago;
import tienda.proyecto_final.model.Pedidos;
import tienda.proyecto_final.model.Productos;
import tienda.proyecto_final.model.Roles;
import tienda.proyecto_final.model.Usuarios;


@Controller
@RequestMapping("")
public class CarritoController {
	
	@GetMapping("/carrito")
	public String carrito(HttpSession session, Model model) {
		
		iniciarCarrito(session, model);
		model.addAttribute("titulo", "Carrito");
		return "Carrito";
	}
	@GetMapping("/carrito_cliente")
	public String carritoCliente(HttpSession session) {
		return "redirect:/carrito";
	}
	@GetMapping("/carrito_anonimo")
	public String carritoAnonimo(HttpSession session) {
		return "redirect:/carrito";
	}
	
	public static void add(HttpSession session, Productos producto) {
		
		@SuppressWarnings("unchecked")
		ArrayList<DetallesPedido> detalles = (ArrayList<DetallesPedido>)session.getAttribute("carrito_detalles");
		if(detalles == null) {
			detalles = new ArrayList<DetallesPedido>();
		}
		
		boolean existe = false;
		
		for(DetallesPedido d: detalles) {
			if(d.getIdProducto().equals(producto.getId())) {
				d.setUnidades(d.getUnidades()+1);
				d.calcularTotal();
				existe = true;
				break;
			}
		}
		if(!existe) {
			DetallesPedido d = new DetallesPedido(0l, producto.getId(), producto.getPrecio(), 1, producto.getImpuesto(), 0d);
			d.calcularTotal();
			detalles.add(d);
		}
		
		session.setAttribute("carrito_detalles", detalles);
		
		//Pedidos carrito = (Pedidos)session.getAttribute("carrito");
		//carrito.calcularTotal(detalles);
		//session.setAttribute("carrito", carrito);
		
		
	}

	@GetMapping("/carrito/delete")
	public String delete(HttpSession session, @RequestParam String idProducto) {
		
		delete(session, Long.parseLong(idProducto));
		
		return "redirect:/carrito";
	}
	
	@GetMapping("/carrito/realizar_pedido/paypal")
	public String realizarPedidoPaypal(HttpSession session) {
		
		session.setAttribute("pago", MetodosPago.PAYPAL);
		return "redirect:/carrito/realizar_pedido";
		
	}
	@GetMapping("/carrito/realizar_pedido/tarjeta")
	public String realizarPedidoTarjeta(HttpSession session) {
		
		session.setAttribute("pago", MetodosPago.TARJETA);
		return "redirect:/carrito/realizar_pedido";
		
	}
	@GetMapping("/carrito/realizar_pedido")
	public String realizarPedido(HttpSession session, Model model) {
		
		Usuarios usuarioLogeado = (Usuarios)session.getAttribute("usuarioLogeado");
		if(usuarioLogeado == null) {
			return "redirect:/login_carrito";
		}else if(usuarioLogeado.getIdRol() != Roles.CLIENTE) {
			//return "ErrorLoginPedido";
			session.removeAttribute("usuarioLogeado");
			session.setAttribute("rol", Roles.ANONIMO);
			model.addAttribute("usuario", new Usuarios());
			session.setAttribute("error", "El usuario debe ser un cliente para realizar un pedido");
			return "redirect:/login_carrito";
		}
		
		return "redirect:/pedidos/registrar_pedido_carrito";
	}
	public static void delete(HttpSession session, Long idProducto) {
		@SuppressWarnings("unchecked")
		ArrayList<DetallesPedido> detalles = (ArrayList<DetallesPedido>)session.getAttribute("carrito_detalles");
				
		for(DetallesPedido d: detalles) {
			if(d.getIdProducto().equals(idProducto)) {
				detalles.remove(d);
				break;
			}
		}
	}
	public static void iniciarCarrito(HttpSession session, Model model) {
		/*if(session.getAttribute("carrito") == null) {
			
			Usuarios usuario = (Usuarios)session.getAttribute("usuarioLogeado");
			
			Long idUsuario = 0l;
			if(usuario != null)
				idUsuario = usuario.getId();
			
			session.setAttribute("carrito", new Pedidos(0l, idUsuario, null, MetodosPago.PAYPAL, Pedidos.SIN_REALIZAR, "", 0d));
			
		}*/
		
		@SuppressWarnings("unchecked")
		ArrayList<DetallesPedido> detalles = (ArrayList<DetallesPedido>)session.getAttribute("carrito_detalles");
		
		if(detalles == null) {
			detalles = new ArrayList<DetallesPedido>();
			session.setAttribute("carrito_detalles", detalles);
		}
		
		//model.addAttribute("total", Math.round(Pedidos.calcularTotalDetalles(detalles)));
		model.addAttribute("total", String.format("%.2f", Pedidos.calcularTotalDetalles(detalles)));
	}
	
}
