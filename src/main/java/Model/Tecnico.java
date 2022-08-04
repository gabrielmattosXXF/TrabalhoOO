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
public class Tecnico extends Usuario
{
    public Tecnico(String nomeUsuario, String login, String senha)throws Exception
    {
        super(nomeUsuario, login, senha, "Tecnico");
    }

    @Override
    public String toString()
    {
        return "Técnico "+getNomeUsuario()+'\n'+"Login: "+getLogin()+'\n'+"Senha: "+getSenha();
    }
}
