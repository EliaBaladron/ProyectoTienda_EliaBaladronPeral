package tienda.proyecto_final.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda.proyecto_final.model.Pedidos;
import tienda.proyecto_final.repository.PedidosRepository;

@Service
public class PedidosService {
	
	@Autowired
    private PedidosRepository pedidosRepository;

    
    
    public PedidosService(PedidosRepository pedidosRepository) {
		super();
		this.pedidosRepository = pedidosRepository;
		
		this.pedidosRepository.save(new Pedidos(
				0l, 1l, new Date(), "metodo1", "estado1", "2020-10", 12.1d
			));
		this.pedidosRepository.save(new Pedidos(
				0l, 1l, new Date(), "metodo2", "estado2", "2020-20", 22.1d
			));
		this.pedidosRepository.save(new Pedidos(
				0l, 1l, new Date(), "metodo3", "estado3", "2020-30", 32.1d
			));
		
	}

	public Iterable<Pedidos> getListaPedidos() {
        return pedidosRepository.findAll();
    }

    public void addPedido(Pedidos pedido) {
    	pedidosRepository.save(pedido);
    }
    
    public void deletePedido(long id) {
    	pedidosRepository.deleteById(id);
    }
    
    public Pedidos getPedido(long id) {
    	
    	return pedidosRepository.findById(id).get();
    }
    
    public void editPedido(Pedidos pedido) {
    	pedidosRepository.save(pedido);
    }
}
