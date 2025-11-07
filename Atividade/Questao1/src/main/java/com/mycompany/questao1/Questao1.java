/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.questao1;

import java.util.ArrayList;

/**
 *
 * @author kayron (Aniki)
 */
public class Questao1 {

    public static void main(String[] args) {
        ArrayList<User> usuarios = new ArrayList<>();
        usuarios.add(new User("Kayron", "aniki", "tadsEaj", false));
        
        usuarios.add(new User("Administrador", "adm", "1234", true));

        Menu menu = new Menu(usuarios);
        User usuarioLogado = menu.realizarLogin();

        if (usuarioLogado == null) {
            System.out.println("Acesso negado. Encerrando programa...");
            return;
        }

        if (usuarioLogado.isAdmin()) {menu.menuAdministrador();} 
        else {menu.menuUsuario(usuarioLogado);}
    }
}
