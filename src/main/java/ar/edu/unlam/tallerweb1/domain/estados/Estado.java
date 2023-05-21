package ar.edu.unlam.tallerweb1.domain.estados;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
public abstract class Estado {
    public Estado() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;

    @Column
    protected String nombre;

    @Column
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRestricciones(ArrayList<String> restricciones) {
        this.restricciones = restricciones;
    }
}

