package modelo.Objetivos;

import modelo.suportados.Objetivavel;

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
    public void influenciar(Objetivavel objetivavel) {
        for (ObjetivoParcialBalao objetivoParcial : objetivosParciais) {
            if (objetivoParcial.hasInfluencia(objetivavel)) {
                objetivoParcial.influenciar(objetivavel);
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
