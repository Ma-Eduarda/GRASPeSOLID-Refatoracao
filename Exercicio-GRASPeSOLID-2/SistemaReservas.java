import java.util.*;

public class SistemaReservas {
    private List<Reserva> reservas = new ArrayList<>();

    public void processarReserva(Reserva reserva) {
        if (!reserva.getQuarto().isDisponivel()) {
            throw new RuntimeException("Quarto indisponível!");
        }

        Desconto desconto = reserva.getCliente().isPremium() ?
                new DescontoPremium() :
                new SemDesconto();

        reserva.calcularTotal(desconto);
        reserva.getQuarto().setDisponivel(false);
        reservas.add(reserva);

        System.out.println("Reserva confirmada. Total: " + reserva.getTotal());
    }
}
