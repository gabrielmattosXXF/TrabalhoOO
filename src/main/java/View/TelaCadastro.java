/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Control.CadastraLogin;
import Control.RetornaInicio;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Gabriel Mattos
 */
public class TelaCadastro extends JFrame implements Tela
{
    JTextField nome;
    JTextField login;
    JPasswordField senha;
    JComboBox nivel;
    
    public TelaCadastro()
    {
        String[] funcionarios = {"Administrador", "Técnico", "Vendedor"};
        this.nome = new JTextField(50);
        this.login = new JTextField(50);
        this.senha = new JPasswordField(50);
        this.nivel = new JComboBox<>(funcionarios);
        
        this.setLayout(new BorderLayout());
        this.add(painelCaixaTexto(), BorderLayout.CENTER);
        this.add(painelBotoes(), BorderLayout.SOUTH);
        
        this.setSize(350, 250);//redimensionar tela
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    private JPanel painelCaixaTexto(){

        JPanel caixaTexto = new JPanel();
        caixaTexto.setLayout(new GridLayout(0, 2));
        caixaTexto.add(new JLabel("Nome:"));
        caixaTexto.add(this.nome);
        caixaTexto.add(new JLabel("Login:"));
        caixaTexto.add(this.login);
        caixaTexto.add(new JLabel("Senha:"));
        caixaTexto.add(this.senha);
        caixaTexto.add(new JLabel("Nivel de acesso:"));
        caixaTexto.add(this.nivel);
        
        return caixaTexto;
    }
    
    private JPanel painelBotoes(){

        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(0, 2));
        JButton btConfirmar = new JButton("Confirmar");
        btConfirmar.addActionListener(new CadastraLogin(this)); 
        botoes.add(btConfirmar);
        
        JButton btCancelar = new JButton("Cancelar");
        btCancelar.addActionListener(new RetornaInicio(this));//fazer retornar para a tela do administrador
        botoes.add(btCancelar);
        
        return botoes;
    }
    
    
    public JTextField getNome() {
        return nome;
    }

    public void setNome(JTextField nome) {
        this.nome = nome;
    }

    public JTextField getLogin() {
        return login;
    }

    public void setLogin(JTextField login) {
        this.login = login;
    }

    public JPasswordField getSenha() {
        return senha;
    }

    public void setSenha(JPasswordField senha) {
        this.senha = senha;
    }
    
    public String getNivel() {
        
        //nivel.getItemAt(nivel.getSelectedIndex());
        return nivel.getItemAt(nivel.getSelectedIndex()).toString();
    }

    public void setNivel(JComboBox nivel) {
        this.nivel = nivel;
    }
}
