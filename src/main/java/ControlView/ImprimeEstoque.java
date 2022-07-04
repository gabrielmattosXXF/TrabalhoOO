/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlView;
import View.*;
import Control.*;
import ControlView.*;
import Model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Gabriel Mattos
 */
public class ImprimeEstoque implements ActionListener
{
    TelaAdm tela;
    
    public ImprimeEstoque(TelaAdm tela)
    {
        //tela.setVisible(false);
        tela.setVisible(true);
        this.tela=tela;
    }
    
    private JPanel painelDeTexto(){

        JPanel caixaTexto = new JPanel();
        caixaTexto.add(new JLabel(Estoque.imprimeEstoqueS()));
        return caixaTexto;
    }

    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        

        //this.tela.remove(this.tela.painelDeTexto());
        this.tela.getPainelTxt().removeAll();
        this.tela.getPainelTxt().add(painelDeTexto(), BorderLayout.EAST);
        this.tela.getPainelTxt().revalidate();
        this.tela.getPainelTxt().repaint();
        this.tela.pack();
        
        //this.tela.validate();
        //this.tela.setVisible(false);
        
        
        //this.tela.add(painelDeTexto(), BorderLayout.EAST);
        //this.tela.setVisible(false);
        
        /*JPanel newPainel = this.tela.getPainelTxt();
        newPainel.removeAll();
        this.tela.add(newPainel, BorderLayout.EAST);
        newPainel=this.painelDeTexto();
        this.tela.validate();
        this.tela.add(newPainel, BorderLayout.EAST);*/
        
        //newTela.setVisible(true);
        
        
        /*
        JFrame telaEstoque = new JFrame("Estoque");
        
        telaEstoque.setLayout(new BorderLayout());
        //telaEstoque.add(painelDeBotoes(), BorderLayout.WEST);
        
        telaEstoque.add(this.painelDeTexto(), BorderLayout.CENTER);
        
        //telaEstoque.painelTxt=painelDeTexto();
        telaEstoque.setSize(400, 400);
        telaEstoque.setVisible(true);
        //telaEstoque.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaEstoque.setLocationRelativeTo(null);
*/
    }
}
