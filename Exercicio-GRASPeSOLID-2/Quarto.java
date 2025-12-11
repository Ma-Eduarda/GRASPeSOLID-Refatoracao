public class Quarto {
    private boolean disponivel = true;
    private double precoDiaria;

    public Quarto(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }
}
