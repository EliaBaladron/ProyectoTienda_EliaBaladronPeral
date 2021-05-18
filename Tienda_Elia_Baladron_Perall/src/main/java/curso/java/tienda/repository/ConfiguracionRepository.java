package curso.java.tienda.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.java.tienda.model.Configuracion;


public interface ConfiguracionRepository extends JpaRepository<Configuracion, Long> {
	ArrayList<Configuracion> findByClave(String clave);
}
