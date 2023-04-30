package ar.edu.grupoesfera.cursospring.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.grupoesfera.cursospring.modelo.Persona;
import ar.edu.grupoesfera.cursospring.servicios.PersonaService;

@RestController
public class ControladorApiRest {

	@Inject
	private PersonaService personaService;
	
	@RequestMapping(path="/api/personas", method = RequestMethod.GET)
	public List<Persona> listarPersonas(){
		List<Persona> personas = this.personaService.listarTodas();
		return personas;
	}
	
	@RequestMapping(path="/api/persona/{id}")
	public Persona obtenerUnaPersona(@PathVariable Long id) {
		return this.personaService.buscarPorId(id);
	}

	@RequestMapping(path="/api/cargar")
	public void generarDatos(){
		Persona p1 = new Persona();
		p1.setApellido("Ismael");
		p1.setEmail("seba@seba.com");
		p1.setNombre("Sebastian");
		personaService.guardar(p1);
		Persona p2 = new Persona();
		p2.setApellido("Messi");
		p2.setEmail("seba@seba.com");
		p2.setNombre("Lionel");
		personaService.guardar(p2);
		Persona p3 = new Persona();
		p3.setApellido("higuain");
		p3.setEmail("seba@seba.com");
		p3.setNombre("Gonzalo");
		personaService.guardar(p3);
		Persona p4 = new Persona();
		p4.setApellido("Rojo");
		p4.setEmail("seba@seba.com");
		p4.setNombre("Marcos");
		personaService.guardar(p4);

	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}
	
}
