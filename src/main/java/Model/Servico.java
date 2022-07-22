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
    private static int numServicoS=0;
    
    private int numServico=0;
    
    private String nomeCliente;
    private String telefoneCliente;
    
    //private String dataChegada;//criar tipo Data
    private Date dataChegada;//criar tipo Data
    private Date dataSaida;//criar tipo Data
    
    private Aparelho aparelho;
    
    private Double preco=0.0;
    
    //private boolean autorizacao;
    
    public Servico(String nomeCliente, String telefoneCliente, Date dataChegada, Date dataSaida,  Aparelho aparelho)
    {
        this.numServicoS++;
        this.numServico=numServicoS;
        
        this.nomeCliente=nomeCliente;
        this.telefoneCliente=telefoneCliente;

        this.dataChegada=dataChegada;
        this.dataSaida=dataSaida;

        this.aparelho=aparelho;

        
    }
    
    public int getNumServico()
    {
        return numServico;
    }
    
    public void setNumServico(int novoS)
    {
        numServico=novoS;
    }
    
    public String getNomeServico()
    {
        return nomeCliente;
    }
    
    public void setNomeServico(String novoNome)
    {
        nomeCliente = novoNome;
    }
    public String getTelefoneServico()
    {
        return telefoneCliente;
    }
    
    public void setTelefoneServico(String novoTel)
    {
        telefoneCliente = novoTel;
    }
    public Date getDataChegada()
    {
        return dataChegada;
    }
    
    public void setDataChegada(Date novaDataC)
    {
        dataChegada = novaDataC;
    }
    
    public Date getDataSaida()
    {
        return dataSaida;
    }
    
    public void setDataSaida(Date novaDataS)
    {
        dataSaida = novaDataS;
    }    
    
    public Aparelho getAparelho()
    {
        return aparelho;
    }
    
    public Double getPreco()
    {
        return preco;
    }
    
    public void setPreco(Double novoPreco)
    {
        this.preco=novoPreco;
    }
}
