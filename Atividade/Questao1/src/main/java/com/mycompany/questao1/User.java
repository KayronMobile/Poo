
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.questao1;
import java.util.ArrayList;

/**
 *
 * @author kayron (Aniki)
 */
public class User {
    private String nome="usuario",login="aniki",senha="tadsEaj";
    private boolean adm=false;
    private float saldo;
    
    public User(String nome,String login,String senha,boolean adm){
    this.senha=senha;
    this.nome=nome;
    this.login=login;
    this.adm=adm;
}
    
    ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Pedido buscarPedidoPorCodigo(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) return p;
        }
        return null;
    }
        //metodos para a listagem de pedidos
    public void listarPedidosConfirmados() {
        System.out.println("\n=== Pedidos Confirmados ===");
        boolean encontrou=false;
        for (Pedido p : pedidos) {
            if (p.isStatusPago() && !p.isStatusEntrega()) {
                p.verificarEntregaAutomatica(); // checa se já passou das 2h
                System.out.println(p);
                encontrou=true;
            }
        }
        if(!encontrou){
            System.out.println("Nao ha nenhum pedido Confirmado");
        }
    }

    public void listarPedidosEntregues() {
        System.out.println("\n=== Pedidos Entregues ===");
        boolean encontrou=false;
        for (Pedido p : pedidos) {
            p.verificarEntregaAutomatica();
            if (p.isStatusEntrega()) {
                System.out.println(p);
                encontrou=true;
            }
        }
        if(!encontrou){
            System.out.println("Nao ha nenhum pedido entregue");
        }
    }

    public String getLogin() { return login; }
    public String getSenha() { return senha; }
    public String getNome() { return nome; }
    public boolean isAdmin() { return adm; }
    public ArrayList<Pedido> getPedidos() { return pedidos; }
}

