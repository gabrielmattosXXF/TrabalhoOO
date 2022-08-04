/*
Augusto de Fillippo Cavalini-202165514B 

Gabriel Mattos-202165503B 

Luiz Gustavo Ferreira Nazareth-202165515B 
*/
package Model;

import Util.Arquivo;
import Util.JSONItens;
import java.io.FileNotFoundException;
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
    
    static
    {
        try {
            String lerArquivo = Arquivo.lerArquivo("estoqueMercadoria.txt");
            estoqueMercadoria = JSONItens.toEstoqueMercadoria(lerArquivo);
            //System.out.println(lerArquivo);

        } catch (FileNotFoundException ex) {
            System.out.println("Pasta nao encontrada!");
        }
        
    }
    
    public static List getEstoqueMercadoria()
    {
        return estoqueMercadoria;
    }
     
    static void adicionaProdutoAoEstoque()
    {
        Item produto = new Item();
        
        estoqueMercadoria.add(produto);
    }
    
    public static void adicionaProdutoAoEstoque(Item produto)
    {
        estoqueMercadoria.add(produto);
    }
       
    public static boolean verificaProdInicializado(String nome)
    {
        for(Item prod : estoqueMercadoria)
        {
            if(prod.getNomeItem().equalsIgnoreCase(nome))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public static int retornaIndexNome(String nome)
    {
        Scanner teclado = new Scanner(System.in);
        int i;
        
        
        for(i=0; i<estoqueMercadoria.size(); i++)
        {
            if(estoqueMercadoria.get(i).getNomeItem().equalsIgnoreCase(nome))
            {
                return i;
            }
        }
        if(i==estoqueMercadoria.size())
        {
            nome = JOptionPane.showInputDialog(null, "Item não localizado no estoque. Insira outro nome: ");
            {
                retornaIndexNome(nome);
            }
        }
        
        return i;
    }
     
    
    public static List imprimeEstoque()
    {
        List<String> listaEstoque = new ArrayList<>();
        for(Item prod : estoqueMercadoria)
        {
            listaEstoque.add(prod.toString());
        }
        return listaEstoque;
    }
    
    public static List imprimeNomeDosProdutos()
    {
        List<String> listaEstoque = new ArrayList<>();
        for(Item prod : estoqueMercadoria)
        {
            listaEstoque.add(prod.getNomeItem());
        }
        return listaEstoque;
    }
        
    public static void realizaVenda(Item item,int qntd,Vendedor vendedor)
    {
        vendedor.computaVenda(item,qntd);
    }
    
    public static void removeItem(int index)
    {
        estoqueMercadoria.remove(index);
    }
    
    public static Item retornaItemIndex(int index)
    {
        return estoqueMercadoria.get(index);
    }
}