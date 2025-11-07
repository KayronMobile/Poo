package questao4;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kayron (Aniki)
 */


public class CriaturaDoOutroLado extends EntidadeParanormal implements Rituais, HabilidadesParanormais {

    private String dominio;

    public CriaturaDoOutroLado(String nome, int energia, String dominio) {
        super(nome, energia);
        this.dominio = dominio;
    }

    @Override
    public void manifestar() {
        System.out.println(nome + " surge do domínio do " + dominio + "!");
    }

    @Override
    public void realizarRitual(String nomeRitual) {
        System.out.println(nome + " realiza o ritual sombrio: " + nomeRitual);
    }

    @Override
    public void usarPoder(String poder) {
        System.out.println(nome + " usa o poder paranormal: " + poder);
    }

    @Override
    public void defender() {
        System.out.println(nome + " envolve-se em uma aura de escuridão para se defender!");
    }

    public void corromperAlma() {
        System.out.println(nome + " tenta corromper a mente de um humano...");
    }
}

