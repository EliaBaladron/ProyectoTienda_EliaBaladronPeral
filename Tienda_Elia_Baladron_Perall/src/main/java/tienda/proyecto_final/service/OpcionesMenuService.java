package tienda.proyecto_final.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda.proyecto_final.model.OpcionesMenu;
import tienda.proyecto_final.repository.OpcionesMenuRepository;

@Service
public class OpcionesMenuService {
	
	@Autowired
    private OpcionesMenuRepository opcionesMenuRepository;

    
    
    public OpcionesMenuService(OpcionesMenuRepository opcionesMenuRepository) {
		super();
		this.opcionesMenuRepository = opcionesMenuRepository;
		
		this.opcionesMenuRepository.save(new OpcionesMenu(
				0l, 1l, "Productos", "/productos_admin"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				0l, 2l, "Productos", "/productos_emple"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				0l, 3l, "Productos", "/productos_cliente"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				0l, 4l, "Productos", "/productos_anonimo"
			));

		this.opcionesMenuRepository.save(new OpcionesMenu(
				0l, 1l, "Clientes", "/clientes_admin"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				0l, 2l, "Clientes", "/clientes_emple"
			));

		this.opcionesMenuRepository.save(new OpcionesMenu(
				0l, 1l, "Empleados", "/empleados_admin"
			));

		this.opcionesMenuRepository.save(new OpcionesMenu(
				0l, 1l, "Pedidos", "/pedidos_admin"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				0l, 1l, "Pedidos", "/pedidos_emple"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				0l, 1l, "Pedidos", "/pedidos_cliente"
			));
		
		//TODO: añadir opciones de ver perfil
		this.opcionesMenuRepository.save(new OpcionesMenu(
				0l, 1l, "Perfil", "/perfil_emple"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				0l, 1l, "Perfil", "/perfil_cliente"
			));
		
		//TODO: añadir opciones carrito
		this.opcionesMenuRepository.save(new OpcionesMenu(
				0l, 1l, "Carrito", "/carrito_cliente"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				0l, 1l, "Carrito", "/carrito_anonimo"
			));
	}

	public Iterable<OpcionesMenu> getListaOpcionesMenu() {
        return opcionesMenuRepository.findAll();
    }
	public Iterable<OpcionesMenu> getListaOpcionesMenuRol(Long rol) {
		return opcionesMenuRepository.findByIdRol(rol);
    }

    public void addOpcionesMenu(OpcionesMenu opcionesMenu) {
    	opcionesMenuRepository.save(opcionesMenu);
    }
    
    /*public void deleteContacto(Contacto contacto) {
        contactoRepository.delete(contacto);
    }*/
    
    
    
    public void deleteOpcionesMenu(long id) {
    	opcionesMenuRepository.deleteById(id);
    }
    
    public OpcionesMenu getOpcionesMenu(long id) {
    	
    	return opcionesMenuRepository.findById(id).get();
    }
    
    public void editOpcionesMenu(OpcionesMenu opcionesMenu) {
    	opcionesMenuRepository.save(opcionesMenu);
    }
}
