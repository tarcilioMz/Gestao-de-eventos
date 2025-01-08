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

    static JLabel tema, tb, st;
    static JButton salvar, cancelar;
    static JComboBox<String> sts;
    static JRadioButton op1, op2;
    static JPanel p1, p2, p3, p4, p5;
    static TelaUpdate instar;

    public TelaUpdate() {
        instar = this;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 300);
        tema = new JLabel("Actualização da Inscrição");
        tb = new JLabel("Tipo de Bilhete ");
        st = new JLabel("Status da Inscrição");
        p1 = new JPanel();
        p1.add(tema);

        op1 = new JRadioButton("VIP");
        op2 = new JRadioButton("Normal");
        ButtonGroup group = new ButtonGroup();
        group.add(op1);
        group.add(op2);
        p2 = new JPanel();
        p2.add(tb);
        p2.add(op1);
        p2.add(op2);
        
        String[] stts = {"Confirmado", "Pendente", "Cancelado"};
        sts = new JComboBox<>(stts);
        p3 = new JPanel();
        p3.add(st);
        p3.add(sts);
        
        add(p1, BorderLayout.NORTH);
        p4 = new JPanel(new BorderLayout());
        p4.add(p2, BorderLayout.NORTH);
        p4.add(p3, BorderLayout.CENTER);
        add(p4, BorderLayout.CENTER);
        
        salvar = new JButton("Guardar");
        cancelar = new JButton("Cancelar");
        cancelar.setActionCommand(cancelar.getText());
        cancelar.addActionListener(new TelaUpdateEH());
        salvar.setActionCommand(salvar.getText());
        salvar.addActionListener(new TelaUpdateEH());
        p5 = new JPanel();
        p5.add(cancelar);
        p5.add(salvar);
        add(p5, BorderLayout.SOUTH);
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
        instar.setVisible(false);
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
