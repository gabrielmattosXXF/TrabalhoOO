/*
Augusto de Fillippo Cavalini-202165514B 

Gabriel Mattos-202165503B 

Luiz Gustavo Ferreira Nazareth-202165515B 
*/
package Model;

import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Gabriel Mattos
 */
public class Vendedor extends Usuario
{
    private List<Item> produtosVendidos=new ArrayList<>();
    private double comissao;
    private double vendatotal;
    
    public Vendedor(String nomeUsuario, String login, String senha)throws Exception
    {
        super(nomeUsuario, login, senha, "Vendedor");
        this.comissao=0;
        this.vendatotal=0;
    }

    public List<Item> getProdutosVendidos() {
        return produtosVendidos;
    }

    public void setProdutosVendidos(List<Item> produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double getVendatotal() {
        return vendatotal;
    }

    public void setVendatotal(double vendatotal) {
        this.vendatotal = vendatotal;
    }


    public List getNomeProdutosVendidos(){

        List<String> nomeprodutosvendidos = new ArrayList<>();
        for(Item item : produtosVendidos)
            {
                    nomeprodutosvendidos.add(item.getNomeItem());
            }
            return nomeprodutosvendidos;
    }
    
    public void computaVenda(Item item, int qntd)
    {        
        try
        {
            if(qntd>item.getQuantItem() || qntd<=0)
            {
                throw new Exception();
            }
            
            Item p1=new Item(item.getNomeItem(),item.getPrecoItem(),qntd);
        
            produtosVendidos.add(p1);
            vendatotal+= item.getPrecoItem()*qntd;
            comissao  += item.getPrecoItem()*qntd*0.05;
            
            item.venda(qntd);
        }
        catch(Exception exception)
        {
            JOptionPane.showMessageDialog(null, "Quantidade inválida. Digite novamente.");
        }
    }
    
    public Item retornaItemIndex(int index)//rever essa função
    {
        return this.produtosVendidos.get(index);
    }
    
    @Override
    public String toString()
    {
        return "Vendedor "+getNomeUsuario()+'\n'+"Login: "+getLogin()+'\n'+"Senha: "+getSenha()+'\n'+"Total Vendas: "+getVendatotal()+'\n'+"Comissão: "+getComissao();
    }
}
