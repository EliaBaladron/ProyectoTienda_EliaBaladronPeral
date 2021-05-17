package curso.java.tienda.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.model.CambiarClave;
import curso.java.tienda.model.Roles;
import curso.java.tienda.model.Usuarios;
import curso.java.tienda.service.UsuariosService;


@Controller
@RequestMapping("")
public class UsuariosController {

	@Autowired
	private UsuariosService sc;
	
	@GetMapping("/usuarios")
	public String index(Model model) {
		model.addAttribute("lista_usuarios", sc.getListaUsuarios());
		model.addAttribute("titulo", "Usuarios");
		return "Listado_Usuarios";
	}
	
	@GetMapping("/clientes_admin")
	public String indexClientesAdmin(Model model) {
		model.addAttribute("lista_usuarios", sc.getListaUsuariosRol(Roles.CLIENTE));
		model.addAttribute("titulo", "Clientes");
		return "Listado_Usuarios";
	}
	@GetMapping("/clientes_emple")
	public String indexClientesEmple(Model model) {
		model.addAttribute("lista_usuarios", sc.getListaUsuariosRol(Roles.CLIENTE));
		model.addAttribute("titulo", "Empleados");
		return "Listado_Usuarios";
	}
	
	@GetMapping("/empleados_admin")
	public String indexEmpleadosAdmin(Model model) {
		model.addAttribute("lista_usuarios", sc.getListaUsuariosRol(Roles.EMPLEADO));
		model.addAttribute("titulo", "Empleados");
		return "Listado_Usuarios";
	}
	
	@GetMapping("/usuarios/registro")
	public String getRegistro(Model model) {
		
		model.addAttribute("usuario", new Usuarios(Roles.CLIENTE));
		model.addAttribute("titulo", "Añadir usuario");
		
		return "Usuarios";
	}
	@PostMapping("/usuarios/registro/registrar")
	public String registrar(Model model, @Valid @ModelAttribute Usuarios usuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "Usuarios";
		}
		else {
			sc.addUsuario(usuario);
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/usuarios/delete")
	public String borrar(Model model, @RequestParam String id) {
		
		sc.deleteUsuario(Long.parseLong(id));
		//sc.deleteUsuario(Integer.parseInt((id)));
		
		return "redirect:/";
	}
	
	@GetMapping("/usuarios/baja")
	public String darDeBaja(Model model, @RequestParam String id) {
		
		sc.deleteUsuario(Long.parseLong(id));
		
		return "redirect:/";
	}
	
	@GetMapping("/usuarios/edit")
	public String editar(Model model, @RequestParam String id) {
		
		model.addAttribute("usuario", sc.getUsuario(Long.parseLong(id)));
		//model.addAttribute("usuario", sc.getUsuario(Integer.parseInt(id)));
		model.addAttribute("titulo", "Editar");
		
		return "Usuarios";
	}
	@PostMapping("/usuarios/edit/editar")
	public String editSubmit(HttpSession session, Model model, @Valid @ModelAttribute Usuarios usuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "Usuarios";
		}
		else {
			sc.editUsuario(usuario);
			session.setAttribute("usuarioLogeado", usuario);
			return "redirect:/";
		}
	}
	
	@GetMapping("/usuarios/edit_pass")
	public String editarContraseña(Model model) {
		
		model.addAttribute("cambiarClave", new CambiarClave());
		model.addAttribute("titulo", "Editar la contraseña");
		
		return "EditPassword";
	}
	@PostMapping("/usuarios/edit_pass/editar")
	public String editSubmitContraseña(HttpSession session, Model model, @Valid @ModelAttribute CambiarClave cambiarClave, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("cambiarClave", cambiarClave);
			model.addAttribute("titulo", "Editar la contraseña");
			return "EditPassword";
		}
		else {
			String mensaje = comprobarClave(session, cambiarClave);
			if(mensaje == ""){
				return "redirect:/perfil";
			}else {
				model.addAttribute("error", mensaje);
				model.addAttribute("cambiarClave", cambiarClave);
				model.addAttribute("titulo", "Editar la contraseña");
				return "EditPassword";
			}
		}
	}
	String comprobarClave(HttpSession session, CambiarClave cambiarClave) {
		String mensaje = "";
		
		Usuarios usuarioLogeado = (Usuarios)session.getAttribute("usuarioLogeado");
		
		if(cambiarClave.getAntigua().equals(usuarioLogeado.getClave())) {
			if(cambiarClave.getNueva().equals(cambiarClave.getRepetida())) {
				usuarioLogeado.setClave(cambiarClave.getNueva());
				sc.editUsuario(usuarioLogeado);
			}else {
				mensaje = "La contraseña nueva no coincide en ambos campos";
			}
		}else {
			mensaje = "La contraseña antigua es incorrecta";
		}
		
		return mensaje;
	}
	
	
	
	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("usuario", new Usuarios());
		
		return "login_form";
	}
	@GetMapping("/login_carrito")
	public String loginCarrito(Model model, HttpSession session) {
		
		model.addAttribute("usuario", new Usuarios());
		session.setAttribute("login_carrito", "login_carrito");
		
		return "login_form";
	}
	
	@PostMapping("/login/comprobar")
	public String comprobarLogin(Model  model, @ModelAttribute Usuarios usuario, HttpSession session) {
		if(loginCorrecto(model, usuario, session)) {
			return "redirect:/";
		}else {
			return "login_form";
		}
	}
	@PostMapping("/login/comprobar_carrito")
	public String comprobarLoginCarrito(Model  model, @ModelAttribute Usuarios usuario, HttpSession session) {
		if(loginCorrecto(model, usuario, session)) {
			return "redirect:/carrito/realizar_pedido";
		}else {
			return "login_form";
		}
	}
	boolean loginCorrecto(Model  model, Usuarios usuario, HttpSession session) {
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
			session.setAttribute("rol", idRol);
			session.setAttribute("usuarioLogeado", usuarioCorrecto);
		}else {
			model.addAttribute("usuario", usuario);
			model.addAttribute("error", "El usuario o la contraseña no es correcto");
		}
		return correcto;
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		
		session.setAttribute("rol", Roles.ANONIMO);
		session.setAttribute("usuarioLogeado", null);
		return "redirect:/";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model, HttpSession session) {
		
		Usuarios usuario = (Usuarios)session.getAttribute("usuarioLogeado");
		
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil");
		
		return "Perfil";
	}
	@GetMapping("/perfil_emple")
	public String perfilEmpleado() {
		return "redirect:/perfil";
	}
	@GetMapping("/perfil_cliente")
	public String perfilCliente() {
		return "redirect:/perfil";
	}
}
