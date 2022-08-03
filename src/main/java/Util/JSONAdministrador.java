/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Model.Administrador;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Mattos
 */
public class JSONAdministrador
{
    public static String toJSON(Administrador administrador) {
        Gson gson = new Gson();
        String json = gson.toJson(administrador);
        return json;
    }

    public static String toJSON(List<Administrador> dadosAdministrador) {
        Gson gson = new Gson();
        String json = gson.toJson(dadosAdministrador);
        return json;
    }

    public static Administrador toAdministrador(String conteudo) {
        Gson gson = new Gson();
        Administrador administrador = gson.fromJson(conteudo, Administrador.class);

        return administrador;
    }

    public static List<Administrador> toDadosAdministrador(String conteudo) {
        Gson gson = new Gson();
        Type administradorTipo = new TypeToken<ArrayList<Administrador>>() {
        }.getType();
        List<Administrador> dadosAdministrador = gson.fromJson(conteudo, administradorTipo);

        return dadosAdministrador;
    }
}
