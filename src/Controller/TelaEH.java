/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import VIEW.Tela;
import VIEW.TelaUpdate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modell.DAO.InscricoesDAO;
import modell.Inscricoes;
import modell.Itext.RelatorioConfirmadas;

/**
 *
 * @author Muzime
 */
public class TelaEH implements ActionListener {

    ArrayList<String> eventos;
    InscricoesDAO inscricoesDAO;
    TelaUpdate telaUpdate;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Atualizar inscrição")) {

            telaUpdate = new TelaUpdate();
            Inscricoes i = new Inscricoes();
            i=Tela.getCurrent();
            System.out.println(i.getNomeEvento());
            TelaUpdate.carregaDados(i);
        }
        if(e.getActionCommand().equals("Gerar Relatório do Evento")){
            inscricoesDAO = new InscricoesDAO();
            RelatorioConfirmadas r = new RelatorioConfirmadas();
            r.relatorio(inscricoesDAO.inscritosPorNomeConfirmados(Tela.getEventName()));
        }
    }

}
