package ar.edu.grupoesfera.cursospring.modelo.estados;

import ar.edu.grupoesfera.cursospring.modelo.Estado;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Arrays;

@Entity
public class Cardiaco extends Estado {

    public Cardiaco() {
        this.nombre = "Cardiaco";
        this.restricciones = new ArrayList<>(
                Arrays.asList("carne_procesada", "azucar", "sal", "carbohidratos_refinados")
        );
    }


}
