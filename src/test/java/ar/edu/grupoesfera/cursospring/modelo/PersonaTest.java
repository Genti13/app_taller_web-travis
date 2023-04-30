package ar.edu.grupoesfera.cursospring.modelo;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

import ar.edu.grupoesfera.cursospring.SpringTest;

public class PersonaTest extends SpringTest{

//	@Test
//	@Transactional
//	@Rollback(true)
//	public void lis2tar(){
//		System.out.println("2 " + getSession().createCriteria(Persona.class).list().size());
//	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testPersona(){
		Persona seba = new Persona();
		seba.setApellido("Ismael");
		seba.setEmail("seba@seba.com");
		seba.setNombre("Sebastian");
		getSession().save(seba);
//		getSession().flush();
//		getSession().getTransaction().commit();
		assertThat(getSession().get(Persona.class, seba.getId())).isNotNull();
	}
	
//	@Test
//	@Transactional
//	@Rollback(true)
//	public void listar(){
//		System.out.println("1 " + getSession().createCriteria(Persona.class).list().size());
//	}
}
