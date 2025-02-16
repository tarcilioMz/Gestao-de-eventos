/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import VIEW.Tela;
import java.sql.Date;
import modell.Eventos;
import modell.DAO.EventosDAO;

/**
 *
 * @author Muzime
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Tela u = new Tela();
        // Seccao de testes de novas funcionalidades
        EventosDAO eventosDAO = new EventosDAO();
        Eventos evento = new Eventos();
        evento.setNomeEvento("DataWave 2024");
        evento.setLocalEvento("Centro Cultural Moçambique-China");
        evento.setDataEvento(Date.valueOf("2024-08-15"));
        evento.setOrganizadores("MozDevz, Vodacom, BCX");
        eventosDAO.guardarEvento(evento);

    }
}
