/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.DadosServico;
import Model.DadosUsuario;
import Model.Estoque;
import Model.Item;
import Model.Servico;
import Model.Usuario;
import Util.Arquivo;
import Util.JSONItens;
import Util.JSONLogins;
import Util.JSONServicos;
import View.Tela;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Mattos
 */
public class EventoJanela implements WindowListener
{
    Tela tela;

    public EventoJanela(Tela tela) {
        this.tela = tela;
    }
    
    @Override
    public void windowOpened(WindowEvent e)
    {
        
    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        List<Usuario> dadosLogin=DadosUsuario.getDadosLogin();
        String toJSONLogin = JSONLogins.toJSON(dadosLogin);
        Arquivo.escreverArquivo("dadosLogin", toJSONLogin);
        
        List<Item> estoqueMercadoria=Estoque.getEstoqueMercadoria();
        String toJSONItem = JSONItens.toJSON(estoqueMercadoria);
        Arquivo.escreverArquivo("estoqueMercadoria", toJSONItem);
        
        List<Servico> dadosServico=DadosServico.getDadosServico();
        String toJSONServico = JSONServicos.toJSON(dadosServico);
        Arquivo.escreverArquivo("dadosServico", toJSONServico);
        
        //System.out.println(toJSON);
        //System.out.println("windowClosing");
    }
    
    public void windowClosing()
    {
        List<Usuario> dadosLogin=DadosUsuario.getDadosLogin();
        String toJSONLogin = JSONLogins.toJSON(dadosLogin);
        Arquivo.escreverArquivo("dadosLogin", toJSONLogin);
        
        List<Item> estoqueMercadoria=Estoque.getEstoqueMercadoria();
        String toJSONItem = JSONItens.toJSON(estoqueMercadoria);
        Arquivo.escreverArquivo("estoqueMercadoria", toJSONItem);
        
        List<Servico> dadosServico=DadosServico.getDadosServico();
        String toJSONServico = JSONServicos.toJSON(dadosServico);
        Arquivo.escreverArquivo("dadosServico", toJSONServico);
        
        //System.out.println(toJSON);
        //System.out.println("windowClosing");
    }

    @Override
    public void windowClosed(WindowEvent e)
    {
        
    }

    @Override
    public void windowIconified(WindowEvent e)
    {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e)
    {
        
    }

    @Override
    public void windowActivated(WindowEvent e)
    {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e)
    {
        
    }
    
}
