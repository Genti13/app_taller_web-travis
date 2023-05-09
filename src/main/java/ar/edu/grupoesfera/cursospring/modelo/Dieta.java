package ar.edu.grupoesfera.cursospring.modelo;

import java.util.ArrayList;
import java.util.List;

public class Dieta {
    private List<Menu> menues;

    public Dieta(List<Menu> menu) {
        this.menues = menu;
    }

    public Dieta(Menu menu) {
        this.menues = new ArrayList<Menu>();
        this.menues.add(menu);
    }

    public Dieta() {

    }

//    public void agregarMenu(Menu menu, ArrayList<String> restricciones) {
//        ArrayList<Plato> platos = (ArrayList<Plato>) menu.getPlatos();
//
//        for (Plato plato:platos) {
//            for (String ingrediente: plato.getIngredientes()) {
//
//            }
//        }
//    }
}
