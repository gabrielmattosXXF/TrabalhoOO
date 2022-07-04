/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Control.Estoque;
import ControlView.*;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Gabriel Mattos
 */
public class TelaAdm extends JFrame implements Tela
{
    /*
    essa tela tem que ter uma implementação diferente, pois a ação de um botão não pode levar a uma nova tela sempre
    */
    
    JPanel painelTxt;
    JPanel painBt;
    
    public TelaAdm()
    {
        super("Tela Administrador");
        
        this.setLayout(new BorderLayout());
        this.add(painelDeBotoes(), BorderLayout.WEST);
        
        this.painelTxt=painelDeTexto();
        this.add(painelTxt, BorderLayout.EAST);
        
        this.painelTxt=painelDeTexto();
        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    public JPanel getPainelTxt()
    {
        return this.painelTxt;
    }
    
    private JPanel painelDeTexto()
    {

        JPanel caixaTexto = new JPanel();
        caixaTexto.add(new JLabel("Bem vindo à tela do administrador!"));
        return caixaTexto;
    }
    
    private JPanel painelDeBotoes()
    {

        //"Adiciona ao estoque", "Imprime estoque", "Administrar produto","Administrar funcionários", "Cancelar"};
        
        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(4, 0));
        
        JButton btImprimeEstoque = new JButton("Imprime estoque");
        btImprimeEstoque.addActionListener(new ImprimeEstoque(this));
        botoes.add(btImprimeEstoque);
        
        JButton btAdministrarProduto = new JButton("Administrar produto");
        //btConfirmar.addActionListener(new ConfirmaLogin(this, this.login, this.senha));
        botoes.add(btAdministrarProduto);
        
        JButton btAdministrarFuncionarios = new JButton("Administrar funcionários");//caso queira fazer a possibilidade de remover usuário, criar uma outra classe no control view que leve a uma tela de remoção de usuário
        btAdministrarFuncionarios.addActionListener(new DirecionaTelaCadastro(this));
        botoes.add(btAdministrarFuncionarios);
        
        JButton btCancelar = new JButton("Cancelar");
        btCancelar.addActionListener(new RetornaInicio(this));
        botoes.add(btCancelar);
        return botoes;
    }
    
    
}
