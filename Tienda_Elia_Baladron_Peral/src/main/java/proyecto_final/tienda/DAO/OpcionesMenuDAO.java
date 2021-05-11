package proyecto_final.tienda.DAO;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import proyecto_final.tienda.model.OpcionesMenu;
import proyecto_final.tienda.utils.HibernateUtil;

public class OpcionesMenuDAO {

	private static final Logger logger = LogManager.getLogger(OpcionesMenuDAO.class);
	
	public static OpcionesMenu getOpcionMenu(int id) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Obteniendo la opción de menú con id "+id);
		
		String hQuery = " from OpcionesMenu e " +
	                  " where e.id = :id";
		
		OpcionesMenu opcionesMenu = s.createQuery(hQuery, OpcionesMenu.class)
	                   .setParameter("id", id)
	                   .setMaxResults(1)
	                   .uniqueResult();
		return opcionesMenu;
	}
	public static ArrayList<OpcionesMenu> getOpcionesMenu() {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Obteniendo las opciones de menu");
		
		String hQuery = "from OpcionesMenu";
		ArrayList<OpcionesMenu> opcionesMenu = (ArrayList<OpcionesMenu>)s.createQuery(hQuery, OpcionesMenu.class).list();
		
		s.close();
		
		return opcionesMenu;
		
	}
	public static ArrayList<OpcionesMenu> getOpcionesMenu(int idRol) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Obteniendo las opciones de menu con idRol "+idRol);
		
		String hQuery = " from OpcionesMenu e " +
                " where e.idRol = :idRol";
		ArrayList<OpcionesMenu> opcionesMenu = (ArrayList<OpcionesMenu>)s.createQuery(hQuery, OpcionesMenu.class)
				.setParameter("idRol", idRol)
				.list();
		
		s.close();
		
		return opcionesMenu;
		
	}
	public static void addOpcionMenu(OpcionesMenu opcionesMenu) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Insertando "+opcionesMenu.toString());
		
		s.save(opcionesMenu);
		
		s.close();
	}
	public static void deleteOpcionMenu(OpcionesMenu opcionesMenu) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Eliminando "+opcionesMenu.toString());
		
		s.delete(opcionesMenu);
		
		s.close();
	}
	public static void updateOpcionMenu(OpcionesMenu opcionesMenu) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Actualizando "+opcionesMenu.toString());
		
		s.update(opcionesMenu);
		
		s.close();
	}
}
