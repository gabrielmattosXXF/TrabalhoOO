/*
Augusto de Fillippo Cavalini-202165514B 

Gabriel Mattos-202165503B 

Luiz Gustavo Ferreira Nazareth-202165515B 
*/
package Util;

import Model.Item;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gabriel Mattos
 */
public class JSONItens
{
    public static String toJSON(Item item) {
        Gson gson = new Gson();
        String json = gson.toJson(item);
        return json;
    }

    public static String toJSON(List<Item> estoqueMercadoria) {
        Gson gson = new Gson();
        String json = gson.toJson(estoqueMercadoria);
        System.out.println(json);
        return json;
    }

    public static Item toItem(String conteudo) {
        Gson gson = new Gson();
        Item item = gson.fromJson(conteudo, Item.class);

        return item;
    }

    public static List<Item> toEstoqueMercadoria(String conteudo) {
        Gson gson = new Gson();
        Type itemTipo = new TypeToken<ArrayList<Item>>() {
        }.getType();
        List<Item>  estoqueMercadoria= gson.fromJson(conteudo, itemTipo);
        
        return estoqueMercadoria;
    }
}
