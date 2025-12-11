public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private int numeroDias;
    private double total;

    public Reserva(Cliente cliente, Quarto quarto, int numeroDias) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.numeroDias = numeroDias;
    }

    public void calcularTotal(Desconto descontoStrategy) {
        double valorBase = numeroDias * quarto.getPrecoDiaria();
        total = descontoStrategy.aplicarDesconto(valorBase);
    }

    public double getTotal() {
        return total;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
