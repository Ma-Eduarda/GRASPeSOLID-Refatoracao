import java.util.Scanner;

public class Jogo {

    private Tabuleiro tabuleiro;
    private Jogador jogador;
    private Scanner scanner;
    private int movimentos;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        jogador = new Jogador();
        scanner = new Scanner(System.in);
        movimentos = 0;
    }

    public void iniciar() {

        System.out.println("🎯 Bem-vindo ao Caça ao Tesouro!");

        while (movimentos < 10) {

            System.out.println("\nVocê está na posição (" 
                    + jogador.getX() + "," + jogador.getY() + ")");

            if (!jogador.jaVisitou()) {

                ElementoTabuleiro elemento =
                        tabuleiro.getElemento(jogador.getX(), jogador.getY());

                int valor = elemento.interagir();

                jogador.registrarVisita(valor);

                System.out.println("Você encontrou: "
                        + elemento.simbolo()
                        + " (Pontos: " + valor + ")");

            } else {
                System.out.println("⚠️ Você já esteve aqui.");
            }

            System.out.println("Pontos atuais: " + jogador.getPontos());

            System.out.print("Mover (W/A/S/D): ");

            String move = scanner.next().toUpperCase();

            jogador.mover(move, tabuleiro.tamanho());

            movimentos++;
        }

        System.out.println("🎮 Fim de jogo! Você fez "
                + jogador.getPontos() + " pontos.");
    }
}
