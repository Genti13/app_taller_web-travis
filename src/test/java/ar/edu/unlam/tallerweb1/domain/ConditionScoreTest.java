package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.domain.conditionScore.ConditionScore;
import ar.edu.unlam.tallerweb1.domain.conditionScore.ServicioConditionScoreImp;
import ar.edu.unlam.tallerweb1.domain.dieta.Dieta;
import ar.edu.unlam.tallerweb1.domain.dieta.RepositorioDieta;
import ar.edu.unlam.tallerweb1.domain.dieta.ServicioDietaImp;
import ar.edu.unlam.tallerweb1.domain.ejercicio.Ejercicio;
import ar.edu.unlam.tallerweb1.domain.estados.Cardiaco;
import ar.edu.unlam.tallerweb1.domain.estados.Estado;
import ar.edu.unlam.tallerweb1.domain.menu.Menu;
import ar.edu.unlam.tallerweb1.domain.menu.Plato;
import ar.edu.unlam.tallerweb1.domain.persona.Persona;
import ar.edu.unlam.tallerweb1.domain.persona.RepositorioPersona;
import ar.edu.unlam.tallerweb1.domain.persona.ServicioPersonaImp;
import ar.edu.unlam.tallerweb1.domain.rutina.Rutina;
import ar.edu.unlam.tallerweb1.domain.usuarios.RepositorioUsuario;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConditionScoreTest {
    private ServicioConditionScoreImp servicioConditionScore;
    private RepositorioPersona repositorioPersona;
    private ServicioPersonaImp servicioPersona;

    @Before
    public void init() {
       servicioPersona = new ServicioPersonaImp();
       servicioConditionScore = new ServicioConditionScoreImp();
    }

    @Test
    public void valorInicialDeCSdeUserEs50(){
        Persona persona = new Persona();
        assertThat(servicioConditionScore.getActual(persona)).isEqualTo(50);
    }

    @Test
    public void calcularCSGanadoDePersonaQuierePerderPesoTieneDieta(){
        Persona persona = makePersona();
        int csGanado = servicioConditionScore.calculateEffectivity(persona);

        assertThat(csGanado).isEqualTo(10);
    }

    @Test
    public void calcularTMBPersonaSinEjercicio(){
        int VALOR_ESPERADO = 1782;
        Persona persona = makePersona();

        int valorObtenido = servicioPersona.getTMB(persona);

        assertThat(valorObtenido).isEqualTo(VALOR_ESPERADO);
    }

    private List<Dieta> makeDieta(){
        Dieta dieta = new Dieta();

        ArrayList<Rutina> rutinas = new ArrayList<Rutina>();
        rutinas.add(makeRutina());

        List<Menu> menus = new ArrayList<Menu>();
        menus.add(makeMenu());

        dieta.setMenus(menus);
        dieta.setRutinas(rutinas);

        List<Dieta> dietas = new ArrayList<Dieta>();

        dietas.add(dieta);

        return dietas;
    }
    private Menu makeMenu() {
        String in1 = "Pepino";
        String ing2 = "Berenjena";

        List<String> ingredientes = new ArrayList<String>();

        ingredientes.add(in1);
        ingredientes.add(ing2);

        Plato plato = new Plato(ingredientes);

        return new Menu(plato);
    }

    private Rutina makeRutina(){
        Ejercicio ej1 = new Ejercicio("Pesas");
        Ejercicio ej2 = new Ejercicio("Flexiones");

        ej1.setDuracion(5);
        ej2.setDuracion(5);

        List<Ejercicio> ejercicios = new ArrayList<>();

        ejercicios.add(ej1);
        ejercicios.add(ej2);

        return  new Rutina(ejercicios);
    }
    private Persona makePersona(){
        Estado enfermedad = new Cardiaco();
        Persona persona = new Persona();
        persona.setDieta(makeDieta());
        persona.setEstado(enfermedad);
        persona.setEdad(25);
        persona.setAltura(1.75);
        persona.setPeso(52);
        persona.setGenero('F');
        persona.setObjetivo(1); //0 => Gestion; 1=> Perdida de Peso; 2=> Ganancia de peso;

        return persona;
    }

}
