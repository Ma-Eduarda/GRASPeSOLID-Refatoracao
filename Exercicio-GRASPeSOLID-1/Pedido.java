import java.util.List;

public class Pedido {
    private int id;
    private List<Item> itens;
    private double total;
    private Pagamento pagamento;

    public Pedido(int id, List<Item> itens, Pagamento pagamento) {
        this.id = id;
        this.itens = itens;
        this.pagamento = pagamento;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    public double getTotal() { return total; }
    public int getId() { return id; }
    public Pagamento getPagamento() { return pagamento; }

}
