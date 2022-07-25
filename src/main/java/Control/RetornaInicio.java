/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Gabriel Mattos
 */
public class RetornaInicio implements ActionListener
{
    Tela tela;
    
    public RetornaInicio(Tela tela)
    {
        this.tela=tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        new TelaInicial(); //faz redirecionar à tela inicial
        tela.setVisible(false);

    }
}
