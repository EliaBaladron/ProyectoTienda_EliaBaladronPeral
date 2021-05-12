package tienda.proyecto_final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tienda.proyecto_final.model.Productos;
import tienda.proyecto_final.service.ProductosService;;


@Controller
@RequestMapping("")
public class ProductosController {

	@Autowired
	private ProductosService sc;
	
	//TODO: cambiar las opciones de los productos según el rol
	@GetMapping("/productos_admin")
	public String indexAdmin(Model model) {
		model.addAttribute("lista_productos", sc.getListaProductos());
		return "index";
	}
	@GetMapping("/productos_emple")
	public String indexEmple(Model model) {
		model.addAttribute("lista_productos", sc.getListaProductos());
		return "index";
	}
	@GetMapping("/productos_cliente")
	public String indexCliente(Model model) {
		model.addAttribute("lista_productos", sc.getListaProductos());
		return "index";
	}
	@GetMapping("/productos_anonimo")
	public String indexAnonimo(Model model) {
		model.addAttribute("lista_productos", sc.getListaProductos());
		return "index";
	}
	
	@GetMapping("/productos/registro")
	public String getRegistro(Model model) {
		
		model.addAttribute("producto", new Productos());
		
		return "Productos";
	}
	@PostMapping("/productos/registro/registrar")
	public String registrar(Model model, @ModelAttribute Productos producto) {
		
		sc.addProducto(producto);
		
		return "redirect:/";
	}
	
	@GetMapping("/productos/delete")
	public String borrar(Model model, @RequestParam String id) {
		
		sc.deleteProducto(Long.parseLong(id));
		//sc.deleteUsuario(Integer.parseInt((id)));
		
		return "redirect:/";
	}
	
	@GetMapping("/productos/edit")
	public String editar(Model model, @RequestParam String id) {
		
		model.addAttribute("producto", sc.getProducto(Long.parseLong(id)));
		
		return "Productos";
	}
	@PostMapping("/productos/edit/editar")
	public String editSubmit(Model model, @ModelAttribute Productos producto) {
		sc.editProducto(producto);
		
		return "redirect:/";
	}
}
