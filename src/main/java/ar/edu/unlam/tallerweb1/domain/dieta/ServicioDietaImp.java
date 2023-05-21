package ar.edu.unlam.tallerweb1.domain.dieta;


import ar.edu.unlam.tallerweb1.domain.menu.Menu;
import ar.edu.unlam.tallerweb1.domain.menu.MenuRestringidoException;
import ar.edu.unlam.tallerweb1.domain.menu.Plato;
import ar.edu.unlam.tallerweb1.domain.rutina.Rutina;
import ar.edu.unlam.tallerweb1.domain.rutina.RutinaRestringidaException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class ServicioDietaImp implements ServicioDieta {
    @Override
    public void agregarMenu(Dieta dieta, Menu menu, ArrayList<String> restricciones) throws MenuRestringidoException {
        ArrayList<Plato> platos = (ArrayList<Plato>) menu.getPlatos();

        for (Plato plato : platos) {
            for (String ingrediente : plato.getIngredientes()) {
                if (restricciones.contains(ingrediente)) {
                    throw new MenuRestringidoException("El menu contiene ingredintes restringidos");
                }
            }
        }
        dieta.getMenus().add(menu);
    }

    @Override
    public void quitarMenu(Dieta dieta, Menu menu) {

    }

    @Override
    public void modificarMenu(Dieta dieta, Menu oldMenu, Menu newMenu) {
        int index = dieta.getMenus().indexOf(oldMenu);

        if(index != -1){
            dieta.getMenus().set(index,newMenu);
        }
    }

    @Override
    public void agregarRutina(Dieta dieta, Rutina rutina, ArrayList<String> restricciones) throws RutinaRestringidaException {
        ArrayList<String> ejercicios = (ArrayList<String>) rutina.getEjercicios();

        for (String ejercicio : ejercicios) {
            if (restricciones.contains(ejercicio)) {
                throw new RutinaRestringidaException("El menu contiene ingredintes restringidos");
            }
        }
        dieta.getRutinas().add(rutina);
    }

    @Override
    public void quitarRutina(Dieta dieta, Rutina rutina) {

    }

    @Override
    public void modificarRutina(Dieta dieta, Rutina oldRutina, Rutina newRutina) {

    }
}
