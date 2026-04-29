public class FitaNormal extends Fita {
    public FitaNormal(String titulo) {
        super(titulo);
    }

    @Override
    public double calcularValor(int dias) {
        double valor = 2;
        if (dias > 2) valor += (dias - 2) * 1.5;
        return valor;
    }

    @Override
    public int calcularPontos(int dias) {
        return 1;
    }
}

