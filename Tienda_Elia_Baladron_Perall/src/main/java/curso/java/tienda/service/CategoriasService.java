package curso.java.tienda.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Categorias;
import curso.java.tienda.repository.CategoriasRepository;

@Service
public class CategoriasService {
	
	Logger logger = LogManager.getLogger(CategoriasService.class.getName());
	
	@Autowired
    private CategoriasRepository repository;

    
    
    public CategoriasService(CategoriasRepository configuracionRepository) {
		super();
		this.repository = configuracionRepository;
		
		this.repository.save(new Categorias(
				"Nombre1", "Descripción de la categoria Nombre1"
			));
		this.repository.save(new Categorias(
				"Nombre2", "Descripción de la categoria Nombre2"
			));
    	
    	logger.info("Insertando Categorias de prueba");
	}

	public ArrayList<Categorias> getLista() {
    	
    	logger.info("Obteniendo todos los datos de Categorias");
    	
        return (ArrayList<Categorias>)repository.findAll();
    }

    public void add(Categorias categoria) {
    	
    	logger.info("Añadir datos de Categorias "+categoria.toString());
    	
    	repository.save(categoria);
    }
    
    public void delete(long id) {
    	
    	logger.info("Borrando la Categoria con el id "+id);
    	
    	repository.deleteById(id);
    }
    
    public Categorias get(long id) {
    	
    	logger.info("Obtener la Categoria según el ID "+id);
    	
    	return repository.findById(id).get();
    }
    
    public void edit(Categorias categoria) {
    	
    	logger.info("Editar datos de Categoria "+ categoria.toString());
    	
    	repository.save(categoria);
    }
}
