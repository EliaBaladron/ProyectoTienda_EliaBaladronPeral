package proyecto_final.tienda.service;

import java.util.ArrayList;

import proyecto_final.tienda.DAO.OpcionesMenuDAO;
import proyecto_final.tienda.model.OpcionesMenu;

public class OpcionesMenuService {
	
	//Metodos DAO
	public static OpcionesMenu getRol(int id) {
		
		return OpcionesMenuDAO.getOpcionMenu(id);
	}
	public static ArrayList<OpcionesMenu> getRoles() {
		
		return OpcionesMenuDAO.getOpcionesMenu();
		
	}
	public static ArrayList<OpcionesMenu> getRoles(int idRol) {
		
		return OpcionesMenuDAO.getOpcionesMenu(idRol);
		
	}
	public static void addRol(OpcionesMenu rol) {
		OpcionesMenuDAO.addOpcionMenu(rol);
	}
	public static void deleteRol(OpcionesMenu rol) {
		OpcionesMenuDAO.deleteOpcionMenu(rol);
	}
	public static void updateRol(OpcionesMenu rol) {
		OpcionesMenuDAO.updateOpcionMenu(rol);
	}
	
}
