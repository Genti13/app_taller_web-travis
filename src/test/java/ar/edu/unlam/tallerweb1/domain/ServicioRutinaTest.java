package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.domain.rutina.*;
import ar.edu.unlam.tallerweb1.domain.estados.Estado;
import ar.edu.unlam.tallerweb1.domain.ejercicio.*;
import ar.edu.unlam.tallerweb1.domain.rutina.RutinaRestringidaException;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ServicioRutinaTest {
    private Rutina rutina;
    private ServicioRutinaImp servicioRutina;
    private Estado estadoMock;

    @Before
    public void init() {
        List<Ejercicio> ejercicios = new ArrayList<>();
        rutina = new Rutina(ejercicios);
        servicioRutina = new ServicioRutinaImp();

        estadoMock = mock(Estado.class);
        when(estadoMock.getRestricciones()).thenReturn(new ArrayList<>()); //Simulamos estado sin restricciones declaradas
    }

    @Test
    public void queSePuedaAgregarUnEjercicioPermitido() throws RutinaRestringidaException, EjercicioRepetidoException {
        Ejercicio ejercicio = new Ejercicio("correr");
        List<Ejercicio> ejercicios = rutina.getEjercicios();
        Rutina rutina = new Rutina(ejercicios);

        servicioRutina.agregarEjercicio(ejercicio, rutina, estadoMock);
        assertTrue(ejercicios.contains(ejercicio));
    }

    @Test
    public void queSePuedaAgregarVariosEjerciciosPermitidos() throws RutinaRestringidaException, EjercicioRepetidoException {
        Ejercicio ejercicio1 = new Ejercicio("correr");
        Ejercicio ejercicio2 = new Ejercicio("nadar");

        List<Ejercicio> ejercicios = new ArrayList<>();
        Rutina rutina = new Rutina(ejercicios);

        servicioRutina.agregarEjercicio(ejercicio1, rutina, estadoMock);
        servicioRutina.agregarEjercicio(ejercicio2, rutina, estadoMock);

        assertTrue(ejercicios.contains(ejercicio1));
        assertTrue(ejercicios.contains(ejercicio2));
    }

    @Test(expected = EjercicioRepetidoException.class)
    public void queNoSePuedaAgregarUnMismoEjercicioDosVeces() throws RutinaRestringidaException, EjercicioRepetidoException {
        Ejercicio ejercicio = new Ejercicio("correr");

        List<Ejercicio> ejercicios = new ArrayList<>();
        ejercicios.add(ejercicio);
        Rutina rutina = new Rutina(ejercicios);

        servicioRutina.agregarEjercicio(ejercicio, rutina, estadoMock);
    }

    @Test(expected = RutinaRestringidaException.class)
    public void queSiSeIntentaAgregarUnaRutinaRestringidaLanceUnaExcepcion() throws RutinaRestringidaException, EjercicioRepetidoException {
        Ejercicio ejercicio = new Ejercicio("pesas");
        List<String> restricciones = new ArrayList<>();
        restricciones.add(ejercicio.getNombre());
        when(estadoMock.getRestricciones()).thenReturn((ArrayList<String>) restricciones);

        servicioRutina.agregarEjercicio(ejercicio, rutina, estadoMock);
    }

    @Test
    public void queSePuedaModificarEjercicioExistentePorUnoRestringido() throws RutinaRestringidaException {
        Ejercicio ejercicioPermitido = new Ejercicio("correr");
        Ejercicio ejercicioRestringido = new Ejercicio("pesas");

        List<Ejercicio> ejercicios = new ArrayList<>();
        ejercicios.add(ejercicioPermitido);
        Rutina rutina = new Rutina(ejercicios);

        servicioRutina.modificarEjercicio(ejercicioPermitido, ejercicioRestringido, rutina);

        List<Ejercicio> ejerciciosActualizados = rutina.getEjercicios();
        assertTrue(ejerciciosActualizados.contains(ejercicioRestringido));
        assertFalse(ejerciciosActualizados.contains(ejercicioPermitido));
    }

    @Test
    public void queSePuedaModificarUnEjercicioCambiandoloPorOtro() {
        Ejercicio ejercicioAnterior = new Ejercicio("correr");
        Ejercicio ejercicioNuevo = new Ejercicio("nadar");

        List<Ejercicio> ejercicios = new ArrayList<>();
        ejercicios.add(ejercicioAnterior);
        rutina.setEjercicios(ejercicios);

        servicioRutina.modificarEjercicio(ejercicioAnterior, ejercicioNuevo, rutina);

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
        servicioRutina.eliminarEjercicio(ejercicio, rutina);

        List<Ejercicio> ejerciciosActualizados = rutina.getEjercicios();
        assertFalse(ejerciciosActualizados.contains(ejercicio));
    }

    @Test
    public void queNoSePuedaEliminarUnEjercicioInexistente() {
        Ejercicio ejercicioExistente = new Ejercicio("correr");
        Ejercicio ejercicioInexistente = new Ejercicio("nadar");

        List<Ejercicio> ejercicios = new ArrayList<>();
        ejercicios.add(ejercicioExistente);
        Rutina rutina = new Rutina(ejercicios);

        servicioRutina.eliminarEjercicio(ejercicioInexistente, rutina);

        List<Ejercicio> ejerciciosActualizados = rutina.getEjercicios();
        assertTrue(ejerciciosActualizados.contains(ejercicioExistente));
    }
}
