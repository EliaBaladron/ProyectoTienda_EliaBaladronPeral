package proyecto_final.tienda.model;

/**
 * DetallesPedido generated by hbm2java
 */
public class DetallesPedido implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer idPedido;
	private Integer idProducto;
	private Float precioUnidad;
	private Integer unidades;
	private Float impuesto;
	private Double total;

	public DetallesPedido() {
	}

	public DetallesPedido(Integer idPedido, Integer idProducto, Float precioUnidad, Integer unidades, Float impuesto,
			Double total) {
		this.idPedido = idPedido;
		this.idProducto = idProducto;
		this.precioUnidad = precioUnidad;
		this.unidades = unidades;
		this.impuesto = impuesto;
		this.total = total;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Integer getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Float getPrecioUnidad() {
		return this.precioUnidad;
	}

	public void setPrecioUnidad(Float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public Integer getUnidades() {
		return this.unidades;
	}

	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}

	public Float getImpuesto() {
		return this.impuesto;
	}

	public void setImpuesto(Float impuesto) {
		this.impuesto = impuesto;
	}

	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "DetallesPedido [id=" + id + ", idPedido=" + idPedido + ", idProducto=" + idProducto + ", precioUnidad="
				+ precioUnidad + ", unidades=" + unidades + ", impuesto=" + impuesto + ", total=" + total + "]";
	}
	
	

}
