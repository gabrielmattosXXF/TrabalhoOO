/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlVendas;
import java.util.*;

/**
 *
 * @author Gabriel Mattos
 */
public class Item
{
     Scanner teclado = new Scanner(System.in);
     
     private String nomeItem;
     private double precoItem;
     private int quantItem; //a quantidade de intens vai ser armazenada em um Map, com chave sendo o objeto item e valor sendo sua quantidade no estoque?
     //ou item guardará a quantidade de itens no estoque e o estoque será formado por um list ou um set de itens?
     
     public Item(String nome, double preco, int quant)
     {
          nomeItem=nome;
          precoItem=preco;
          quantItem=quant;
     }
     
     public Item()
     {
          System.out.println("Informe o nome do item: ");
          nomeItem=teclado.nextLine();
          
          System.out.println("Informe o preço do item: ");
          precoItem=teclado.nextDouble();
          
          System.out.println("Informe a quantidade do item: ");
          quantItem=teclado.nextInt();
     }
     
     public String getNome()
     {
         return nomeItem;
     }
     
     public double getpreco()
     {
         return precoItem;
     }
     
     public int getQuant()
     {
         return quantItem;
     }
     
     public void setPreco(double preco)
     {
         if(preco>0)
         {
             precoItem=preco;
         }
         else
         {
             System.out.println("Preço inválido. Digite o ajuste novamente.");
             preco=teclado.nextDouble();
             setPreco(preco);
         }
     }
     
     public void setQuant(int quant)
     {
         if(quant>0)
         {
             quantItem=quant;
         }
         else
         {
             System.out.println("Quantidade inválida. Digite o ajuste novamente.");
             quant=teclado.nextInt();
             setPreco(quant);
         }
     }
}
