package ar.edu.grupoesfera.cursospring.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Plato {
    private List<String> ingredientes;

    public Plato(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Plato(String ingredientes) {
        this.ingredientes = new ArrayList<String>();
        this.ingredientes.add(ingredientes);
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plato plato = (Plato) o;
        return Objects.equals(ingredientes, plato.ingredientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientes);
    }

    public Plato() {

    }


    public List<String> getIngredientes() {
        return this.ingredientes;
    }
}
