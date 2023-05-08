package ar.edu.grupoesfera.cursospring.modelo;

import ar.edu.grupoesfera.cursospring.SpringTest;
import ar.edu.grupoesfera.cursospring.modelo.estados.Cardiaco;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class EstadoTest extends SpringTest {

    /*Probando como funcionan los test consultando la BD con clases que heredan*/
    @Test
    @Transactional
    @Rollback
    public void queExistaElEstado() {
        Estado cardiaco = new Cardiaco();
        getSession().save(cardiaco);
        System.out.print("test");
        assertThat(getSession().get(Estado.class, cardiaco.getId())).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    public void buscarUnEstado() {
        Estado cardiaco = new Cardiaco();
        getSession().save(cardiaco);

        final List<Estado> estados = getSession().createCriteria(Estado.class)
                .add(Restrictions.eq("nombre", "Cardiaco"))
                .list();

        /*Esto Esta solo para ver el guardado*/
//        for (Estado estado : estados) {
//            for (String restriccion: estado.getRestricciones()) {
//                System.out.print(restriccion+"\n");
//            }
//        }

        assertThat(estados).hasSize(1);
    }

}
