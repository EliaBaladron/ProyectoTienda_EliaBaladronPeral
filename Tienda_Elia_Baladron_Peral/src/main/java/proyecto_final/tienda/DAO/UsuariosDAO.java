package proyecto_final.tienda.DAO;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import proyecto_final.tienda.model.Usuarios;
import proyecto_final.tienda.utils.HibernateUtil;

public class UsuariosDAO {

	private static final Logger logger = LogManager.getLogger(UsuariosDAO.class);
	
	public static Usuarios getUsuario(int id) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Obteniendo el usuario con id "+id);
		
		String hQuery = " from Usuarios e " +
	                  " where e.id = :id";
		
		Usuarios usuario = s.createQuery(hQuery, Usuarios.class)
	                   .setParameter("id", id)
	                   .setMaxResults(1)
	                   .uniqueResult();
		return usuario;
	}
	public static ArrayList<Usuarios> getUsuarios() {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Obteniendo los usuarios");
		
		String hQuery = "from Usuarios";
		ArrayList<Usuarios> usuarios = (ArrayList<Usuarios>)s.createQuery(hQuery, Usuarios.class).list();
		
		s.close();
		
		return usuarios;
		
	}
	public static void addUsuario(Usuarios usuario) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Insertando usuario "+usuario.toString());
		
		s.save(usuario);
		
		s.close();
	}
	public static void deleteUsuario(Usuarios usuario) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Eliminando usuario "+usuario.toString());
		
		s.delete(usuario);
		
		s.close();
	}
	public static void updateUsuario(Usuarios usuario) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Actualizando usuario "+usuario.toString());
		
		s.update(usuario);
		
		s.close();
	}
}
