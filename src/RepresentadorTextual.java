import modelo.AreaJogavel;
import modelo.Jogo;
import modelo.bases.Base;
import modelo.bases.BaseAr;
import modelo.bases.BaseSuportadora;
import modelo.suportados.*;

/**
 * Created by bruno on 17/03/2017.
 */
public class RepresentadorTextual {
    private Jogo jogo;


    public RepresentadorTextual(Jogo jogo) {
        this.jogo = jogo;
    }

    public void representar() {
        representarAreaJogavel();
        representarPontuacao();
        representarNumeroMovimentosRestantes();
        representarObjetivos();

    }
    private void representarAreaJogavel() {
        AreaJogavel areaJogavel = jogo.getAreaJogavel();
        int numLinhas = areaJogavel.getNumLinhas();
        int numColunas = areaJogavel.getNumColunas();

        System.out.print("  ");
        for (int j = 0; j < numColunas; j++){
            System.out.print(j + " ");

        }
        System.out.println();
        for (int i = 0; i < numLinhas; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < numColunas; j++) {
                representar(areaJogavel.getBase(i,j));
            }
            System.out.println();
        }


    }

    private void representar(Base base) {
        String texto = "";
        if (base instanceof BaseAr) {
            texto += " ";
        } else if (base instanceof BaseSuportadora){
            BaseSuportadora baseSuportadora;
            baseSuportadora = (BaseSuportadora) base;
            if (baseSuportadora.isVazia()){
                texto += "-";
            } else {
                texto += representar(baseSuportadora.getSuportado());

            }

        }
        System.out.print(texto + " ");
    }

    private String representar(Suportado suportado) {
        String texto = "";

        if (suportado instanceof Balao) {
            texto += ((Balao) suportado).getEspecie().getInicial();

        } else if (suportado instanceof Madeira) {
            Madeira madeira = (Madeira) suportado;
            texto += madeira.getForca() > 1 ? "W" : "w";

        } else if (suportado instanceof Vidro) {
            texto += "V";
        } else if (suportado instanceof Porco) {
            Porco porco = (Porco) suportado;
            texto += ((Porco) suportado).getForca() > 1 ? "P" : "p";
        }

        return texto;
    }

    private void representarPontuacao() {
        System.out.println("Pontuacao:" + jogo.getPontuacao());
    }

    private void representarNumeroMovimentosRestantes() {
        System.out.println("Numero de movimentos restantes: " + jogo.getNumeroMovimentosRestantes());
    }

    private void representarObjetivos(){
        System.out.println("Objetivos: \n" + jogo.getObjetivoJogo());
    }


}
