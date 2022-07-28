/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ice
 */
public class CriarServico implements ActionListener
{
    TelaServico tela;

    public CriarServico(TelaServico tela)
    {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String nomeCliente = tela.getNomeClienteP().getText();
        String telefoneCliente = tela.getNomeClienteP().getText();//é numero
        String dataChegada = tela.getDataChegadaP().getText();//é numero
        String dataSaida = tela.getDataSaidaP().getText();//é numero
        String marca = tela.getMarcaP().getText();
        String modelo = tela.getModeloP().getText();
        String serial = tela.getSerialP().getText();//é numero
        String observacaoVendedor = tela.getObservacaoVendedorP().getText();
        
        DadosServico.adicionaServico(new Servico(nomeCliente, telefoneCliente, dataChegada, dataSaida, marca, modelo, serial, observacaoVendedor));
        
        
    }
}