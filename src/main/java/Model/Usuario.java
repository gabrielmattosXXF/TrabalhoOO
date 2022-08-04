/*
Augusto de Fillippo Cavalini-202165514B 

Gabriel Mattos-202165503B 

Luiz Gustavo Ferreira Nazareth-202165515B 
*/
package Model;

/**
 *
 * @author Gabriel Mattos
 */
public abstract class Usuario implements Comparable<Usuario>
{
    private String nomeUsuario;
    private String login;
    private String senha;
    private String nivelDeAcesso;

    public Usuario(String nomeUsuario, String login, String senha, String nivelDeAcesso) throws Exception {
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(String nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public boolean verificaLogin(String loginDigitado, String senhaDigitada)
    {
        return this.senha.equals(senhaDigitada) && this.login.equals(loginDigitado);
    }

    @Override
    public int compareTo(Usuario outro) {
        if(nivelDeAcesso.equalsIgnoreCase(outro.nivelDeAcesso))
        {
            return nomeUsuario.compareToIgnoreCase(outro.nomeUsuario);
        }
        else
        {
            return nivelDeAcesso.compareToIgnoreCase(outro.nivelDeAcesso);
        }
    }
    
    @Override
    public abstract String toString();
}
