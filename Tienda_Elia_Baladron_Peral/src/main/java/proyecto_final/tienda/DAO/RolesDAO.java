package proyecto_final.tienda.DAO;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import proyecto_final.tienda.model.Roles;
import proyecto_final.tienda.utils.HibernateUtil;

public class RolesDAO {

	private static final Logger logger = LogManager.getLogger(RolesDAO.class);
	
	public static Roles getRol(int id) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Obteniendo el rol con id "+id);
		
		String hQuery = " from Roles e " +
	                  " where e.id = :id";
		
		Roles rol = s.createQuery(hQuery, Roles.class)
	                   .setParameter("id", id)
	                   .setMaxResults(1)
	                   .uniqueResult();
		return rol;
	}
	public static ArrayList<Roles> getRoles() {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Obteniendo los roles");
		
		String hQuery = "from Roles";
		ArrayList<Roles> roles = (ArrayList<Roles>)s.createQuery(hQuery, Roles.class).list();
		
		s.close();
		
		return roles;
		
	}
	public static void addRol(Roles rol) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Insertando rol "+rol.toString());
		
		s.save(rol);
		
		s.close();
	}
	public static void deleteRol(Roles rol) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Eliminando rol "+rol.toString());
		
		s.delete(rol);
		
		s.close();
	}
	public static void updateRol(Roles rol) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Actualizando rol "+rol.toString());
		
		s.update(rol);
		
		s.close();
	}
}
