/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import javax.swing.*;
import java.awt.*;

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
    
    /*private JTextField nomeItem;
    private JTextField precoItem;
    private JTextField quantItem;*/
    
    JTextField nomeItem;
    JTextField precoItem;
    JTextField quantItem; 
    
    
    public TelaAdmProduto()
    {
        super("Administrar Produto");
        
        nomeItem = new JTextField(15);
        precoItem = new JTextField(15);
        quantItem = new JTextField(15);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.principal = new JPanel();
        this.principal.setLayout(new BorderLayout());
        this.principal.setLayout(new GridLayout(2, 0));
        
        this.principal.add(painelGerencia(), BorderLayout.CENTER);
        this.principal.add(painelProdutos());
        
        this.add(principal);
        
        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
    }
    
    private JPanel painelProdutos()
    {
        JPanel painelProd = new JPanel();
        painelProd.setBorder(BorderFactory.createTitledBorder("Lista de produtos"));
        
        //fazer a impressão da lista de produtos
        
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
        botoesGer.setLayout(new GridLayout(0, 4));
        
        nomeGer.add(new JLabel("Nome: "));
        nomeGer.add(nomeItem);
        
        precoGer.add(new JLabel("Preço: "));
        precoGer.add(precoItem, BorderLayout.CENTER);
        
        quantGer.add(new JLabel("Quantidade: "));
        quantGer.add(quantItem, BorderLayout.CENTER);

        JButton btAdicionar = new JButton("Adicionar");
        //btAdicionar.addActionListener(new SalvarContato(this));
        botoesGer.add(btAdicionar);

        JButton btRemover = new JButton("Remover");
        //btRemover.addActionListener(new RemoverContato(this));
        botoesGer.add(btRemover);
        
        JButton btEditar = new JButton("Editar");
        //btnEditar.addActionListener(new EditarContato(this));
        botoesGer.add(btEditar);
        
        JButton btLimpar = new JButton("Limpar");
        //btnLimpar.addActionListener(new LimparFormulario(this));
        botoesGer.add(btLimpar);
        
        painelGer.add(nomeGer);
        painelGer.add(precoGer);
        painelGer.add(quantGer);
        painelGer.add(botoesGer);
        
        return painelGer;
    }
}
