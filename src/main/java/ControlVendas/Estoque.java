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
    
    static Map<Item, Integer> estoqueMercadoria = new HashMap<>();
    //caso a classe item não contenha o preço do produto, cria-se:
    //
    //static Map<Item, Double> precoMercadoria = new HashMap<>();
    //
    //static Set<Item> estoque = new HashSet<>();
     
    public static void adicionaAoEstoque(Item produto, int quantidade)
    {
         estoqueMercadoria.put(produto, estoqueMercadoria.getOrDefault(produto, 0)+quantidade);
       //estoqueMercadoria.put(produto, estoqueMercadoria.getOrDefault(produto, 0)+1);
    }
     
    public static boolean verificaDisponiblidade(Item produto)
    {
        if(estoqueMercadoria.get(produto)>0)
        {
            //System.out.printf("há %d unidades disponíveis!", estoqueMercadoria.get(produto));
            return true;
         }
         else 
            return false;
     }
     
    public static void removeDoEstoque(Item produto, int quantidade)
    {
        estoqueMercadoria.put(produto, estoqueMercadoria.getOrDefault(produto, 0)-quantidade);
    }
     
     
}
