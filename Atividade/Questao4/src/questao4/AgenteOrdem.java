package questao4;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kayron (Aniki)
 */

public class AgenteOrdem extends EntidadeParanormal {
    protected String especialidade;

    public AgenteOrdem(String nome, int nivelEnergia, String especialidade) {
        super(nome, nivelEnergia);
        this.especialidade = especialidade;
    }

    // construtor sobrecarregado
    public AgenteOrdem(String nome) {
        super(nome);
        this.especialidade = "Genérico";
    }

    @Override
    public void manifestar() {
        System.out.println(nome + " sente a presença do Outro Lado...");
    }

    public void agir() {
        System.out.println(nome + " está cumprindo uma missão da Ordo Realitas!");
    }

    // sobrecarga de método agir()
    public void agir(String local) {
        System.out.println(nome + " investiga atividade paranormal em " + local);
    }
}
