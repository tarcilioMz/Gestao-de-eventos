/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VIEW;

import Controller.TelaUpdateEH;
import java.awt.BorderLayout;
import javax.swing.*;
import modell.Inscricoes;

/**
 *
 * @author Muzime
 */
public class TelaUpdate extends JFrame {

    static JLabel tema, tipoBilhete, statusIncricao;
    static JButton salvar, cancelar;
    static JComboBox<String> sts;
    static JRadioButton op1, op2;
    static JPanel painelTema, painelRadio, painelSelect, painelPrinc, painelBtns;
    static TelaUpdate instancia;

    public TelaUpdate() {
        // Instancia da classe
        instancia = this;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 300);
        tema = new JLabel("Actualização da Inscrição");
        tipoBilhete = new JLabel("Tipo de Bilhete ");
        statusIncricao = new JLabel("Status da Inscrição");
        painelTema = new JPanel();
        painelTema.add(tema);

        op1 = new JRadioButton("VIP");
        op2 = new JRadioButton("Normal");
        ButtonGroup group = new ButtonGroup();
        group.add(op1);
        group.add(op2);
        painelRadio = new JPanel();
        painelRadio.add(tipoBilhete);
        painelRadio.add(op1);
        painelRadio.add(op2);

        String[] statusOps = {"Confirmado", "Pendente", "Cancelado"};
        sts = new JComboBox<>(statusOps);
        painelSelect = new JPanel();
        painelSelect.add(statusIncricao);
        painelSelect.add(sts);

        add(painelTema, BorderLayout.NORTH);
        painelPrinc = new JPanel(new BorderLayout());
        painelPrinc.add(painelRadio, BorderLayout.NORTH);
        painelPrinc.add(painelSelect, BorderLayout.CENTER);
        add(painelPrinc, BorderLayout.CENTER);

        // Criação e config. dos Botões da Janela
        salvar = new JButton("Guardar");
        cancelar = new JButton("Cancelar");
        cancelar.setActionCommand(cancelar.getText());
        cancelar.addActionListener(new TelaUpdateEH());
        salvar.setActionCommand(salvar.getText());
        salvar.addActionListener(new TelaUpdateEH());
        painelBtns = new JPanel();
        painelBtns.add(cancelar);
        painelBtns.add(salvar);
        add(painelBtns, BorderLayout.SOUTH);
        setVisible(true);

    }

    public static void carregaDados(Inscricoes inscricoes) {
        if ("VIP".equals(inscricoes.getTipo_Bilhete())) {
            op1.setSelected(true);
        } else {
            op2.setSelected(true);
        }
        sts.setSelectedItem(inscricoes.getStatus());

    }

    public static void setVisibleOff() {
        instancia.setVisible(false);
    }

    public static Inscricoes devolveDados() {
        Inscricoes i = new Inscricoes();
        i = Tela.getCurrent();
        if (op1.isSelected()) {
            i.setTipo_Bilhete(op1.getText());
        } else {
            i.setTipo_Bilhete(op2.getText());
        }
        i.setStatus((String) sts.getSelectedItem());

        return i;
    }

}
