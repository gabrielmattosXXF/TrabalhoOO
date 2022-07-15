/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlView;

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
        String telefoneCliente = tela.getNomeClienteP().getText();
        String dataChegada = tela.getDataChegadaP().getText();
        String dataSaida = tela.getDataSaidaP().getText();
        boolean autorizacao = true;
        
        DadosServico.adicionaServico(new Servico(nomeCliente, telefoneCliente, dataChegada, dataSaida, autorizacao));
        
        
        /*
        if(!DadosUsuario.validaLogin(tela.getLogin().getText(), tela.getSenha().getText()))
        {
            if(tela.getNivel().getText().equalsIgnoreCase("Administrador"))
            {
                DadosUsuario.adicionaLogin(new Administrador(tela.getNome().getText(), tela.getLogin().getText(), tela.getSenha().getText()));
            }
            else if(tela.getNivel().getText().equalsIgnoreCase("Vendedor"))
            {
                DadosUsuario.adicionaLogin(new Vendedor(tela.getNome().getText(), tela.getLogin().getText(), tela.getSenha().getText()));
            }
            else if(tela.getNivel().getText().equalsIgnoreCase("Tecnico"))
            {
                DadosUsuario.adicionaLogin(new Tecnico(tela.getNome().getText(), tela.getLogin().getText(), tela.getSenha().getText()));
            }
            //está estabelecido que o usuário digitou o nivel de acesso corretamente
            //fazer um tratamento de excessão aq
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
            //new TelaAdministrador();
            //levar até uma tela e fechar essa tela atual
            //new TelaAdm();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Usuario ja cadastrado");
            new TelaAdm();
            tela.setVisible(false);
            
        }
        */
        
    }
}