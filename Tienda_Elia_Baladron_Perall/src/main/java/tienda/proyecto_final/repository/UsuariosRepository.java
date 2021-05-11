package tienda.proyecto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda.proyecto_final.model.Usuarios;


public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

}
