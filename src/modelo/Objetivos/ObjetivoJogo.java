package modelo.Objetivos;

import modelo.suportados.Balao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 31/03/2017.
 */
public class ObjetivoJogo extends Objetivo {
    List<ObjetivoParcialBalao> objetivosParciais;

    public ObjetivoJogo() {

        objetivosParciais = new ArrayList<>();
        this.objetivosParciais = objetivosParciais;
    }

    public void adicionar(ObjetivoParcialBalao objetivoParcial) {
        objetivosParciais.add(objetivoParcial);
    }

    @Override
    public void influenciar(Balao balao) {
        for (ObjetivoParcialBalao objetivoParcial : objetivosParciais) {
            if (objetivoParcial.hasInfluencia(balao)) {
                objetivoParcial.influenciar(balao);
            }

        }
    }

    @Override
    public boolean isConcluido() {
        for (ObjetivoParcialBalao objetivoParcial : objetivosParciais) {
            if (!objetivoParcial.isConcluido()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String texto = "";
        texto += objetivosParciais;
        return texto;
    }
}
