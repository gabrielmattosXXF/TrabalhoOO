/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlVendas;
import Model.Vendedor;
import Model.Administrador;
import Model.Tecnico;
import Model.DadosUsuario;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Derlucio Nazareth
 */
public class TelaAdministrador {
    
    public TelaAdministrador()
    {
        
        Scanner teclado=new Scanner(System.in);
        
        JOptionPane.showMessageDialog(null, "Bem vindo a tela do administrador", "tela do administrador", JOptionPane.INFORMATION_MESSAGE, null);
        
        String options[] = {"Adiciona ao estoque", "Imprime estoque", "Administrar produto","Administrar funcionários", "Cancelar"};
        
        //JOptionPane.showInputDialog(null, opcoes, "Ações do administrador", JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        
        int option=0;
        
        
        // O while representa a tela do administrador
        while(option!=4)
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
                    break;
                    
                }

                case 3:
                {
                    String[] nivelUsuario = {"Administrador", "Vendedor", "Técnico", "Cancelar"};
                    
                    int optionUsuario = JOptionPane.showOptionDialog(null, "Informe o tipo de usuário ","Opções", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, nivelUsuario, nivelUsuario[3]);;
                    
                    switch(optionUsuario)
                    {
                        case 0:
                        {
                            String nomeUsuario = JOptionPane.showInputDialog(null, "Digite o nome do novo usuário:");
                            String login=JOptionPane.showInputDialog(null, "Digite o login do novo usuário:");
                            String senha=JOptionPane.showInputDialog(null, "Digite a senha do novo usuário:");
                            
                            DadosUsuario.adicionaLogin(new Administrador(nomeUsuario, login, senha));
                            break;
                        }
                        
                        case 1:
                        {
                            String nomeUsuario = JOptionPane.showInputDialog(null, "Digite o nome do novo usuário:");
                            String login=JOptionPane.showInputDialog(null, "Digite o login do novo usuário:");
                            String senha=JOptionPane.showInputDialog(null, "Digite a senha do novo usuário:");
                            
                            DadosUsuario.adicionaLogin(new Vendedor(nomeUsuario, login, senha));
                            break;
                        }
                        
                        case 2:
                        {
                            String nomeUsuario = JOptionPane.showInputDialog(null, "Digite o nome do novo usuário:");
                            String login=JOptionPane.showInputDialog(null, "Digite o login do novo usuário:");
                            String senha=JOptionPane.showInputDialog(null, "Digite a senha do novo usuário:");
                            
                            DadosUsuario.adicionaLogin(new Tecnico(nomeUsuario, login, senha));
                            break;
                        }
                        
                        case 3:
                        {
                            break;
                        }
                    }
                }
                
                case 4:
                {
                    break;
                }

            }
        }
        
        
    }
    
}
