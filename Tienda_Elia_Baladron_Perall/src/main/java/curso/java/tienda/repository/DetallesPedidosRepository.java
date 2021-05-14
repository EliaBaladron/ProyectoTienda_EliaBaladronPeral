package curso.java.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.java.tienda.model.DetallesPedido;


public interface DetallesPedidosRepository extends JpaRepository<DetallesPedido, Long> {
	List<DetallesPedido> findByIdPedido(Long idPedido);
}
