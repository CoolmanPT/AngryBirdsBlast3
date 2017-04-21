package modelo.bases;

import modelo.*;
import modelo.suportados.Balao;
import modelo.suportados.Suportado;
import modelo.suportados.SuportadoSensivelOndaChoque;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno on 10/03/2017.
 */
public class BaseSuportadora extends Base implements SensivelOndaChoque {

    private Suportado suportado;

    public BaseSuportadora(AreaJogavel areaJogavel, Posicao posicao) {
        super(areaJogavel, posicao);
    }

    public List<Balao> getGrupoFormado() {
        List<Balao> aAnalisar = new ArrayList<>();
        List<Balao> analisados = new ArrayList<>();

        aAnalisar.add((Balao) suportado);

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
        return suportado == null;
    }

    @Override
    public void agarrar(Balao balao) {
        this.suportado = balao;
        balao.setBaseSuportadora(this);
        if (permiteSubirBalao()) {
            fazerBalaoSubir();
        }

    }

    public void iterar() {
        if (suportado instanceof Balao) {
            ((Balao) suportado).iterar();
        }

    }

    public Suportado getSuportado() {
        return suportado;
    }

    public void setSuportado(Suportado suportado) {
        this.suportado = suportado;
    }

    public boolean permiteSubirBalao() {
        if (!(suportado instanceof Balao)) {
            return false;
        }
        Base baseAcima = areaJogavel.getBase(posicao.seguir(Sentido.NORTE));
        if (baseAcima == null) {
            return false;
        }
        return baseAcima.aceita((Balao) suportado);
    }

    public void fazerBalaoSubir() {
        if (!permiteSubirBalao()) {
            return;
        }
        Base baseAcima = areaJogavel.getBase(posicao.seguir(Sentido.NORTE));
        baseAcima.agarrar((Balao) suportado);
        suportado = null;
    }
    public boolean podeInteragir(){
        return suportado instanceof Balao;
    }
    public boolean reagirInteracao() {
        if (!podeInteragir()){
            return false;
        }
        return ((Balao) suportado).reagirInteracao();
    }

    public Balao getBalaoA(Sentido sentido) {
        return areaJogavel.getBalaoEm(posicao.seguir(sentido));
    }

    public void libertarSuportado() {

        this.suportado = null;
    }

    public Jogo getJogo(){
        return areaJogavel.getJogo();
    }

    @Override
    public void receberOndaChoque() {
        if (suportado instanceof SuportadoSensivelOndaChoque) {
            ((SuportadoSensivelOndaChoque) suportado).receberOndaChoque();
        }
    }

    public List<SensivelOndaChoque> getVizinhosSensiveisOndaChoque() {
        List<SensivelOndaChoque> sensiveis = new ArrayList<>();
        for (Sentido sentido : Sentido.values()) {
            Base base = areaJogavel.getBase(posicao.seguir(sentido));
            if (base instanceof SensivelOndaChoque) {
                sensiveis.add((SensivelOndaChoque) base);
            }
        }
        return sensiveis;
    }
}
