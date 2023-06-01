package ar.edu.unlam.tallerweb1.domain;
import ar.edu.unlam.tallerweb1.domain.rutina.Rutina;
import ar.edu.unlam.tallerweb1.domain.estados.Estado;
import ar.edu.unlam.tallerweb1.domain.ejercicio.Ejercicio;
import ar.edu.unlam.tallerweb1.domain.rutina.RutinaRestringidaException;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class RutinaTest {
    private Rutina rutina;
    private Estado estadoMock;

    @Before
    public void init() {
        List<Ejercicio> ejercicios = new ArrayList<>();
        rutina = new Rutina(ejercicios);

        estadoMock = mock(Estado.class);
        when(estadoMock.getRestricciones()).thenReturn(new ArrayList<>()); //Simulamos estado sin restricciones declaradas
    }

    @Test
    public void queSePuedaAgregarUnEjercicioPermitido() throws RutinaRestringidaException {
        Ejercicio ejercicio = new Ejercicio("correr");
        rutina.agregarEjercicio(ejercicio, estadoMock);

        List<Ejercicio> ejercicios = rutina.getEjercicios();
        assertTrue(ejercicios.contains(ejercicio));
    }

    @Test(expected = RutinaRestringidaException.class)
    public void queSiSeIntentaAgregarUnaRutinaRestringidaLanceUnaExcepcion() throws RutinaRestringidaException {
        Ejercicio ejercicio = new Ejercicio("pesas");
        List<String> restricciones = new ArrayList<>();
        restricciones.add(ejercicio.getNombre());
        when(estadoMock.getRestricciones()).thenReturn((ArrayList<String>) restricciones);

        rutina.agregarEjercicio(ejercicio, estadoMock);
    }

    @Test
    public void queSePuedaModificarUnEjercicioCambiandoloPorOtro() {
        Ejercicio ejercicioAnterior = new Ejercicio("correr");
        Ejercicio ejercicioNuevo = new Ejercicio("nadar");

        List<Ejercicio> ejercicios = new ArrayList<>();
        ejercicios.add(ejercicioAnterior);
        rutina.setEjercicios(ejercicios);

        rutina.modificarEjercicio(ejercicioAnterior, ejercicioNuevo);

        List<Ejercicio> ejerciciosActualizados = rutina.getEjercicios();
        assertTrue(ejerciciosActualizados.contains(ejercicioNuevo));
        assertFalse(ejerciciosActualizados.contains(ejercicioAnterior));
    }

    @Test
    public void queSePuedaEliminarUnEjercicioDeLaRutina() {
        Ejercicio ejercicio = new Ejercicio("correr");

        List<Ejercicio> ejercicios = new ArrayList<>();
        ejercicios.add(ejercicio);

        rutina.setEjercicios(ejercicios);
        rutina.eliminarEjercicio(ejercicio);

        List<Ejercicio> ejerciciosActualizados = rutina.getEjercicios();
        assertFalse(ejerciciosActualizados.contains(ejercicio));
    }
}
