/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Mattos
 */
public class Loja
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        
        String[] optionsInicial = {"Fazer Login", "Cancelar"};
        
        JOptionPane.showMessageDialog(null, "Bem vindo à tela inicial", "Tela inicial", JOptionPane.INFORMATION_MESSAGE, null);
        
        int option = 0;
        
        while(option != 1)
        {
            option = JOptionPane.showOptionDialog(null, "Digite a opção desejada","Opções", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, optionsInicial, optionsInicial[0]);
            
            switch(option)
            {
                case 0:
                {                    
                    String login=JOptionPane.showInputDialog(null, "Digite o seu login:");
                    String senha=JOptionPane.showInputDialog(null, "Digite a sua senha:");
                    
                    if(DadosUsuario.validaLogin(login, senha))
                    {   

                        if(DadosUsuario.NivelAcessoLogin(login, senha) == "Administrador")
                        {
                            TelaAdministrador telaAdm = new TelaAdministrador();
                        }
                        else if(DadosUsuario.NivelAcessoLogin(login, senha) == "Tecnico")
                        {

                        }
                        else if(DadosUsuario.NivelAcessoLogin(login, senha) == "Vendedor")
                        {
                            Vendedor v = (Vendedor) DadosUsuario.retornaUsuario(login, senha);
                            
                            TelaVendedor telaVend = new TelaVendedor(v);
                        }
                        
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Login ou senha incorretos.", "tela inicial", JOptionPane.INFORMATION_MESSAGE, null);
                    }
                    
                }
                case 1:
                {
                    break;
                }
            }
        }
    }
}
        
        
        
        
        
        
        
        
        
        
        
        
        