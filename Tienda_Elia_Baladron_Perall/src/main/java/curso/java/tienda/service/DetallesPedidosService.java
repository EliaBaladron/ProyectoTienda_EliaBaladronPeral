package curso.java.tienda.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.DetallesPedido;
import curso.java.tienda.repository.DetallesPedidosRepository;

@Service
public class DetallesPedidosService {
	
	Logger logger = LogManager.getLogger(DetallesPedidosService.class.getName());
	
	@Autowired
    private DetallesPedidosRepository detallesPedidosRepository;

    
    
    public DetallesPedidosService(DetallesPedidosRepository detallesPedidosRepository) {
		super();
		this.detallesPedidosRepository = detallesPedidosRepository;
		
		this.detallesPedidosRepository.save(new DetallesPedido(
				18l, 1l, 12.1d, 1, 12.1f, 21.1d
			));
		this.detallesPedidosRepository.save(new DetallesPedido(
				20l, 2l, 12.2d, 2, 12.2f, 21.2d
			));
		this.detallesPedidosRepository.save(new DetallesPedido(
				20l, 3l, 12.3d, 3, 12.3f, 21.3d
			));
    	
    	logger.info("Insertando DetallesPedido de prueba");
	}

	public Iterable<DetallesPedido> getListaDetallesPedidos() {
    	
    	logger.info("Obteniendo todos los datos de DetallesPedidos");
    	
        return detallesPedidosRepository.findAll();
    }
	public Iterable<DetallesPedido> getListaDetallesPedidosXPedido(Long idPedido) {
    	
    	logger.info("Obteniendo los datos de DetallesPedidos según el idPedido "+idPedido);
    	
        return detallesPedidosRepository.findByIdPedido(idPedido);
    }

    public void addDetallePedido(DetallesPedido detallesPedido) {
    	
    	logger.info("Añadir datos de DetallesPedido "+detallesPedido.toString());
    	
    	detallesPedidosRepository.save(detallesPedido);
    }
    
    public void deleteDetallePedido(long id) {
    	
    	logger.info("Borrando los DetallesPedido con el id "+id);
    	
    	detallesPedidosRepository.deleteById(id);
    }
    
    public DetallesPedido getDetallePedido(long id) {
    	
    	logger.info("Obtener los detalles de pedido según el ID "+id);
    	
    	return detallesPedidosRepository.findById(id).get();
    }
    
    public void editDetallePedido(DetallesPedido detallesPedido) {
    	
    	logger.info("Editar datos de DetallesPedidos "+detallesPedido.toString());
    	
    	detallesPedidosRepository.save(detallesPedido);
    }
}
