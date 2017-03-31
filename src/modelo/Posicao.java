package modelo;

/**
 * Created by bruno on 10/03/2017.
 */
public class Posicao {
    private int linha;
    private int coluna;

    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public Posicao seguir(Sentido sentido){
        return new Posicao(linha + sentido.getPosicao().getLinha(), coluna + sentido.getPosicao().getColuna());
    }
}
