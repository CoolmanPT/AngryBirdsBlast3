package modelo.Objetivos;

import modelo.Balao;

/**
 * Created by Bruno on 31/03/2017.
 */
public abstract class Objetivo {

    public Objetivo() {

    }

    protected void influenciar(Balao balao) {

    }

    protected boolean isConcluido() {
        return true;
    }


}
