/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
//import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author nicoledefilippo
 */
public class TelaTecnico {
    
    public TelaTecnico()
    {
        //Scanner teclado = new Scanner(System.in);
        String options[] = {"Conserta produto", "Destrói produto", "Cancelar"};
        
        JOptionPane.showMessageDialog(null, "bem vindo a tela do Técnico", "tela do Técnico", JOptionPane.INFORMATION_MESSAGE, null);
        
        int option = 0;
        
        while(option != 2)
        {
            option = JOptionPane.showOptionDialog(null, "Digite a opção desejada","Opções", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            
            switch(option)
            {
                case 0:
                {
                    
                }

                case 1:
                {
                    
                }
                case 2:
                {
                    break;
                }
            }
        }
            
        
    }
}
