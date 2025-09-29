package br.com.campominado.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {

    private final int linha;
    private final int coluna;

    private boolean aberto = false;
    private  boolean minado;
    private boolean marcado = false;

    private List<Campo> vizinhos = new ArrayList<>();

    // Construtor
    Campo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    // ---------------- Métodos ----------------
    boolean adicionarVizinho(Campo vizinho) {
        
    }


}
