/*
Augusto de Fillippo Cavalini-202165514B 

Gabriel Mattos-202165503B 

Luiz Gustavo Ferreira Nazareth-202165515B 
*/
package View;

import Control.EventoJanela;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Gabriel Mattos
 */
public class TelaInicial extends JFrame implements Tela
{
    public TelaInicial()
    {
        super("Tela inicial");

        this.setLayout(new BorderLayout());
        this.setLayout(new GridLayout(2,0));
        this.add(new JLabel("Bem vindo à tela inicial!"));
        this.add(painelDeBotoes());
        this.setSize(300, 200);
        this.setVisible(true);
        
        this.addWindowListener(new EventoJanela(this));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLocationRelativeTo(null);
    }

    private JPanel painelDeBotoes()
    {
        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(0,2));
        
        JButton btLogin = new JButton("Login");
        btLogin.addActionListener(a->{
            this.setVisible(false);
            new TelaLogin();
        });
        botoes.add(btLogin);
        
        JButton btSair = new JButton("Sair");
        btSair.addActionListener(a->{
            
            new EventoJanela(this).windowClosing();
            System.exit(0);
        });
        botoes.add(btSair);
        return botoes;
    }
    
    public static void main(String[] args)
    {
        TelaInicial telaInicial = new TelaInicial();
    }
}
