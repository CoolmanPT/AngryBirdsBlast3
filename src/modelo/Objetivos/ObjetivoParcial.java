package modelo.Objetivos;

import modelo.Balao;
import modelo.Especie;

/**
 * Created by Bruno on 31/03/2017.
 */
public class ObjetivoParcial extends Objetivo {

    private Especie especie;
    private int quantidade;

    public ObjetivoParcial(Especie especie, int quantidade) {

        this.especie = especie;
        this.quantidade = quantidade;
    }

    public boolean hasInfluencia(Balao balao) {
        return balao.getEspecie() == especie;
    }

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

    @Override
    public String toString() {
        return "Especie: " + especie + "\n" + "Quantidade: " + quantidade + "\n";
    }
}
