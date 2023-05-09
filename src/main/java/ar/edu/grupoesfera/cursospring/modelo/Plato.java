package ar.edu.grupoesfera.cursospring.modelo;

import java.util.ArrayList;
import java.util.List;

public class Plato {
    private List<String> ingredientes;

    public Plato(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Plato(String ingredientes){
        this.ingredientes = new ArrayList<String>();
        this.ingredientes.add(ingredientes);
    }



}
