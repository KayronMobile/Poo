package questao4;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kayron (Aniki)
 */


public abstract class EntidadeParanormal {
    protected String nome;
    protected int nivelEnergia;

    public EntidadeParanormal(String nome, int nivelEnergia) {
        this.nome = nome;
        this.nivelEnergia = nivelEnergia;
    }

    public abstract void manifestar(); // método abstrato obrigatório

    // método concreto comum a todas as entidades
    public void exibirStatus() {
        System.out.println(nome + " possui energia: " + nivelEnergia);
    }

    // sobrecarga de construtor
    public EntidadeParanormal(String nome) {
        this(nome, 100);
    }
}
