public class FitaLancamento extends Fita {
    public FitaLancamento(String titulo) {
        super(titulo);
    }

    @Override
    public double calcularValor(int dias) {
        return dias * 3;
    }

    @Override
    public int calcularPontos(int dias) {
        return dias > 1 ? 2 : 1;
    }
}