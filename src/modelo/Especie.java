package modelo;

/**
 * Created by bruno on 17/03/2017.
 */
public enum Especie {
    RED,
    CHUCK,
    BOMB,
    MATILDA,
    TERENCE,
    STELLA;

    public char getInicial() {
        return this.toString().charAt(0);
    }
}
