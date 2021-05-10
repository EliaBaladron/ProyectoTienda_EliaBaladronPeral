package proyecto_final.tienda.model;

import java.util.Date;

/**
 * Productos generated by hbm2java
 */
public class Productos implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Categorias categorias;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer stock;
	private Date fechaAlta;
	private Date fechaBaja;
	private Float impuesto;
	private String imagen;

	public Productos() {
	}

	public Productos(Date fechaAlta, Date fechaBaja) {
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}

	public Productos(Categorias categorias, String nombre, String descripcion, Double precio, Integer stock,
			Date fechaAlta, Date fechaBaja, Float impuesto, String imagen) {
		this.categorias = categorias;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.impuesto = impuesto;
		this.imagen = imagen;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Categorias getCategorias() {
		return this.categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Float getImpuesto() {
		return this.impuesto;
	}

	public void setImpuesto(Float impuesto) {
		this.impuesto = impuesto;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
