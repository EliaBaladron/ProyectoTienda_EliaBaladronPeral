package proyecto_final.tienda.otros;

public class Opcion {
	
	private String nombre;
	private String url;
	
	
	public Opcion() {
		super();
	}
	public Opcion(String nombre, String url) {
		super();
		this.nombre = nombre;
		this.url = url;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "Opcion [nombre=" + nombre + ", url=" + url + "]";
	}
	
}
