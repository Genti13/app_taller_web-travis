package ar.edu.grupoesfera.cursospring.dao;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.SpringTest;
import ar.edu.grupoesfera.cursospring.modelo.Persona;

public class PersonaDaoTest extends SpringTest{
	@Inject
	private PersonaDao dao;
	@Before
	public void before(){
		Persona seba = new Persona();
		seba.setApellido("Ismael");
		seba.setEmail("seba@seba.com");
		seba.setNombre("Sebastian");
		getSession().save(seba);

		Persona pedro = new Persona();
		pedro.setApellido("Gonzalez");
		pedro.setEmail("pedro@pedro.com");
		pedro.setNombre("Pedro");
		getSession().save(pedro);
	}
	
	@Test
	@Transactional @Rollback(true)
	public void testFindAll(){
		assertThat(dao.findAll()).hasSize(2);
	}

	@Test
	@Transactional @Rollback(true)
	public void findAllDeberiaDevolverListaVaciaSiNoHayFarmacias(){
		getSession().createQuery("delete from Persona").executeUpdate();
		assertThat(dao.findAll()).hasSize(0);
	}

}
