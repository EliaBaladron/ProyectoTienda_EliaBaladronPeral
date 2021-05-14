package tienda.proyecto_final.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda.proyecto_final.model.Productos;


public interface ProductosRepository extends JpaRepository<Productos, Long> {
	ArrayList<Productos> findAllByOrderByPrecioAsc();
	ArrayList<Productos> findAllByOrderByStockDesc();
	ArrayList<Productos> findAllByOrderByIdCategoriaAsc();
}
