/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import ControlView.*;

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
        //o package control serve para fazer o redirecionamento das telas do view. dependendo do botão clicado, é o control que redireciona ele a uma tela específica
        //essas classes de controle inplementam a interface implements ActionListener que faz aparecer a tela

        //adicionar um título â essa tela acima dos botões de entrada
        super("Tela inicial");

        this.setLayout(new BorderLayout());
        this.add(painelDeBotoes(), BorderLayout.CENTER);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private JPanel painelDeBotoes()
    {
        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(2, 0));
        
        JButton btLogin = new JButton("Login");
        btLogin.addActionListener(new OpcaoLogin(this)); //addActionListener adiciona um comando ao click do botão
        //vai implementar uma classe no control que recebe esse comando. Essa classe chama dentro dela a tela login, implementando a interface ActionListener
        botoes.add(btLogin);
        
        JButton btCadastro = new JButton("Cadastro");
        btCadastro.addActionListener(new DirecionaTelaCadastro(this)); //mesma coisa que na tela de login
        botoes.add(btCadastro);
        return botoes;
    }
    
    /*
    
    */
    public static void main(String[] args)
    {
        TelaInicial telaInicial = new TelaInicial();
    }
}
