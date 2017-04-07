package modelo.Objetivos;

import modelo.Especie;
import modelo.suportados.Balao;

/**
 * Created by Bruno on 31/03/2017.
 */
public class ObjetivoParcialBalao extends ObjetivoParcial {

    private Especie especie;
    private int quantidade;

    public ObjetivoParcialBalao(Especie especie, int quantidade) {

        this.especie = especie;
        this.quantidade = quantidade;
    }

    public boolean hasInfluencia(Balao balao) {
        return balao.getEspecie() == especie;
    }

    @Override
    public String toString() {
        return "Especie: " + especie + "\n" + "Quantidade: " + quantidade + "\n";
    }
}
