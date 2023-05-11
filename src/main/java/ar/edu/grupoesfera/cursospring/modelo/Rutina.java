package ar.edu.grupoesfera.cursospring.modelo;

import java.util.ArrayList;
import java.util.List;

public class Rutina {
    private List<String> ejercicios;

    public  Rutina(List<String> ejercicios){

        this.ejercicios =  ejercicios;
    }

    public Rutina(String ejercicio) {
        this.ejercicios = new ArrayList<>();
        this.ejercicios.add(ejercicio);
    }

    public List<String> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<String> ejercicios) {
        this.ejercicios = ejercicios;
    }


}
