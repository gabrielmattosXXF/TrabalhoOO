/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Gabriel Mattos
 */
public class Item
{
     Scanner teclado = new Scanner(System.in);
     
     private String nomeItem;
     private double precoItem;
     //private double precoDeCompra;
     private int quantItem=0; 
     
     public Item(String nome, double preco,/*double precoCompra,*/ int quant)
     {
          this.nomeItem=nome.toLowerCase();
          this.precoItem=preco;
          //this.precoDeCompra=precoCompra;
          this.quantItem=quant;
     }
     
     public Item()
     {
          //System.out.println("Informe o nome do item: ");
          //this.nomeItem=teclado.nextLine().toLowerCase();
          this.nomeItem=JOptionPane.showInputDialog(null,"informe o nome do item");
          
          //System.out.println("Informe o preço do item: ");
          //this.precoItem=teclado.nextDouble();
          //this.precoItem=JOptionPane.showInputDialog(null,"informe o preço do Item");
          this.precoItem = Double.parseDouble(JOptionPane.showInputDialog(null,"informe o preço do Item"));

          //System.out.println("Informe a quantidade do item: ");
          //this.quantItem=teclado.nextInt();
          this.quantItem=Integer.parseInt(JOptionPane.showInputDialog(null,"informe a quantidade do Item"));
          
     }
     
     public String getNome()
     {
         return nomeItem;
     }
     
     public double getPreco()
     {
         return precoItem;
     }
     
     public int getQuant()
     {
         return quantItem;
     }
     
     public void setQuant(int quant)
     {
         if(quantItem+quant>=0)
         {
             quantItem+=quant;
         }
         else
         {
             quant = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade inválida. Digite o ajuste novamente."));
             //System.out.println("Quantidade inválida. Digite o ajuste novamente.");
             //quant=teclado.nextInt();
             setPreco(quant);
         }
     }
     
     public void setPreco(double preco)
     {
         if(preco>0)
         {
             precoItem=preco;
         }
         else
         {
             preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Preço inválido. Digite o ajuste novamente."));
             //System.out.println("Preço inválido. Digite o ajuste novamente.");
             //preco=teclado.nextDouble();
             setPreco(preco);
         }
     }
     
     public void setNome(String nome)
     {
         this.nomeItem=nome.toLowerCase();
     }

    @Override
    public String toString() {
        return "Nome =" + nomeItem + ", preco =" + precoItem + ", quantidade em estoque =" + quantItem+".";
    }
     
     
}
