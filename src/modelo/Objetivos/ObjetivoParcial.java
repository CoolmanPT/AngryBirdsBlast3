package modelo.Objetivos;

import modelo.suportados.Balao;

/**
 * Created by Bruno on 07/04/2017.
 */
public abstract class ObjetivoParcial extends Objetivo {
    private int quantidade;


    @Override
    public void influenciar(Balao balao) {
        if (hasInfluencia(balao)){
            quantidade--;
        }
    }

    @Override
    public boolean isConcluido() {
        return quantidade <= 0;
    }

    public abstract boolean hasInfluencia(Balao balao);
}
