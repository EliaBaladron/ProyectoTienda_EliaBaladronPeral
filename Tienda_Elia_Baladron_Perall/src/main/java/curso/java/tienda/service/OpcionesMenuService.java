package curso.java.tienda.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.OpcionesMenu;
import curso.java.tienda.model.Roles;
import curso.java.tienda.repository.OpcionesMenuRepository;

@Service
public class OpcionesMenuService {
	
	Logger logger = LogManager.getLogger(OpcionesMenuService.class.getName());
	
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
		
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.EMPLEADO, "Perfil", "/perfil_emple"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.CLIENTE, "Perfil", "/perfil_cliente"
			));
		
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.CLIENTE, "Carrito", "/carrito_cliente"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.ANONIMO, "Carrito", "/carrito_anonimo"
			));
		
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.EMPLEADO, "Categorias", "/categorias"
			));
		this.opcionesMenuRepository.save(new OpcionesMenu(
				Roles.ADMIN, "Categorias", "/categorias"
			));
    	
    	logger.info("Insertando OpcionesMenu de prueba");
	}

	public Iterable<OpcionesMenu> getListaOpcionesMenu() {
    	
    	logger.info("Obteniendo todos los datos de OpcionesMenu");
    	
        return opcionesMenuRepository.findAll();
    }
	public Iterable<OpcionesMenu> getListaOpcionesMenuRol(Long rol) {
    	
    	logger.info("Obteniendo los datos de OpcionesMenu según el rol "+rol);
    	
		return opcionesMenuRepository.findByIdRol(rol);
    }

    public void addOpcionesMenu(OpcionesMenu opcionesMenu) {
    	
    	logger.info("Añadir datos de OpcionesMenu "+opcionesMenu.toString());
    	
    	opcionesMenuRepository.save(opcionesMenu);
    }
    
    public void deleteOpcionesMenu(long id) {
    	
    	logger.info("Borrando las OpcionesMenu con el id "+id);
    	
    	opcionesMenuRepository.deleteById(id);
    }
    
    public OpcionesMenu getOpcionesMenu(long id) {
    	
    	logger.info("Obtener las OpcionesMenu según el ID "+id);
    	
    	return opcionesMenuRepository.findById(id).get();
    }
    
    public void editOpcionesMenu(OpcionesMenu opcionesMenu) {
    	
    	logger.info("Editar datos de OpcionesMenu "+opcionesMenu.toString());
    	
    	opcionesMenuRepository.save(opcionesMenu);
    }
}
