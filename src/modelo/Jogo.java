package modelo;

import java.util.Enumeration;

/**
 * Created by bruno on 10/03/2017.
 */
public class Jogo extends ObjetoComAreaJogavel{

    private int numeroMovimentosRestantes;
    private int pontuacao;
    private EstadoJogo estadoJogo;

    public Jogo() {
        super();
        areaJogavel.setJogo(this);
        numeroMovimentosRestantes = 10;
        pontuacao = 0;
        estadoJogo = EstadoJogo.A_DECORRER;
    }


    public int getNumeroMovimentosRestantes() {
        return numeroMovimentosRestantes;
    }

    public void decrementarNumMovimentosRestantes() {
        numeroMovimentosRestantes--;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void incrementarPontuacao(int incremento) {
        pontuacao+=incremento;
    }
    public AreaJogavel getAreaJogavel(){
        return areaJogavel;
    }
    public EstadoJogo getEstadoJogo() {
        return estadoJogo;
    }

    public void iterar(){
        areaJogavel.iterar();
    }

    public boolean interagir(int linha, int coluna) {
        boolean valido = areaJogavel.interagir(linha,coluna);
        if (valido) {
            decrementarNumMovimentosRestantes();
        }
        return valido;

    }
}
