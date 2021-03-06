package curso.java.tienda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Configuracion generated by hbm2java
 */
@Entity
public class Configuracion implements java.io.Serializable {
	
	public static String NOMBRE = "Nombre";
	public static String CIF = "CIF";
	public static String DIRECCION = "Direccion";
	public static String NUM_FACTURA = "NumFactura";

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String clave;
	private String valor;
	private String tipo;

	public Configuracion() {
	}

	public Configuracion(String clave, String valor, String tipo) {
		this.clave = clave;
		this.valor = valor;
		this.tipo = tipo;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Configuracion [id=" + id + ", clave=" + clave + ", valor=" + valor + ", tipo=" + tipo + "]";
	}
	
	

}
