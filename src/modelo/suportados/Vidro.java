package modelo.suportados;

import modelo.bases.BaseSuportadora;

/**
 * Created by Bruno on 07/04/2017.
 */
public class Vidro extends SuportadoSensivelOndaChoque {
    public Vidro(BaseSuportadora baseSuportadora) {
        super(baseSuportadora);
    }

    @Override
    public void receberOndaChoque() {
        explodir();
        getBaseSuportadora().getJogo().incrementarPontuacao(60);
    }
}
