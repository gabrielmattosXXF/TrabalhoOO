/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Gabriel Mattos
 */
public class Item
{
     private String nomeItem;
     private double precoItem;
     private int quantItem; 

    public Item() {
    }

    public Item(String nomeItem, double precoItem, int quantItem) {
        this.nomeItem = nomeItem.toLowerCase();
        this.precoItem = precoItem;
        this.quantItem = quantItem;
    }
    
    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem.toLowerCase();
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(double precoItem) {
        this.precoItem = precoItem;
    }

    public int getQuantItem() {
        return quantItem;
    }

    public void setQuantItem(int quantItem) {
        this.quantItem = quantItem;
    }
    
    public void venda(int quantidadevendida)
    {
        quantItem = quantItem - quantidadevendida;
    }
     
    @Override
    public String toString() 
    {
        return "Nome =" + nomeItem + "\nPreco =" + precoItem + "\nQuantidade =" + quantItem;
    }
    
     
}
