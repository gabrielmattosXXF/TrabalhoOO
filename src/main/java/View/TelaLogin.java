/*
Augusto de Fillippo Cavalini-202165514B 

Gabriel Mattos-202165503B 

Luiz Gustavo Ferreira Nazareth-202165515B 
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
    JTextField login;
    JPasswordField senha;
    
    public TelaLogin(){

        this.login = new JTextField(50);
        this.senha = new JPasswordField(50);
        this.setLayout(new BorderLayout());
        
        this.add(painelDeTexto(), BorderLayout.CENTER);
        
        this.add(painelDeBotoes(), BorderLayout.SOUTH);
        
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
