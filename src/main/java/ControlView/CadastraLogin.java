/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlView;

import View.*;
import Control.*;
import ControlView.*;
import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Gabriel Mattos
 */
public class CadastraLogin implements ActionListener
{
    TelaCadastro tela;

    public CadastraLogin(TelaCadastro tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
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
            DadosUsuario.ordenaDadosLoginAlfabetico();
            DadosUsuario.ordenaDadosLoginNivel();
            tela.setVisible(false);
            new TelaAdm();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Usuario ja cadastrado");
            tela.setVisible(false);
            new TelaAdm();
            
            
        }
    }
}
