package curso.java.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.java.tienda.model.Pedidos;


public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
	List<Pedidos> findByIdUsuario(Long idUsuario);
}
