package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.dieta.RepositorioDieta;
import ar.edu.unlam.tallerweb1.domain.rutina.Rutina;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDietaImp implements RepositorioDieta {

    public List<Rutina> get(){
        return new ArrayList<Rutina>();
    }

}
