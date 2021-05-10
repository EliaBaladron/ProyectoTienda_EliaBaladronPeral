package proyecto_final.tienda.DAO;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import proyecto_final.tienda.model.DetallesPedido;
import proyecto_final.tienda.utils.HibernateUtil;

public class DetallesPedidosDAO {

	private static final Logger logger = LogManager.getLogger(DetallesPedidosDAO.class);
	
	public static DetallesPedido getDetallesPedido(int id) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Obteniendo el detalle de pedido con id "+id);
		
		String hQuery = " from DetallesPedido e " +
	                  " where e.id = :id";
		
		DetallesPedido detallesPedidos = s.createQuery(hQuery, DetallesPedido.class)
	                   .setParameter("id", id)
	                   .setMaxResults(1)
	                   .uniqueResult();
		return detallesPedidos;
	}
	public static ArrayList<DetallesPedido> getDetallesPedidos() {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Obteniendo los detalles de pedidos");
		
		String hQuery = "from DetallesPedido";
		ArrayList<DetallesPedido> detallesPedidos = (ArrayList<DetallesPedido>)s.createQuery(hQuery, DetallesPedido.class).list();
		
		s.close();
		
		return detallesPedidos;
		
	}
	public static void addDetallesPedido(DetallesPedido detallesPedidos) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Insertando detalles de pedido "+detallesPedidos.toString());
		
		s.save(detallesPedidos);
		
		s.close();
	}
	public static void deleteDetallesPedido(DetallesPedido detallesPedidos) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Eliminando detalles de pedido "+detallesPedidos.toString());
		
		s.delete(detallesPedidos);
		
		s.close();
	}
	public static void updateDetallesPedido(DetallesPedido detallesPedidos) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Actualizando detalles de pedido "+detallesPedidos.toString());
		
		s.update(detallesPedidos);
		
		s.close();
	}
}
