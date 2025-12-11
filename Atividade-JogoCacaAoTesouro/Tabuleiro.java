import java.util.Random;

public class Tabuleiro {

    private final int TAM = 6;
    private ElementoTabuleiro[][] matriz;

    public Tabuleiro() {
        matriz = new ElementoTabuleiro[TAM][TAM];

        for (int l = 0; l < TAM; l++) {
            for (int c = 0; c < TAM; c++) {
                matriz[l][c] = new Vazio();
            }
        }

        posicionar(new Tesouro(), 3);
        posicionar(new Armadilha(), 3);
    }

    private void posicionar(ElementoTabuleiro elemento, int quantidade) {
        Random rand = new Random();
        int colocados = 0;

        while (colocados < quantidade) {
            int l = rand.nextInt(TAM);
            int c = rand.nextInt(TAM);

            if (matriz[l][c] instanceof Vazio) {
                matriz[l][c] = elemento;
                colocados++;
            }
        }
    }

    public ElementoTabuleiro getElemento(int x, int y) {
        return matriz[x][y];
    }

    public int tamanho() {
        return TAM;
    }
}
