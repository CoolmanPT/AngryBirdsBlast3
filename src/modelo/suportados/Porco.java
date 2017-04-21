package modelo.suportados;

import modelo.bases.BaseSuportadora;

/**
 * Created by Bruno on 07/04/2017.
 */
public class Porco extends SuportadoSensivelOndaChoqueComForca implements Objetivavel {
    public Porco(BaseSuportadora baseSuportadora) {
        super(baseSuportadora, 2, 100);
    }
}
