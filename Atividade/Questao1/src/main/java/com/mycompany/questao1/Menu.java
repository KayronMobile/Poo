package com.mycompany.questao1;
import java.util.*;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<User> usuarios;

    public Menu(ArrayList<User> usuarios) {
        this.usuarios = usuarios;
    }

    // === LOGIN ===
    public User realizarLogin() {
        System.out.println("=== SISTEMA DE PEDIDOS DE BOTIJAO ===");
        for (int tentativas = 1; tentativas <= 3; tentativas++) {
            System.out.print("Login: ");
            String login = sc.nextLine();
            System.out.print("Senha: ");
            String senha = sc.nextLine();

            for (User u : usuarios) {
                if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                    System.out.println("\nBem-vindo, " + u.getNome() + "!");
                    pressionarEnter();
                    return u;
                }
            }
            System.out.println("Credenciais incorretas! (" + (3 - tentativas) + " tentativas restantes)");
        }
        return null;
    }

    // === MENU USUÁRIO ===
    public void menuUsuario(User usuario) {
        int opcao;
        do {
            System.out.println("=== MENU USUARIO (" + usuario.getNome() + ") ===");
            System.out.println("1 - Fazer pedido");
            System.out.println("2 - Confirmar pedido");
            System.out.println("3 - Ver pedidos confirmados");
            System.out.println("4 - Ver pedidos entregues");
            System.out.println("5 - Trocar de conta");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    fazerPedido(usuario);
                    pressionarEnter();
                   
                }
                case 2 -> {
                    confirmarPedidoUsuario(usuario);
                    pressionarEnter();
                    
                }
                case 3 -> {
                    usuario.listarPedidosConfirmados();
                    pressionarEnter();
                    
                }
                case 4 -> {
                    usuario.listarPedidosEntregues();
                    pressionarEnter();
                   
                }
                case 5 -> trocarUsuario();
                case 0 -> {
                    System.out.println("Saindo...");
                    
                    System.exit(0);
                }
                default -> {
                    System.out.println("Opcao invalida!");
                    pressionarEnter();
                    
                }
            }
        } while (opcao != 0);
    }

    // === MENU ADMINISTRADOR ===
    public void menuAdministrador() {
        int opcao;
        do {
            
            System.out.println("=== MENU ADMINISTRADOR (ADM) ===");
            System.out.println("1 - Ver todos os pedidos");
            System.out.println("2 - Confirmar entrega");
            System.out.println("3 - Trocar de conta");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    listarTodosPedidos();
                    pressionarEnter();
                   
                }
                case 2 -> {
                    confirmarEntregaUsuario();
                    pressionarEnter();
                    
                }
                case 3 -> trocarUsuario();
                case 0 -> {
                    System.out.println("Encerrando painel admin...");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Opçao invalida!");
                    pressionarEnter();
                   
                }
            }
        } while (opcao != 0);
    }

    // === MÉTODOS DE AÇÃO ===
    private void fazerPedido(User usuario) {
        
        System.out.println("=== NOVO PEDIDO ===");
        System.out.print("Endereco: ");
        String endereco = sc.nextLine();
        System.out.print("Quantidade de botijoes: ");
        int qtd = sc.nextInt();
        sc.nextLine();

        Pedido novo = new Pedido(qtd, endereco, usuario.getNome());
        System.out.println("\nPedido criado:");
        System.out.println(novo);
        usuario.adicionarPedido(novo);
        System.out.println("Pedido aguardando confirmacao do usuario.");
    }

    private void confirmarPedidoUsuario(User usuario) {
       
        System.out.println("=== CONFIRMAR PEDIDO ===");
        System.out.print("Digite o codigo do pedido: ");
        int cod = sc.nextInt();
        sc.nextLine();

        Pedido p = usuario.buscarPedidoPorCodigo(cod);
        if (p == null) {
            System.out.println("Pedido nao encontrado!");
            return;
        }

        if (p.isStatusPago()) {
            System.out.println("Este pedido ja foi confirmado!");
            return;
        }

        System.out.print("Numero do cartao (8 digitos): ");
        String cartao = sc.nextLine();
        while (!cartao.matches("\\d{8}")) {
            System.out.print("Numero invalido! Digite 8 digitos: ");
            cartao = sc.nextLine();
        }

        p.confirmarPedido(cartao);
        System.out.println("Pedido " + cod + " confirmado com sucesso!");
    }

    private void listarTodosPedidos() {
        
        System.out.println("=== TODOS OS PEDIDOS ===");
        boolean encontrou = false;
        for (User u : usuarios) {
            for (Pedido p : u.getPedidos()) {
                p.verificarEntregaAutomatica();
                System.out.println(p);
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum pedido encontrado.");
    }

    private void confirmarEntregaUsuario() {
        
        System.out.println("=== CONFIRMAR ENTREGA ===");
        System.out.print("Digite o cod do pedido: ");
        int cod = sc.nextInt();
        sc.nextLine();

        for (User u : usuarios) {
            for (Pedido p : u.getPedidos()) {
                if (p.getId() == cod) {
                    p.entregarManualmente();
                    System.out.println(" Pedido " + cod + " marcado como ENTREGUE!");
                    return;
                }
            }
        }
        System.out.println("Pedido nao encontrado.");
    }

    // === TROCAR DE USUÁRIO ===
    private void trocarUsuario() {
        System.out.println("\n--- Trocando de usuario ---");
        pressionarEnter();
        User novoLogin = realizarLogin();
        if (novoLogin != null) {
            if (novoLogin.isAdmin()) {
                menuAdministrador();
            } else {
                menuUsuario(novoLogin);
            }
        } else {
            System.out.println("Falha no login. Retornando ao menu anterior...");
            pressionarEnter();
        }
    }

 

    private void pressionarEnter() {
        System.out.println("\nPressione ENTER para continuar...");
        sc.nextLine();
    }
}
