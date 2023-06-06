package ar.edu.unlam.tallerweb1.domain.menu;

import org.hibernate.annotations.CollectionType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    @ElementCollection
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

    public int calcularValorEnBaseACalorias() {
    return 3;
    }
}
