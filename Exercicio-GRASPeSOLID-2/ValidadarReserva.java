public class ValidadarReserva {
    public void validar(Reserva reserva) {
        if (!reserva.getQuarto().isDisponivel()) {
            throw new RuntimeException("Quarto indisponível!");
        }
    }
}