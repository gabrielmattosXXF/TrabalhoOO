/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Model.Servico;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Mattos
 */
public class JSONServicos
{
    public static String toJSON(Servico servico) {
        Gson gson = new Gson();
        String json = gson.toJson(servico);
        return json;
    }

    public static String toJSON(List<Servico> dadosServico) {
        Gson gson = new Gson();
        String json = gson.toJson(dadosServico);
        return json;
    }

    public static Servico toServico(String conteudo) {
        Gson gson = new Gson();
        Servico servico = gson.fromJson(conteudo, Servico.class);

        return servico;
    }

    public static List<Servico> toDadosServico(String conteudo) {
        Gson gson = new Gson();
        Type servicoTipo = new TypeToken<ArrayList<Servico>>() {
        }.getType();
        List<Servico> dadosServico = gson.fromJson(conteudo, servicoTipo);

        return dadosServico;
    }
}
