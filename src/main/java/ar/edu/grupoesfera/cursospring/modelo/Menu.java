package ar.edu.grupoesfera.cursospring.modelo;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Plato> platos;

    public Menu(List<Plato> platos) {
        this.platos = platos;
    }

    public Menu(Plato plato){
        this.platos = new ArrayList<Plato>();
        this.platos.add(plato);
    }

    public void agregarPlato(Plato plato){
        this.platos.add(plato);
    }

    public Object getPlatos() {
        return this.platos;
    }
}
