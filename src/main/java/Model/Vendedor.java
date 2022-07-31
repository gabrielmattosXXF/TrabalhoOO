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
    private double vendatotal;
    
    public Vendedor(String nomeUsuario, String login, String senha)
    {
        super(nomeUsuario, login, senha, "Vendedor");
    }

    @Override
    public String toString() {
        return "Vendedor "+getNomeUsuario()+'\n'+"Login: "+getLogin()+'\n'+"Senha: "+getSenha();
    }

    public double getcomissao(){
        return comissao;
    }

    public double getvendatotal(){
        return vendatotal;
    }

    public List getprodutosvendidos(){

        List<String> nomeprodutosvendidos = new ArrayList<>();
        for(Item item : produtosVendidos)
            {
                    nomeprodutosvendidos.add(item.getNome());
            }
            return nomeprodutosvendidos;
    }
    
    public void computaVenda(Item item, int qntd)
    {        
        Item p1=new Item(item.getNome(),item.getPreco(),qntd);
        
        produtosVendidos.add(p1);
        vendatotal= item.getPreco()*qntd;
        comissao += item.getPreco()*qntd*0.05;
    }
}
