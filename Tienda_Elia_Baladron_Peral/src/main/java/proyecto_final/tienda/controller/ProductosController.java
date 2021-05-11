package proyecto_final.tienda.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import proyecto_final.tienda.model.Productos;
import proyecto_final.tienda.otros.Opcion;
import proyecto_final.tienda.service.ProductosService;;

@Controller
@RequestMapping("")
public class ProductosController {
	

	
	@GetMapping("/productos_admin")
	public String productosAdmin(Model model) {
		model.addAttribute("lista_productos", ProductosService.getProductos());
		
		ArrayList<Opcion> opciones = new ArrayList<Opcion>();
		opciones.add(new Opcion("Dar de alta", "@{/productos/alta}"));
		opciones.add(new Opcion("Dar de baja", "@{/productos/baja(id=${producto.id})}"));
		opciones.add(new Opcion("Modificar", "@{/productos/edit(id=${producto.id})}"));
		opciones.add(new Opcion("Eliminar", "@{/productos/delete(id=${producto.id})}"));
		model.addAttribute("opciones_producto", opciones);
		
		return "listado_productos";
	}
	@GetMapping("/productos_emple")
	public String productosEmple(Model model) {
		model.addAttribute("lista_productos", ProductosService.getProductos());

		ArrayList<Opcion> opciones = new ArrayList<Opcion>();
		opciones.add(new Opcion("Dar de alta", "@{/productos/alta}"));
		opciones.add(new Opcion("Dar de baja", "@{/productos/baja(id=${producto.id})}"));
		opciones.add(new Opcion("Modificar", "@{/productos/edit(id=${producto.id})}"));
		model.addAttribute("opciones_producto", opciones);
		
		return "listado_productos";
	}
	@GetMapping("/productos_cliente")
	public String productosCli(Model model) {
		model.addAttribute("lista_productos", ProductosService.getProductos());
		
		ArrayList<Opcion> opciones = new ArrayList<Opcion>();
		opciones.add(new Opcion("Detalles", "@{/productos/detalles(id=${producto.id})}"));
		opciones.add(new Opcion("Añadir al carrito", "@{/productos/carrito(id=${producto.id})}"));
		model.addAttribute("opciones_producto", opciones);
		
		return "listado_productos";
	}
	@GetMapping("/productos")
	public String productosAnonimo(Model model) {
		model.addAttribute("lista_productos", ProductosService.getProductos());
		
		ArrayList<Opcion> opciones = new ArrayList<Opcion>();
		opciones.add(new Opcion("Detalles", "@{/productos/detalles(id=${producto.id})}"));
		opciones.add(new Opcion("Añadir al carrito", "@{/productos/carrito(id=${producto.id})}"));
		model.addAttribute("opciones_producto", opciones);
		
		return "listado_productos";
	}
	
	
	//Alta
	@GetMapping("/productos/alta")
	public String darDeAlta(Model model) {
		
		model.addAttribute("producto", new Productos());
		
		return "productos_registro";
	}
	@PostMapping("/productos/alta/registrar")
	public String darDeAlta(Model model, @ModelAttribute Productos producto) {
		
		ProductosService.addProducto(producto);
		
		model.addAttribute("lista_productos", ProductosService.getProductos());
		return "listado_productos";
	}
	
	
	//Baja
	@GetMapping("/productos/baja")
	public String darDeBaja(Model model, @RequestParam String id) {
		
		ProductosService.darDeBaja(ProductosService.getProducto(Integer.parseInt(id)));
		
		model.addAttribute("lista_productos", ProductosService.getProductos());
		return "listado_productos";
	}
	
	
	//Modificacion
	@GetMapping("/productos/edit")
	public String editar(Model model, @RequestParam String id) {
		
		model.addAttribute("producto", ProductosService.getProducto(Integer.parseInt(id)));
		
		return "productos_editar";
	}
	@PostMapping("/productos/edit/editar")
	public String editar(Model model, @ModelAttribute Productos producto) {
		
		ProductosService.updateProducto(producto);
		
		model.addAttribute("lista_productos", ProductosService.getProductos());
		return "listado_productos";
	}
	
	
	//Eliminación
	@GetMapping("/productos/delete")
	public String borrar(Model model, @RequestParam String id) {
		
		ProductosService.deleteProducto(ProductosService.getProducto(Integer.parseInt(id)));
		
		model.addAttribute("lista_productos", ProductosService.getProductos());
		return "listado_productos";
	}
}
