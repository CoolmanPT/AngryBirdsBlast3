package modelo.bases;

import modelo.AreaJogavel;
import modelo.ObjetoComAreaJogavel;
import modelo.Posicao;
import modelo.suportados.Balao;

/**
 * Created by bruno on 10/03/2017.
 */
public abstract class Base extends ObjetoComAreaJogavel {
    protected Posicao posicao;

    public Base(AreaJogavel areaJogavel, Posicao posicao) {
        super(areaJogavel);
        this.posicao = posicao;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public abstract boolean aceita(Balao balao);

    public abstract void agarrar(Balao balao);
}
