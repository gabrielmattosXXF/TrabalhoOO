/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Control.DirecionaTelaCadastro;
import Model.Estoque;
import Control.*;
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
        
        this.addWindowListener(new EventoJanela(this));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
        botoes.setLayout(new GridLayout(5, 0));
        
        JButton btImprimeEstoque = new JButton("Imprime estoque");
        btImprimeEstoque.addActionListener(e -> {
                
            JList listaEstoque = new JList (Estoque.imprimeEstoqueS().toArray());
            listaEstoque.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
            
            listaEstoque.addListSelectionListener(a->{
                int firstIndex = listaEstoque.getSelectedIndex();

                if (firstIndex != -1) {

                    Item elementAt = Estoque.retornaItemIndex(firstIndex);
                    
                    JOptionPane.showMessageDialog(null, elementAt);
                }
            });
            
            JScrollPane scroll= new JScrollPane (listaEstoque);
            scroll.setPreferredSize(new Dimension(200,200));
            btImprimeEstoque.add(scroll);

            painelTxt.removeAll();
            painelTxt.add(scroll, BorderLayout.CENTER);
            painelTxt.revalidate();
            painelTxt.repaint();
            
        });
        botoes.add(btImprimeEstoque);
        
        JButton btImprimeServicos = new JButton("Imprime Serviços");
        btImprimeServicos.addActionListener(e -> {
                
            JList listaServico = new JList (DadosServico.imprimeServico().toArray());
            listaServico.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
            
            listaServico.addListSelectionListener(a->{
                int firstIndex = listaServico.getSelectedIndex();

                if (firstIndex != -1) {

                    Servico elementAt = DadosServico.retornaServicoIndex(firstIndex);
                    
                    JOptionPane.showMessageDialog(null, elementAt);
                }
            });
            
            JScrollPane scroll= new JScrollPane (listaServico);
            scroll.setPreferredSize(new Dimension(200,200));
            btImprimeServicos.add(scroll);

            painelTxt.removeAll();
            painelTxt.add(scroll, BorderLayout.CENTER);
            
            JButton btTotalPrecoServico = new JButton("Calcular valor total");
            btTotalPrecoServico.addActionListener(a->{
                JOptionPane.showMessageDialog(null, "Valor total dos serviços feitos: R$"+DadosServico.totalPrecoServico());
            });
            painelTxt.add(btTotalPrecoServico);
            //fazer um botão que mostre a soma dos valores de cada servico feito
            painelTxt.revalidate();
            painelTxt.repaint();
            
        });
        botoes.add(btImprimeServicos);
        
        JButton btAdministrarProduto = new JButton("Administrar produto");
        btAdministrarProduto.addActionListener(d-> {
            this.setVisible(false);
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
            remover.addActionListener(f->{

                
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
                    scroll.setPreferredSize(new Dimension(200,200));

                    btopcao.add(scroll);
                    
                    listaFuncionarios.addListSelectionListener(s->{
                        
                        int funcSelectedIndex = listaFuncionarios.getSelectedIndex();
                    
                        if(selectedIndex==1)
                        {
                            funcSelectedIndex+=DadosUsuario.indexLastAdm()+1;
                            
                            
                        }
                        else if(selectedIndex==2)
                        {
                            funcSelectedIndex+=DadosUsuario.indexLastTec()+1;
                            
                        }
                        if(JOptionPane.showConfirmDialog(null, "Deseja remover o "+DadosUsuario.imprimeUsuarioIndex(funcSelectedIndex))==0)
                        {
                            if(selectedIndex != -1)
                            {
                                DadosUsuario.removeFuncionario(funcSelectedIndex);
                            }
                        }
                        
                    });
                    //listaFuncionarios =new JList (DadosUsuario.imprimeFuncionario(selectedIndex).toArray());
                    
                    painelTxt.removeAll();
                    painelTxt.add(listFunc, BorderLayout.CENTER);
                    painelTxt.add(scroll,BorderLayout.SOUTH);
                    painelTxt.revalidate();
                    painelTxt.repaint();
                    this.revalidate();
                    this.repaint();

                    });
            });
            btopcao.add(remover);
            
            //JButton imprime = new JButton("Imprimir funcionários");
            //imprime.addActionListener(g -> {

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
                scroll.setPreferredSize(new Dimension(200,200));

                //btopcao.add(scroll);
                    
                listaFuncionarios.addListSelectionListener(s->{
                        
                    int funcSelectedIndex = listaFuncionarios.getSelectedIndex();
                    
                    if(selectedIndex==1)
                    {
                        funcSelectedIndex+=DadosUsuario.indexLastAdm()+1;
                    }
                    else if(selectedIndex==2)
                    {
                        funcSelectedIndex+=DadosUsuario.indexLastTec()+1;
                        }
                        JOptionPane.showMessageDialog(null, DadosUsuario.imprimeUsuarioIndex(funcSelectedIndex));
                    });

                    //listaFuncionarios = DadosUsuario.imprimeFuncionario(selectedIndex).toArray();
                    //btopcao.add(listFunc);
                    btopcao.add(scroll);

                    painelTxt.removeAll();
                    painelTxt.add(opcao);
                    //painelTxt.add(btopcao);
                    //painelTxt.add(remover);
                    //painelTxt.add(listFunc, BorderLayout.CENTER);
                    painelTxt.add(scroll,BorderLayout.SOUTH);
                    painelTxt.revalidate();
                    painelTxt.repaint();

                });
                
            //});
            btopcao.add(listFunc);
            
            
            opcao.add(btopcao);
            
            
            
            painelTxt.removeAll();
            painelTxt.add(opcao, BorderLayout.CENTER);
            painelTxt.revalidate();
            painelTxt.repaint();
        });
        botoes.add(btAdministrarFuncionarios);
        
        JButton btCancelar = new JButton("Cancelar");
        btCancelar.addActionListener(e->{
            this.setVisible(false);
            new TelaInicial(); 
        });
        botoes.add(btCancelar);
        return botoes;
    }
    
    
}
