package modelo.Objetivos;

import modelo.Especie;
import modelo.suportados.Balao;
import modelo.suportados.Objetivavel;

/**
 * Created by Bruno on 31/03/2017.
 */
public class ObjetivoParcialBalao extends ObjetivoParcial {

    private Especie especie;


    public ObjetivoParcialBalao(Especie especie, int quantidade) {
        super(quantidade);
        this.especie = especie;

    }

    public boolean hasInfluencia(Objetivavel objetivavel) {
        return objetivavel instanceof Balao && ((Balao) objetivavel).getEspecie() == especie;
    }

    @Override
    public String toString() {
        return "Especie: " + especie + "\n" + "Quantidade: " + quantidade + "\n";
    }
}
