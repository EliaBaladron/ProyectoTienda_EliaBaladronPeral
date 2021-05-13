package tienda.proyecto_final.service;

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
				28l, "metodo1", Pedidos.ENVIADO, "2020-10", 12.1d
			));
		this.pedidosRepository.save(new Pedidos(
				28l, "metodo2", Pedidos.PENDIENTE, "2020-20", 22.1d
			));
		this.pedidosRepository.save(new Pedidos(
				28l, "metodo3", Pedidos.CANCELADO, "2020-30", 32.1d
			));
		this.pedidosRepository.save(new Pedidos(
				28l, "metodo4", Pedidos.PENDIENTE, "2020-40", 42.1d
			));
		
	}

	public Iterable<Pedidos> getListaPedidos() {
        return pedidosRepository.findAll();
    }
	public Iterable<Pedidos> getListaPedidosCliente(Long idCliente) {
        return pedidosRepository.findByIdUsuario(idCliente);
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
