/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.*;
import Model.*;

/**
 *
 * @author ice
 */
public class Servico
{
    static int numServicoS=0;
    
    private int numServico=0;
    
    private String nomeCliente;
    private String telefoneCliente;
    
    private String dataChegada;//criar tipo Data
    private String dataSaida;//criar tipo Data
    
    //Aparelho aparelho;
    
    private boolean autorizacao;
    
    public Servico(String nomeCliente, String telefoneCliente, String dataChegada, String dataSaida, boolean autorizacao)
    {
        this.numServicoS++;
        this.numServico=numServicoS;
        
        this.nomeCliente=nomeCliente;
        this.telefoneCliente=telefoneCliente;

        this.dataChegada=dataChegada;
        this.dataSaida=dataSaida;

        //this.aparelho=new Aparelho();

        this.autorizacao=autorizacao;
        
    }
}
