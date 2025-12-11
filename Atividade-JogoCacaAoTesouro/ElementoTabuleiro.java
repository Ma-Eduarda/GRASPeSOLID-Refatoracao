public abstract class ElementoTabuleiro {
    public abstract int interagir(); 
    public abstract String simbolo(); 
}

class Tesouro extends ElementoTabuleiro {
    @Override
    public int interagir() { return 3; } 
    @Override
    public String simbolo() { return "💰"; } 
}

class Armadilha extends ElementoTabuleiro {
    @Override
    public int interagir() { return -2; }
    @Override
    public String simbolo() { return "💣"; }
}

class Vazio extends ElementoTabuleiro {
    @Override
    public int interagir() { return 0; }
    @Override
    public String simbolo() { return "⬜"; }
}
