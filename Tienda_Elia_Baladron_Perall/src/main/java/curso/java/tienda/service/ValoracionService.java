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

    
    
    public ValoracionService(ValoracionRepository valoracionRepository) {
		super();
		this.repository = valoracionRepository;
		
		this.repository.save(new Valoraciones(
				1l, 1l, 4, "Valoracion 1"
			));
    	
    	logger.info("Insertando Valoraciones de prueba");
	}

	public ArrayList<Valoraciones> getLista() {
    	
    	logger.info("Obteniendo todos los datos de Valoraciones");
    	
        return (ArrayList<Valoraciones>)repository.findAll();
    }
	public ArrayList<Valoraciones> getListaByIdProducto(String idProducto) {
    	
    	logger.info("Obteniendo los datos de Valoraciones con el idProducto "+idProducto);
    	
        return (ArrayList<Valoraciones>)repository.findByClave(idProducto);
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
