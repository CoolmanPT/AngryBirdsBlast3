package modelo.Objetivos;

import modelo.suportados.Objetivavel;

/**
 * Created by Bruno on 07/04/2017.
 */
public abstract class ObjetivoParcial extends Objetivo {
    protected int quantidade;

    public ObjetivoParcial(int quantidade) {
        this.quantidade = quantidade;

    }


    @Override
    public void influenciar(Objetivavel objetivavel) {
        if (hasInfluencia(objetivavel)) quantidade--;
    }

    @Override
    public boolean isConcluido() {
        return quantidade <= 0;
    }

    public abstract boolean hasInfluencia(Objetivavel objetivavel);
}
