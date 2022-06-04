/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlVendas;
import ControlVendas.Estoque.*;
import ControlVendas.TelaVendedor;
import Model.Vendedor;

import static ControlVendas.Estoque.diminuiQuantidade;
import static ControlVendas.Estoque.estoqueMercadoria;
import static ControlVendas.Estoque.retornaIndexNome;
import static ControlVendas.Estoque.retornaItem;
import static ControlVendas.Estoque.verificaDispoProd;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;




/**
 *
 * @author Gabriel Mattos
 */
public class Venda
{
    //private static List<Item> ProdutosVendidos = new ArrayList<>();
    
    public static void realizaVenda(String nome,int qntd, Vendedor v)
    {
        if(verificaDispoProd(nome))
        {
            if(qntd<=estoqueMercadoria.get(retornaIndexNome(nome)).getQuant())
            {
                diminuiQuantidade(nome, qntd);
                v.computaVenda(nome ,retornaItem(nome).getPreco(),qntd);
            }
            else
            {
                JOptionPane.showConfirmDialog(null, "Não há estoque suficiente.");
            }
            
        }
        else
        {
            JOptionPane.showConfirmDialog(null, "Não há estoque para o produto informado.");
        }
        
    }
}
