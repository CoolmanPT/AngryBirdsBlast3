package modelo.Objetivos;

import modelo.suportados.Objetivavel;
import modelo.suportados.Porco;

/**
 * Created by Bruno on 07/04/2017.
 */
public class ObjetivoParcialPorco extends ObjetivoParcial {


    public ObjetivoParcialPorco(int quantidade) {
        super(quantidade);
    }

    @Override
    public boolean hasInfluencia(Objetivavel objetivavel) {
        return objetivavel instanceof Porco;
    }
}
