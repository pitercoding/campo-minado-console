package br.com.campominado.modelo;

import br.com.campominado.excecao.ExplosaoException;

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
    boolean adicionarVizinho(Campo candidatoVizinho) {
        boolean linhaDiferente = linha != candidatoVizinho.linha;
        boolean colunaDiferente = coluna != candidatoVizinho.coluna;
        boolean diagonal = linhaDiferente && colunaDiferente;

        int deltaLinha = Math.abs(linha - candidatoVizinho.linha);
        int deltaColuna = Math.abs(coluna - candidatoVizinho.coluna);
        int deltaGeral = deltaColuna + deltaLinha;

        if (deltaGeral == 1 && !diagonal) {
            vizinhos.add(candidatoVizinho);
            return true;
        } else if (deltaGeral == 2 && diagonal) {
            vizinhos.add(candidatoVizinho);
            return true;
        } else {
            return false;
        }
    }

    void alternarMarcacao() {
        if (!aberto) {
            marcado = !marcado;
        }
    }

    boolean abrir(){
        if (!aberto && !marcado) {
            aberto = true;

            if (minado) {
                throw new ExplosaoException();
            }

            if (vizinhancaSegura()) {
                vizinhos.forEach(v -> v.abrir());
            }
            return true;
        } else {
            return false;
        }
    }

    boolean vizinhancaSegura() {
        return  vizinhos.stream().noneMatch(v -> v.minado);
    }
}
