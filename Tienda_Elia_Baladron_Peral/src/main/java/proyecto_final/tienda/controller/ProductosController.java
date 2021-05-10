package proyecto_final.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import proyecto_final.tienda.model.Productos;
import proyecto_final.tienda.service.ProductosService;;

@Controller
@RequestMapping("")
public class ProductosController {
	
	@GetMapping("/productos")
	public String index(Model model) {
		model.addAttribute("lista_productos", ProductosService.getProductos());
		return "listado_productos";
	}
	
	@GetMapping("/productos/registro")
	public String getRegistro(Model model) {
		
		model.addAttribute("producto", new Productos());
		
		return "productos_registro";
	}
	@PostMapping("/productos/registro/registrar")
	public String registrar(Model model, @ModelAttribute Productos producto) {
		
		ProductosService.addProducto(producto);
		
		return "redirect:/";
	}
	
	@GetMapping("/productos/delete")
	public String borrar(Model model, @RequestParam String id) {
		
		ProductosService.deleteProducto(ProductosService.getProducto(Integer.parseInt(id)));
		
		return "redirect:/";
	}
	
	@GetMapping("/productos/edit")
	public String editar(Model model, @RequestParam String id) {
		
		model.addAttribute("producto", ProductosService.getProducto(Integer.parseInt(id)));
		
		return "productos_editar";
	}
	@PostMapping("/productos/edit/editar")
	public String editSubmit(Model model, @ModelAttribute Productos producto) {
		
		ProductosService.updateProducto(producto);
		
		return "redirect:/";
	}
}
