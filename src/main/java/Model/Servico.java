/*
Augusto de Fillippo Cavalini-202165514B 

Gabriel Mattos-202165503B 

Luiz Gustavo Ferreira Nazareth-202165515B 
*/
package Model;

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
    
    private boolean feito, semManutencao;


    
    public Servico(String nomeCliente, int telefoneCliente, String dataChegada, String dataSaida, String marca, String modelo, int serial, String observacaoVendedor)throws Exception 
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
        this.feito=false;
        this.semManutencao=false;
    }
    
    public boolean isFeito() {
        return feito;
    }

    public void setFeito(boolean feito) {
        this.feito = feito;
    }

    public boolean isSemManutencao() {
        return semManutencao;
    }

    public void setSemManutencao(boolean semManutencao) {
        this.semManutencao = semManutencao;
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
    
    @Override
    public String toString()
    {
        if(this.isFeito())
        {
            return "FEITO\n"
                    + "\nNome: "+getNomeCliente()
                    + "\nTelefone: "+getTelefoneCliente()
                    + "\nData chegada: "+getDataChegada()
                    + "\nData Saida: "+getDataSaida()
                    + "\nMarca: "+getMarca()
                    + "\nModelo: "+getModelo()
                    + "\nSerial: "+getSerial()
                    + "\nDefeito: "+getDefeito()
                    + "\nReparo: "+getReparo()
                    + "\nObservação: "+getObservacao()
                    + "\nPreço: "+getPreco();
        }
            else if(this.isSemManutencao())
        {
                return "SEM CONSERTO\n"
                    + "\nNome: "+getNomeCliente()
                    + "\nTelefone: "+getTelefoneCliente()
                    + "\nData chegada: "+getDataChegada()
                    + "\nData Saida: "+getDataSaida()
                    + "\nMarca: "+getMarca()
                    + "\nModelo: "+getModelo()
                    + "\nSerial: "+getSerial();
        }
        
        return "EM ANÁLISE\n"
                    + "\nNome: "+getNomeCliente()
                    + "\nTelefone: "+getTelefoneCliente()
                    + "\nData chegada: "+getDataChegada()
                    + "\nData Saida: "+getDataSaida()
                    + "\nMarca: "+getMarca()
                    + "\nModelo: "+getModelo()
                    + "\nSerial: "+getSerial()
                    + "\nObservação: "+getObservacaoVendedor();
    }
}
