/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Model.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Mattos
 */
public class JSONLogins
{
    public static String toJSON(Usuario usuario) {
        Gson gson = new Gson();
        String json = gson.toJson(usuario);
        return json;
    }

    public static String toJSON(List<Usuario> dadosLogin) {
        Gson gson = new Gson();
        String json = gson.toJson(dadosLogin);
        return json;
    }

    public static Usuario toUsuario(String conteudo) {
        Gson gson = new Gson();
        Usuario usuario = gson.fromJson(conteudo, Usuario.class);

        return usuario;
    }

    public static List<Usuario> toDadosLogin(String conteudo) {
        Gson gson = new Gson();
        Type usuarioTipo = new TypeToken<ArrayList<Usuario>>() {
        }.getType();
        List<Usuario> dadosLogin = gson.fromJson(conteudo, usuarioTipo);

        return dadosLogin;
    }
}
