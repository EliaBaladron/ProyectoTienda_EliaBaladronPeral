package proyecto_final.tienda.model;

/**
 * MetodosPago generated by hbm2java
 */
public class MetodosPago implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String metodoPago;

	public MetodosPago() {
	}

	public MetodosPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMetodoPago() {
		return this.metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

}