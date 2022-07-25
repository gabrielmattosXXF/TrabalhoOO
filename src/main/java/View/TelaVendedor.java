package View;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Derlucio Nazareth
 */
import Control.RetornaInicio;
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
    protected Vendedor v;
    
    public TelaVendedor(Vendedor v)
    {
        super("Tela Vendedor");
        this.v=v;

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
        
        JButton btConsultarProduto = new JButton("Consultar Estoque");
        btConsultarProduto.addActionListener(e -> {
                
            JList listaEstoque = new JList (Estoque.imprimeEstoque().toArray());
            listaEstoque.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
            JScrollPane scroll= new JScrollPane (listaEstoque);
            scroll.setPreferredSize(new Dimension(200,200));
            btConsultarProduto.add(scroll);

            painelTxt.removeAll();
            painelTxt.add(scroll, BorderLayout.CENTER);
            painelTxt.revalidate();
            painelTxt.repaint();
            
        });
        botoes.add(btConsultarProduto);
        
        JButton btAdministrarProduto = new JButton("Realizar Venda");
        btAdministrarProduto.addActionListener(d-> {
            //this.setVisible(false);
            new TelaAdmProduto();
            
            
        });
        botoes.add(btAdministrarProduto);
        
        JButton btAdministrarFuncionarios = new JButton("Criar Ordem de Serviço");
        btAdministrarFuncionarios.addActionListener(e-> {
            
            new TelaServico();
            
        });
            
                        
            
        
        JButton btCancelar = new JButton("Cancelar");
        btCancelar.addActionListener(new RetornaInicio(this));
        botoes.add(btCancelar);
        return botoes;
    }
    
    
}
