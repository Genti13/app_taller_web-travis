package ar.edu.unlam.tallerweb1.domain.rutina;

import ar.edu.unlam.tallerweb1.domain.ejercicio.Ejercicio;
import ar.edu.unlam.tallerweb1.domain.ejercicio.EjercicioRepetidoException;
import ar.edu.unlam.tallerweb1.domain.estados.Estado;

public interface ServicioRutina {

    public void agregarEjercicio(Ejercicio ejercicio, Rutina rutina, Estado estadoMock) throws RutinaRestringidaException, EjercicioRepetidoException;

    public void modificarEjercicio(Ejercicio ejercicioAnterior, Ejercicio ejercicioNuevo, Rutina rutina);

    public void eliminarEjercicio(Ejercicio ejercicio, Rutina rutina);
}
