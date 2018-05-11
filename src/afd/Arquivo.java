package afd;

import grammar.GrammarAFDParser;
import grammar.GrammarAFDLexer;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.exit;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Arquivo {
    private ArrayList<String> estados;             //Nome dos Estados
    private ArrayList<Character> alfabeto;              //Alfabeto Entrada
    private ArrayList<String> transicoes;               //Transições
    private String inicial;
    private ArrayList<String> finais;

    public Arquivo() {
        leArquivo();
    }

    private void leArquivo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome do arquivo:");
        String filename = String.valueOf(scanner.next());

        String entrada = "";
        BufferedReader br = null;

        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(filename));

            while ((sCurrentLine = br.readLine()) != null) {
                entrada += sCurrentLine;
                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao ler arquivo...");
            exit(0);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        entrada = entrada.replaceAll(" ", "");
        entrada = entrada.trim();

        try {
            InputStream stream = new ByteArrayInputStream(entrada.getBytes(StandardCharsets.UTF_8));
            ANTLRInputStream input = new ANTLRInputStream(stream);
            GrammarAFDLexer lexer = new GrammarAFDLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            GrammarAFDParser parser = new GrammarAFDParser(tokens);
            ParseTree tree = parser.expression();
            
            // OBTENÇÃO DO ALFABETO - INICIO
            entrada = entrada.substring(2);
            int cont=0;
            while(entrada.charAt(cont)!='}'){
                cont++;
            }
            String alfabeto = entrada.substring(0, cont);
            this.alfabeto = new ArrayList<>();
            String[] a = alfabeto.split("[,]");
            for(int i=0; i<a.length; i++){
                verificaSimbolo(a[i]);
                this.alfabeto.add(a[i].charAt(0));
            }
            verificaRepAlfabeto(this.alfabeto);
            System.out.println("ALFABETO="+alfabeto);
            // OBTENÇÃO DO ALFABETO - FIM
            
            
            // OBTENÇÃO DOS ESTADOS - INICIO
            cont+=3;
            entrada = entrada.substring(cont);
            cont=0;
            while(entrada.charAt(cont)!='}'){
                cont++;
            }
            String estados = entrada.substring(0, cont);
            System.out.println("ESTADOS="+estados);
            this.estados = new ArrayList<>();
            String[] e = estados.split("[,]");
            for(int i=0; i<e.length; i++){
                this.estados.add(e[i]);
            }
            // OBTENÇÃO DOS ESTADOS - FIM
            
            
            // OBTENÇÃO DAS TRANSIÇÕES - INICIO
            cont+=3;
            entrada = entrada.substring(cont);
            cont=0;
            while(entrada.charAt(cont)!='}'){
                cont++;
            }
            String trans = entrada.substring(0, cont);
            transicoes = new ArrayList<>();
            trans = trans.substring(1);
            while(trans.length()>5){
                int j = 0;
                while(trans.charAt(j)!=')'){
                    j++;
                }
                transicoes.add(trans.substring(0, j));
                trans = trans.substring(j);
                if(trans.length() >= 3){
                    trans = trans.substring(3);
                }
            }
            System.out.println("TRANSIÇÕES:");
            for(int i=0; i<transicoes.size(); i++){
                System.out.println("T->"+transicoes.get(i));
                if( !alfabeto.contains(transicoes.get(i).substring(transicoes.get(i).length()-1)) ){
                    System.out.println("Transição contém simbolo não pertencente ao alfabeto");
                    System.exit(4);
                }
            }
            // OBTENÇÃO DAS TRANSIÇÕES - FIM
            
            
            // OBTENÇÃO DO ESTADO INICIAL - INICIO
            cont+=2;
            entrada = entrada.substring(cont);
            cont=0;
            while(entrada.charAt(cont)!=','){
                cont++;
            }
            inicial = entrada.substring(0, cont);
            System.out.println("ESTADO INICIAL="+inicial);
            // OBTENÇÃO DO ESTADO INICIAL - FIM
            
            
            // OBTENÇÃO DOS ESTADOS FINAIS - INICIO
            cont+=2;
            entrada = entrada.substring(cont);
            cont=0;
            while(entrada.charAt(cont)!='}'){
                cont++;
            }
            String fin = entrada.substring(0, cont);
            finais = new ArrayList<>();
            String[] t = fin.split("[,]");
            for(int i=0; i<t.length; i++){
                finais.add(t[i]);
            }
            System.out.println("ESTADOS FINAIS="+fin);
            // OBTENÇÃO DOS ESTADOS FINAIS - FIM
            
        } catch (IOException ex) {
            Logger.getLogger(AFD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void verificaSimbolo(String simbolo) {
        if (simbolo.length() != 1 ) {
            System.out.println("Simbolo Inserido Inválido");
            System.exit(3);
        }
    }

    private void verificaRepAlfabeto(ArrayList alf) {
        Set<String> set = new HashSet<String>(alf);

        if (set.size() < alf.size()) {
            System.out.println("Simbolo Repetido no Alfabeto");
            System.exit(2);
        }
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
    }

    public ArrayList<Character> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(ArrayList<Character> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public ArrayList<String> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(ArrayList<String> transicoes) {
        this.transicoes = transicoes;
    }

    public String getInicial() {
        return inicial;
    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
    }

    public ArrayList<String> getFinais() {
        return finais;
    }

    public void setFinais(ArrayList<String> finais) {
        this.finais = finais;
    }
    
    

    
}
