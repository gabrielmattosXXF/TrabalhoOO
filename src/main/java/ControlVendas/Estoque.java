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
            estoqueMercadoria.get(retornaIndexNome(nome)).setQuant(-quant);
        }
    }
    
    public static boolean verificaDispoProd(String nome)
    {
        if(estoqueMercadoria.isEmpty())
        {
            System.out.println("Estoque vazio!");
            return false;
        }
        else
        {
            if(estoqueMercadoria.get(retornaIndexNome(nome)).getQuant()>0)
                return true;
            else
                return false;
        }
        
        
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
            System.out.println("Item não localizado no estoque. Insira outro nome: ");
            {
                nome=teclado.nextLine();
                retornaIndexNome(nome);
            }
        }
        
        return i;
    }
     
    
    public static void imprimeEstoque()
    {
        System.out.println("Estoque da loja:");
        int i=0;
        
        for(Item produto : estoqueMercadoria)
        {
            System.out.println("Produto "+(i+1)+" -> "+produto);
            i++;
        }
    }
}