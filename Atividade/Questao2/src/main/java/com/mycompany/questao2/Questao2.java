/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.questao2;

import java.util.Scanner;

/**
 *
 * @author kayron (Aniki)
 */
public class Questao2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int LINHAS = 20;
        final int COLUNAS = 40;

        Robo r1 = new Robo(0, 0);
        
        int opcao;

        do {
            mostrarSala(LINHAS, COLUNAS, r1);
            r1.mostrarPosicaoAtual();

            System.out.println("\n------------ controles do robo ------------");
            System.out.println("1 - Andar para cima");
            System.out.println("2 - Andar para baixo");
            System.out.println("3 - Andar para Direita");
            System.out.println("4 - Andar para Esquerda");
            System.out.println("5 - Tamanho Passos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();


            switch (opcao) {
                case 1 -> r1.andarFrente();
                case 2 -> r1.andarTras(LINHAS);
                case 3 -> r1.andarDireita(COLUNAS);
                case 4 -> r1.andarEsquerda();
                case 5 ->{
                    System.out.print("Quantos passos deseja andar? ");
                    int passos = sc.nextInt();
                    r1.setPasso(passos);
                }
                case 0 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção invalida!");
            }

        } while (opcao != 0);

        sc.close();
    }
    public static void mostrarSala(int linhas, int colunas, Robo robo) {
        System.out.println("\n------------ SALA ------------");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (i == robo.getLinha() && j == robo.getColuna()) {
                    System.out.print("1");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}

