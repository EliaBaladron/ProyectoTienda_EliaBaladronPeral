package curso.java.tienda.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.java.tienda.model.Productos;


public interface ProductosRepository extends JpaRepository<Productos, Long> {
	ArrayList<Productos> findAllByOrderByPrecioAsc();
	ArrayList<Productos> findAllByOrderByStockDesc();
	ArrayList<Productos> findAllByOrderByIdCategoriaAsc();
}
