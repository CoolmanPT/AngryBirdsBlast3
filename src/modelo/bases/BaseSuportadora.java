package modelo.bases;

import modelo.*;
import modelo.suportados.Balao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno on 10/03/2017.
 */
public class BaseSuportadora extends Base implements SensivelOndaChoque {

    private Balao balao;

    public BaseSuportadora(AreaJogavel areaJogavel, Posicao posicao) {
        super(areaJogavel, posicao);
    }

    public List<Balao> getGrupoFormado() {
        List<Balao> aAnalisar = new ArrayList<>();
        List<Balao> analisados = new ArrayList<>();

        aAnalisar.add(balao);

        while (!aAnalisar.isEmpty()){
            Balao balao = aAnalisar.remove(0);
            if (analisados.contains(balao)){
                continue;
            }
            analisados.add(balao);
            aAnalisar.addAll(balao.getAgrupaveisVizinhos());
        }

        return analisados;


    }

    @Override
    public boolean aceita(Balao balao) {
        return isVazia();
    }

    public boolean isVazia() {
        return balao == null;
    }

    @Override
    public void agarrar(Balao balao) {
        this.balao = balao;
        balao.setBaseSuportadora(this);
        if (permiteSubirBalao()) {
            fazerBalaoSubir();
        }

    }

    public void iterar() {
        if (balao != null) {
            balao.iterar();
        }

    }

    public Balao getBalao() {
        return balao;
    }

    public void setBalao(Balao balao) {
        this.balao = balao;
    }

    public boolean permiteSubirBalao() {
        if (balao == null) {
            return false;
        }
        Base baseAcima = areaJogavel.getBase(posicao.seguir(Sentido.NORTE));
        if (baseAcima == null) {
            return false;
        }
        return baseAcima.aceita(balao);
    }

    public void fazerBalaoSubir() {
        if (!permiteSubirBalao()) {
            return;
        }
        Base baseAcima = areaJogavel.getBase(posicao.seguir(Sentido.NORTE));
        baseAcima.agarrar(balao);
        balao = null;
    }
    public boolean podeInteragir(){
        return !isVazia();
    }
    public boolean reagirInteracao() {
        if (!podeInteragir()){
            return false;
        }
        return balao.reagirInteracao();
    }

    public Balao getBalaoA(Sentido sentido) {
        return areaJogavel.getBalaoEm(posicao.seguir(sentido));
    }

    public void libertarBalao() {

        this.balao = null;
    }

    public Jogo getJogo(){
        return areaJogavel.getJogo();
    }
}
