/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import javax.swing.*;
import java.awt.*;
import Model.Estoque;
import Model.Item;

/**
 *
 * @author Gabriel Mattos
 */
public class TelaAdmProduto extends JFrame implements Tela
{
    /*
    fazendo a JList que aparecerá no canto esuqerdo conter apenas os nomes dos produtos. ao acessar um dos produtos pela seleção, retornará essa string, que servirá para buscar esse produto no estoque e realizar as alterações nele
    */
    
    JPanel principal;
    //private JList<String> lista;
    //o item selecionado na JList retorna seu index ao action, fazendo alterações na lista dessa forma. Será feita alterações da mesma forma no item da lista normal do estoque
    
    private JTextField nomeItem;
    private JTextField precoItem;
    private JTextField quantItem;
    private JList listaEstoque = new JList (Estoque.imprimeEstoqueS().toArray());
    
    //JTextField nomeItem;
    //JTextField precoItem;
    //JTextField quantItem; 
    
    
    public TelaAdmProduto()
    {
        super("Administrar Produto");
        
        //DefaultListModel<Item> model = new DefaultListModel<>();
        
        listaEstoque.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
        
        nomeItem = new JTextField(15);
        precoItem = new JTextField(15);
        quantItem = new JTextField(15);
        
        listaEstoque.addListSelectionListener(a->{
            int firstIndex = listaEstoque.getSelectedIndex();

            if (firstIndex != -1) {
                
                Item elementAt = Estoque.retornaItemIndex(firstIndex);
                
                this.nomeItem.setText(elementAt.getNome());
                this.precoItem.setText(Double.toString(elementAt.getPreco()));
                this.quantItem.setText(Integer.toString(elementAt.getQuant()));
                
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
            //fazer um script que adiciona o contato escrito à JList
            Estoque.adicionaProdutoAoEstoque(new Item(nomeItem.getText(), Double.parseDouble(precoItem.getText()), Integer.parseInt(quantItem.getText())));
            //this.principal.repaint();
            //SwingUtilities.updateComponentTreeUI(this);
            this.setVisible(false);//cambiarra
            new TelaAdmProduto();
        });
        botoesGer.add(btAdicionar);

        JButton btRemover = new JButton("Remover");
        btRemover.addActionListener(b->{
            
            int selectedIndex = listaEstoque.getSelectedIndex();
                    
            if(JOptionPane.showConfirmDialog(null, "Deseja remover o "+Estoque.retornaItemIndex(selectedIndex))==0)
            {
                if(selectedIndex != -1)
                {
                Estoque.removeItem(selectedIndex);//fazer um mecanismo que atualize a JList na hora de execução

                                //DefaultListModel<String> model = (DefaultListModel<String>) listaFuncionarios.getModel();
                                //model.removeElementAt(selectedIndex);
                                //listaFuncionarios.setModel(model);
                                //painelTxt.repaint();
                                
                                //painelTxt.removeAll();
                                //painelTxt.add(scroll,BorderLayout.CENTER);
                                //painelTxt.add(removerFunc,BorderLayout.SOUTH);
                                //painelTxt.revalidate();
                                //painelTxt.repaint();
                    this.setVisible(false);//cambiarra
                    new TelaAdmProduto();
                }
            }
        });
        botoesGer.add(btRemover);
        
        JButton btEditar = new JButton("Editar");
        btEditar.addActionListener(c->{
            int selectedIndex = listaEstoque.getSelectedIndex();
            
            Item selectedItem = Estoque.retornaItemIndex(selectedIndex);
            
            selectedItem.setNome(nomeItem.getText());
            selectedItem.setPreco(Double.parseDouble(precoItem.getText()));
            selectedItem.setQuant(Integer.parseInt(quantItem.getText()));
            
            this.setVisible(false);//cambiarra
            new TelaAdmProduto();
            
        });
        botoesGer.add(btEditar);
        
        JButton btLimpar = new JButton("Limpar");
        //btnLimpar.addActionListener(new LimparFormulario(this));
        btLimpar.addActionListener(d->{
            nomeItem.setText("");
            precoItem.setText("");
            quantItem.setText("");
        });
        botoesGer.add(btLimpar);
        
        JButton btSair = new JButton("Sair");
        btSair.addActionListener(d->{
            this.setVisible(false);
        });
        botoesGer.add(btSair);
        
        painelGer.add(nomeGer);
        painelGer.add(precoGer);
        painelGer.add(quantGer);
        painelGer.add(botoesGer);
        
        return painelGer;
    }
}
