package tienda.proyecto_final.controller;

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

import tienda.proyecto_final.model.Productos;
import tienda.proyecto_final.model.ProductosAgrupadosCategoria;
import tienda.proyecto_final.service.ProductosService;;


@Controller
@RequestMapping("")
public class ProductosController {

	@Autowired
	private ProductosService sc;
	
	//TODO: cambiar las opciones de los productos según el rol
	@GetMapping("/productos")
	public String index(Model model, HttpSession session) {
		/*
		Usuarios usuarioLogeado = (Usuarios)session.getAttribute("usuarioLogeado");
		if(usuarioLogeado.getIdRol().equals(Roles.ADMIN)) {
			return "redirect:/productos_admin";
		}
		else if(usuarioLogeado.getIdRol().equals(Roles.EMPLEADO)) {
			return "redirect:/productos_emple";
		}
		else if(usuarioLogeado.getIdRol().equals(Roles.CLIENTE)) {
			return "redirect:/productos_cliente";
		}
		else {
			return "redirect:/productos_anonimo";
		}
		*/
		
		model.addAttribute("lista_productosXcategoria", iniciarProductosXCategoria());
		return "index";
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
	public String getRegistro(Model model) {
		
		model.addAttribute("producto", new Productos(true));
		
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
	
	@GetMapping("/productos/carrito")
	public String carrito(Model model, @RequestParam String id) {
		//TODO: implementar carrito
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
		
		return "ProductosMostrar";
	}
	
	
	ArrayList<ProductosAgrupadosCategoria> iniciarProductosXCategoria() {
		ArrayList<ProductosAgrupadosCategoria> arrayList = new ArrayList<ProductosAgrupadosCategoria>();
		
		ArrayList<Productos> productos = (ArrayList<Productos>)sc.getListaProductos();
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
	
	
}
