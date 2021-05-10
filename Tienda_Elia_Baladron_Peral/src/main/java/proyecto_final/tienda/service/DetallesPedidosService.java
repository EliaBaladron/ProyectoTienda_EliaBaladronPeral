package proyecto_final.tienda.service;

import java.util.ArrayList;

import proyecto_final.tienda.DAO.DetallesPedidosDAO;
import proyecto_final.tienda.model.DetallesPedido;;

public class DetallesPedidosService {
	
	//Metodos DAO
	public static DetallesPedido getDetallesPedido(int id) {
		
		return DetallesPedidosDAO.getDetallesPedido(id);
	}
	public static ArrayList<DetallesPedido> getDetallesPedidos() {
		
		return DetallesPedidosDAO.getDetallesPedidos();
		
	}
	public static void addDetallesPedido(DetallesPedido detallesPedidos) {
		DetallesPedidosDAO.addDetallesPedido(detallesPedidos);
	}
	public static void deleteDetallesPedido(DetallesPedido detallesPedidos) {
		DetallesPedidosDAO.deleteDetallesPedido(detallesPedidos);
	}
	public static void updateDetallesPedido(DetallesPedido detallesPedidos) {
		DetallesPedidosDAO.updateDetallesPedido(detallesPedidos);
	}
	
}
