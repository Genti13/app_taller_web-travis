package ar.edu.unlam.tallerweb1.domain.dieta;

import ar.edu.unlam.tallerweb1.domain.menu.Menu;
import ar.edu.unlam.tallerweb1.domain.rutina.Rutina;

import java.util.ArrayList;
import java.util.List;

public class Dieta {
    private List<Menu> menus;
    private List<Rutina> rutinas;

    public Dieta() {
        this.menus = new ArrayList<>();
    }

    public List<Rutina> getRutinas() {
        return rutinas;
    }

    public void setRutinas(List<Rutina> rutinas) {
        this.rutinas = rutinas;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
