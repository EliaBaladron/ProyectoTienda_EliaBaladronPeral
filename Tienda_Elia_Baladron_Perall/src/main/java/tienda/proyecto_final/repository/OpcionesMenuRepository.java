package tienda.proyecto_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda.proyecto_final.model.OpcionesMenu;


public interface OpcionesMenuRepository extends JpaRepository<OpcionesMenu, Long> {
	List<OpcionesMenu> findByIdRol(Long idRol);
}
