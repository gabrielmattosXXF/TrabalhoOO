/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlView;
import View.*;
import Model.*;
import Control.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel Mattos
 */
public class ConfirmaLogin implements ActionListener
{
    private JTextField login;
    private JPasswordField senha;
    TelaLogin tela;
    Usuario usuario;

    public ConfirmaLogin(TelaLogin tela, JTextField login, JPasswordField senha) {
        this.login = login;
        this.senha = senha;
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //new TelaInicial(); //faz redirecionar à tela inicial
        
        //implementação das funções de confirmação de login
        if(DadosUsuario.validaLogin(login.getText(), senha.getText()))
        {
            usuario = DadosUsuario.retornaUsuario(login.getText(), senha.getText());
            
            if(usuario.getNivelDeAcesso().equals("Administrador"))
            {
                this.tela.setVisible(false);
                new TelaAdm();
            }
            else if(usuario.getNivelDeAcesso().equals("Vendedor"))
            {
                this.tela.setVisible(false);
                new TelaVendedor((Vendedor)usuario);//gambiarra?
            }
            else if(usuario.getNivelDeAcesso().equals("Tecnico"))
            {
                this.tela.setVisible(false);
                new TelaAdm(); //NÃO SEI PQ CARALHOS ESSA MERDA NAO FUNCIONA
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Login Inválido");
            //fazer implementação que retorna a tela de incio
            tela.setVisible(false);
            new TelaInicial();
        }
        
        tela.setVisible(false);

    }
}
