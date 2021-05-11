package tienda.proyecto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda.proyecto_final.model.Productos;


public interface ProductosRepository extends JpaRepository<Productos, Long> {

}
