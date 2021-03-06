/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Item;
import Model.Usuario;
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
    
    private static List<Item> estoqueMercadoria = new ArrayList<>();
     
    static void adicionaProdutoAoEstoque()
    {
        Item produto = new Item();
        
        estoqueMercadoria.add(produto);
    }
    
    public static void adicionaProdutoAoEstoque(Item produto)
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
     
    public static double retornaPrecoItem(String nome)
    {
        return estoqueMercadoria.get(retornaIndexNome(nome)).getPreco();
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
            nome = JOptionPane.showInputDialog(null, "Item n??o localizado no estoque. Insira outro nome: ");
            //System.out.println("Item n??o localizado no estoque. Insira outro nome: ");
            {
                //nome=teclado.nextLine();
                retornaIndexNome(nome);
            }
        }
        
        return i;
    }
     
    
    public static List imprimeEstoque()//provavelmente vai apagar
    {
        List<String> listaEstoque = new ArrayList<>();
        for(Item prod : estoqueMercadoria)
        {
            listaEstoque.add(prod.toString());
        }
        return listaEstoque;
    }
    
    public static List imprimeEstoqueS()
    {
        List<String> listaEstoque = new ArrayList<>();
        for(Item prod : estoqueMercadoria)
        {
            listaEstoque.add(prod.getNome());
        }
        return listaEstoque;
    }
    
    public static void setPrecoProd(String nome, double preco)//rever essa fun??/??o
    {
        estoqueMercadoria.get(retornaIndexNome(nome)).setPreco(preco);
    }
    
    /*public static void setNomeProd(String nome1, String nome2)//rever essa fun??/??o
    {
        estoqueMercadoria.get(retornaIndexNome(nome1)).setNome(nome2);
    }*/
    
    
    public static boolean realizaVenda(String nome,int qntd,Vendedor v)
    {
        if(verificaDispoProd(nome))
        {
            if(qntd>=estoqueMercadoria.get(retornaIndexNome(nome)).getQuant())
            {
                diminuiQuantidade(nome, qntd);
                v.computaVenda(nome ,retornaPrecoItem(nome),qntd);
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
    
    public static void removeItem(int index)
    {
        estoqueMercadoria.remove(index);
    }
    
    public static Item retornaItemIndex(int index)//rever essa fun????o
    {
        return estoqueMercadoria.get(index);
    }
}