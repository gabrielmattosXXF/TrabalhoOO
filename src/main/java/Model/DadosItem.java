/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.*;

/**
 *
 * @author Gabriel Mattos
 */
public class DadosItem
{
    static DefaultListModel<Item> model = new DefaultListModel<>();
    
    static JList<Item> estoque = new JList<>(model);
}
