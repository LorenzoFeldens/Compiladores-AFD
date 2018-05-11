package afd;

import java.util.ArrayList;
import java.util.Scanner;

public class AFD {
    private static Arquivo arq;
    private static ArrayList<Estado> estados;
    private static Estado estado_atual;
    private static Estado estado_inicial;
    
    
    public static void main(String[] args) {
        arq = new Arquivo();
        criaEstados();
        
        executaAFD();
        
    }
    
    private static void criaEstados(){
        estados = new ArrayList<>();
        
        for(int i=0; i<arq.getEstados().size(); i++){
            String nome = (String) arq.getEstados().get(i);
            Estado e = new Estado(nome);
            if(arq.getFinais().contains(nome)){
                e.setAceitacao(true);
            }
            estados.add(e);
            if(nome.equalsIgnoreCase(arq.getInicial())){
                estado_inicial = e;
            }
            
        }
        
        for (int i=0; i<arq.getTransicoes().size(); i++){
            String s = (String) arq.getTransicoes().get(i);                   // Seleciona uma das Funções de Transição
            
            String[] fs = s.split("->");                                   // Separa Função pela , deixando a posição 0 com o nome do Estado
            String[] id = fs[1].trim().split("[,]");
            
            verificaEstados(arq.getEstados(),fs[0].trim(), id[0].trim());
            verificaSimbolo(id[1].trim());
            
            for (int j=0; j<arq.getEstados().size(); j++){
                if(arq.getEstados().get(j).equals(fs[0].trim())){               // Procura o Estado Correpondente a Transição
                    Estado e = (Estado) estados.get(j);
                    Estado n = buscaEstado(id[0].trim());
                    e.addTransicao(s,id[1].trim().charAt(0),n);                                    // Cria a Transição
                }
            }
        }
    }
    
    private static void verificaSimbolo(String simbolo) {
        if (simbolo.length() != 1) {
            System.out.println("Simbolo Inserido Inválido");
            System.exit(3);
        }
    }
    
    private static void verificaEstados(ArrayList<String> estados, String e1, String e2){
        if((!estados.contains(e1) || (!estados.contains(e2)))){
            System.out.println("Transição possui estado não declarado");
            System.exit(6);
        }
    }
    
    private static Estado buscaEstado(String nome){
        for(int i=0; i<arq.getEstados().size(); i++){
            if (((String)arq.getEstados().get(i)).equalsIgnoreCase(nome)){
                return (Estado) estados.get(i);
            }
        }
        return null;
    }


    private static void executaAFD() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Insira a Entrada:");
        String entrada = String.valueOf(scanner.nextLine());                               //Lê a Entrada
        verificaEntrada(entrada);
        
        estado_atual = estado_inicial;
        
        int cab = 0;
        
        while(estado_atual != null){
            System.out.println("Estado Atual: "+estado_atual.getNome());
            Transicao t;
            if(entrada.length()>cab){
                t = estado_atual.getTransicao(entrada.charAt(cab));
            }else{
                t = null;
            }
            if(t != null){
                System.out.println("Transição: "+t.getOriginal());
                estado_atual = t.getProx_estado();
            }else{
                System.out.println("Não há Transição");
                if(estado_atual.isAceitacao() && cab == entrada.length()){
                    System.out.println("Aceita");
                }else{
                    System.out.println("Rejeita");
                }
                estado_atual = null;
            }
            cab++;
        }
    }
    
    private static void verificaEntrada(String entrada) {
        for(int i=0; i<entrada.length(); i++){
            if(!arq.getAlfabeto().contains(entrada.charAt(i))){
                System.out.println("Entrada possui Símbolo não presente no Alfabeto de Entrada");
                System.exit(5);
            }
        }
    }

    
    
}
