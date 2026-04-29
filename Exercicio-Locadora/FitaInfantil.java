public class FitaInfantil extends Fita {
    public FitaInfantil(String titulo) {
        super(titulo);
    }

    @Override
    public double calcularValor(int dias) {
        double valor = 1.5;
        if (dias > 3) valor += (dias - 3) * 1.5;
        return valor;
    }

    @Override
    public int calcularPontos(int dias) {
        return 1;
    }
}
