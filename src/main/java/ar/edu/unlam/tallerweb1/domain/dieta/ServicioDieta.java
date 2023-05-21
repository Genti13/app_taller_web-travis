package ar.edu.unlam.tallerweb1.domain.dieta;

import ar.edu.unlam.tallerweb1.domain.menu.Menu;
import ar.edu.unlam.tallerweb1.domain.menu.MenuRestringidoException;
import ar.edu.unlam.tallerweb1.domain.rutina.Rutina;
import ar.edu.unlam.tallerweb1.domain.rutina.RutinaRestringidaException;

import java.util.ArrayList;

public interface ServicioDieta {
    void agregarMenu(Dieta dieta, Menu menu, ArrayList<String> restricciones) throws MenuRestringidoException;

    void quitarMenu(Dieta dieta, Menu menu);
    void modificarMenu(Dieta dieta, Menu oldMenu, Menu newMenu);

    void agregarRutina(Dieta dieta, Rutina rutina, ArrayList<String> restricciones) throws RutinaRestringidaException;

    void quitarRutina(Dieta dieta, Rutina rutina);
    void modificarRutina(Dieta dieta, Rutina oldRutina, Rutina newRutina);
}
