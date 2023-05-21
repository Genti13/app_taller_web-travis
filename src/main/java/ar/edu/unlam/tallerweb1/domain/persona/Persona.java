package ar.edu.unlam.tallerweb1.domain.persona;

import ar.edu.unlam.tallerweb1.domain.estados.Estado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Persona {


	private Long id;

	private String nombre;
	//Estado => Eenfermedades: Celiaco o Sano

	private Estado estado;

	private String apellido;

	private String email;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Estado getEstado(){return this.estado;}
	public void setEstado(Estado estado){this.estado = estado;}
}
