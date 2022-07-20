/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Estoque;
import Model.Vendedor;
//import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Derlucio Nazareth
 */
public class TelaVendedor {
    
    public TelaVendedor(Vendedor v)
    {
        //Scanner teclado = new Scanner(System.in);
        String options[] = {"Realizar Venda", "Consultar Produto", "Criar Ordem de Serviço", "Cancelar"};
        
        JOptionPane.showMessageDialog(null, "bem vindo a tela do Vendedor", "tela do Vendedor", JOptionPane.INFORMATION_MESSAGE, null);
        
        int option = 0;
        
        while(option != 3)
        {
            option = JOptionPane.showOptionDialog(null, "Digite a opção desejada","Opções", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            
            switch(option)
            {
                case 0:
                {                    
                    //tem que ser criado um loop para computar a venda
                    
                    String nomeProduto=JOptionPane.showInputDialog("Informe o nome do item: ");
                    int qntd= Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade vendida: "));
                    
                    //Venda.realizaVenda(nomeProduto, qntd, v);
                    
                    break;
                }
                case 1:
                {
                    //System.out.println("Informe o nome do item: ");
                    //String nomeProduto=teclado.nextLine();
                    //System.out.println(Estoque.retornaItem(nomeProduto));
                    String nomeProduto=JOptionPane.showInputDialog("Informe o nome do item: ");
                    JOptionPane.showConfirmDialog(null, Estoque.retornaItem(nomeProduto));
                    break;
                }
                case 2:
                {
                    //ordem de serviço que ainda não foi implementado
                    break;
                }
                case 3:
                {
                    break;
                }
            }
        }
    }
    
}
