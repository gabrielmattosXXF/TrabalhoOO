/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.*;

/**
 *
 * @author Gabriel Mattos
 */
public class DirecionaTelaCadastro implements ActionListener
{
    
    Tela tela;
    
    public DirecionaTelaCadastro(Tela tela)
    {
        this.tela=tela;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        new TelaCadastro();
        tela.setVisible(false);

    }
    
}
