package proyecto_final.tienda.DAO;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import proyecto_final.tienda.model.Pedidos;
import proyecto_final.tienda.utils.HibernateUtil;

public class PedidosDAO {

	private static final Logger logger = LogManager.getLogger(PedidosDAO.class);
	
	public static Pedidos getPedido(int id) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Obteniendo el pedido con id "+id);
		
		String hQuery = " from Pedidos e " +
	                  " where e.id = :id";
		
		Pedidos pedidos = s.createQuery(hQuery, Pedidos.class)
	                   .setParameter("id", id)
	                   .setMaxResults(1)
	                   .uniqueResult();
		return pedidos;
	}
	public static ArrayList<Pedidos> getPedidos() {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Obteniendo los pedidos");
		
		String hQuery = "from Pedidos";
		ArrayList<Pedidos> pedidos = (ArrayList<Pedidos>)s.createQuery(hQuery, Pedidos.class).list();
		
		s.close();
		
		return pedidos;
		
	}
	public static void addPedido(Pedidos pedido) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Insertando pedido "+pedido.toString());
		
		s.save(pedido);
		
		s.close();
	}
	public static void deletePedido(Pedidos pedido) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Eliminando pedido "+pedido.toString());
		
		s.delete(pedido);
		
		s.close();
	}
	public static void updatePedido(Pedidos pedido) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Actualizando pedido "+pedido.toString());
		
		s.update(pedido);
		
		s.close();
	}
}
