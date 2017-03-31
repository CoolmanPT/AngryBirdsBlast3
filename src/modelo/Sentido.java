package modelo;

/**
 * Created by bruno on 17/03/2017.
 */
public enum Sentido {
    NORTE(-1,0),
    OESTE(0,-1),
    SUL(1,0),
    ESTE(0,1);

    private Posicao posicao;

    Sentido(int deltaLinha, int deltaColuna) {
        posicao = new Posicao(deltaLinha, deltaColuna);
    }

    public Posicao getPosicao() {
        return posicao;
    }
}
