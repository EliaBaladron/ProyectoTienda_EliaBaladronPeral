package proyecto_final.tienda.service;

import java.util.ArrayList;

import proyecto_final.tienda.DAO.PedidosDAO;
import proyecto_final.tienda.model.Pedidos;

public class PedidosService {
	
	//Metodos DAO
	public static Pedidos getPedido(int id) {
		
		return PedidosDAO.getPedido(id);
	}
	public static ArrayList<Pedidos> getPedidos() {
		
		return PedidosDAO.getPedidos();
		
	}
	public static void addPedido(Pedidos pedidos) {
		PedidosDAO.addPedido(pedidos);
	}
	public static void deletePedido(Pedidos pedidos) {
		PedidosDAO.deletePedido(pedidos);
	}
	public static void updatePedido(Pedidos pedidos) {
		PedidosDAO.updatePedido(pedidos);
	}
	
}
