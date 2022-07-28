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
public class TelaTecnico extends JFrame implements Tela
{
    /*
    fazendo a JList que aparecerá no canto esuqerdo conter apenas os nomes dos produtos. ao acessar um dos produtos pela seleção, retornará essa string, que servirá para buscar esse produto no estoque e realizar as alterações nele
    */
    
    JPanel principal;
    JPanel painelGerencia;
    JPanel painelBotoes;
    JPanel painelInsercao;
    
    
    private JLabel numServico = new JLabel("OS:");
    private JLabel nomeCliente = new JLabel("Nome:");
    private JLabel telefoneCliente = new JLabel("Telefone:");
    private JLabel dataChegada = new JLabel("Data entrada:");
    private JLabel dataSaida = new JLabel("Data saida:");
    
    private JLabel marca = new JLabel("Marca:");
    private JLabel modelo = new JLabel("Modelo:");
    private JLabel serial = new JLabel("Serial:");
    private JLabel observacaovendedor = new JLabel("Observacao do vendedor:");

    private JLabel defeito = new JLabel("Defeito:");
    private JLabel reparo = new JLabel("Reparo:");
    private JLabel observacao = new JLabel("Observacao:");
    
    
    private JTextField tfDefeito;
    private JTextField tfReparo;
    private JTextField tfObservacao;
    private JTextField tfPreco;
    
    private JLabel preco = new JLabel("Preço:");
    
    private JList listaServico = new JList (DadosServico.imprimeServico().toArray());
    
