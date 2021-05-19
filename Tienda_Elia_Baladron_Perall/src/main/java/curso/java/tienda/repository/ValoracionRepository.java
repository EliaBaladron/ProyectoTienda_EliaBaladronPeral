package curso.java.tienda.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.java.tienda.model.Valoraciones;


public interface ValoracionRepository extends JpaRepository<Valoraciones, Long> {
	ArrayList<Valoraciones> findByClave(String clave);
}
