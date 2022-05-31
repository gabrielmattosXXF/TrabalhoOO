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
        
        
        JOptionPane.showMessageDialog(null, "bem vindo a tela do administrador", "tela do administrador", JOptionPane.INFORMATION_MESSAGE, null);
        
        String options[] = {"Adiciona ao estoque", "Imprime estoque", "Calcel"};
        
        //JOptionPane.showInputDialog(null, opcoes, "Ações do administrador", JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        
        int option = JOptionPane.showOptionDialog(null, "Informe a ação desejada", "Janela do usuário", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        switch(option)
        {
            case 0:
            {
                Estoque.adicionaProdutoAoEstoque();
                break;
            }
            
            case 1:
            {
                Estoque.imprimeEstoque();
                break;
            }
            
            case 2:
            {
                break;
            }
            
        }
    }
    
    
    
}
