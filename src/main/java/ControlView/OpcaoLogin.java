/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlView;

import View.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Gabriel Mattos
 */
public class OpcaoLogin implements ActionListener
{
    Tela tela;

    public OpcaoLogin(Tela tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new TelaLogin();
        tela.setVisible(false);//faz a tela ficar oculta após o comando acontecer


    }
}
