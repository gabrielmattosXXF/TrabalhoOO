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
public class Administrador extends Usuario
{
    public Administrador(String nomeUsuario, String login, String senha)throws Exception {
        super(nomeUsuario, login, senha, "Administrador");
    }

    @Override
    public String toString()
    {
        return "Administrador " + getNomeUsuario()+'\n'+"Login: "+getLogin()+'\n'+"Senha: "+getSenha();
    }
}
