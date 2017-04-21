package modelo.suportados;

import modelo.Especie;
import modelo.Jogo;
import modelo.SensivelOndaChoque;
import modelo.Sentido;
import modelo.bases.BaseSuportadora;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno on 17/03/2017.
 */
public class Balao extends Suportado implements Objetivavel {
    private Especie especie;



    public Balao(BaseSuportadora baseSuportadora, Especie especie) {
        super(baseSuportadora);
        this.especie = especie;


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

    private void espalharOndaChoque(List<BaseSuportadora> bases) {
        List<SensivelOndaChoque> sensiveis = new ArrayList<>();
        for (BaseSuportadora baseSuportadora : bases) {
            for (SensivelOndaChoque sensivelOndaChoque : baseSuportadora.getVizinhosSensiveisOndaChoque()) {
                if (!sensiveis.contains(sensivelOndaChoque)) {
                    sensiveis.add(sensivelOndaChoque);
                }
            }
        }
        for (SensivelOndaChoque sensivelOndaChoque : sensiveis) {
            sensivelOndaChoque.receberOndaChoque();
        }
    }

    public boolean reagirInteracao() {
        List<Balao> grupo = baseSuportadora.getGrupoFormado();
        if (grupo.size() == 1) {
            return false;
        }
        List<BaseSuportadora> bases = new ArrayList<>();
        for (Balao balao: grupo) {
            balao.explodir();
            bases.add(balao.getBaseSuportadora());

        }
        espalharOndaChoque(bases);
        getJogo().incrementarPontuacao((int) Math.pow(2,grupo.size()) * 10);
        baseSuportadora = null;
        return true;
    }

    private Jogo getJogo(){
        return baseSuportadora.getJogo();
    }

    protected void explodir() {
        super.explodir();
        baseSuportadora.libertarSuportado();
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
