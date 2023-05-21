package ar.edu.unlam.tallerweb1.domain.estados;
import java.util.ArrayList;


public abstract class Estado {

    protected Long id;

    protected String nombre;

    protected ArrayList<String> restricciones;

    public ArrayList<String> getRestricciones(){
        return  this.restricciones;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

