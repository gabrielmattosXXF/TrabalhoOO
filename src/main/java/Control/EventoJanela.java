/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Administrador;
import Model.DadosServico;
import Model.DadosUsuario;
import Model.Estoque;
import Model.Item;
import Model.Servico;
import Model.Tecnico;
import Model.Usuario;
import Model.Vendedor;
import Util.Arquivo;
import Util.JSONAdministrador;
import Util.JSONItens;
import Util.JSONServicos;
import Util.JSONTecnico;
import Util.JSONVendedor;
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
        
        List<Administrador> dadosAdministrador = new ArrayList<>();
        List<Tecnico> dadosTecnico = new ArrayList<>();
        List<Vendedor> dadosVendedor = new ArrayList<>();
        for(Usuario user : dadosLogin)
        {
            if(user.getClass().getName()=="Model.Administrador")
            {
                dadosAdministrador.add((Administrador)user);
            }
            else if(user.getClass().getName()=="Model.Tecnico")
            {
                dadosTecnico.add((Tecnico)user);
            }
            else if(user.getClass().getName()=="Model.Vendedor")
            {
                dadosVendedor.add((Vendedor)user);
            }
        }
        String toJSONAdm = JSONAdministrador.toJSON(dadosAdministrador);
        Arquivo.escreverArquivo("dadosAdministrador.txt", toJSONAdm);
        
        String toJSONTec = JSONTecnico.toJSON(dadosTecnico);
        Arquivo.escreverArquivo("dadosTecnico.txtt", toJSONTec);
        
        String toJSONVend = JSONVendedor.toJSON(dadosVendedor);
        Arquivo.escreverArquivo("dadosVendedor.txt", toJSONVend);
        
        List<Item> estoqueMercadoria=Estoque.getEstoqueMercadoria();
        String toJSONItem = JSONItens.toJSON(estoqueMercadoria);
        Arquivo.escreverArquivo("estoqueMercadoria.txt", toJSONItem);
        
        List<Servico> dadosServico=DadosServico.getDadosServico();
        String toJSONServico = JSONServicos.toJSON(dadosServico);
        Arquivo.escreverArquivo("dadosServico.txt", toJSONServico);
    }
    
    public void windowClosing()
    {
        List<Usuario> dadosLogin=DadosUsuario.getDadosLogin();
        
        List<Administrador> dadosAdministrador = new ArrayList<>();
        List<Tecnico> dadosTecnico = new ArrayList<>();
        List<Vendedor> dadosVendedor = new ArrayList<>();
        for(Usuario user : dadosLogin)
        {
            if(user.getClass().getName()=="Model.Administrador")
            {
                dadosAdministrador.add((Administrador)user);
            }
            else if(user.getClass().getName()=="Model.Tecnico")
            {
                dadosTecnico.add((Tecnico)user);
            }
            else if(user.getClass().getName()=="Model.Vendedor")
            {
                dadosVendedor.add((Vendedor)user);
            }
        }
        String toJSONAdm = JSONAdministrador.toJSON(dadosAdministrador);
        Arquivo.escreverArquivo("dadosAdministrador.txt", toJSONAdm);
        
        String toJSONTec = JSONTecnico.toJSON(dadosTecnico);
        Arquivo.escreverArquivo("dadosTecnico.txt", toJSONTec);
        
        String toJSONVend = JSONVendedor.toJSON(dadosVendedor);
        Arquivo.escreverArquivo("dadosVendedor.txt", toJSONVend);
        
        List<Item> estoqueMercadoria=Estoque.getEstoqueMercadoria();
        String toJSONItem = JSONItens.toJSON(estoqueMercadoria);
        Arquivo.escreverArquivo("estoqueMercadoria.txt", toJSONItem);
        
        List<Servico> dadosServico=DadosServico.getDadosServico();
        String toJSONServico = JSONServicos.toJSON(dadosServico);
        Arquivo.escreverArquivo("dadosServico.txt", toJSONServico);
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
