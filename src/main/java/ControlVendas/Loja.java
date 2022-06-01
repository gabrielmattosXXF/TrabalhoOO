/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlVendas;
import Model.*;
import java.util.Scanner;
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
        
        String login=JOptionPane.showInputDialog(null, "Digite o seu login:");
        String senha=JOptionPane.showInputDialog(null, "Digite a sua senha:");
        
        for(int i=0;i<DadosUsuarios.dadosLogin.size();i++)
        {
            if(DadosUsuarios.validaLogin(login, senha))
            {
                TelaAdministrador telaAdm=new TelaAdministrador();
            }
        }
        
        //no inicio do programa deve ser lido um login e uma senha
        //vai ser verificado o nivel de acesso de login
        //caso ele seja de administrador, será direcionado à página do administrador( representado pelo for abaixo)
    
    }
}
