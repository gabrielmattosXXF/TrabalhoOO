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
    public Tecnico(String nomeUsuario, String login, String senha) {
        super(nomeUsuario, login, senha, "Tecnico");
    }

    @Override
    public String toString() {
        return "Técnico "+getNomeUsuario()+'\n'+"Login: "+getLogin()+'\n'+"Senha: "+getSenha();
    }
}
