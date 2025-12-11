public class Item {
    private final double preco;
    private final int quantidade;

    public Item(double preco, int quantidade) {
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }
}
