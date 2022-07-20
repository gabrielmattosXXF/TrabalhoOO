/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Aparelho;
import ControlView.CriarServico;
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
    
    //boolean autorizacao; fazer um modelo faz se tornar true qnd o botão for selecionado
    
    private JTextField marcaP;
    private JTextField modeloP;
    private JTextField serialP;
    private JTextField defeitoP;
    
    
    
    public TelaServico()
    {
        this.nomeClienteP = new JTextField(50);
        this.telefoneClienteP = new JTextField(50);
        this.dataChegadaP = new JTextField(50);
        this.dataSaidaP = new JTextField(50);
        
        this.marcaP = new JTextField(50);
        this.modeloP = new JTextField(50);
        this.serialP = new JTextField(50);
        this.defeitoP = new JTextField(50);
        
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
        caixaTexto.add(new JLabel("Defeito:"));
        caixaTexto.add(this.defeitoP);
        
        return caixaTexto;
    }
    
    private JPanel painelBotoes(){

        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(0, 2));
        JButton btConfirmar = new JButton("Confirmar");
        btConfirmar.addActionListener(new CriarServico(this));
        botoes.add(btConfirmar);
        
        JButton btCancelar = new JButton("Cancelar");
        //btCancelar.addActionListener(new RetornaInicio(this));//fazer retornar para a tela do administrador
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
    
    public JTextField getmodeloP()
    {
        return modeloP;
    }
    
    public void modeloP(JTextField modeloP)
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
    
    public JTextField getDefeito()
    {
        return defeitoP;
    }
    
    public void setDefeitoP(JTextField defeitoP)
    {
        this.defeitoP = defeitoP;
    }
}