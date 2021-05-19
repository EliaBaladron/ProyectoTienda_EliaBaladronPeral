package curso.java.tienda.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.MetodosPago;
import curso.java.tienda.model.Pedidos;
import curso.java.tienda.repository.PedidosRepository;

@Service
public class PedidosService {
	
	Logger logger = LogManager.getLogger(PedidosService.class.getName());
	
	@Autowired
    private PedidosRepository pedidosRepository;

    
    
    public PedidosService(PedidosRepository pedidosRepository) {
		super();
		this.pedidosRepository = pedidosRepository;
		
		this.pedidosRepository.save(new Pedidos(
				32l, MetodosPago.PAYPAL, Pedidos.ENVIADO, "2021-0001", 12.1d
			));
		this.pedidosRepository.save(new Pedidos(
				32l, MetodosPago.TARJETA, Pedidos.PENDIENTE, "", 22.1d
			));
		this.pedidosRepository.save(new Pedidos(
				32l, MetodosPago.PAYPAL, Pedidos.CANCELADO, "", 32.1d
			));
		this.pedidosRepository.save(new Pedidos(
				32l, MetodosPago.TARJETA, Pedidos.PENDIENTE, "", 42.1d
			));
    	
    	logger.info("Insertando Pedidos de prueba");
	}

	public Iterable<Pedidos> getListaPedidos() {
    	
    	logger.info("Obteniendo todos los datos de Pedidos");
    	
        return pedidosRepository.findAll();
    }
	public Iterable<Pedidos> getListaPedidosCliente(Long idCliente) {
    	
    	logger.info("Obteniendo los datos de Pedidos según el idCliente "+idCliente);
    	
        return pedidosRepository.findByIdUsuario(idCliente);
    }

    public Pedidos addPedido(Pedidos pedido) {
    	
    	logger.info("Añadir datos de Pedidos "+pedido.toString());
    	
    	return pedidosRepository.save(pedido);
    }
    
    public void deletePedido(long id) {
    	
    	logger.info("Borrando los Pedidos con el id "+id);
    	
    	pedidosRepository.deleteById(id);
    }
    
    public Pedidos getPedido(long id) {
    	
    	logger.info("Obteniendo los Pedidos según el ID "+id);
    	
    	return pedidosRepository.findById(id).get();
    }
    
    public Pedidos editPedido(Pedidos pedido) {
    	
    	logger.info("Editar datos de Pedidos "+pedido.toString());
    	
    	return pedidosRepository.save(pedido);
    }
}
