/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Gabriel Mattos
 */
public class Administrador extends Usuario
{
    public Administrador(String nomeUsuario, String login, String senha) {
        super(nomeUsuario, login, senha, "Administrador");
    }

    @Override
    public String toString()
    {
        return "Administrador " + getNomeUsuario()+'\n'+"Login: "+getLogin()+'\n'+"Senha: "+getSenha();
    }
}
