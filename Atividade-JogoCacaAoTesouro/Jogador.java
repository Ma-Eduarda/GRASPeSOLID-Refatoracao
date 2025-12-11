import java.util.HashSet;
import java.util.Set;

public class Jogador {
    private int x = 0;
    private int y = 0;
    private int pontos = 0;
    private Set<String> visitados = new HashSet<>();

    public int getX() { return x; }
    public int getY() { return y; }
    public int getPontos() { return pontos; }

    public boolean jaVisitou() {
        return visitados.contains(x + "," + y);
    }

    public void registrarVisita(int pontosGanhos) {
        visitados.add(x + "," + y);
        this.pontos += pontosGanhos;
    }

    public void mover(String move, int limite) {
        switch (move) {
            case "W": if (x > 0) x--; break;
            case "S": if (x < limite - 1) x++; break;
            case "A": if (y > 0) y--; break;
            case "D": if (y < limite - 1) y++; break;
            default:
                System.out.println("Movimento inválido.");
        }
    }
}

