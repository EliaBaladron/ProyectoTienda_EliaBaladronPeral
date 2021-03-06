package curso.java.tienda.otro;

import java.util.ArrayList;

import curso.java.tienda.model.Productos;


public class ProductosAgrupadosCategoria {
	
	Long categoria;
	ArrayList<Productos> productos;
	
	
	/*public ProductosAgrupadosCategoria() {
		super();
		productos = new ArrayList<Productos>();
	}*/
	public ProductosAgrupadosCategoria(Long categoria) {
		super();
		this.categoria = categoria;
		this.productos = new ArrayList<Productos>();
	}
	public ProductosAgrupadosCategoria(Long categoria, ArrayList<Productos> productos) {
		super();
		this.categoria = categoria;
		this.productos = productos;
	}
	
	
	public Long getCategoria() {
		return categoria;
	}
	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}
	public ArrayList<Productos> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Productos> productos) {
		this.productos = productos;
	}
	
	
	public void addProducto(Productos producto) {
		productos.add(producto);
	}
	
	
}
