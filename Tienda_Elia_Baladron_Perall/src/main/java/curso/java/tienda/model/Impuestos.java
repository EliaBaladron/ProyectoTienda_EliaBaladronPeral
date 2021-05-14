package curso.java.tienda.model;

/**
 * Impuestos generated by hbm2java
 */
public class Impuestos implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Float impuesto;

	public Impuestos() {
	}

	public Impuestos(Float impuesto) {
		this.impuesto = impuesto;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getImpuesto() {
		return this.impuesto;
	}

	public void setImpuesto(Float impuesto) {
		this.impuesto = impuesto;
	}

	@Override
	public String toString() {
		return "Impuestos [id=" + id + ", impuesto=" + impuesto + "]";
	}
	
	

}