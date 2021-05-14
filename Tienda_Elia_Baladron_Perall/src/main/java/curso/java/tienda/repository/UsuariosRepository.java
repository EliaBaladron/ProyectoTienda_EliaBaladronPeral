package curso.java.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.java.tienda.model.Usuarios;


public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	List<Usuarios> findByIdRol(Long idRol);
}
