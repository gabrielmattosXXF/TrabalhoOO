/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import javax.swing.*;
import java.awt.*;
import Model.Estoque;
import Model.Item;
import Control.EventoJanela;

/**
 *
 * @author Gabriel Mattos
 */
public class TelaAdmProduto extends JFrame implements Tela
{
    JPanel principal;
    
    private JTextField nomeItem;
    private JTextField precoItem;
    private JTextField quantItem;
    private JList listaEstoque = new JList (Estoque.imprimeNomeDosProdutos().toArray());
    
    public TelaAdmProduto()
    {
        super("Administrar Produto");
        
        listaEstoque.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
        
        nomeItem = new JTextField(15);
        precoItem = new JTextField(15);
        quantItem = new JTextField(15);
        
        listaEstoque.addListSelectionListener(a->{
            int firstIndex = listaEstoque.getSelectedIndex();

            if (firstIndex != -1) {
                
                Item elementAt = Estoque.retornaItemIndex(firstIndex);
                
                this.nomeItem.setText(elementAt.getNomeItem());
                this.precoItem.setText(Double.toString(elementAt.getPrecoItem()));
                this.quantItem.setText(Integer.toString(elementAt.getQuantItem()));
            }
        });
        
        this.addWindowListener(new EventoJanela(this));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.principal = new JPanel();
        this.principal.setLayout(new BorderLayout());
        this.principal.setLayout(new GridLayout(2, 0));
        
        this.principal.add(painelGerencia(), BorderLayout.CENTER);
        this.principal.add(painelProdutos());
        
        this.add(principal);
        
        this.setSize(500, 500);
        this.setVisible(true);
        
        
        
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
        
        nomeGer.add(new JLabel("Nome: "));
        nomeGer.add(nomeItem);
        
        precoGer.add(new JLabel("Preço: "));
        precoGer.add(precoItem, BorderLayout.CENTER);
        
        quantGer.add(new JLabel("Quantidade: "));
        quantGer.add(quantItem, BorderLayout.CENTER);

        JButton btAdicionar = new JButton("Adicionar");
        btAdicionar.addActionListener(a->{

            try
            {   
                if(!Estoque.verificaProdInicializado(nomeItem.getText()))
                {
                    Estoque.adicionaProdutoAoEstoque(new Item(nomeItem.getText(), Double.parseDouble(precoItem.getText()), Integer.parseInt(quantItem.getText())));
                    //this.principal.repaint();
                    //SwingUtilities.updateComponentTreeUI(this);
                    this.setVisible(false);//cambiarra
                    new TelaAdmProduto();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Esse item já está no estoque!");
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Login Inválido. Tente novamente.");
            }
            
        });
        botoesGer.add(btAdicionar);

        JButton btRemover = new JButton("Remover");
        btRemover.addActionListener(b->{
            
            int selectedIndex = listaEstoque.getSelectedIndex();
                    
            if(JOptionPane.showConfirmDialog(null, "Deseja remover o "+Estoque.retornaItemIndex(selectedIndex))==0)
            {
                if(selectedIndex != -1)
                {
                    Estoque.removeItem(selectedIndex);

                    this.setVisible(false);
                    new TelaAdmProduto();
                }
            }
        });
        botoesGer.add(btRemover);
        
        JButton btEditar = new JButton("Editar");
        btEditar.addActionListener(c->{
            int selectedIndex = listaEstoque.getSelectedIndex();
            
            Item selectedItem = Estoque.retornaItemIndex(selectedIndex);
            
            selectedItem.setNomeItem(nomeItem.getText());
            selectedItem.setPrecoItem(Double.parseDouble(precoItem.getText()));
            selectedItem.setQuantItem(Integer.parseInt(quantItem.getText()));
            
            this.setVisible(false);
            new TelaAdmProduto();
            
        });
        botoesGer.add(btEditar);
        
        JButton btLimpar = new JButton("Limpar");
        btLimpar.addActionListener(d->{
            nomeItem.setText("");
            precoItem.setText("");
            quantItem.setText("");
        });
        botoesGer.add(btLimpar);
        
        JButton btSair = new JButton("Sair");
        btSair.addActionListener(d->{
            this.setVisible(false);
            new TelaAdm();
        });
        botoesGer.add(btSair);
        
        painelGer.add(nomeGer);
        painelGer.add(precoGer);
        painelGer.add(quantGer);
        painelGer.add(botoesGer);
        
        return painelGer;
    }
}
