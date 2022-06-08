/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.*;
import Control.Item;
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
        return "Vendedor "+getNomeUsuario();
    }
    
    public void computaVenda(String nome, double preco, int qntd)
    {        
        Item p1=new Item(nome,preco,qntd);
        
        produtosVendidos.add(p1);
        comissao+=p1.getPreco()*0.05;
    }
}
