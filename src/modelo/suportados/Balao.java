package modelo.suportados;

import modelo.Especie;
import modelo.Jogo;
import modelo.Sentido;
import modelo.bases.BaseSuportadora;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno on 17/03/2017.
 */
public class Balao extends Suportado implements Objetivavel {
    private BaseSuportadora baseSuportadora;
    private Especie especie;



    public Balao(BaseSuportadora baseSuportadora, Especie especie) {
        this.baseSuportadora = baseSuportadora;
        this.especie = especie;


    }

    public BaseSuportadora getBaseSuportadora() {
        return baseSuportadora;
    }

    public void setBaseSuportadora(BaseSuportadora baseSuportadora) {
        this.baseSuportadora = baseSuportadora;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void iterar() {
        if (baseSuportadora.permiteSubirBalao()) {
            baseSuportadora.fazerBalaoSubir();
        }
    }

    public boolean reagirInteracao() {
        List<Balao> grupo = baseSuportadora.getGrupoFormado();
        if (grupo.size() == 1) {
            return false;
        }
        for (Balao balao: grupo) {
            balao.explodir();
        }
        getJogo().incrementarPontuacao((int) Math.pow(2,grupo.size()) * 10);
        baseSuportadora = null;
        return true;
    }

    private Jogo getJogo(){
        return baseSuportadora.getJogo();
    }

    private void explodir() {
        baseSuportadora.libertarBalao();
        getJogo().verificarInfluenciaObjetivoJogo(this);

    }

    public List<Balao> getAgrupaveisVizinhos() {
        List<Balao> vizinhos = new ArrayList<>();
        for (Sentido sentido : Sentido.values()){
            Balao balao = baseSuportadora.getBalaoA(sentido);
            if (balao != null && agrupaCom(balao)){
                vizinhos.add(balao);
            }
        }
        return vizinhos;
    }

    private boolean agrupaCom(Balao balao) {
        return this.especie == balao.especie;
    }
}
