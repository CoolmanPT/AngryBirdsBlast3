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
        super();
        this.especie = especie;
        this.quantidade = quantidade;
    }

    public boolean hasInfluencia(Balao balao) {
        return true;
    }
}
