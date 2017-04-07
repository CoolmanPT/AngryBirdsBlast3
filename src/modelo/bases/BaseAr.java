package modelo.bases;


import modelo.AreaJogavel;
import modelo.Posicao;
import modelo.Sentido;
import modelo.suportados.Balao;

/**
 * Created by bruno on 10/03/2017.
 */
public class BaseAr extends Base{
    public BaseAr(AreaJogavel areaJogavel, Posicao posicao) {
        super(areaJogavel, posicao);
        this.posicao = posicao;
    }

    @Override
    public boolean aceita(Balao balao) {
        Base baseAcima = areaJogavel.getBase(posicao.seguir(Sentido.NORTE));
        if (baseAcima == null) {
            return false;
        }
        return baseAcima.aceita(balao);

    }

    @Override
    public void agarrar(Balao balao) {
        if (!aceita(balao)){
            return;
        }
        Base baseAcima = areaJogavel.getBase(posicao.seguir(Sentido.NORTE));
        baseAcima.agarrar(balao);
    }
}
