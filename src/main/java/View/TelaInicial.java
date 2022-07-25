/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private JPanel painelDeBotoes()
    {
        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(0,2));
        
        JButton btLogin = new JButton("Login");
        //btLogin.addActionListener(new OpcaoLogin(this)); //addActionListener adiciona um comando ao click do botão
        btLogin.addActionListener(a->{
            this.setVisible(false);//faz a tela ficar oculta após o comando acontecer
            new TelaLogin();
        });
        botoes.add(btLogin);
        
        JButton btSair = new JButton("Sair");
        btSair.addActionListener(a->{
            System.exit(0);
        }); //mesma coisa que na tela de login
        botoes.add(btSair);
        return botoes;
    }
    
    /*
    
    */
    public static void main(String[] args)
    {
        TelaInicial telaInicial = new TelaInicial();
    }
}
