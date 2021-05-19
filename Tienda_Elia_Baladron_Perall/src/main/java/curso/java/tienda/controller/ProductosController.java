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

import curso.java.tienda.model.Productos;
import curso.java.tienda.otro.ProductosAgrupadosCategoria;
import curso.java.tienda.service.ProductosService;;


@Controller
@RequestMapping("")
public class ProductosController {
	
	
	@Autowired
	private ProductosService sc;
	
	/*@GetMapping("/productos/sin_categorias")
	public String indexProductos(Model model, HttpSession session) {
		
		model.addAttribute("lista_productos", sc.getListaProductos());
		model.addAttribute("titulo", "Productos");
		//return "index";
		return "Listado_Productos";
	}*/
	@GetMapping("/productos")
	public String indexProductosCategorias(Model model, HttpSession session) {

		model.addAttribute("titulo", "Productos");
		
		String orden = (String)session.getAttribute("orden");
		session.removeAttribute("orden");
		
		if(orden == null)
			orden = "categoria";
		
		switch(orden) {
		case "precio":
			model.addAttribute("lista_productos", sc.getListaProductosOrderByPrecio());
			return "Listado_Productos";
			
		/*case "mejor_valorados":
			return "Listado_Productos";*/
			
		case "stock":
			model.addAttribute("lista_productos", sc.getListaProductosOrderByStock());
			return "Listado_Productos";
			
		/*case "mas_comprados":
			return "Listado_Productos";*/
			
		case "categoria":
		default:
			model.addAttribute("lista_productosXcategoria", iniciarProductosXCategoria());
			return "Listado_ProductosCategorias";
		}
		
	}
	@GetMapping("/productos_admin")
	public String indexAdmin(Model model) {
		return "redirect:/";
	}
	@GetMapping("/productos_emple")
	public String indexEmple(Model model) {
		return "redirect:/";
	}
	@GetMapping("/productos_cliente")
	public String indexCliente(Model model) {
		return "redirect:/";
	}
	@GetMapping("/productos_anonimo")
	public String indexAnonimo(Model model) {
		return "redirect:/";
	}
	
	@GetMapping("/productos/registro")
	public String addRegistro(Model model) {
		
		model.addAttribute("producto", new Productos(true));
		model.addAttribute("titulo", "Producto");
		
		return "Productos";
	}
	@PostMapping("/productos/registro/registrar")
	public String registrar(@ModelAttribute Productos producto) {
		
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
		model.addAttribute("titulo", "Producto");
		
		return "Productos";
	}
	@PostMapping("/productos/edit/editar")
	public String editSubmit(Model model, @ModelAttribute Productos producto) {
		sc.editProducto(producto);
		
		return "redirect:/";
	}
	
	@GetMapping("/productos/baja")
	public String baja(Model model, @RequestParam String id) {
		
		Productos producto = sc.getProducto(Long.parseLong(id));
		producto.darDeBaja();
		
		sc.editProducto(producto);
		
		return "redirect:/";
	}
	
	@GetMapping("/productos/detalles")
	public String detalles(Model model, @RequestParam String id) {
		
		model.addAttribute("producto", sc.getProducto(Long.parseLong(id)));
		model.addAttribute("titulo", "Producto");
		
		return "ProductosMostrar";
	}
	
	
	ArrayList<ProductosAgrupadosCategoria> iniciarProductosXCategoria() {
		ArrayList<ProductosAgrupadosCategoria> arrayList = new ArrayList<ProductosAgrupadosCategoria>();
		
		ArrayList<Productos> productos = (ArrayList<Productos>)sc.getListaProductosOrderByCategoria();
		for(Productos p: productos) {
			boolean existe = false;
			for(ProductosAgrupadosCategoria pxc: arrayList) {
				//Si existe un ProductosAgrupadosCategoria en el array con la misma categoría se añade el producto
				if(p.getIdCategoria().equals(pxc.getCategoria())) {
					
					pxc.addProducto(p);
					
					existe = true;
					break;
				}
			}
			
			//Si no existe un ProductosAgrupadosCategoria en el array con la misma categoría se crea y se añade el producto
			if(!existe) {
				ProductosAgrupadosCategoria pxc = new ProductosAgrupadosCategoria(p.getIdCategoria());
				pxc.addProducto(p);
				arrayList.add(pxc);
			}
			
		}
		
		return arrayList;
	}
	
	
	
	//Carrito
	@GetMapping("/carrito/add")
	public String addGet(HttpSession session, @RequestParam String id) {
		
		CarritoController.add(session, sc.getProducto(Long.parseLong(id)));
		
		return "redirect:/";
	}
	@PostMapping("/carrito/add")
	public String addPost(HttpSession session, @RequestParam String id) {
		
		CarritoController.add(session, sc.getProducto(Long.parseLong(id)));
		
		return "redirect:/";
	}
	
}
