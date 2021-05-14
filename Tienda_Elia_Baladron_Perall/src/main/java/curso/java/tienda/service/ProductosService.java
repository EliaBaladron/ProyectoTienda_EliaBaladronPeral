package curso.java.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Productos;
import curso.java.tienda.repository.ProductosRepository;;

@Service
public class ProductosService {
	
	@Autowired
    private ProductosRepository productosRepository;

    
    
    public ProductosService(ProductosRepository productosRepository) {
		super();
		this.productosRepository = productosRepository;

		this.productosRepository.save(new Productos(
				2l, "Producto4", "Descripcion4", 42.3d, 10, 42.0f, ""
			));
		this.productosRepository.save(new Productos(
				1l, "Producto1", "Descripcion1", 12.3d, 7, 12.0f, ""
			));
		this.productosRepository.save(new Productos(
				1l, "Producto2", "Descripcion2", 22.3d, 8, 22.0f, ""
			));
		this.productosRepository.save(new Productos(
				2l, "Producto3", "Descripcion3", 32.3d, 9, 32.0f, ""
			));
		
	}

	public Iterable<Productos> getListaProductos() {
        return productosRepository.findAll();
    }
	public Iterable<Productos> getListaProductosOrderByPrecio() {
        return productosRepository.findAllByOrderByPrecioAsc();
    }
	public Iterable<Productos> getListaProductosOrderByStock() {
        return productosRepository.findAllByOrderByStockDesc();
    }
	public Iterable<Productos> getListaProductosOrderByCategoria() {
        return productosRepository.findAllByOrderByIdCategoriaAsc();
    }

    public void addProducto(Productos producto) {
    	productosRepository.save(producto);
    }
    
    /*public void deleteContacto(Contacto contacto) {
        contactoRepository.delete(contacto);
    }*/
    
    
    
    public void deleteProducto(long id) {
    	productosRepository.deleteById(id);
    }
    
    public Productos getProducto(long id) {
    	
    	return productosRepository.findById(id).get();
    }
    
    public void editProducto(Productos producto) {
    	productosRepository.save(producto);
    }
}
