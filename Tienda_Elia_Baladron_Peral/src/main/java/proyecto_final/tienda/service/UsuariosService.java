package proyecto_final.tienda.service;

import java.util.ArrayList;

import proyecto_final.tienda.DAO.UsuariosDAO;
import proyecto_final.tienda.model.Usuarios;

public class UsuariosService {
	
	//Metodos DAO
	public static Usuarios getUsuario(int id) {
		
		return UsuariosDAO.getUsuario(id);
	}
	public static ArrayList<Usuarios> getUsuarios() {
		
		return UsuariosDAO.getUsuarios();
		
	}
	public static void addUsuario(Usuarios usuario) {
		UsuariosDAO.addUsuario(usuario);
	}
	public static void deleteUsuario(Usuarios usuario) {
		UsuariosDAO.deleteUsuario(usuario);
	}
	public static void updateUsuario(Usuarios usuario) {
		UsuariosDAO.updateUsuario(usuario);
	}
	

	
	public static boolean usuarioCorrecto(String user, String pass) {
		boolean correcto = false;
		
		ArrayList<Usuarios> usuarios = getUsuarios();
		
		for(Usuarios u: usuarios) {
			
			if(u.getEmail() == user) {
				if(u.getClave() == pass) {
					correcto = true;
					break;
				}
			}
			
		}
		
		
		return correcto;
	}
	
}
