package ar.edu.grupoesfera.cursospring.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.modelo.Persona;

@Service("personaDao")
@Transactional
public class PersonaDaoImpl implements PersonaDao{

	@Inject
	private SessionFactory sessionFactory;
    
	@SuppressWarnings("unchecked")
	public List<Persona> findAll() {
		System.out.println("Ejecutando find all");
		return (List<Persona>) sessionFactory.getCurrentSession().createCriteria(Persona.class).list();
	}

	@Override
	public void save(Persona persona) {
		sessionFactory.getCurrentSession().save(persona);
	}

	@Override
	public Persona findById(Long id) {
		return sessionFactory.getCurrentSession().get(Persona.class, id);
	}
	
}
