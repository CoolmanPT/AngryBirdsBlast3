import modelo.EstadoJogo;
import modelo.Jogo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bruno on 10/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();


        RepresentadorTextual representadorTextual = new RepresentadorTextual(jogo);

        representadorTextual.representar();


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (jogo.getEstadoJogo() == EstadoJogo.A_DECORRER) {
            jogo.iterar();
            representadorTextual.representar();

            try {
                System.out.print("Posicao a jogar: ");
                String jogada = bufferedReader.readLine();
                String[] partes = jogada.split(",");
                int linha = Integer.parseInt(partes[0]);
                int coluna = Integer.parseInt(partes[1]);
                boolean jogadaValida = jogo.interagir(linha,coluna);




            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
