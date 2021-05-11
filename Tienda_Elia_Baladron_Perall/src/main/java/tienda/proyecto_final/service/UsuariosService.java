package tienda.proyecto_final.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda.proyecto_final.model.Usuarios;
import tienda.proyecto_final.repository.UsuariosRepository;

@Service
public class UsuariosService {
	
	@Autowired
    private UsuariosRepository usuarioRepository;

    
    
    public UsuariosService(UsuariosRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
		
		this.usuarioRepository.save(new Usuarios(
				0l, 1, "mail1@mail1.com", "4321", "nombre1", "apellido11", "apellido21",
				"direccion1", "localidad1", "provincia1", "987654321", "87654321A"
			));
		this.usuarioRepository.save(new Usuarios(
				0l, 2, "mail2@mail2.com", "4322", "nombre2", "apellido12", "apellido22",
				"direccion2", "localidad2", "provincia2", "987654322", "87654322B"
			));
		this.usuarioRepository.save(new Usuarios(
				0l, 3, "mail3@mail3.com", "4323", "nombre3", "apellido13", "apellido23",
				"direccion3", "localidad3", "provincia3", "987654323", "87654323C"
			));
		
	}

	public Iterable<Usuarios> getListaUsuarios() {
        return usuarioRepository.findAll();
    }

    public void addUsuario(Usuarios contacto) {
    	usuarioRepository.save(contacto);
    }
    
    /*public void deleteContacto(Contacto contacto) {
        contactoRepository.delete(contacto);
    }*/
    
    
    
    public void deleteUsuario(long id) {
    	usuarioRepository.deleteById(id);
    }
    
    public Usuarios getUsuario(long id) {
    	
    	return usuarioRepository.findById(id).get();
    }
    
    public void editUsuario(Usuarios contacto) {
    	usuarioRepository.save(contacto);
    }
}
