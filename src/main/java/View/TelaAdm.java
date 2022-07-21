/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Estoque;
import Control.*;
import ControlView.*;
import Model.*;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Gabriel Mattos
 */
public class TelaAdm extends JFrame implements Tela
{
    JPanel painelTxt;
    
    public TelaAdm()
    {
        super("Tela Administrador");

        //this.setLayout(new BorderLayout());
        this.setLayout(new GridLayout(0, 2));
        //this.add(painelDeBotoes(), BorderLayout.WEST);
        this.add(painelDeBotoes());

        this.painelTxt= new JPanel();
                
        painelTxt.add(painelDeTexto());
        
        //this.add(painelTxt, BorderLayout.EAST);
        this.add(painelTxt);

        this.setSize(500, 500);
        this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    public JPanel getPainelTxt()
    {
        return this.painelTxt;
    }
    
    private JPanel painelDeTexto()
    {
        JPanel caixaTexto = new JPanel();
        caixaTexto.add(new JLabel("Bem vindo à tela do administrador!"));
        return caixaTexto;
    }
    
    private JPanel painelDeBotoes()
    {

        //"Adiciona ao estoque", "Imprime estoque", "Administrar produto","Administrar funcionários", "Cancelar"};
        
        JPanel botoes = new JPanel();
        //botoes.setSize(500, 250);
        botoes.setLayout(new GridLayout(4, 0));
        
        JButton btImprimeEstoque = new JButton("Imprime estoque");
        btImprimeEstoque.addActionListener(e -> {
                
            JList listaEstoque = new JList (Estoque.imprimeEstoque().toArray());
            listaEstoque.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
            JScrollPane scroll= new JScrollPane (listaEstoque);
            btImprimeEstoque.add(scroll);

            painelTxt.removeAll();
            painelTxt.add(scroll, BorderLayout.CENTER);
            painelTxt.revalidate();
            painelTxt.repaint();
            
        });
        botoes.add(btImprimeEstoque);
        
        JButton btAdministrarProduto = new JButton("Administrar produto");
        btAdministrarProduto.addActionListener(d-> {
            //this.setVisible(false);
            new TelaAdmProduto();
        });
        botoes.add(btAdministrarProduto);
        
        JButton btAdministrarFuncionarios = new JButton("Administrar funcionários");
        btAdministrarFuncionarios.addActionListener(e-> {
            
            JPanel opcao = new JPanel();
            //opcao.setSize(500, 250);
            
            opcao.setLayout(new GridLayout(2, 0));
            opcao.add(new JLabel("Informe a opção desejada:"));
            
            JPanel btopcao = new JPanel();
            btopcao.setLayout(new GridLayout(4,0));
            
            JButton adicionar = new JButton("Adicionar");
            adicionar.addActionListener(new DirecionaTelaCadastro(this));
            btopcao.add(adicionar);
            
            JButton remover = new JButton("Remover");
            //remover.addActionListener(new DirecionaTelaCadastro(this)); //Fazer uma tela de remoção de usuário
            remover.addActionListener(f->{
                
                JList listaFuncionarios = new JList (DadosUsuario.imprimeFuncionario(0).toArray());
                listaFuncionarios.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
                JScrollPane scroll= new JScrollPane (listaFuncionarios);
                
                btopcao.add(scroll); 
                
                JButton removerFunc = new JButton("Remover");//fazer uma tela de aviso antes de remover o usuário
                removerFunc.addActionListener(evento->{
                    
                    int selectedIndex = listaFuncionarios.getSelectedIndex();
                    
                    if(JOptionPane.showConfirmDialog(null, "Deseja remover o "+DadosUsuario.retornaUsuarioIndex(selectedIndex))==0)
                    {
                        if(selectedIndex != -1)
                        {
                            DadosUsuario.removeFuncionario(selectedIndex);//fazer um mecanismo que atualize a JList na hora de execução

                                //DefaultListModel<String> model = (DefaultListModel<String>) listaFuncionarios.getModel();
                                //model.removeElementAt(selectedIndex);
                                //listaFuncionarios.setModel(model);
                                //painelTxt.repaint();
                                
                                //painelTxt.removeAll();
                                //painelTxt.add(scroll,BorderLayout.CENTER);
                                //painelTxt.add(removerFunc,BorderLayout.SOUTH);
                                //painelTxt.revalidate();
                                //painelTxt.repaint();
                                
                        }
                    }
                    
                });
                
                //listaFuncionarios = new JList (DadosUsuario.imprimeFuncionario(0).toArray());

                painelTxt.removeAll();
                painelTxt.add(scroll,BorderLayout.CENTER);
                painelTxt.add(removerFunc,BorderLayout.SOUTH);
                painelTxt.revalidate();
                painelTxt.repaint();
                
            });
            btopcao.add(remover);
            
            JButton imprime = new JButton("Imprimir funcionários");
            imprime.addActionListener(g -> {

                String[] funcionarios = {"Administradores", "Técnicos", "Vendedores"};
                JComboBox listFunc = new JComboBox<>(funcionarios);
                btopcao.add(listFunc);

                painelTxt.removeAll();
                painelTxt.add(listFunc, BorderLayout.CENTER);
                painelTxt.revalidate();
                painelTxt.repaint();

                listFunc.addActionListener(h->
                {
                    int selectedIndex = listFunc.getSelectedIndex();
                    
                    JList listaFuncionarios = new JList (DadosUsuario.imprimeFuncionario(selectedIndex).toArray());
                    listaFuncionarios.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
                    
                    JScrollPane scroll= new JScrollPane (listaFuncionarios);

                    btopcao.add(scroll);
                    
                    listaFuncionarios.addListSelectionListener(s->{
                        
                        int funcSelectedIndex = listaFuncionarios.getSelectedIndex();
                    
                        if(selectedIndex==0)
                        {
                            //JOptionPane.showConfirmDialog(null, DadosUsuario.retornaUsuarioIndex(funcSelectedIndex).toString());
                            JOptionPane.showMessageDialog(null, DadosUsuario.retornaUsuarioIndex(funcSelectedIndex).toString());
                        }
                        else if(selectedIndex==1)
                        {
                            funcSelectedIndex+=DadosUsuario.indexLastAdm()+1;
                            JOptionPane.showMessageDialog(null, DadosUsuario.retornaUsuarioIndex(funcSelectedIndex).toString());
                        }
                        else if(selectedIndex==2)
                        {
                            funcSelectedIndex+=DadosUsuario.indexLastTec()+1;
                            JOptionPane.showMessageDialog(null, DadosUsuario.retornaUsuarioIndex(funcSelectedIndex).toString());
                        }
                    });
                    
                    

                    painelTxt.removeAll();
                    painelTxt.add(listFunc, BorderLayout.CENTER);
                    painelTxt.add(scroll,BorderLayout.SOUTH);
                    painelTxt.revalidate();
                    painelTxt.repaint();

                });
                
            });
            btopcao.add(imprime);
            
            
            opcao.add(btopcao);
            
            
            
            painelTxt.removeAll();
            painelTxt.add(opcao, BorderLayout.CENTER);
            painelTxt.revalidate();
            painelTxt.repaint();
        });
        botoes.add(btAdministrarFuncionarios);
        
        JButton btCancelar = new JButton("Cancelar");
        btCancelar.addActionListener(new RetornaInicio(this));
        botoes.add(btCancelar);
        return botoes;
    }
    
    
}
