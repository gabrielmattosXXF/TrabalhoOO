/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.*;

/**
 *
 * @author Gabriel Mattos
 */
public class DadosUsuario
{
    private static List<Usuario> dadosLogin = new ArrayList<>();
    
    static
    {
        if(dadosLogin.isEmpty())
        {
             dadosLogin.add(new Administrador("Luiz Gustavo Ferreira Nazareth", "luizgustavonazareth4@gmail.com", "12345678"));
             dadosLogin.add(new Administrador("Gabriel Mattos", "gabrielmattos@gmail.com", "12345678"));
             dadosLogin.add(new Administrador("Augusto de Filippo Cavalini", "augustocavalini@gmail.com", "12345678"));
             dadosLogin.add(new Administrador("Yuri Freitas Toledo", "yuritoledo@gmail.com", "12345678"));
             dadosLogin.add(new Administrador("ugas", "sim", "nao"));
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
    
    public static void imprimelogin()
    {
        for(Usuario user : dadosLogin)
        {
            System.out.println(user);
        }
    }
    public static void adicionaLogin(Usuario user)
    {
        dadosLogin.add(user);
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
    
}
