import java.util.Scanner;

public class CacaTesouroJogo {
    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador = new Jogador();

        Scanner scanner = new Scanner(System.in);
        int movimentos = 0;

        System.out.println("🎯 Bem-vindo ao Caça ao Tesouro!");

        while (movimentos < 10) {

            System.out.println("\nVocê está na posição (" + jogador.getX() + "," + jogador.getY() + ")");

            if (!jogador.jaVisitou()) {

                ElementoTabuleiro elemento = tabuleiro.getElemento(jogador.getX(), jogador.getY());
                int valor = elemento.interagir();
                jogador.registrarVisita(valor);

                System.out.println("Você encontrou: " + elemento.simbolo() + " (Pontos: " + valor + ")");
            } else {
                System.out.println("⚠️ Você já esteve aqui.");
            }

            System.out.println("Pontos atuais: " + jogador.getPontos());
            System.out.print("Mover (W/A/S/D): ");

            String move = scanner.next().toUpperCase();
            jogador.mover(move, tabuleiro.tamanho());

            movimentos++;
        }

        System.out.println("🎮 Fim de jogo! Você fez " + jogador.getPontos() + " pontos.");
    }
}
