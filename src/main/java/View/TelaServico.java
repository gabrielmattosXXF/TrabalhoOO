/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Aparelho;
import Model.Vendedor;
import Model.DadosServico;
import Model.Servico;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author ice
 */
public class TelaServico extends JFrame implements Tela
{
    private JTextField nomeClienteP;
    private JTextField telefoneClienteP;
    
    private JTextField dataChegadaP;//criar tipo Data
    private JTextField dataSaidaP;//criar tipo Data
    
    private JTextField marcaP;
    private JTextField modeloP;
    private JTextField serialP;
    private JTextField observacaoVendedorP;
    private Vendedor vendedor;
    //private JTextField reparoP; serão informadas pelo técnico
    //private JTextField observacaoP;
    //private JTextField precoP;
    
    
    
    public TelaServico(Vendedor vendedor)
    {
        super("Ordem de servico num: "+DadosServico.NumeroDeServicos());
        
        this.vendedor = vendedor;
        this.nomeClienteP = new JTextField(50);
        this.telefoneClienteP = new JTextField(50);
        this.dataChegadaP = new JTextField(50);
        this.dataSaidaP = new JTextField(50);
        
        this.marcaP = new JTextField(50);
        this.modeloP = new JTextField(50);
        this.serialP = new JTextField(50);
        
        this.observacaoVendedorP = new JTextField(50);
        
        this.setLayout(new BorderLayout());
        this.add(painelCaixaTexto(), BorderLayout.CENTER);
        this.add(painelBotoes(), BorderLayout.SOUTH);
        
        this.setSize(350, 250);//redimensionar tela
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    private JPanel painelCaixaTexto(){

        JPanel caixaTexto = new JPanel();
        caixaTexto.setLayout(new GridLayout(0, 2));
        
        caixaTexto.add(new JLabel("Nome:"));
        caixaTexto.add(this.nomeClienteP);
        caixaTexto.add(new JLabel("Telefone:"));
        caixaTexto.add(this.telefoneClienteP);
        caixaTexto.add(new JLabel("Data de chegada:"));
        caixaTexto.add(this.dataChegadaP);
        caixaTexto.add(new JLabel("Data de saida:"));
        caixaTexto.add(this.dataSaidaP);
        caixaTexto.add(new JLabel("Marca:"));
        caixaTexto.add(this.marcaP);
        caixaTexto.add(new JLabel("Modelo:"));
        caixaTexto.add(this.modeloP);
        caixaTexto.add(new JLabel("Serial:"));
        caixaTexto.add(this.serialP);
        caixaTexto.add(new JLabel("Observação vendedor:"));
        caixaTexto.add(this.observacaoVendedorP);
        
        return caixaTexto;
    }
    
    private JPanel painelBotoes(){

        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(0, 2));
        JButton btConfirmar = new JButton("Confirmar");
        btConfirmar.addActionListener(e->{
            //new CriarServico(this);
            
            String nomeCliente = nomeClienteP.getText();
            String telefoneCliente = telefoneClienteP.getText();//é numero
            String dataChegada = dataChegadaP.getText();//é numero
            String dataSaida = dataSaidaP.getText();//é numero
            String marca = marcaP.getText();
            String modelo = modeloP.getText();
            String serial = serialP.getText();//é numero
            String observacaoVendedor = observacaoVendedorP.getText();

            DadosServico.adicionaServico(new Servico(nomeCliente, telefoneCliente, dataChegada, dataSaida, marca, modelo, serial, observacaoVendedor));

            
            this.setVisible(false);
            new TelaVendedor(vendedor);
        });
        botoes.add(btConfirmar);
        
        JButton btCancelar = new JButton("Cancelar");
        btCancelar.addActionListener(f->{
            this.setVisible(false);
            new TelaVendedor(vendedor);

        });
        botoes.add(btCancelar);
        
        return botoes;
    }
    
    public JTextField getNomeClienteP()
    {
        return nomeClienteP;
    }
    
    public void setNomeClienteP(JTextField nomeClienteP)
    {
        this.nomeClienteP = nomeClienteP;
    }
    
    public JTextField getTelefoneClienteP()
    {
        return telefoneClienteP;
    }
    
    public void setTelefoneClienteP(JTextField telefoneClienteP)
    {
        this.telefoneClienteP = telefoneClienteP;
    }
    
    public JTextField getDataChegadaP()
    {
        return dataChegadaP;
    }
    
    public void setDataChegadaP(JTextField dataChegadaP)
    {
        this.dataChegadaP = dataChegadaP;
    }
            
    public JTextField getDataSaidaP()
    {
        return dataSaidaP;
    }
    
    public void setDataSaidaP(JTextField dataSaidaP)
    {
        this.dataSaidaP = dataSaidaP;
    }
    
    public JTextField getMarcaP()
    {
        return marcaP;
    }
    
    public void setMarcaP(JTextField marcaP)
    {
        this.marcaP = marcaP;
    }
    
    public JTextField getModeloP()
    {
        return modeloP;
    }
    
    public void setModeloP(JTextField modeloP)
    {
        this.modeloP = modeloP;
    }
    
    public JTextField getSerialP()
    {
        return serialP;
    }
    
    public void setSerialP(JTextField serialP)
    {
        this.serialP = serialP;
    }
    
    public JTextField getObservacaoVendedorP()
    {
        return observacaoVendedorP;
    }
    
    public void setObservacaoVendedorP(JTextField observacaoVendedorP)
    {
        this.observacaoVendedorP = observacaoVendedorP;
    }
}
