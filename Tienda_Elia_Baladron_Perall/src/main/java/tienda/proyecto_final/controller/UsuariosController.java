package tienda.proyecto_final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tienda.proyecto_final.model.Usuarios;
import tienda.proyecto_final.service.UsuariosService;


@Controller
@RequestMapping("")
public class UsuariosController {

	@Autowired
	private UsuariosService sc;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("lista_usuarios", sc.getListaUsuarios());
		return "index";
	}
	
	@GetMapping("/usuarios/registro")
	public String getRegistro(Model model) {
		
		model.addAttribute("usuario", new Usuarios());
		
		return "Usuarios";
	}
	@PostMapping("/usuarios/registro/registrar")
	public String registrar(Model model, @ModelAttribute Usuarios usuario) {
		
		sc.addUsuario(usuario);
		
		return "redirect:/";
	}
	
	@GetMapping("/usuarios/delete")
	public String borrar(Model model, @RequestParam String id) {
		
		sc.deleteUsuario(Long.parseLong(id));
		//sc.deleteUsuario(Integer.parseInt((id)));
		
		return "redirect:/";
	}
	
	@GetMapping("/usuarios/edit")
	public String editar(Model model, @RequestParam String id) {
		
		model.addAttribute("usuario", sc.getUsuario(Long.parseLong(id)));
		//model.addAttribute("usuario", sc.getUsuario(Integer.parseInt(id)));
		
		return "Usuarios";
	}
	@PostMapping("/usuarios/edit/editar")
	public String editSubmit(Model model, @ModelAttribute Usuarios usuario) {
		sc.editUsuario(usuario);
		
		return "redirect:/";
	}
}
