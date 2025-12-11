import java.util.ArrayList;
import java.util.List;

public class SistemaPedidos {
    private List<Pedido> pedidos = new ArrayList<>();

    public void processarPedido(Pedido pedido) {
        pedido.getPagamento().processar(); 
        salvarPedido(pedido);
    }

    private void salvarPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido salvo: " + pedido.getId());
    }
}
