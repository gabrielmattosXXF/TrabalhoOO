/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Model.Item;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
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