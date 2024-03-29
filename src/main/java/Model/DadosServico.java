/*
Augusto de Fillippo Cavalini-202165514B 

Gabriel Mattos-202165503B 

Luiz Gustavo Ferreira Nazareth-202165515B 
*/
package Model;
import Util.Arquivo;
import Util.JSONServicos;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author ice
 */
public class DadosServico
{
    private static List<Servico> dadosServico = new ArrayList<>();
    
    static
    {
        try {
            String lerArquivo = Arquivo.lerArquivo("dadosServico.txt");
            dadosServico = JSONServicos.toDadosServico(lerArquivo);

        } catch (FileNotFoundException ex) {
            System.out.println("Pasta nao encontrada!");
        }
        
    }
    
    public static List getDadosServico()
    {
        return dadosServico;
    }
    
    public static void adicionaServico(Servico serv) throws Exception
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
