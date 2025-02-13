/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VIEW;

import Controller.TelaEH;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import modell.DAO.InscricoesDAO;
import modell.Inscricoes;

/**
 *
 * @author Muzime
 */
public class Tela extends JFrame {

    static JLabel titulo, titulo2, titulo3;
    static JComboBox<String> jcb;
    static ArrayList<Inscricoes> inscritosTodos;
    static ArrayList<String> eventos;
    static JScrollPane jscp;
    static JTable table;
    static DefaultTableModel model;
    static DefaultComboBoxModel<String> cbxModel;
    static JButton updBtn;
    static JPanel painelTitulo, painelNorte, pC, pP, pS;
    static InscricoesDAO inscricoesDAO;

    public Tela() {
        // configurações essencias da Janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 600);
        titulo = new JLabel("Menu de gerenciamento de inscrições");
        painelTitulo = new JPanel();
        painelTitulo.add(titulo);

        add(painelTitulo, BorderLayout.NORTH);
        titulo2 = new JLabel("Selecione o evento");
        titulo3 = new JLabel("Inscrições do evento:");

        cbxModel = new DefaultComboBoxModel<>();
        inscricoesDAO = new InscricoesDAO();
        //inscritosTodos.addAll(inscricoesDAO.inscritosTodos());
        model = new DefaultTableModel();
        model.addColumn("Nome do Evento");
        model.addColumn("Nome do Participante");
        model.addColumn("Data de Inscrição");
        model.addColumn("Tipo de Bilhete");
        model.addColumn("Status da Inscrição");
        eventos = new ArrayList<>();
        eventos.addAll(inscricoesDAO.eventos());
        cbxModel.addAll(eventos);

        table = new JTable(model);
        jscp = new JScrollPane(table);
        jscp.setBorder(new BevelBorder(BevelBorder.RAISED));
        jcb = new JComboBox(cbxModel);
        String act = (String) jcb.getSelectedItem();
        System.out.println(act);

        jcb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (String ev : eventos) {
                    if (jcb.getSelectedItem().equals(ev)) {
                        recarregaInscritosPorEvento(ev);
                        break;
                    }
                }
            }
        });

        updBtn = new JButton("Atualizar inscrição");
        updBtn.setActionCommand(updBtn.getText());
        updBtn.addActionListener(new TelaEH());
        JButton gerarBtn = new JButton("Gerar Relatório do Evento");
        gerarBtn.setActionCommand(gerarBtn.getText());
        gerarBtn.addActionListener(new TelaEH());
        pS = new JPanel();
        pS.add(updBtn);

        pS.add(gerarBtn);

        // O painel Norte carrega O JComboBox assim como o label que o corresponde
        painelNorte = new JPanel();
        painelNorte.add(titulo2);
        painelNorte.add(jcb);
        pC = new JPanel(new BorderLayout());
        pC.add(titulo3);
        pC.add(jscp);
        pP = new JPanel(new BorderLayout());
        pP.add(painelNorte, BorderLayout.NORTH);
        pP.add(pC, BorderLayout.CENTER);
        add(pP, BorderLayout.CENTER);
        add(pS, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void recarregaInscritosPorEvento(String evento) {
        model.setRowCount(0);
        inscricoesDAO = new InscricoesDAO();
        inscritosTodos = new ArrayList<>();
        inscritosTodos.addAll(inscricoesDAO.inscritosPorNome(evento));

        for (Inscricoes ins : inscritosTodos) {
            model.addRow(new Object[]{ins.getNomeEvento(), ins.getNomeParticipante(), ins.getDataInscricao(), ins.getTipo_Bilhete(), ins.getStatus()});
        }
    }

    public static Inscricoes getCurrent() {
        int i = table.getSelectedRow();
        System.out.println(i);
        Inscricoes inscricoes = new Inscricoes();
        inscricoes.setNomeEvento((String) model.getValueAt(i, 0));
        inscricoes.setNomeParticipante((String) model.getValueAt(i, 1));

        inscricoes.setTipo_Bilhete((String) model.getValueAt(i, 3));
        inscricoes.setStatus((String) model.getValueAt(i, 4));
        return inscricoes;
    }

    public static String getEventName() {
        return (String) jcb.getSelectedItem();
    }
}
