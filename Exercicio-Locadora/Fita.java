public abstract class Fita {
    private String titulo;

    public Fita(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract double calcularValor(int dias);
    public abstract int calcularPontos(int dias);
}