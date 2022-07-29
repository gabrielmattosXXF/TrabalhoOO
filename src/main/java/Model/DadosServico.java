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
    
    public static Servico retornaServicoIndex(int index)
    {
        return dadosServico.get(index);
    }
    
    public static List imprimeServico()
    {
        List <String> listaServico = new ArrayList<>();
        
        for(Servico serv : dadosServico)
            {
                listaServico.add("OS: "+serv.getNumServico()+". Cliente "+serv.getNomeCliente());
            }  
        
        return listaServico;
    }
    
    public static int NumeroDeServicos()
    {
        return dadosServico.size();
    }
    
    public static double totalPrecoServico()
    {
        double valor=0;
        
        for(Servico serv : dadosServico)
        {
            if(serv.isFeito())
            {
                valor+=serv.getPreco();
            }
        }
        
        return valor;
    }
    
}
