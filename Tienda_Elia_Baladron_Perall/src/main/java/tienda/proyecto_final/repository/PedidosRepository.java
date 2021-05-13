package tienda.proyecto_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda.proyecto_final.model.Pedidos;


public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
	List<Pedidos> findByIdUsuario(Long idUsuario);
}
