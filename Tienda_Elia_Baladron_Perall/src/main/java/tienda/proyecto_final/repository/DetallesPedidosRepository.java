package tienda.proyecto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda.proyecto_final.model.DetallesPedido;


public interface DetallesPedidosRepository extends JpaRepository<DetallesPedido, Long> {

}
