package afd;

import java.util.ArrayList;

public class Estado {
    private String nome;                                    // Nome do estado
    private ArrayList<Transicao> transicoes;                   // Transições do Estado
    private boolean aceitacao;
    
    public Estado(String nome) {
        this.nome = nome;
        transicoes = new ArrayList<>();
        aceitacao = false;
    }
    
    public void addTransicao(String original, Character c,Estado e){
        transicoes.add(new Transicao(original, c,e));
    }
    
    public Transicao getTransicao(Character c){
        Transicao t = null;
        for(int i=0; i<transicoes.size(); i++){
            t = transicoes.get(i);
            
            if(t.getCaracter() == c){
                return t;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Transicao> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(ArrayList<Transicao> transicoes) {
        this.transicoes = transicoes;
    }

    public boolean isAceitacao() {
        return aceitacao;
    }

    public void setAceitacao(boolean aceitacao) {
        this.aceitacao = aceitacao;
    }
    
    
}
