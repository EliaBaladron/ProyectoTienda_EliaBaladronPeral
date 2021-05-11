package proyecto_final.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import proyecto_final.tienda.model.Usuarios;
import proyecto_final.tienda.service.UsuariosService;

@Controller
@RequestMapping("")
public class UsuariosController {
	
	@GetMapping("/usuarios")
	public String index(Model model) {
		model.addAttribute("lista_usuarios", UsuariosService.getUsuarios());
		return "listado_usuarios";
	}
	
	@GetMapping("/usuarios/registro")
	public String getRegistro(Model model) {
		
		model.addAttribute("usuario", new Usuarios());
		
		return "usuarios";
	}
	@PostMapping("/usuarios/registro/registrar")
	public String registrar(Model model, @ModelAttribute Usuarios usuario) {
		
		UsuariosService.addUsuario(usuario);
		
		return "redirect:/";
	}
	
	@GetMapping("/usuarios/delete")
	public String borrar(Model model, @RequestParam String id) {
		
		UsuariosService.deleteUsuario(UsuariosService.getUsuario(Integer.parseInt(id)));
		
		return "redirect:/";
	}
	
	@GetMapping("/usuarios/edit")
	public String editar(Model model, @RequestParam String id) {
		Usuarios u = UsuariosService.getUsuario(Integer.parseInt(id));
		//Usuarios u = UsuariosService.getUsuario(1);
		model.addAttribute("usuario", u);
		
		return "usuarios";
	}
	@PostMapping("/usuarios/edit/editar")
	public String editSubmit(Model model, @ModelAttribute Usuarios usuario) {
		
		UsuariosService.updateUsuario(usuario);
		
		return "redirect:/";
	}
}
