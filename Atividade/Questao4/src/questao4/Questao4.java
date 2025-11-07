package questao4;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author kayron (Aniki)
 */
public class Questao4 {

    public static void main(String[] args) {
        System.out.println("=== ORDEM PARANORMAL – TESTE DE HERANÇA E INTERFACES ===\n");

        AgenteOrdem agenteBase = new AgenteOrdem("Arthur Cervero");
        Investigador inv = new Investigador("Cesar Cohen", 90, 12);
        Combatente comb = new Combatente("Elizabeth Webber", 100, "Espada Ritualística");
        CriaturaDoOutroLado criatura = new CriaturaDoOutroLado("Mefisto", 150, "Sangue");

        System.out.println("--- TESTANDO CLASSES ---");
        agenteBase.manifestar();
        agenteBase.agir("Quartel da Ordo");

        inv.manifestar();
        inv.agir();
        inv.coletarProvas();

        comb.manifestar();
        comb.agir();
        comb.abencoarArma();
        comb.realizarRitual("Luz da Purificação");

        criatura.manifestar();
        criatura.usarPoder("Corrupção Mental");
        criatura.defender();
        criatura.realizarRitual("Ritual de Sangue");
        criatura.corromperAlma();

        System.out.println("\n--- TESTE DE SOBRECARGA DE CONSTRUTORES ---");
        AgenteOrdem generico = new AgenteOrdem("Gabriel");
        generico.agir();
    }
}

