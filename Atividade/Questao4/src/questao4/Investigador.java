package questao4;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kayron (Aniki)
 */

public class Investigador extends AgenteOrdem {
    private int casosResolvidos;

    public Investigador(String nome, int energia, int casosResolvidos) {
        super(nome, energia, "Investigador Paranormal");
        this.casosResolvidos = casosResolvidos;
    }

    @Override
    public void agir() {
        System.out.println(nome + " analisa vestígios ectoplasmáticos...");
    }

    public void coletarProvas() {
        System.out.println(nome + " coleta amostras de substância paranormal.");
    }
}
