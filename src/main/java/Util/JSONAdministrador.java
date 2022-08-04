/*
Augusto de Fillippo Cavalini-202165514B 

Gabriel Mattos-202165503B 

Luiz Gustavo Ferreira Nazareth-202165515B 
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
