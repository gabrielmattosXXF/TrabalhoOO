/*
Augusto de Fillippo Cavalini-202165514B 

Gabriel Mattos-202165503B 

Luiz Gustavo Ferreira Nazareth-202165515B 
*/
package Control;

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