    public TelaTecnico()
    {
        super("Tela Técnico");
        
        //DefaultListModel<Item> model = new DefaultListModel<>();
        
        listaServico.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
        
        tfDefeito = new JTextField(15);
        tfReparo = new JTextField(15);
        tfObservacao = new JTextField(15);
        tfPreco = new JTextField(15);
        
        listaServico.addListSelectionListener(a->{
            int firstIndex = listaServico.getSelectedIndex();

            if (firstIndex != -1) {
                
                Servico elementAt = DadosServico.retornaServicoIndex(firstIndex);
                
                this.numServico.setText("OS: "+elementAt.getNumServico());
                this.nomeCliente.setText("Nome: "+elementAt.getNomeServico());
                this.telefoneCliente.setText("Telefone: "+elementAt.getTelefoneServico());
                this.dataChegada.setText("Data entrada: "+elementAt.getDataChegada());
                this.dataSaida.setText("Data saída: "+elementAt.getDataSaida());
                
                this.marca.setText("Marca: "+elementAt.getAparelho().getMarca());
                this.modelo.setText("Modelo: "+elementAt.getAparelho().getModelo());
                this.serial.setText("Serial: "+elementAt.getAparelho().getSerial());
                //this.observacaovendedor.setText("Observação do vendedor: " + elementAt.getObservacaoVendedor());
                
                this.tfDefeito.setText(elementAt.getAparelho().getDefeito());
                this.tfReparo.setText(elementAt.getAparelho().getReparo());
                this.tfObservacao.setText(elementAt.getAparelho().getObservacao());
                this.tfPreco.setText(elementAt.getPreco().toString());
                
                painelGerencia.revalidate();
                painelGerencia.repaint();
                
                painelInsercao.revalidate();
                painelInsercao.repaint();
                
            }
        });
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//repensar isso

        this.principal = new JPanel();
        this.principal.setLayout(new BorderLayout());
        this.principal.setLayout(new GridLayout(2, 2));
        
        this.painelBotoes=painelBotoes();
        this.painelGerencia=painelGerencia();
        this.painelInsercao=painelInsercao();
        
        this.principal.add(painelGerencia, BorderLayout.CENTER);
        this.principal.add(painelServicos());
        this.principal.add(painelInsercao, BorderLayout.CENTER);
        this.principal.add(painelBotoes, BorderLayout.CENTER);
        
        this.add(principal);
        
        this.setSize(650, 600);
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
    
    private JPanel painelBotoes()
    {
        JPanel botoesGer = new JPanel();//Fazer as funcionalidades realizar orçamento e direcionar o Serviço para a lista de feitos e de sem concerto
        
        botoesGer.setLayout(new GridLayout(5, 0));

        JButton btAdicionar = new JButton("Add. Feito");//vale a pena implementar isso?
        btAdicionar.addActionListener(a->{
            
            this.setVisible(true);//cambiarra
            new TelaTecnico();
            painelGerencia.removeAll();
            painelGerencia.revalidate();
            painelGerencia.repaint();
        });
        botoesGer.add(btAdicionar);

        JButton btEditar = new JButton(" Add. Sem Manutenção");
        btEditar.addActionListener(c->{
            
            this.setVisible(true);//cambiarra
            new TelaTecnico();
            painelGerencia.removeAll();
            painelGerencia.revalidate();
            painelGerencia.repaint();
            
        });
        botoesGer.add(btEditar);
        
        JButton btRemover = new JButton("Add. Orçamento");
        btRemover.addActionListener(b->{
            
            int selectedIndex = listaServico.getSelectedIndex();
                    
            if(selectedIndex != -1)
            {
                Servico selectedServico = DadosServico.retornaServicoIndex(selectedIndex);
                
                selectedServico.getAparelho().setDefeito(defeito.getText());
                selectedServico.getAparelho().setReparo(reparo.getText());
                selectedServico.getAparelho().setObservacao(observacao.getText());
                selectedServico.setPreco(Double.parseDouble(preco.getText()));
                
                this.setVisible(true);//cambiarra
                new TelaTecnico();
                painelGerencia.removeAll();
                painelGerencia.revalidate();
                painelGerencia.repaint();
            }
        });
        botoesGer.add(btRemover);
        
        JButton btLimpar = new JButton("Limpar");
        btLimpar.addActionListener(d->{
            this.numServico.setText("OS:  ");
            this.nomeCliente.setText("Nome: ");
            this.telefoneCliente.setText("Telefone: ");
            this.dataChegada.setText("Data entrada: ");
            this.dataSaida.setText("Data saída: ");
            this.marca.setText("Marca: ");
            this.modelo.setText("Modelo: ");
            this.serial.setText("Serial: ");
            this.serial.setText("Observação do vendedor: ");
            painelGerencia.revalidate();
            painelGerencia.repaint();
            
            this.tfDefeito.setText("");
            this.tfReparo.setText("");
            this.tfObservacao.setText("");
            this.tfPreco.setText("");
            
            
        });
        botoesGer.add(btLimpar);
        
        JButton btSair = new JButton("Sair");
        btSair.addActionListener(d->{
            this.setVisible(false);
            new TelaInicial();
        });
        botoesGer.add(btSair);
        
        return botoesGer;
    }
    
    private JPanel painelInsercao()
    {
        JPanel painelInsercao = new JPanel();
        
        JPanel gerDefeito = new JPanel();
        gerDefeito.add(defeito);
        gerDefeito.add(tfDefeito);
        
        JPanel gerReparo = new JPanel();
        gerReparo.add(reparo);
        gerReparo.add(tfReparo);
        
        JPanel gerObservacao = new JPanel();
        gerObservacao.add(observacao);
        gerObservacao.add(tfObservacao);
        
        JPanel gerPreco = new JPanel();
        gerPreco.add(preco);
        gerPreco.add(tfPreco);
        
        painelInsercao.add(gerDefeito);
        painelInsercao.add(gerReparo);
        painelInsercao.add(gerObservacao);
        painelInsercao.add(gerPreco);
        
        return painelInsercao;
    }
    
    private JPanel painelGerencia()
    {
        JPanel painelGer = new JPanel();
        painelGer.setBorder(BorderFactory.createTitledBorder("Informações da Ordem de Serviço"));
        painelGer.setLayout(new GridLayout(13, 0));
        
        painelGer.add(numServico);
        painelGer.add(nomeCliente);
        painelGer.add(telefoneCliente);
        painelGer.add(dataChegada);
        painelGer.add(dataSaida);
        
        painelGer.add(marca);
        painelGer.add(modelo);
        painelGer.add(serial);
        painelGer.add(observacaovendedor);
        
        return painelGer;
    }
}
