package modelo.Objetivos;

import modelo.Balao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 31/03/2017.
 */
public class ObjetivoJogo extends Objetivo {
    List<ObjetivoParcial> objetivosParciais;

    public ObjetivoJogo() {

        objetivosParciais = new ArrayList<>();
        this.objetivosParciais = objetivosParciais;
    }

    public void adicionar(ObjetivoParcial objetivoParcial) {
        objetivosParciais.add(objetivoParcial);
    }

    @Override
    public void influenciar(Balao balao) {
        for (ObjetivoParcial objetivoParcial : objetivosParciais) {
            if (objetivoParcial.hasInfluencia(balao)) {
                objetivoParcial.influenciar(balao);
            }

        }
    }

    @Override
    public boolean isConcluido() {
        for (ObjetivoParcial objetivoParcial : objetivosParciais) {
            if (!objetivoParcial.isConcluido()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+objetivosParciais;
    }
}
