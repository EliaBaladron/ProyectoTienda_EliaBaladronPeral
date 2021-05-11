package tienda.proyecto_final.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import tienda.proyecto_final.model.Productos;
import tienda.proyecto_final.repository.ProductosRepository;;

@Service
public class ProductosService {
	
	@Autowired
    private ProductosRepository productosRepository;

    
    
    public ProductosService(ProductosRepository productosRepository) {
		super();
		this.productosRepository = productosRepository;
		
		this.productosRepository.save(new Productos(
				0l, 1l, "Producto1", "Descripcion1", 12.3d, 7, new Date(), null, 12.0f, ""
			));
		this.productosRepository.save(new Productos(
				0l, 1l, "Producto2", "Descripcion2", 22.3d, 8, new Date(), null, 22.0f, ""
			));
		this.productosRepository.save(new Productos(
				0l, 1l, "Producto1", "Descripcion1", 32.3d, 9, new Date(), null, 32.0f, ""
			));
		
	}

	public Iterable<Productos> getListaProductos() {
        return productosRepository.findAll();
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
