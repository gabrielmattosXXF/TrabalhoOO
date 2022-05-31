/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Gabriel Mattos
 */
public class Tecnico extends Usuario
{
    public Tecnico(String nomeUsuario, String email, String login, String senha) {
        super(nomeUsuario, login, senha, "Técnico");
    }

    @Override
    public String getNomeUsuario() {
        return super.getNomeUsuario();
    }

    @Override
    public void setNomeUsuario(String nomeUsuario) {
        super.setNomeUsuario(nomeUsuario);
    }

    @Override
    public String getLogin() {
        return super.getLogin();
    }

    @Override
    public void setLogin(String login) {
        super.setLogin(login);
    }

    @Override
    public String getSenha() {
        return super.getSenha();
    }

    @Override
    public void setSenha(String senha) {
        super.setSenha(senha);
    }

    @Override
    public boolean verificaLogin(String loginDigitado, String senhaDigitada) {
        return super.verificaLogin(loginDigitado, senhaDigitada);
    }

    @Override
    public String toString() {
        return "Técnico";
    }
}
