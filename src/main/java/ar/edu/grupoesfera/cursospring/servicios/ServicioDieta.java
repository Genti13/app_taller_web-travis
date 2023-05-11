package ar.edu.grupoesfera.cursospring.servicios;

import ar.edu.grupoesfera.cursospring.modelo.*;

import java.util.ArrayList;

public interface ServicioDieta {
    void agregarMenu(Dieta dieta, Menu menu, ArrayList<String> restricciones) throws MenuRestringidoException;

    void quitarMenu(Dieta dieta, Menu menu);
    void modificarMenu(Dieta dieta, Menu oldMenu, Menu newMenu);

    void agregarRutina(Dieta dieta, Rutina rutina, ArrayList<String> restricciones) throws RutinaRestringidaException;

    void quitarRutina(Dieta dieta, Rutina rutina);
    void modificarRutina(Dieta dieta, Rutina oldRutina, Rutina newRutina);
}
