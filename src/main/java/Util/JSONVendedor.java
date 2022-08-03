/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Model.Vendedor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Mattos
 */
public class JSONVendedor
{
    public static String toJSON(Vendedor vendedor) {
        Gson gson = new Gson();
        String json = gson.toJson(vendedor);
        return json;
    }

    public static String toJSON(List<Vendedor> dadosVendedor) {
        Gson gson = new Gson();
        String json = gson.toJson(dadosVendedor);
        return json;
    }

    public static Vendedor toVendedor(String conteudo) {
        Gson gson = new Gson();
        Vendedor vendedor = gson.fromJson(conteudo, Vendedor.class);

        return vendedor;
    }

    public static List<Vendedor> toDadosVendedor(String conteudo) {
        Gson gson = new Gson();
        Type vendedorTipo = new TypeToken<ArrayList<Vendedor>>() {
        }.getType();
        List<Vendedor> dadosVendedor = gson.fromJson(conteudo, vendedorTipo);

        return dadosVendedor;
    }
}
