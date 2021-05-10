package proyecto_final.tienda.service;

import java.util.ArrayList;

import proyecto_final.tienda.DAO.ProductosDAO;
import proyecto_final.tienda.model.Productos;

public class ProductosService {
	
	//Metodos DAO
	public static Productos getProducto(int id) {
		
		return ProductosDAO.getProducto(id);
	}
	public static ArrayList<Productos> getProductos() {
		
		return ProductosDAO.getProductos();
		
	}
	public static void addProducto(Productos producto) {
		ProductosDAO.addProducto(producto);
	}
	public static void deleteProducto(Productos producto) {
		ProductosDAO.deleteProducto(producto);
	}
	public static void updateProducto(Productos producto) {
		ProductosDAO.updateProducto(producto);
	}
	
}
