package ar.edu.unlam.tallerweb1.domain.conditionScore;

import java.util.ArrayList;
import java.util.List;

public class ConditionScore {
    private List<Integer> historico;

    public ConditionScore() {
        this.historico = new ArrayList<>();
        this.historico.add(50);
    }

    public Integer getLastCS() {
        return this.historico.get(0);
    }

    public void setHistorico(List<Integer> historico) {
        this.historico = historico;
    }
}
