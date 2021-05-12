package tienda.proyecto_final.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda.proyecto_final.model.OpcionesMenu;
import tienda.proyecto_final.model.Roles;
import tienda.proyecto_final.repository.OpcionesMenuRepository;

@Service
public class OpcionesMenuService {
	
	@Autowired
    private OpcionesMenuRepository opcionesMenuRepository;

    
    
    public OpcionesMenuService(OpcionesMenuRepository opcionesMenuRepository) {
		super();
		this.opcionesMenuRepository = opcionesMenuRepository;
		
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.ADMIN, "Productos", "/productos_admin"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.EMPLEADO, "Productos", "/productos_emple"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.CLIENTE, "Productos", "/productos_cliente"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.ANONIMO, "Productos", "/productos_anonimo"
			));

		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.ADMIN, "Clientes", "/clientes_admin"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.EMPLEADO, "Clientes", "/clientes_emple"
			));

		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.ADMIN, "Empleados", "/empleados_admin"
			));

		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.ADMIN, "Pedidos", "/pedidos_admin"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.EMPLEADO, "Pedidos", "/pedidos_emple"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.CLIENTE, "Pedidos", "/pedidos_cliente"
			));
		
		//TODO: añadir opciones de ver perfil
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.EMPLEADO, "Perfil", "/perfil_emple"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.CLIENTE, "Perfil", "/perfil_cliente"
			));
		
		//TODO: añadir opciones carrito
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.CLIENTE, "Carrito", "/carrito_cliente"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.ANONIMO, "Carrito", "/carrito_anonimo"
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
