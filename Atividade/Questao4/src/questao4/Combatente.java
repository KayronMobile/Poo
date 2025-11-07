package questao4;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kayron (Aniki)
 */

public class Combatente extends AgenteOrdem implements Rituais {
    private String armaSagrada;

    public Combatente(String nome, int energia, String armaSagrada) {
        super(nome, energia, "Combatente da Ordo Realitas");
        this.armaSagrada = armaSagrada;
    }

    @Override
    public void agir() {
        System.out.println(nome + " empunha sua arma " + armaSagrada + " e enfrenta uma criatura!");
    }

    @Override
    public void realizarRitual(String nomeRitual) {
        System.out.println(nome + " realiza o ritual de purificação: " + nomeRitual);
    }

    public void abencoarArma() {
        System.out.println(nome + " abençoa a " + armaSagrada + " com energia da Realitas.");
    }
}


