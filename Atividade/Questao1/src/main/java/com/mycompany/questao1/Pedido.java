/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.questao1;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author kayron (Aniki)
 */
public class Pedido {
   private static int contador=1;
    private LocalDateTime dataCompra,dataEntrega; 
   private boolean statusPago,statusEntrega;
   final private float preco=80;
   private float totalPagar;
   private int quantidade,id;
   private String endereco,cartao;
   private String usuarioResponsavel;

    public Pedido( int quantidade, String endereco,String usuarioResponsavel) {
        this.id=contador++;
        this.quantidade = quantidade;
        this.endereco = endereco;
         this.usuarioResponsavel = usuarioResponsavel;
        this.totalPagar = quantidade * preco;
        this.dataCompra = LocalDateTime.now();
        this.dataEntrega=this.dataCompra.plusHours(2);
      //  this.dataEntrega=this.dataCompra.plusSeconds(30);//Teste rapido para ver a atualização automatica da entrega
        this.statusPago = false;
        this.statusEntrega = false;
    }
    public void confirmarPedido(String numeroCartao) {
        this.cartao = numeroCartao;
        this.statusPago = true;
    }

    public void verificarEntregaAutomatica() {
        // Se já passou da hora prevista, marca como entregue
        if (LocalDateTime.now().isAfter(dataEntrega)) {
            this.statusEntrega = true;
        }
    }

    public void entregarManualmente() {
        this.statusEntrega = true;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

   
   

    public float getTotalPagar() {return totalPagar;}
    public boolean isStatusPago() { return statusPago; }
    public boolean isStatusEntrega() { return statusEntrega; }
    public int getId() { return id; }
    public String getUsuarioResponsavel() { return usuarioResponsavel; }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "\n=== Pedido " + id + " ==="
                + "\nUsuario: " + usuarioResponsavel
                + "\nEndereco: " + endereco
                + "\nQtd: " + quantidade
                + "\nPreco unitario: R$ " + preco
                + "\nTotal: R$ " + totalPagar
                + "\nData/Hora compra: " + dataCompra.format(fmt)
                + "\nPrevisao entrega: " + dataEntrega.format(fmt)
                + "\nConfirmado: " + (statusPago ? "Sim" : "Nao")
                + "\nEntregue: " + (statusEntrega ? "Sim" : "Nao");
    }
}
