public class DescontoPremium implements Desconto {
    public double aplicarDesconto(double valor) {
        return valor * 0.9;
    }
}