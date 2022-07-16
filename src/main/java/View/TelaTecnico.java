/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Control.*;
import ControlView.*;
import Model.*;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Gabriel Mattos
 */
public class TelaTecnico extends JFrame implements Tela
{
    JPanel painelTxt;
    
    public TelaTecnico()
    {
        super("Tela Técnico");

        //this.setLayout(new BorderLayout());
        this.setLayout(new GridLayout(0, 2));
        //this.add(painelDeBotoes(), BorderLayout.WEST);
        this.add(painelDeBotoes());

        this.painelTxt= new JPanel();
                
        painelTxt.add(painelDeTexto());
        
        //this.add(painelTxt, BorderLayout.EAST);
        this.add(painelTxt);

        this.setSize(500, 500);
        this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    public JPanel getPainelTxt()
    {
        return this.painelTxt;
    }
    
    private JPanel painelDeTexto()
    {
        JPanel caixaTexto = new JPanel();
        caixaTexto.add(new JLabel("Bem vindo à tela do técnico!"));
        return caixaTexto;
    }
    
    private JPanel painelDeBotoes()
    {

        //Vai ser implementado igual a tela de administração de itens
        //o técnico vai selecionar a ordem de serviço pela JList e vai abrir uma tela por ela, podendo alterar os dados lá dentro
        
        JPanel botoes = new JPanel();
        //botoes.setSize(500, 250);
        botoes.setLayout(new GridLayout(4, 0));
        
        return botoes;
    }
}
