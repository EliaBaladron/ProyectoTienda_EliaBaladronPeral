package tienda.proyecto_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda.proyecto_final.model.DetallesPedido;


public interface DetallesPedidosRepository extends JpaRepository<DetallesPedido, Long> {
	List<DetallesPedido> findByIdPedido(Long idPedido);
}
