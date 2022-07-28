package View;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Derlucio Nazareth
 */
import Model.Estoque;
import Control.*;
import Model.*;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Gabriel Mattos
 */
public class TelaVendedor extends JFrame implements Tela
{
    JPanel painelTxt;
    protected Vendedor vendedor;
    
    public TelaVendedor(Vendedor vendedor)
    {
        super("Tela Vendedor: " + vendedor.getNomeUsuario());
        this.vendedor=vendedor;

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
        caixaTexto.add(new JLabel("Bem vindo à tela do vendedor!"));
        return caixaTexto;
    }
    
    private JPanel painelDeBotoes()
    {

        //"Adiciona ao estoque", "Imprime estoque", "Administrar produto","Administrar funcionários", "Cancelar"};
        
        JPanel botoes = new JPanel();
        //botoes.setSize(500, 250);
        botoes.setLayout(new GridLayout(4, 0));
        
        JButton btEstoque = new JButton("Consultar Estoque");
        btEstoque.addActionListener(e -> {
                
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
            btEstoque.add(scroll);

            painelTxt.removeAll();
            painelTxt.add(scroll, BorderLayout.CENTER);
            painelTxt.revalidate();
            painelTxt.repaint();
            
        });
        botoes.add(btEstoque);
        
        JButton btVenda = new JButton("Realizar Venda");
        btVenda.addActionListener(d-> {
            this.setVisible(false);
            new TelaVenda(vendedor);
        });
        botoes.add(btVenda);
        
        JButton btServico = new JButton("Criar Ordem de Serviço");
        btServico.addActionListener(e-> {
            this.setVisible(false);
            new TelaServico(vendedor);
            
        });
        botoes.add(btServico);
        
        JButton btCancelar = new JButton("Cancelar");
        btCancelar.addActionListener(a->{
            this.setVisible(false);
            new TelaInicial();
        });
        botoes.add(btCancelar);
        return botoes;
    }
    
    
}
