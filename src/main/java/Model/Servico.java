/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.*;
import Model.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ice
 */
public class Servico
{
    private static int numServicoS=0;
    private int numServico;
    
    private String nomeCliente;
    private String telefoneCliente;
    private String dataChegada;
    private String dataSaida;
    private String marca;
    private String modelo;
    private String serial;
    private String observacaoVendedor;
    
    private String defeito;
    private String reparo;
    private String observacao;
    private Double preco;
    
    public Servico(String nomeCliente, int telefoneCliente, String dataChegada, String dataSaida, String marca, String modelo, int serial, String observacaoVendedor)
    {
        numServicoS++;
        this.numServico=numServicoS;
        
        this.nomeCliente=nomeCliente;
        
        Integer tel = telefoneCliente;
        this.telefoneCliente=tel.toString();
        this.telefoneCliente=this.telefoneCliente.charAt(0)+" "+this.telefoneCliente.substring(1, 5)+"-"+this.telefoneCliente.substring(5);

        this.dataChegada=dataChegada;
        this.dataSaida=dataSaida;

        this.marca=marca;
        this.modelo=modelo;
        Integer ser = serial;
        this.serial=ser.toString();
        
        this.observacaoVendedor=observacaoVendedor;
        
        this.defeito=" ";
        this.reparo=" ";
        this.observacao=" ";
        this.preco=0.0;
    }

    public int getNumServico() {
        return numServico;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public String getDataChegada() {
        return dataChegada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getSerial() {
        return serial;
    }

    public String getObservacaoVendedor() {
        return observacaoVendedor;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getReparo() {
        return reparo;
    }

    public void setReparo(String reparo) {
        this.reparo = reparo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
