package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.conditionScore.ServicioConditionScore;
import ar.edu.unlam.tallerweb1.domain.persona.Persona;
import ar.edu.unlam.tallerweb1.domain.persona.RepositorioPersona;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public class ControladorReporteDeEstado {
    private ServicioConditionScore servicioConditionScore;
    private ServicioLogin servicioLogin;
    private RepositorioPersona repositorioPersona;
    public ControladorReporteDeEstado(ServicioConditionScore servicioConditionScore, ServicioLogin servicioLogin, RepositorioPersona repositorioPersona) {
        this.servicioConditionScore = servicioConditionScore;
        this.servicioLogin = servicioLogin;
        this.repositorioPersona = repositorioPersona;
    }

@RequestMapping(path = "/ver-estado", method = RequestMethod.POST)
    public ModelAndView analizarCS(HttpServletRequest request) {
        Persona persona = repositorioPersona.getPersona((String) request.getSession().getAttribute("UserName"));
        ModelMap model = new ModelMap();

        if(servicioConditionScore.getActual(persona) < 50){
            return new ModelAndView("underCS", model);
        }

        return new ModelAndView("vistaReporte", model);
    }
}
