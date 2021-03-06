/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.*;
import View.*;
import javax.swing.*;
//import java.awt.*;

/**
 *
 * @author Gabriel Mattos
 */
public class DadosUsuario 
{
    private static List<Usuario> dadosLogin = new ArrayList<>();
    
    //vamos implementar um tratamento na lista para armazenar sempre na ordem adm, func e tec;
    
    static
    {
        if(dadosLogin.isEmpty())
        {
             dadosLogin.add(new Administrador("Luiz Gustavo Ferreira Nazareth", "luizgustavonazareth4@gmail.com", "12345678"));
             dadosLogin.add(new Administrador("Gabriel Mattos", "gabrielmattos@gmail.com", "12345678"));
             dadosLogin.add(new Administrador("Augusto de Filippo Cavalini", "augustocavalini@gmail.com", "12345678"));
             dadosLogin.add(new Administrador("Yuri Freitas Toledo", "yuritoledo@gmail.com", "12345678"));
             dadosLogin.add(new Administrador("ugas", "sim", "nao"));
             dadosLogin.add(new Tecnico("lolo", "opa", "opa"));
             dadosLogin.add(new Vendedor("maras", "oi", "oi"));
             
             Collections.sort(dadosLogin);
             
        }
        
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
        return ("é...");
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
    
    public static Usuario retornaUsuario(String loginDigitado, String senhaDigitada)//verificar diminuição de acoplamento aqui
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
                if(user.getNivelDeAcesso()=="Administrador")
                    listaFuncionario.add(user.getNomeUsuario());
            }
        }
        else if(i==1)
        {
            for(Usuario user : dadosLogin)
            {
                if(user.getNivelDeAcesso()=="Tecnico")
                    listaFuncionario.add(user.getNomeUsuario());
            }            
        }
        else if(i==2)
        {
            for(Usuario user : dadosLogin)
            {
                if(user.getNivelDeAcesso()=="Vendedor")
                    listaFuncionario.add(user.getNomeUsuario());
            }            
        }
        
        if(listaFuncionario.isEmpty())
        {
            
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
    
    public static int indexLastAdm() //função só serve se a lista já tiver sido tratada
    {
        int i;
        for(i=0; i<dadosLogin.size(); i++)
        {
            if(dadosLogin.get(i).getNivelDeAcesso()=="Administrador")
            {
                if(dadosLogin.get(i+1).getNivelDeAcesso()=="Tecnico" || dadosLogin.get(i+1).getNivelDeAcesso()=="Vendedor")
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
            if(dadosLogin.get(i).getNivelDeAcesso()=="Administrador")
            {
                if(dadosLogin.get(i+1).getNivelDeAcesso()=="Vendedor")
                {
                    return i;
                }
            }
            else if(dadosLogin.get(i).getNivelDeAcesso()=="Tecnico")
                {
                    if(dadosLogin.get(i+1).getNivelDeAcesso()=="Vendedor")
                    {
                        return i;
                    }
                } 
            
        }
        
        return 0;
    }
}