/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import View.*;
import Model.*;

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
                Vendedor vendedor = (Vendedor)usuario;
                new TelaVendedor(vendedor);
            }
            else if(usuario.getNivelDeAcesso().equals("Tecnico"))
            {
                this.tela.setVisible(false);
                new TelaTecnico();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Login Inválido. Tente novamente.");
            tela.setVisible(false);
            new TelaLogin();
        }
        
        tela.setVisible(false);

    }
}
