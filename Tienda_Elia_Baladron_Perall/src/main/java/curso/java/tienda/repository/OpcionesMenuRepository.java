package curso.java.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.java.tienda.model.OpcionesMenu;


public interface OpcionesMenuRepository extends JpaRepository<OpcionesMenu, Long> {
	List<OpcionesMenu> findByIdRol(Long idRol);
}
