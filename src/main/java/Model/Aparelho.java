/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Derlucio Nazareth
 */
public class Aparelho {
    
    private String marca;
    private String modelo;
    private int serial;
    private String defeito="";
    private String reparo="";
    private String observacao="";
    
    public Aparelho(String marca, String modelo, int serial)
    {        
        this.marca=marca;
        this.modelo=modelo;
        this.serial=serial;
    }
    
    public String getMarca()
    {
        return marca;
    }
    
    public void setMarca(String newMarca)
    {
        marca=newMarca;
    }
    
    public String getModelo()
    {
        return modelo;
    }
    
    public void setModelo(String newModelo)
    {
        modelo=newModelo;
    }
    
    public int getSerial()
    {
        return serial;
    }
    
    public void setSerial(int newSerial)
    {
        serial=newSerial;
    }
    
    public String getDefeito()
    {
        return defeito;
    }
    
    public void setDefeito(String newDefeito)
    {
        defeito=newDefeito;
    }
    
    public String getReparo()
    {
        return reparo;
    }
    
    public void setReparo(String newReparo)
    {
        defeito=newReparo;
    }
    
    public String getObservacao()
    {
        return observacao;
    }
    
    public void setObservacao(String newObservacao)
    {
        defeito=newObservacao;
    }
}
