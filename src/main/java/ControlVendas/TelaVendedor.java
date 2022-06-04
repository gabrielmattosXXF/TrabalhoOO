/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlVendas;

import Model.Vendedor;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Derlucio Nazareth
 */
public class TelaVendedor {
    
    public TelaVendedor(Vendedor v)
    {
        Scanner teclado = new Scanner(System.in);
        String options[] = {"Realiza Venda", "Consultar Produto", "Criar Ordem de Serviço", "Cancelar"};
        
        JOptionPane.showMessageDialog(null, "bem vindo a tela do Vendedor", "tela do Vendedor", JOptionPane.INFORMATION_MESSAGE, null);
        
        int option = 0;
        
        while(option != 3)
        {
            option = JOptionPane.showOptionDialog(null, "Digite a opção desejada","Opções", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            
            switch(option)
            {
                case 0:
                {                    
                    System.out.println("Informe o nome do item: ");
                    String nomeProduto=teclado.nextLine();
                    System.out.println("Informe a quantidade Vendida: ");
                    int qntd=teclado.nextInt();
                    
                    if(!Estoque.realizaVenda(nomeProduto,qntd,v))
                    {
                        System.out.println("Quantidade ou produto inválido.");
                    }
                }
                case 1:
                {
                    //System.out.println("Informe o nome do item: ");
                    //String nomeProduto=teclado.nextLine();
                    String nomeProduto=JOptionPane.showInputDialog("Informe o nome do item: ");
                    System.out.println(Estoque.retornaItem(nomeProduto));
                }
                case 2:
                {
                    
                }
                case 3:
                {
                    break;
                }
            }
        }
    }
    
}
