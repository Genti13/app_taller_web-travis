package ar.edu.unlam.tallerweb1.domain.rutina;
import ar.edu.unlam.tallerweb1.domain.ejercicio.Ejercicio;
import ar.edu.unlam.tallerweb1.domain.ejercicio.EjercicioRepetidoException;
import ar.edu.unlam.tallerweb1.domain.estados.Estado;

import java.util.List;

public class ServicioRutinaImp implements ServicioRutina{

    @Override
    public void agregarEjercicio(Ejercicio ejercicio, Rutina rutina, Estado estadoPersona) throws RutinaRestringidaException, EjercicioRepetidoException {
        List<String> restricciones = estadoPersona.getRestricciones();
        List<Ejercicio> ejercicios = rutina.getEjercicios();

        if (ejercicios.contains(ejercicio)) {
            throw new EjercicioRepetidoException("El ejercicio ya está presente en la rutina");
        }

        for (String restriccion : restricciones) {
            if (restriccion.equalsIgnoreCase(ejercicio.getNombre())) {
                throw new RutinaRestringidaException("El ejercicio no está permitido para este estado");
            }
        }

        ejercicios.add(ejercicio);
    }
    @Override
    public void modificarEjercicio(Ejercicio ejercicioAnterior, Ejercicio ejercicioNuevo, Rutina rutina) {
        List<Ejercicio> ejercicios = rutina.getEjercicios();

        int index = ejercicios.indexOf(ejercicioAnterior);
        if (index != -1) {
            ejercicios.set(index, ejercicioNuevo);
        }
    }

    @Override
    public void eliminarEjercicio(Ejercicio ejercicio, Rutina rutina) {
        List<Ejercicio> ejercicios = rutina.getEjercicios();
        ejercicios.remove(ejercicio);
    }

}
