/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import View.*;
import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        if(!DadosUsuario.verificaLoginInicializado(tela.getLogin().getText()))
        {
            if(tela.getNivel().equalsIgnoreCase("Administrador"))
            {
                DadosUsuario.adicionaLogin(new Administrador(tela.getNome().getText(), tela.getLogin().getText(), tela.getSenha().getText()));
            }
            else if(tela.getNivel().equalsIgnoreCase("Vendedor"))
            {
                DadosUsuario.adicionaLogin(new Vendedor(tela.getNome().getText(), tela.getLogin().getText(), tela.getSenha().getText()));
            }
            else if(tela.getNivel().equalsIgnoreCase("Tecnico"))
            {
                DadosUsuario.adicionaLogin(new Tecnico(tela.getNome().getText(), tela.getLogin().getText(), tela.getSenha().getText()));
            }
            
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
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
