/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;
import Model.Tecnico;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Mattos
 */
public class JSONTecnico
{
    public static String toJSON(Tecnico tecnico) {
        Gson gson = new Gson();
        String json = gson.toJson(tecnico);
        return json;
    }

    public static String toJSON(List<Tecnico> dadosTecnico) {
        Gson gson = new Gson();
        String json = gson.toJson(dadosTecnico);
        return json;
    }

    public static Tecnico toTecnico(String conteudo) {
        Gson gson = new Gson();
        Tecnico tecnico = gson.fromJson(conteudo, Tecnico.class);

        return tecnico;
    }

    public static List<Tecnico> toDadosTecnico(String conteudo) {
        Gson gson = new Gson();
        Type tecnicoTipo = new TypeToken<ArrayList<Tecnico>>() {
        }.getType();
        List<Tecnico> dadosTecnico = gson.fromJson(conteudo, tecnicoTipo);

        return dadosTecnico;
    }
}
