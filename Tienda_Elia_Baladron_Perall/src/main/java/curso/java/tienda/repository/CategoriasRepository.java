package curso.java.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.java.tienda.model.Categorias;


public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
}
