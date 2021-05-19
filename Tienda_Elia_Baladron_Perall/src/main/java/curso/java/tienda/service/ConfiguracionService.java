package curso.java.tienda.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Configuracion;
import curso.java.tienda.repository.ConfiguracionRepository;

@Service
public class ConfiguracionService {
	
	Logger logger = LogManager.getLogger(ConfiguracionService.class.getName());
	
	@Autowired
    private ConfiguracionRepository repository;

    
    
    public ConfiguracionService(ConfiguracionRepository configuracionRepository) {
		super();
		this.repository = configuracionRepository;
		
		this.repository.save(new Configuracion(
				Configuracion.NOMBRE, "Tienda.es", "texto"
			));
		this.repository.save(new Configuracion(
				Configuracion.CIF, "A58818501", "texto"
			));
		this.repository.save(new Configuracion(
				Configuracion.DIRECCION, "Zamora", "texto"
			));
		this.repository.save(new Configuracion(
				Configuracion.NUM_FACTURA, "2021-0002", "texto"
			));
    	
    	logger.info("Insertando Configuracion de prueba");
	}

	public ArrayList<Configuracion> getLista() {
    	
    	logger.info("Obteniendo todos los datos de Configuracion");
    	
        return (ArrayList<Configuracion>)repository.findAll();
    }
	public ArrayList<Configuracion> getListaByClave(String clave) {
    	
    	logger.info("Obteniendo los datos de Configuracion con la calave "+clave);
    	
        return (ArrayList<Configuracion>)repository.findByClave(clave);
    }

    public void add(Configuracion configuracion) {
    	
    	logger.info("Añadir datos de Configuracion "+configuracion.toString());
    	
    	repository.save(configuracion);
    }
    
    public void delete(long id) {
    	
    	logger.info("Borrando la Configuracion con el id "+id);
    	
    	repository.deleteById(id);
    }
    
    public Configuracion get(long id) {
    	
    	logger.info("Obtener la Configuracion según el ID "+id);
    	
    	return repository.findById(id).get();
    }
    
    public void edit(Configuracion configuracion) {
    	
    	logger.info("Editar datos de Configuracion "+configuracion.toString());
    	
    	repository.save(configuracion);
    }
}
