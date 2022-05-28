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
public class Estoquee
{
    Scanner teclado = new Scanner(System.in);
    
    static List<Item> estoqueMercadoria = new ArrayList<>();
    
    static Set<Item> estoqueMercadoriaset = new HashSet<>();
    //essa coleção saberá de todos os itens que estão em estoque 
     
    static void adicionaProdutoAoEstoque()
    {
        Item produto = new Item();
        
        estoqueMercadoria.add(produto);
    }
    
    public static void aumentaQuantidade(String nome, int quant)
    {
        for(int i=0; i<estoqueMercadoria.size(); i++)
        {
            if(estoqueMercadoria.get(i).getNome()==nome)
            {
                estoqueMercadoria.get(i).setQuant(quant);
            }
        }
    }
    
    public static void removeDoEstoque(String nome, int quant)
    {
        for(int i=0; i<estoqueMercadoria.size(); i++)
        {
            if(estoqueMercadoria.get(i).getNome()==nome)
            {
                estoqueMercadoria.get(i).setQuant(-quant);
            }
        }
    }
     
    public static boolean verificaDisponiblidade(String nome)
    {
        if(estoqueMercadoria.isEmpty())
        {
            System.out.println("Estoque vazio!");
            return false;
        }
        
        
        for(int i=0; i<estoqueMercadoria.size(); i++)
        {
            if(estoqueMercadoria.get(i).getNome()==nome)
            {
                if(estoqueMercadoria.get(i).getQuant()>0)
                    return true;
            }
        }
        return false;
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
            if(estoqueMercadoria.get(i).getNome()==nome)
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
     
}