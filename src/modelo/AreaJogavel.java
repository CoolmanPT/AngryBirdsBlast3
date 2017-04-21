package modelo;

import modelo.bases.Base;
import modelo.bases.BaseAr;
import modelo.bases.BaseSuportadora;
import modelo.suportados.Balao;
import modelo.suportados.Madeira;
import modelo.suportados.Porco;
import modelo.suportados.Vidro;

import java.util.Random;

/**
 * Created by bruno on 10/03/2017.
 */
public class AreaJogavel {


    private Jogo jogo;
    private Base[][] grelha;
    private int[][] nivel = {
            {0, 0, 0, 4, 1},
            {1, 0, 0, 1, 1},
            {1, 1, 1, 2, 0},
            {1, 0, 3, 1, 1},
            {1,1,1,1,1}
    };

    private Random random = new Random();



    public AreaJogavel() {

        grelha = new Base[5][5];

        for(int i = 0; i < getNumLinhas(); i++ ) {
            for (int j = 0; j < getNumColunas(); j++) {
                grelha[i][j] = nivel[i][j] == 0 ? new BaseAr(this, new Posicao(i,j)) : new BaseSuportadora(this, new Posicao(i,j));
                switch (nivel[i][j]) {
                    case 2: //Porco
                        ((BaseSuportadora) grelha[i][j]).setSuportado(new Porco((BaseSuportadora) grelha[i][j]));
                        break;
                    case 3: //Madeira
                        ((BaseSuportadora) grelha[i][j]).setSuportado(new Madeira((BaseSuportadora) grelha[i][j]));
                        break;
                    case 4: //Vidro
                        ((BaseSuportadora) grelha[i][j]).setSuportado(new Vidro((BaseSuportadora) grelha[i][j]));
                        break;
                }
            }
        }
    }

    public Base getBase(int linha, int coluna) {
        int numeroLinhas = getNumLinhas();
        int numeroColunas = getNumColunas();

        if (linha < 0 || linha >= numeroLinhas || coluna < 0 || coluna >= numeroColunas) {
            return null;
        }
        return grelha[linha][coluna];
    }

    public Base getBase (Posicao posicao) {
        return getBase(posicao.getLinha(), posicao.getColuna());
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public int getNumLinhas(){
        return grelha.length;
    }

    public int getNumColunas() {
        return grelha[0].length;
    }


    public void iterar() {
        for (int i = 0; i < getNumLinhas(); i++){
            for (int j = 0; j < getNumColunas(); j++){
                Base base = getBase(i,j);
                if (base instanceof BaseSuportadora){
                    ((BaseSuportadora) base).iterar();

                }
            }
        }
        int numLin = getNumLinhas();
        int numCol = getNumColunas();
        for (int j = 0; j < numCol; j++){
            Base base = getBase(numLin-1, j);
            Balao balaoNovo ;
            while (base.aceita(balaoNovo = gerarBalao())){
                base.agarrar(balaoNovo);

            }
        }
    }

    private Balao gerarBalao(){
        return new Balao(null,Especie.values()[random.nextInt(Especie.values().length)]);
    }

    public boolean interagir(int linha, int coluna) {
        Base base = getBase(linha,coluna);
        if (base == null || !(base instanceof BaseSuportadora)) {
            return false;
        }
            return ((BaseSuportadora) base).reagirInteracao();


    }

    public Balao getBalaoEm(Posicao posicao) {
        Base base = getBase(posicao);
        if (base instanceof BaseSuportadora && ((BaseSuportadora) base).getSuportado() instanceof Balao) {
            return (Balao) ((BaseSuportadora) base).getSuportado();
        }
        return null;
    }
}
