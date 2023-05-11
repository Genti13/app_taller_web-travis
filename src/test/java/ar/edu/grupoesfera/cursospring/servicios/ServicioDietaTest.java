package ar.edu.grupoesfera.cursospring.servicios;

import ar.edu.grupoesfera.cursospring.modelo.*;
import ar.edu.grupoesfera.cursospring.modelo.estados.Cardiaco;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class ServicioDietaTest {
    private ServicioDietaImp servicioDieta;
    private Dieta dieta;

    @Before
    public void init() {
        servicioDieta = new ServicioDietaImp();
        dieta = new Dieta();
    }

    @Test(expected = MenuRestringidoException.class)
    public void unaPersonaConProblemasCardiacosNoPuedeAgregarUnMenuConSal() throws MenuRestringidoException {
        Plato plato = new Plato("sal");
        Menu menu = new Menu(plato);

        Estado enfermedad = new Cardiaco();
        Persona persona = new Persona();
        persona.setEstado(enfermedad);

        servicioDieta.agregarMenu(dieta, menu, persona.getEstado().getRestricciones());
    }

    @Test(expected = RutinaRestringidaException.class)
    public void unaPersonaConProblemasCardiacosNoPuedeAgregarUnaRutinaConPesas() throws RutinaRestringidaException {
        Rutina rutina = new Rutina("pesas");
        ArrayList<String> ejercicios = new ArrayList<String>();
        ejercicios.add("pesas");
        rutina.setEjercicios(ejercicios);

        Estado enfermedad = new Cardiaco();
        Persona persona = new Persona();
        persona.setEstado(enfermedad);

        servicioDieta.agregarRutina(dieta, rutina, persona.getEstado().getRestricciones());
    }

    @Test
    public void sePuedeEditarUnMenuDentroDeUnaDieta() throws MenuRestringidoException {
        Plato plato = new Plato("pepino");
        Menu menu = new Menu(plato);

        Persona persona = new Persona();
        persona.setEstado(new Cardiaco());

        servicioDieta.agregarMenu(dieta, menu, persona.getEstado().getRestricciones());

        Plato newPlato = new Plato("pepino");
        Menu newMenu = new Menu(newPlato);

        servicioDieta.modificarMenu(dieta, menu, newMenu);

        assertThat(dieta.getMenus().get(0).equals(newMenu));
    }

    @Test
    public void sePuedeEditarUnaRutinaDentroDeUnaDieta() {

    }

}
