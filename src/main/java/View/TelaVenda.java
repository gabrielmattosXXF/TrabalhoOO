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
    private JLabel nomeItem = new JLabel("Nome: ");
    private JLabel precoItem = new JLabel("Preço: ");
    private JLabel quantItem = new JLabel("Quantidade em estoque: ");
    private JLabel quantVenda = new JLabel("Quantidade da venda: ");
    private JTextField tfQuantVenda = new JTextField(10);
    
    private JList listaEstoque = new JList(Estoque.imprimeEstoqueS().toArray());
    private Vendedor vendedor;
    
    public TelaVenda(Vendedor vendedor)
    {
        this.vendedor=vendedor;
        
        listaEstoque.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tfQuantVenda = new JTextField(10);
        
        listaEstoque.addListSelectionListener(a->{
            int firstIndex = listaEstoque.getSelectedIndex();

            if (firstIndex != -1) {
                
                Item elementAt = Estoque.retornaItemIndex(firstIndex);
                
                this.nomeItem.setText("Nome: " + elementAt.getNome());
                this.precoItem.setText("Preço: " + elementAt.getPreco());
                this.quantItem.setText("Quantidade em estoque: " + elementAt.getQuant());
                this.tfQuantVenda.setText("");
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
        painelGer.setLayout(new GridLayout(5, 0));
        
        JPanel nomeGer = new JPanel();
        JPanel precoGer = new JPanel();
        JPanel quantGer = new JPanel();
        JPanel quantVendGer = new JPanel();
        JPanel botoesGer = new JPanel();
        botoesGer.setLayout(new GridLayout(0, 2));
        
        nomeGer.add(nomeItem);       
        precoGer.add(precoItem, BorderLayout.CENTER);                
        quantGer.add(quantItem, BorderLayout.CENTER);
        quantVendGer.add(quantVenda);
        quantVendGer.add(tfQuantVenda);
        
        JButton btRealizarVenda = new JButton("Realizar Venda");      
        btRealizarVenda.addActionListener(a->{
            int selectedIndex = listaEstoque.getSelectedIndex();
                    
            if(JOptionPane.showConfirmDialog(null, "Deseja vender " + tfQuantVenda.getText() + " unidades do produto \""+listaEstoque.getModel().getElementAt(selectedIndex)+"\"?")==0)
            {
                if(selectedIndex != -1)
                {
                    Item elementAt = Estoque.retornaItemIndex(selectedIndex);
                    
                    Estoque.realizaVenda(elementAt, Integer.parseInt(tfQuantVenda.getText()), vendedor);
                    this.dispose();
                    new TelaVenda(vendedor);

                }
            }
        });
        botoesGer.add(btRealizarVenda);

        JButton btCancelar = new JButton("Cancelar");
        btCancelar.addActionListener(f->{
            this.dispose();
            new TelaVendedor(vendedor);

        });
        botoesGer.add(btCancelar);
        


        painelGer.add(nomeGer);
        painelGer.add(precoGer);
        painelGer.add(quantGer);
        painelGer.add(quantVendGer);
        painelGer.add(botoesGer);
                
        return painelGer;
     }  
    
}