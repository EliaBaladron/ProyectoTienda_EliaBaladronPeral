package curso.java.tienda.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class CambiarClave{
	

	@NotBlank(message="La clave es obligatoria")
	private String antigua;
	@NotBlank(message="La clave es obligatoria") @Size(min=4, max=8, message="La clave debe tener un mínimo de 4 caracteres y un máximo de 8")
	private String nueva;
	@NotBlank(message="La clave es obligatoria")
	private String repetida;
	
	
	public CambiarClave() {
		super();
	}
	public CambiarClave(@NotBlank(message = "La clave es obligatoria") String antigua,
			@NotBlank(message = "La clave es obligatoria") @Size(min = 4, max = 8, message = "La clave debe tener un mínimo de 4 caracteres y un máximo de 8") String nueva,
			@NotBlank(message = "La clave es obligatoria") String repetida) {
		super();
		this.antigua = antigua;
		this.nueva = nueva;
		this.repetida = repetida;
	}
	
	
	public String getAntigua() {
		return antigua;
	}
	public void setAntigua(String antigua) {
		this.antigua = antigua;
	}
	public String getNueva() {
		return nueva;
	}
	public void setNueva(String nueva) {
		this.nueva = nueva;
	}
	public String getRepetida() {
		return repetida;
	}
	public void setRepetida(String repetida) {
		this.repetida = repetida;
	}
}
