package modelo;

import modelo.Objetivos.ObjetivoJogo;
import modelo.Objetivos.ObjetivoParcialBalao;
import modelo.suportados.Balao;

/**
 * Created by bruno on 10/03/2017.
 */
public class Jogo extends ObjetoComAreaJogavel{

    private int numeroMovimentosRestantes;
    private int pontuacao;
    private EstadoJogo estadoJogo;

    private ObjetivoJogo objetivoJogo;

    public Jogo() {
        super();
        areaJogavel.setJogo(this);
        numeroMovimentosRestantes = 10;
        pontuacao = 0;
        estadoJogo = EstadoJogo.A_DECORRER;

        objetivoJogo = new ObjetivoJogo();
        objetivoJogo.adicionar(new ObjetivoParcialBalao(Especie.STELLA, 4));
        objetivoJogo.adicionar(new ObjetivoParcialBalao(Especie.BOMB, 3));
    }

    public void verificarInfluenciaObjetivoJogo(Balao balao) {
        objetivoJogo.influenciar(balao);
        if (objetivoJogo.isConcluido()){
            System.out.println("VITORIA");
            estadoJogo = EstadoJogo.CONCLUIDO_VITORIA;
        }
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

    public ObjetivoJogo getObjetivoJogo() {
        return objetivoJogo;
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
            if (getNumeroMovimentosRestantes() == 0 && !objetivoJogo.isConcluido()){
                estadoJogo = EstadoJogo.CONCLUIDO_DERROTA;
            }
        }
        return valido;

    }
}
