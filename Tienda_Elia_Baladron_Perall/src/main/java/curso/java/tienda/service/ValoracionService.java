package curso.java.tienda.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Valoraciones;
import curso.java.tienda.repository.ValoracionRepository;

@Service
public class ValoracionService {
	
	Logger logger = LogManager.getLogger(ValoracionService.class.getName());
	
	@Autowired
    private ValoracionRepository repository;

    
    
    public ValoracionService(ValoracionRepository repository) {
		super();
		this.repository = repository;
		
		this.repository.save(new Valoraciones(
				28l, 32l, 4, "Valoracion 1"
			));
		this.repository.save(new Valoraciones(
				28l, 32l, 4, "Valoracion 2"
			));
		this.repository.save(new Valoraciones(
				29l, 32l, 4, "Valoracion 3"
			));
		this.repository.save(new Valoraciones(
				30l, 32l, 4, "Valoracion 4"
			));
    	
    	logger.info("Insertando Valoraciones de prueba");
	}

	public ArrayList<Valoraciones> getLista() {
    	
    	logger.info("Obteniendo todos los datos de Valoraciones");
    	
        return (ArrayList<Valoraciones>)repository.findAll();
    }
	public ArrayList<Valoraciones> getListaByIdProducto(long idProducto) {
    	
    	logger.info("Obteniendo los datos de Valoraciones con el idProducto "+idProducto);
    	
    	return repository.findByIdProducto(idProducto);
    }

    public void add(Valoraciones valoracion) {
    	
    	logger.info("Añadir datos de Valoraciones "+valoracion.toString());
    	
    	repository.save(valoracion);
    }
    
    public void delete(long id) {
    	
    	logger.info("Borrando la Valoracion con el id "+id);
    	
    	repository.deleteById(id);
    }
    
    public Valoraciones get(long id) {
    	
    	logger.info("Obtener la Valoracion según el ID "+id);
    	
    	return repository.findById(id).get();
    }
    
    public void edit(Valoraciones valoracion) {
    	
    	logger.info("Editar datos de Valoracion "+valoracion.toString());
    	
    	repository.save(valoracion);
    }
}
