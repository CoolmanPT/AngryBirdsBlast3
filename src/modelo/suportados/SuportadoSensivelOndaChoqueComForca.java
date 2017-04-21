package modelo.suportados;


import modelo.bases.BaseSuportadora;

/**
 * Created by Bruno on 07/04/2017.
 */
public abstract class SuportadoSensivelOndaChoqueComForca extends SuportadoSensivelOndaChoque {
    private int forca;
    private int forcaInicial;
    private int multiplicadorPontuacao;

    public SuportadoSensivelOndaChoqueComForca(BaseSuportadora baseSuportadora, int forca, int multiplicadorPontuacao) {
        super(baseSuportadora);
        this.forca = forca;
        this.forcaInicial = forca;
        this.multiplicadorPontuacao = multiplicadorPontuacao;


    }

    @Override
    public void receberOndaChoque() {
        forca--;
        if (forca == 0) {
            explodir();
        }
        getBaseSuportadora().getJogo().incrementarPontuacao((forcaInicial - forca) * multiplicadorPontuacao);
    }

    public int getForca() {
        return forca;
    }
}
