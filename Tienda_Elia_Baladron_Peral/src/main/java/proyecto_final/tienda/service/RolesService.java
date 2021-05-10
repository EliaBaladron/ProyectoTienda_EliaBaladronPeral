package proyecto_final.tienda.service;

import java.util.ArrayList;

import proyecto_final.tienda.DAO.RolesDAO;
import proyecto_final.tienda.model.Roles;

public class RolesService {
	
	//Metodos DAO
	public static Roles getRol(int id) {
		
		return RolesDAO.getRol(id);
	}
	public static ArrayList<Roles> getRoles() {
		
		return RolesDAO.getRoles();
		
	}
	public static void addRol(Roles rol) {
		RolesDAO.addRol(rol);
	}
	public static void deleteRol(Roles rol) {
		RolesDAO.deleteRol(rol);
	}
	public static void updateRol(Roles rol) {
		RolesDAO.updateRol(rol);
	}
	
}
