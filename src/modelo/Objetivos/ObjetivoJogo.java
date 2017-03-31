package modelo.Objetivos;

import java.util.List;

/**
 * Created by Bruno on 31/03/2017.
 */
public class ObjetivoJogo extends Objetivo {
    List<ObjetivoParcial> objetivosParciais;

    public ObjetivoJogo(List<ObjetivoParcial> objetivosParciais) {
        super();
        this.objetivosParciais = objetivosParciais;
    }

    public void adicionar(ObjetivoParcial objetivoParcial) {
    }
}
