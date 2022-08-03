/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Util.Arquivo;
import Util.JSONAdministrador;
import Util.JSONTecnico;
import Util.JSONVendedor;
import java.util.*;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
//import java.awt.*;

/**
 *
 * @author Gabriel Mattos
 */
public class DadosUsuario 
{
    private static List<Usuario> dadosLogin = new ArrayList<>();
    
    static
    {
        try {
            String lerArquivoAdm = Arquivo.lerArquivo("dadosAdministrador.txt");
            List<Administrador> dadosAdministrador = JSONAdministrador.toDadosAdministrador(lerArquivoAdm);
            for(Administrador adm : dadosAdministrador)
            {
                dadosLogin.add(adm);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Pasta nao encontrada!");
        }
        
        try
        {
            String lerArquivoTecnico = Arquivo.lerArquivo("dadosTecnico.txt");
            List<Tecnico> dadosTecnico = JSONTecnico.toDadosTecnico(lerArquivoTecnico);
            for(Tecnico tec : dadosTecnico)
            {
                dadosLogin.add(tec);
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("Pasta nao encontrada!");
        }
        
        try
        {
            String lerArquivoVendedor = Arquivo.lerArquivo("dadosVendedor.txt");
            List<Vendedor> dadosVendedor = JSONVendedor.toDadosVendedor(lerArquivoVendedor);
            for(Vendedor vend : dadosVendedor)
            {
                dadosLogin.add(vend);
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("Pasta nao encontrada!");
        }
        
        Collections.sort(dadosLogin);
        if(dadosLogin.isEmpty())
        {
            try
            {
             dadosLogin.add(new Administrador("Luiz Gustavo Ferreira Nazareth", "luizgustavonazareth4@gmail.com", "12345678"));
             dadosLogin.add(new Administrador("Gabriel Mattos", "gabrielmattos@gmail.com", "12345678"));
             dadosLogin.add(new Administrador("Augusto de Filippo Cavalini", "augustocavalini@gmail.com", "12345678"));
             dadosLogin.add(new Tecnico("Yuri Freitas Toledo", "yuritoledo@gmail.com", "12345678"));
             dadosLogin.add(new Vendedor("Marina Civinelli Gomes Facio", "marinacivinelli@gmail.com", "12345678"));
            }
            catch(Exception ex)
            {
               JOptionPane.showMessageDialog(null, "Login Inválido. Tente novamente.");
            }
            Collections.sort(dadosLogin);
        }
    }
    
    public static List getDadosLogin()
    {
        return dadosLogin;
    }
    
    public static String NivelAcessoLogin(String login, String senha)
    {
        for(Usuario user : dadosLogin)
        {
            if(user.verificaLogin(login, senha))
            {
                return user.getNivelDeAcesso();
            }
        }
        return ("null");
    }
            
    public static boolean validaLogin(String login, String senha)
    {
        for(Usuario user : dadosLogin)
        {
            if(user.verificaLogin(login, senha))
            {
                return true;
            }
        }
        return false;
    }
    
    public static boolean verificaLoginInicializado(String login)
    {
        for(Usuario user : dadosLogin)
        {
            if(user.getLogin().equals(login))
                return true;
            
        }
        return false;
    }
    
    public static void adicionaLogin(Usuario user)
    {
        dadosLogin.add(user);
        Collections.sort(dadosLogin);
    }
    
    public static Usuario retornaUsuario(String loginDigitado, String senhaDigitada)
    {
        for(Usuario user : dadosLogin)
        {
            if(user.verificaLogin(loginDigitado, senhaDigitada))
            {
                return user;
            }
        }
        
        return null;

    }
    
    public static List imprimeFuncionario(int i)
    {
        List <String> listaFuncionario = new ArrayList<>();
        
        if(i==0)
        {
            for(Usuario user : dadosLogin)
            {
                if(user.getNivelDeAcesso().equalsIgnoreCase("Administrador"))
                
                    listaFuncionario.add(user.getNomeUsuario());
            }
        }
        else if(i==1)
        {
            for(Usuario user : dadosLogin)
            {
                if(user.getNivelDeAcesso().equalsIgnoreCase("Tecnico"))
                    listaFuncionario.add(user.getNomeUsuario());
            }            
        }
        else if(i==2)
        {
            for(Usuario user : dadosLogin)
            {
                if(user.getNivelDeAcesso().equalsIgnoreCase("Vendedor"))
                    listaFuncionario.add(user.getNomeUsuario());
            }            
        }
        
        if(listaFuncionario.isEmpty())
        {
            listaFuncionario.add("Não há funcionários cadastrados");
        }
        
        return listaFuncionario;
    }
    
    public static void removeFuncionario(int index)
    {
        dadosLogin.remove(index);
    }
    
    public static String imprimeUsuarioIndex(int index)
    {
        return dadosLogin.get(index).toString();
    }
    
    public static int indexLastAdm()
    {
        int i;
        for(i=0; i<dadosLogin.size(); i++)
        {
            if(dadosLogin.get(i).getNivelDeAcesso().equalsIgnoreCase("Administrador"))
            {
                if(dadosLogin.get(i+1).getNivelDeAcesso().equalsIgnoreCase("Tecnico") || dadosLogin.get(i+1).getNivelDeAcesso().equalsIgnoreCase("Vendedor"))
                {
                    return i;
                }
            }
        }
        
        return 0;
    }
    
    public static int indexLastTec()
    {
        int i;
        for(i=0; i<dadosLogin.size(); i++)
        {
            if(dadosLogin.get(i).getNivelDeAcesso().equalsIgnoreCase("Administrador"))
            {
                if(dadosLogin.get(i+1).getNivelDeAcesso().equalsIgnoreCase("Vendedor"))
                {
                    return i;
                }
            }
            else if(dadosLogin.get(i).getNivelDeAcesso().equalsIgnoreCase("Tecnico"))
                {
                    if(dadosLogin.get(i+1).getNivelDeAcesso().equalsIgnoreCase("Vendedor"))
                    {
                        return i;
                    }
                } 
            
        }
        
        return 0;
    }
}