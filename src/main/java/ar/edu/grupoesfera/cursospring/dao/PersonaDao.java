package ar.edu.grupoesfera.cursospring.dao;

import java.util.List;

import ar.edu.grupoesfera.cursospring.modelo.Persona;

public interface PersonaDao {

	List<Persona> findAll();
	
	void save(Persona persona);

	Persona findById(Long id);
}
