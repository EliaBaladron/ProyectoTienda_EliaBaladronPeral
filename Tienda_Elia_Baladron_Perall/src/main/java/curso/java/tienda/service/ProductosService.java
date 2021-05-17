package curso.java.tienda.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Productos;
import curso.java.tienda.repository.ProductosRepository;;

@Service
public class ProductosService {
	
	Logger logger = LogManager.getLogger(ProductosService.class.getName());
	
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
    	
    	logger.info("Insertando Productos de prueba");
	}

	public Iterable<Productos> getListaProductos() {
    	
    	logger.info("Obteniendo todos los datos de Productos");
    	
        return productosRepository.findAll();
    }
	public Iterable<Productos> getListaProductosOrderByPrecio() {
    	
		logger.info("Obteniendo todos los datos de Productos ordenados por precio");
    	
        return productosRepository.findAllByOrderByPrecioAsc();
    }
	public Iterable<Productos> getListaProductosOrderByStock() {
    	
		logger.info("Obteniendo todos los datos de Productos ordenados por stock");
    	
        return productosRepository.findAllByOrderByStockDesc();
    }
	public Iterable<Productos> getListaProductosOrderByCategoria() {
		
		logger.info("Obteniendo todos los datos de Productos ordenados por categoría");
		
        return productosRepository.findAllByOrderByIdCategoriaAsc();
    }

    public void addProducto(Productos producto) {
    	
    	logger.info("Añadir datos de Productos "+producto.toString());
    	
    	productosRepository.save(producto);
    }
    
    public void deleteProducto(long id) {
    	
    	logger.info("Borrando los Productos con el id "+id);
    	
    	productosRepository.deleteById(id);
    }
    
    public Productos getProducto(long id) {
    	
    	logger.info("Obtener los Productos según el ID "+id);
    	
    	return productosRepository.findById(id).get();
    }
    
    public void editProducto(Productos producto) {
    	
    	logger.info("Editar datos de Productos "+producto.toString());
    	
    	productosRepository.save(producto);
    }
}
