package proyecto_final.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import proyecto_final.tienda.model.Roles;
import proyecto_final.tienda.service.RolesService;

@Controller
@RequestMapping("")
public class RolesController {
	
	@GetMapping("/roles")
	public String index(Model model) {
		model.addAttribute("lista_roles", RolesService.getRoles());
		return "listado_roles";
	}
	
	@GetMapping("/roles/registro")
	public String getRegistro(Model model) {
		
		model.addAttribute("pedido", new Roles());
		
		return "roles_registro";
	}
	@PostMapping("/roles/registro/registrar")
	public String registrar(Model model, @ModelAttribute Roles rol) {
		
		RolesService.addRol(rol);
		
		return "redirect:/";
	}
	
	@GetMapping("/roles/delete")
	public String borrar(Model model, @RequestParam String id) {
		
		RolesService.deleteRol(RolesService.getRol(Integer.parseInt(id)));
		
		return "redirect:/";
	}
	
	@GetMapping("/roles/edit")
	public String editar(Model model, @RequestParam String id) {
		
		model.addAttribute("pedido", RolesService.getRol(Integer.parseInt(id)));
		
		return "roles_editar";
	}
	@PostMapping("/roles/edit/editar")
	public String editSubmit(Model model, @ModelAttribute Roles rol) {
		
		RolesService.updateRol(rol);
		
		return "redirect:/";
	}
}
