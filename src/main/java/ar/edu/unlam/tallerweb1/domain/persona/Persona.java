package ar.edu.unlam.tallerweb1.domain.persona;

import ar.edu.unlam.tallerweb1.domain.estados.Estado;

import javax.persistence.*;

@Entity
public class Persona {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nombre;
	//Estado => Eenfermedades: Celiaco o Sano
	@OneToOne
	private Estado estado;
	@Column
	private String apellido;
	@Column
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
