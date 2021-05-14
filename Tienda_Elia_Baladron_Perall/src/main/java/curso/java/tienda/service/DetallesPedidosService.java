package curso.java.tienda.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.DetallesPedido;
import curso.java.tienda.repository.DetallesPedidosRepository;

@Service
public class DetallesPedidosService {
	
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
		
	}

	public Iterable<DetallesPedido> getListaDetallesPedidos() {
        return detallesPedidosRepository.findAll();
    }
	public Iterable<DetallesPedido> getListaDetallesPedidosXPedido(Long idPedido) {
        return detallesPedidosRepository.findByIdPedido(idPedido);
    }

    public void addDetallePedido(DetallesPedido detallesPedido) {
    	detallesPedidosRepository.save(detallesPedido);
    }
    
    public void deleteDetallePedido(long id) {
    	detallesPedidosRepository.deleteById(id);
    }
    
    public DetallesPedido getDetallePedido(long id) {
    	
    	return detallesPedidosRepository.findById(id).get();
    }
    
    public void editDetallePedido(DetallesPedido detallesPedido) {
    	detallesPedidosRepository.save(detallesPedido);
    }
}
