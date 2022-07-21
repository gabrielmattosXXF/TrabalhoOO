/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import javax.swing.*;
import java.awt.*;
import Model.DadosServico;
import Model.Servico;

/**
 *
 * @author Gabriel Mattos
 */
public class TelaTecnicoS extends JFrame implements Tela
{
    /*
    fazendo a JList que aparecerá no canto esuqerdo conter apenas os nomes dos produtos. ao acessar um dos produtos pela seleção, retornará essa string, que servirá para buscar esse produto no estoque e realizar as alterações nele
    */
    
    JPanel principal;
    
    private JLabel numServico = new JLabel("OS");
    private JLabel nomeCliente = new JLabel("Nome");
    private JLabel telefoneCliente = new JLabel("Telefone");
    private JLabel dataChegada = new JLabel("Data entrada");
    private JLabel dataSaida = new JLabel("data saida");
    
    private JList listaServico = new JList (DadosServico.imprimeServico().toArray());
    
    public TelaTecnicoS()
    {
        super("Administrar Produto");
        
        //DefaultListModel<Item> model = new DefaultListModel<>();
        
        listaServico.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
        
        //nomeItem = new JTextField(15);
        //precoItem = new JTextField(15);
        //quantItem = new JTextField(15);
        
        listaServico.addListSelectionListener(a->{
            int firstIndex = listaServico.getSelectedIndex();

            if (firstIndex != -1) {
                
                Servico elementAt = DadosServico.retornaServicoIndex(firstIndex);
                
                this.numServico.setText("OS: "+elementAt.getNumServico());
                this.nomeCliente.setText("Nome: "+elementAt.getNomeServico());
                this.telefoneCliente.setText("Telefone: "+elementAt.getTelefoneServico());
                this.dataChegada.setText("Data chegada: "+elementAt.getDataChegada());
                this.dataSaida.setText("Data saída: "+elementAt.getDataSaida());
                //this.precoItem.setText(Double.toString(elementAt.getPreco()));
                //this.quantItem.setText(Integer.toString(elementAt.getQuant()));
                
                //tela.setLastIndex(firstIndex);
            }
        });
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//repensar isso

        this.principal = new JPanel();
        this.principal.setLayout(new BorderLayout());
        this.principal.setLayout(new GridLayout(2, 0));
        
        this.principal.add(painelGerencia(), BorderLayout.CENTER);
        this.principal.add(painelServicos());
        
        this.add(principal);
        
        this.setSize(600, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
    }
    
    private JPanel painelServicos()
    {
        JPanel painelProd = new JPanel();
        painelProd.setBorder(BorderFactory.createTitledBorder("Lista de Serviços"));
        JScrollPane scroll= new JScrollPane (listaServico);
        
        painelProd.add(scroll);
        
        return painelProd;
    }
    
    private JPanel painelGerencia()
    {
        JPanel painelGer = new JPanel();
        painelGer.setBorder(BorderFactory.createTitledBorder("Informações da Ordem de Serviço"));
        painelGer.setLayout(new GridLayout(6, 0));
        
        painelGer.add(numServico);
        painelGer.add(nomeCliente);
        painelGer.add(telefoneCliente);
        painelGer.add(dataChegada);
        painelGer.add(dataSaida);
        
        JPanel botoesGer = new JPanel();//Fazer as funcionalidades realizar orçamento e direcionar o Serviço para a lista de feitos e de sem concerto
        
        //botoesGer.setLayout(new GridLayout(0, 5));

        JButton btAdicionar = new JButton("Add. Feito");//vale a pena implementar isso?
        btAdicionar.addActionListener(a->{
            
            this.setVisible(false);//cambiarra
            new TelaTecnico();
        });
        botoesGer.add(btAdicionar);

        JButton btEditar = new JButton(" Add. Sem Manutenção");
        btEditar.addActionListener(c->{
            
            this.setVisible(false);//cambiarra
            new TelaTecnico();
            
        });
        botoesGer.add(btEditar);
        
        JButton btRemover = new JButton("Add. Orçamento");
        btRemover.addActionListener(b->{
            
            int selectedIndex = listaServico.getSelectedIndex();
                    
            if(selectedIndex != -1)
            {
                Servico selectedServico = DadosServico.retornaServicoIndex(selectedIndex);
                
                

                //selectedItem.setNome(nomeItem.getText());
                //selectedItem.setPreco(Double.parseDouble(precoItem.getText()));
                //selectedItem.setQuant(Integer.parseInt(quantItem.getText()));
                
                
                
                this.setVisible(false);//cambiarra
                new TelaTecnico();
            }
        });
        botoesGer.add(btRemover);
        
        JButton btLimpar = new JButton("Limpar");
        //btnLimpar.addActionListener(new LimparFormulario(this));
        btLimpar.addActionListener(d->{
            this.numServico.setText("OS: ");
            this.nomeCliente.setText("Nome: ");
            this.telefoneCliente.setText("Telefone: ");
            this.dataChegada.setText("Data chegada: ");
            this.dataSaida.setText("Data saída: ");
        });
        botoesGer.add(btLimpar);
        
        JButton btSair = new JButton("Sair");
        btSair.addActionListener(d->{
            this.setVisible(false);
            new TelaInicial();
        });
        botoesGer.add(btSair);
        
        painelGer.add(botoesGer);
        
        return painelGer;
    }
}
