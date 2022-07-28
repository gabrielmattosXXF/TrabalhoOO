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
    
    /*private String nomeCliente;
    private String telefoneCliente;
    
    private String dataChegada;//criar tipo Data
    private Date dataChegada;//criar tipo Data
    private Date dataSaida;//criar tipo Data
    
    private Aparelho aparelho;
    
    private Double preco=0.0;
    
    private boolean autorizacao;*/
    
    String nomeCliente;
    String telefoneCliente;
    String dataChegada;
    String dataSaida;
    String marca;
    String modelo;
    String serial;
    String observacaoVendedor;
    
    String defeito;
    String reparo;
    String observacao;
    String preco;
    
    public Servico(String nomeCliente, String telefoneCliente, String dataChegada, String dataSaida, String marca, String modelo, String serial, String observacaoVendedor)
    {
        numServicoS++;
        this.numServico=numServicoS;
        
        this.nomeCliente=nomeCliente;
        this.telefoneCliente=telefoneCliente;

        this.dataChegada=dataChegada;
        this.dataSaida=dataSaida;

        this.marca=marca;
        this.modelo=modelo;
        this.serial=serial;
        
        this.observacaoVendedor=observacaoVendedor;
        
        this.defeito=" ";
        this.reparo=" ";
        this.observacao=" ";
        this.preco=" ";
    }

    public int getNumServico() {
        return numServico;
    }

    public void setNumServico(int numServico) {
        this.numServico = numServico;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(String dataChegada) {
        this.dataChegada = dataChegada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getObservacaoVendedor() {
        return observacaoVendedor;
    }

    public void setObservacaoVendedor(String observacaoVendedor) {
        this.observacaoVendedor = observacaoVendedor;
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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
