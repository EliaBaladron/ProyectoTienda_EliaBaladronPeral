package proyecto_final.tienda.DAO;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import proyecto_final.tienda.model.Productos;
import proyecto_final.tienda.utils.HibernateUtil;

public class ProductosDAO {

	private static final Logger logger = LogManager.getLogger(ProductosDAO.class);
	
	public static Productos getProducto(int id) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Obteniendo el producto con id "+id);
		
		String hQuery = " from Productos e " +
	                  " where e.id = :id";
		
		Productos usuario = s.createQuery(hQuery, Productos.class)
	                   .setParameter("id", id)
	                   .setMaxResults(1)
	                   .uniqueResult();
		return usuario;
	}
	public static ArrayList<Productos> getProductos() {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Obteniendo los productos");
		
		String hQuery = "from Productos";
		ArrayList<Productos> productos = (ArrayList<Productos>)s.createQuery(hQuery, Productos.class).list();
		
		s.close();
		
		return productos;
		
	}
	public static void addProducto(Productos producto) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Insertando producto "+producto.toString());
		
		s.save(producto);
		
		s.close();
	}
	public static void deleteProducto(Productos producto) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Eliminando producto "+producto.toString());
		
		s.delete(producto);
		
		s.close();
	}
	public static void updateProducto(Productos producto) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Actualizando producto "+producto.toString());
		
		s.update(producto);
		
		s.close();
	}
}
