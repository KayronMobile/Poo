package com.mycompany.questao2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kayron (Aniki)
 */
public class Robo {
    private int linha;
    private int coluna;
    private int passo;

    public Robo(int linhaInicial, int colunaInicial) {
        this.linha = linhaInicial;
        this.coluna = colunaInicial;
        this.passo = 1;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getPasso() {
        return passo;
    }

    public void setPasso(int passo) {
        this.passo = passo;
    }

    public void mostrarPosicaoAtual() {
        System.out.println("Posicao atual do robo: (" + linha + ", " + coluna + ")");
    }

    public void andarFrente() {
        if (linha - passo < 0) {
            linha = 0; 
            System.out.println("Ele bateu no topo");
        } else {
            linha -= passo;
        }
    }

    public void andarTras(int limiteLinhas) {
        if (linha + passo >= limiteLinhas) {
            linha = limiteLinhas - 1;
            System.out.println("Ele bateu na base");

        } else {
            linha += passo;
        }
    }

    public void andarDireita(int limiteColunas) {
        if (coluna + passo >= limiteColunas) {
            coluna = limiteColunas - 1;
            System.out.println("Ele bateu no limite da direita");
        } else {
            coluna += passo;
        }
    }

    public void andarEsquerda() {
        if (coluna - passo < 0) {
            coluna = 0;
            System.out.println("Ele bateu no limite da Esquerda");
        } else {
            coluna -= passo;
        }
    }
    
     
}

