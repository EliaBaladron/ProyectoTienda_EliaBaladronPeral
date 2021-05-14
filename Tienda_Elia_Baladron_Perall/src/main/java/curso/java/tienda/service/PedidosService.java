package curso.java.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.MetodosPago;
import curso.java.tienda.model.Pedidos;
import curso.java.tienda.repository.PedidosRepository;

@Service
public class PedidosService {
	
	@Autowired
    private PedidosRepository pedidosRepository;

    
    
    public PedidosService(PedidosRepository pedidosRepository) {
		super();
		this.pedidosRepository = pedidosRepository;
		
		this.pedidosRepository.save(new Pedidos(
				28l, MetodosPago.PAYPAL, Pedidos.ENVIADO, "2020-10", 12.1d
			));
		this.pedidosRepository.save(new Pedidos(
				28l, MetodosPago.TARJETA, Pedidos.PENDIENTE, "2020-20", 22.1d
			));
		this.pedidosRepository.save(new Pedidos(
				28l, MetodosPago.PAYPAL, Pedidos.CANCELADO, "2020-30", 32.1d
			));
		this.pedidosRepository.save(new Pedidos(
				28l, MetodosPago.TARJETA, Pedidos.PENDIENTE, "2020-40", 42.1d
			));
		
	}

	public Iterable<Pedidos> getListaPedidos() {
        return pedidosRepository.findAll();
    }
	public Iterable<Pedidos> getListaPedidosCliente(Long idCliente) {
        return pedidosRepository.findByIdUsuario(idCliente);
    }

    public Pedidos addPedido(Pedidos pedido) {
    	return pedidosRepository.save(pedido);
    }
    
    public void deletePedido(long id) {
    	pedidosRepository.deleteById(id);
    }
    
    public Pedidos getPedido(long id) {
    	
    	return pedidosRepository.findById(id).get();
    }
    
    public Pedidos editPedido(Pedidos pedido) {
    	return pedidosRepository.save(pedido);
    }
}
