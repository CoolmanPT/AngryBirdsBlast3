package modelo.Objetivos;

import modelo.suportados.Balao;

/**
 * Created by Bruno on 31/03/2017.
 */
public abstract class Objetivo {

    public Objetivo() {

    }

    public abstract void influenciar(Balao balao);

    public abstract boolean isConcluido();


}
