package modelo.suportados;

import modelo.bases.BaseSuportadora;

/**
 * Created by Bruno on 07/04/2017.
 */
public class Suportado {
    protected BaseSuportadora baseSuportadora;

    public Suportado(BaseSuportadora baseSuportadora) {
        this.baseSuportadora = baseSuportadora;
    }

    public BaseSuportadora getBaseSuportadora() {
        return baseSuportadora;
    }

    protected void explodir() {
        baseSuportadora.libertarSuportado();
    }
}
