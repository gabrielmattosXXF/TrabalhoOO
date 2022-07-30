/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Control.ConfirmaLogin;
import Control.EventoJanela;

import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Gabriel Mattos
 */
public class TelaLogin extends JFrame implements Tela
{
    //chega nessa classe através da classe no control que direciona à essa
    
    JTextField login;//quando escrito ele aparece a String
    JPasswordField senha;//quando escrito a String aparece no formato ******
    
    public TelaLogin(){

        this.login = new JTextField(50);
        this.senha = new JPasswordField(50);
        this.setLayout(new BorderLayout());
        
        this.add(painelDeTexto(), BorderLayout.CENTER);//coloca o painel de texto ao centro 
        
        this.add(painelDeBotoes(), BorderLayout.SOUTH);//coloca o painel de botoes na parte de baixo da tela
        
        this.setSize(300, 200);
        this.setVisible(true);
        
        this.addWindowListener(new EventoJanela(this));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
    }

    private JPanel painelDeTexto(){

        JPanel caixaTexto = new JPanel();
        caixaTexto.setLayout(new GridLayout(0, 2));
        caixaTexto.add(new JLabel("Login:"));
        caixaTexto.add(this.login);
        caixaTexto.add(new JLabel("Senha:"));
        caixaTexto.add(this.senha);
        return caixaTexto;
    }
    
    private JPanel painelDeBotoes(){

        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(0, 2));
        
        JButton btConfirmar = new JButton("Confirmar");
        btConfirmar.addActionListener(new ConfirmaLogin(this, this.login, this.senha));
        botoes.add(btConfirmar);
        
        JButton btCancelar = new JButton("Cancelar");
        btCancelar.addActionListener(e->{
            this.setVisible(false);
            new TelaInicial(); 
        });
        botoes.add(btCancelar);
        return botoes;
    }
    
    public JTextField getLogin() {
        return login;
    }

    public JPasswordField getSenha() {
        return senha;
    }
}
