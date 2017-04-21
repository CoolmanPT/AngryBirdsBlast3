package modelo.Objetivos;

import modelo.suportados.Objetivavel;

/**
 * Created by Bruno on 31/03/2017.
 */
public abstract class Objetivo {

    public Objetivo() {

    }

    public abstract void influenciar(Objetivavel objetivavel);

    public abstract boolean isConcluido();


}
