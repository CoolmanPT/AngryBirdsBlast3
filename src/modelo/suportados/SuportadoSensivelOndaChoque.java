package modelo.suportados;

import modelo.SensivelOndaChoque;
import modelo.bases.BaseSuportadora;

/**
 * Created by Bruno on 07/04/2017.
 */
public abstract class SuportadoSensivelOndaChoque extends Suportado implements SensivelOndaChoque {
    public SuportadoSensivelOndaChoque(BaseSuportadora baseSuportadora) {
        super(baseSuportadora);
    }

    @Override
    public abstract void receberOndaChoque();
}
