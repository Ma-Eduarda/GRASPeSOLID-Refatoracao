import java.util.Random;

public class Tabuleiro {

    private final int TAM = 6;
    private final ElementoTabuleiro[][] matriz;

    public Tabuleiro() {
        matriz = new ElementoTabuleiro[TAM][TAM];

        posicionar(new Tesouro(), 3);
        posicionar(new Armadilha(), 3);
    }

    private void posicionar(ElementoTabuleiro elemento, int quantidade) {
        Random rand = new Random();
        int colocados = 0;

        while (colocados < quantidade) {
            int l = rand.nextInt(TAM);
            int c = rand.nextInt(TAM);

            if (matriz[l][c] == null) {
                matriz[l][c] = elemento;
                colocados++;
            }
        }
    }

    public ElementoTabuleiro getElemento(int x, int y) {
        return matriz[x][y] != null ? matriz[x][y] : new Vazio();
    }

    public int tamanho() {
        return TAM;
    }
}