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
public class Vendedor extends Usuario
{
    private List<Item> produtosVendidos=new ArrayList<>();
    private double comissao=0;
    
    public Vendedor(String nomeUsuario, String login, String senha)
    {
        super(nomeUsuario, login, senha, "Vendedor");
    }

    @Override
    public String toString() {
        return "Vendedor "+getNomeUsuario()+'\n'+"Login: "+getLogin()+'\n'+"Senha: "+getSenha();
    }
    
    public void computaVenda(String nome, double preco, int qntd)
    {        
        Item p1=new Item(nome,preco,qntd);
        
        produtosVendidos.add(p1);
        comissao+=p1.getPreco()*0.05;
    }
}
