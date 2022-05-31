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
        
        //no inicio do programa deve ser lido um login e uma senha
        //vai ser verificado o nivel de acesso de login
        //caso ele seja de administrador, será direcionado à página do administrador( representado pelo for abaixo)
        
        
        JOptionPane.showMessageDialog(null, "bem vindo a tela do administrador", "tela do administrador", JOptionPane.INFORMATION_MESSAGE, null);
        
        String options[] = {"Adiciona ao estoque", "Imprime estoque", "Administrar produto", "Cancelar"};
        
        //JOptionPane.showInputDialog(null, opcoes, "Ações do administrador", JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        
        int option=0;
        
        
        // O for representa a tela do administrador
        for(; option!=3;)
        {
            option = JOptionPane.showOptionDialog(null, "Informe a ação desejada", "Janela do administrador", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            
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
                    if(Estoque.veirificaEStoqueVazio())
                    {
                        System.out.println("Estoque vazio! Adicone um produto");
                        Estoque.adicionaProdutoAoEstoque();
                        break;
                    }
                    
                    System.out.println("Informe o nome do produto: ");
                    
                    String nome = teclado.nextLine();
                    
                    while(!Estoque.verificaProdInicializado(nome))
                    {
                        System.out.println("Nome Inválido! Digite outro nome.");
                        
                        nome=teclado.nextLine();
                    }
                    
                    String optionsProd[] = {"Aumentar Quantidade", "Diminuir quantidade", "Alterar preço", "Alterar nome", "Calcelar"};
                    
                    int i_prod = JOptionPane.showOptionDialog(null, "Informe a ação desejada", "Janela do administrador", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, optionsProd, optionsProd[0]);

                    switch(i_prod)
                    {
                        case 0:
                        {
                            System.out.println("Informe a quantidade a ser adicionada: ");
                            int quant=teclado.nextInt();
                            Estoque.aumentaQuantidade(nome, quant);
                            break;
                        }
                        
                        case 1:
                        {
                            System.out.println("Informe a quantidade a ser removida: ");
                            int quant=teclado.nextInt();
                            Estoque.diminuiQuantidade(nome, quant);
                            break;
                        }
                        
                        case 2:
                        {
                            System.out.println("Informe o novo preço: ");
                            double preco=teclado.nextDouble();
                            Estoque.setPrecoProd(nome, preco);
                            break;
                        }
                        
                        case 3:
                        {
                            System.out.println("Informe o novo nome: ");
                            String novo_nome=teclado.nextLine();
                            Estoque.setNomeProd(nome, novo_nome);
                            
                            break;
                        }
                        
                        case 4:
                        {
                            break;
                        }
                    }
                    
                }

                case 3:
                {
                    break;
                }

            }
        }
        
        
    }
    
    
    
}
