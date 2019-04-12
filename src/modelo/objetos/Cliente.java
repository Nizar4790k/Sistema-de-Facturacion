package modelo.objetos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente extends Identified  {
	
	public Cliente() {
		
	}
	
	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public String getTelefono() {
		return telefono;
	}


	public String getCorreo() {
		return email;
	}

	@Override
	public int getId() {
		return id;
	}


	public String getEmail() {
		return email;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	


	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="email")
	private String email;
	
	@Id
	@Column(name="id")
	private int id;
	
	
	public Cliente(String nombre, String apellido, String telefono, String correo) {
	
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this. email = correo;
		
	}



	
	
	
	

}
