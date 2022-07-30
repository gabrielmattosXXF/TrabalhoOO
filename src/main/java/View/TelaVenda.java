/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import javax.swing.*;
import java.awt.*;
import Model.Estoque;
import Model.Item;
import Model.Vendedor;
/**
 *
 * @author Derlucio Nazareth
 */
public class TelaVenda extends JFrame implements Tela{
    
    private JPanel principal;
    private JTextField qntdVendida;
    private JLabel nomeItem = new JLabel("Nome: ");
    private JLabel precoItem = new JLabel("Preço: ");
    private JLabel quantItem = new JLabel("Quantidade do item: ");
    private JList listaEstoque = new JList(Estoque.imprimeEstoqueS().toArray());
    private Vendedor v;
    
    public TelaVenda(Vendedor v)
    {
        listaEstoque.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        qntdVendida = new JTextField(15);
        
        listaEstoque.addListSelectionListener(a->{
            int firstIndex = listaEstoque.getSelectedIndex();

            if (firstIndex != -1) {
                
                Item elementAt = Estoque.retornaItemIndex(firstIndex);
                
                this.nomeItem.setText("Nome: " + elementAt.getNome());
                this.precoItem.setText("Preço: " + elementAt.getPreco());
                this.quantItem.setText("Quantidade: " + elementAt.getQuant());
                //tela.setLastIndex(firstIndex);
            }
        });
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.principal = new JPanel();
        this.principal.setLayout(new BorderLayout());
        this.principal.setLayout(new GridLayout(2, 0));
        
        this.principal.add(painelGerencia(), BorderLayout.CENTER);
        this.principal.add(painelProdutos());
        
        this.add(principal);
        
        this.setSize(500, 500);
        this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    private JPanel painelProdutos()
    {
        JPanel painelProd = new JPanel();
        painelProd.setBorder(BorderFactory.createTitledBorder("Lista de produtos"));
        JScrollPane scroll= new JScrollPane (listaEstoque);
        scroll.setPreferredSize(new Dimension(450,200));
        
        painelProd.add(scroll);
        
        return painelProd;
    }
    
    private JPanel painelGerencia()
    {
        JPanel painelGer = new JPanel();
        painelGer.setBorder(BorderFactory.createTitledBorder("Preencha os dados do produto"));
        painelGer.setLayout(new GridLayout(4, 0));
        
        JPanel nomeGer = new JPanel();
        JPanel precoGer = new JPanel();
        JPanel quantGer = new JPanel();
        JPanel botoesGer = new JPanel();
        botoesGer.setLayout(new GridLayout(0, 5));
        
        nomeGer.add(nomeItem);       
        precoGer.add(precoItem, BorderLayout.CENTER);                
        quantGer.add(quantItem, BorderLayout.CENTER);
        
        JButton btRealizarVenda = new JButton("Realizar Venda");      
        btRealizarVenda.addActionListener(a->{
            int selectedIndex = listaEstoque.getSelectedIndex();
                    
            if(JOptionPane.showConfirmDialog(null, "Deseja vender" + quantItem + "do produto "+Estoque.retornaItemIndex(selectedIndex))==0)
            {
                if(selectedIndex != -1)
                {
                //Estoque.realizaVenda(nomeItem,quantItem,v);
                }
            }
        });

        JButton Cancela = new JButton("Cancelar");
            Cancela.addActionListener(j->{

            });


        painelGer.add(nomeGer);
        painelGer.add(precoGer);
        painelGer.add(quantGer);
        painelGer.add(btRealizarVenda);
                
        return painelGer;
     }  
    
}