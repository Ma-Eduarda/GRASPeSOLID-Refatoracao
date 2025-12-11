import java.util.*;

public class Cliente {
    private String nome;
    private Collection<Aluguel> fitasAlugadas = new ArrayList<>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionaAluguel(Aluguel aluguel) {
        fitasAlugadas.add(aluguel);
    }

    public String extrato() {
        final String fim = System.getProperty("line.separator");
        double valorTotal = 0;
        int pontos = 0;

        String resultado = "Registro de Alugueis de " + nome + fim;

        for (Aluguel a : fitasAlugadas) {
            double valor = a.getValor();
            int pontosFita = a.getPontos();

            resultado += "\t" + a.getFita().getTitulo() + "\t" + valor + fim;

            valorTotal += valor;
            pontos += pontosFita;
        }

        resultado += "Valor total devido: " + valorTotal + fim;
        resultado += "Voce acumulou " + pontos + " pontos de alugador frequente";

        return resultado;
    }
}
