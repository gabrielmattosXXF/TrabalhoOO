/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.*;

/**
 *
 * @author ice
 */
public class DadosServico
{
    private static List<Servico> dadosServico = new ArrayList<>();
    
    public static void adicionaServico(Servico serv)
    {
        dadosServico.add(serv);
    }
    
}
