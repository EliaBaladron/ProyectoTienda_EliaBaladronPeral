package tienda.proyecto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda.proyecto_final.model.Pedidos;


public interface PedidosRepository extends JpaRepository<Pedidos, Long> {

}
