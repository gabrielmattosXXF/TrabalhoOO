/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Vendedor;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Mattos
 */
public class Estoque
{
    Scanner teclado = new Scanner(System.in);
    
    static List<Item> estoqueMercadoria = new ArrayList<>();
     
    static void adicionaProdutoAoEstoque()
    {
        Item produto = new Item();
        
        estoqueMercadoria.add(produto);
    }
    
    static void adicionaProdutoAoEstoque(Item produto)
    {
        //Item produto = new Item();
        
        estoqueMercadoria.add(produto);
    }
    
    public static void aumentaQuantidade(String nome, int quant)
    {
        estoqueMercadoria.get(retornaIndexNome(nome)).setQuant(quant);
    }
    
    public static void diminuiQuantidade(String nome, int quant)
    {
        if(verificaDispoProd(nome))
        {
            //estoqueMercadoria.get(retornaIndexNome(nome)).getQuant();
            estoqueMercadoria.get(retornaIndexNome(nome)).setQuant((-quant));
        }
    }
    
    public static boolean veirificaEStoqueVazio()
    {
        if(estoqueMercadoria.isEmpty())
        {
            return true;
        }
        else
            return false;
    }
    
    public static boolean verificaDispoProd(String nome)
    {
        if(estoqueMercadoria.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Estoque vazio!", "Estoque", 0);
            //System.out.println("Estoque vazio!");
            return false;
        }
        else if(verificaProdInicializado(nome))
        {
            if(estoqueMercadoria.get(retornaIndexNome(nome)).getQuant()>0)
                return true;
            else
                return false;
        }
        else
            return false;
    }
    
    public static boolean verificaProdInicializado(String nome)
    {
        for(Item prod : estoqueMercadoria)
        {
            if(prod.getNome().equalsIgnoreCase(nome))
            {
                return true;
            }
        }
        
        return false;
        
        /*
        for(i=0; i<estoqueMercadoria.size(); i++)
        {
            if(estoqueMercadoria.get(i).getNome().equalsIgnoreCase(nome))
            {
                return true;
            }
        }
        
        return false;
        */
        
        
    }
     
    public static Item retornaItem(String nome)
    {
        return estoqueMercadoria.get(retornaIndexNome(nome));
    }
    
    public static int retornaIndexNome(String nome)
    {
        Scanner teclado = new Scanner(System.in);
        int i;
        
        
        for(i=0; i<estoqueMercadoria.size(); i++)
        {
            if(estoqueMercadoria.get(i).getNome().equalsIgnoreCase(nome))
            {
                return i;
            }
        }
        if(i==estoqueMercadoria.size())
        {
            nome = JOptionPane.showInputDialog(null, "Item não localizado no estoque. Insira outro nome: ");
            //System.out.println("Item não localizado no estoque. Insira outro nome: ");
            {
                //nome=teclado.nextLine();
                retornaIndexNome(nome);
            }
        }
        
        return i;
    }
     
    
    public static void imprimeEstoque()
    {
        JOptionPane.showMessageDialog(null, "Estoque da loja:");
        //System.out.println("Estoque da loja:");
        int i=0;
        
        String printEstoque;
        
        for(Item produto : estoqueMercadoria)
        {
            //printEstoque+=(produto+"\n");
            JOptionPane.showMessageDialog(null, "Produto " + (i+1) + " -> " + produto);
            //System.out.println("Produto "+(i+1)+" -> "+produto);
            i++;
        }
    }
    
    public static void setPrecoProd(String nome, double preco)
    {
        estoqueMercadoria.get(retornaIndexNome(nome)).setPreco(preco);
    }
    
    public static void setNomeProd(String nome1, String nome2)
    {
        estoqueMercadoria.get(retornaIndexNome(nome1)).setNome(nome2);
    }
    
    /*
    public static boolean realizaVenda(String nome,int qntd,Vendedor v)
    {
        if(verificaDispoProd(nome))
        {
            if(qntd>=estoqueMercadoria.get(retornaIndexNome(nome)).getQuant())
            {
                diminuiQuantidade(nome, qntd);
                v.computaVenda(nome ,retornaItem(nome).getPreco(),qntd);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
            return false;
    }
    */
    
    
}