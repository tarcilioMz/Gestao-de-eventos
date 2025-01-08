/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import VIEW.Tela;
import VIEW.TelaUpdate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import modell.DAO.InscricoesDAO;
import modell.Inscricoes;

/**
 *
 * @author Muzime
 */
public class TelaUpdateEH implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        InscricoesDAO inscricoesDAO = new InscricoesDAO();
        if(e.getActionCommand().equals("Cancelar")){
            TelaUpdate.setVisibleOff();
        }
        if(e.getActionCommand().equals("Guardar")){
            Inscricoes updt = new Inscricoes();
            updt=TelaUpdate.devolveDados();
         boolean sucesso = inscricoesDAO.updateInscricao(updt); 
         if (sucesso) { 
             Tela.recarregaInscritosPorEvento(updt.getNomeEvento());
             JOptionPane.showMessageDialog(null, "Atualização bem-sucedida!", "Sucesso", JOptionPane.INFORMATION_MESSAGE); } 
         else { JOptionPane.showMessageDialog(null, "Erro na atualização.", "Erro", JOptionPane.ERROR_MESSAGE); }
        }
        }
    
}
