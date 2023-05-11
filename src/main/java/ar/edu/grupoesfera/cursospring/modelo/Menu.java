package ar.edu.grupoesfera.cursospring.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Menu {
    private List<Plato> platos;

    public Menu(List<Plato> platos) {
        this.platos = platos;
    }

    public Menu(Plato plato) {
        this.platos = new ArrayList<Plato>();
        this.platos.add(plato);
    }

    public void agregarPlato(Plato plato) {
        this.platos.add(plato);
    }

    public Object getPlatos() {
        return this.platos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(platos, menu.platos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(platos);
    }
}
