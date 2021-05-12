package tienda.proyecto_final.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tienda.proyecto_final.model.Roles;
import tienda.proyecto_final.model.Usuarios;
import tienda.proyecto_final.service.UsuariosService;


@Controller
@RequestMapping("")
public class UsuariosController {

	@Autowired
	private UsuariosService sc;
	
	@GetMapping("/usuarios")
	public String index(Model model) {
		model.addAttribute("lista_usuarios", sc.getListaUsuarios());
		return "Listado_Usuarios";
	}
	//TODO: añadir solo los clientes y no todos los usuarios
	@GetMapping("/clientes_admin")
	public String indexClientesAdmin(Model model) {
		model.addAttribute("lista_usuarios", sc.getListaUsuarios());
		return "Listado_Usuarios";
	}
	@GetMapping("/clientes_emple")
	public String indexClientesEmple(Model model) {
		model.addAttribute("lista_usuarios", sc.getListaUsuarios());
		return "Listado_Usuarios";
	}
	//TODO: añadir solo los empleados y no todos los usuarios
	@GetMapping("/empleados_admin")
	public String indexEmpleadosAdmin(Model model) {
		model.addAttribute("lista_usuarios", sc.getListaUsuarios());
		return "Listado_Usuarios";
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
	
	
	
	@GetMapping("login")
	public String login(Model model) {
		
		model.addAttribute("usuario", new Usuarios());
		
		return "login_form";
	}
	
	@PostMapping("/login/comprobar")
	public String comprobarLogin(Model  model, @ModelAttribute Usuarios usuario, HttpSession session) {
		boolean correcto = false;
		
		Usuarios usuarioCorrecto = null;
		
		for(Usuarios u: sc.getListaUsuarios()) {
			if(u.getEmail().equals(usuario.getEmail())) {
				if(u.getClave().equals(usuario.getClave())) {
					usuarioCorrecto = u;
					correcto = true;
					break;
				}
			}
		}
		
		if(correcto) {
			Long idRol = usuarioCorrecto.getIdRol();
			System.out.println(idRol);
			//session.setAttribute("rol", usuarioCorrecto.getIdRol());
			session.setAttribute("rol", idRol);
			session.setAttribute("usuarioLogeado", usuarioCorrecto);
			return "redirect:/";
		}
		else {
			model.addAttribute("usuario", usuario);
			model.addAttribute("error", "El usuario o la contraseña no es correcto");
			return "login_form";
		}
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		
		session.setAttribute("rol", Roles.ANONIMO);
		session.setAttribute("usuarioLogeado", null);
		return "redirect:/";
	}
}
