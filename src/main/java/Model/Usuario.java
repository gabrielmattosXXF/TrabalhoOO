/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Gabriel Mattos
 */
public class Usuario
{
    private String nomeUsuario;
    private String login;
    private String senha;
    private String nivelDeAcesso;

    public Usuario(String nomeUsuario, String login, String senha, String nivelDeAcesso) {
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public String getNomeUsuario()
    {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario)
    {
        this.nomeUsuario = nomeUsuario;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public String getNivelDeAcesso()
    {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(String nivelDeAcesso)
    {
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public boolean verificaLogin(String loginDigitado, String senhaDigitada)
    {
        return this.senha.equals(senhaDigitada) && this.login.equals(loginDigitado);
    }
}
