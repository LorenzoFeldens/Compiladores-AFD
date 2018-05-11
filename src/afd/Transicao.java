package afd;

public class Transicao {
    private String original;
    private Character caracter;
    private Estado prox_estado;
    
    public Transicao(String original, Character c, Estado prox_estado) {
        this.original = original;
        caracter = c;
        this.prox_estado = prox_estado;
    }

    public Estado getProx_estado() {
        return prox_estado;
    }

    public void setProx_estado(Estado prox_estado) {
        this.prox_estado = prox_estado;
    }

    public Character getCaracter() {
        return caracter;
    }

    public void setCaracter(Character caracter) {
        this.caracter = caracter;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }
    
    
}
