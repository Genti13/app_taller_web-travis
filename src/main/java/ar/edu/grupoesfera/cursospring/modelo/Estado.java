package ar.edu.grupoesfera.cursospring.modelo;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "ESTADO")
public abstract class Estado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}

