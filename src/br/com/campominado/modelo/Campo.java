package br.com.campominado.modelo;

import br.com.campominado.excecao.ExplosaoException;

import java.util.ArrayList;
import java.util.List;

public class Campo {

    private final int linha;
    private final int coluna;

    private boolean aberto = false;
    private boolean minado = false;
    private boolean marcado = false;

    private List<Campo> vizinhos = new ArrayList<>();

    Campo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    boolean adicionarVizinho(Campo vizinho) {
        boolean linhaDiferente = linha != vizinho.linha;
        boolean colunaDiferente = coluna != vizinho.coluna;
        boolean diagonal = linhaDiferente && colunaDiferente;

        int deltaLinha = Math.abs(linha - vizinho.linha);
        int deltaColuna = Math.abs(coluna - vizinho.coluna);
        int detalGeral = deltaColuna + deltaLinha;

        if(detalGeral == 1 && !diagonal) {
            vizinhos.add(vizinho);
            return true;
        } else if(detalGeral == 2 && diagonal) {
            vizinhos.add(vizinho);
            return true;
        } else {
            return false;
        }
    }

    void alternarMarcacao() {
        if(!aberto) {
            marcado = !marcado;
        }
    }

    boolean abrir() {

        if(!aberto && !marcado) {
            aberto = true;

            if(minado) {
                throw new ExplosaoException();
            }

            if(vizinhancaSegura()) {
                vizinhos.forEach(v -> v.abrir());
            }

            return true;
        } else {
            return false;
        }
    }

    boolean vizinhancaSegura() {
        return vizinhos.stream().noneMatch(v -> v.minado);
    }

    void minar() {
        minado = true;
    }

    public boolean isMinado() {
        return minado;
    }

    public boolean isMarcado() {
        return marcado;
    }

    void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public boolean isAberto() {
        return aberto;
    }

    public boolean isFechado() {
        return !isAberto();
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    boolean objetivoAlcancado() {
        boolean desvendado = !minado && aberto;
        boolean protegido = minado && marcado;
        return desvendado || protegido;
    }

    long minasNaVizinhanca() {
        return vizinhos.stream().filter(v -> v.minado).count();
    }

    void reiniciar() {
        aberto = false;
        minado = false;
        marcado = false;
    }

    @Override
    public String toString() {
        final String RESET = "\u001B[0m";
        String cor;

        if (marcado) {
            return "\u001B[33mx\u001B[0m"; // amarelo para bandeira
        } else if (aberto && minado) {
            return "\u001B[31m*\u001B[0m"; // vermelho para mina
        } else if (aberto && minasNaVizinhanca() > 0) {
            long minas = minasNaVizinhanca();
            switch ((int) minas) {
                case 1: cor = "\u001B[34m"; break; // azul
                case 2: cor = "\u001B[32m"; break; // verde
                case 3: cor = "\u001B[31m"; break; // vermelho
                case 4: cor = "\u001B[35m"; break; // roxo
                default: cor = "\u001B[36m"; break; // ciano para 5+
            }
            return cor + minas + RESET;
        } else if (aberto) {
            return " "; // campo aberto vazio
        } else {
            return "?"; // campo fechado
        }
    }
}
