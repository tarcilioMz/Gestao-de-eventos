/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modell.DAO;

import modell.Inscricoes;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muzime
 */
public class InscricoesDAO {

    private Connection conexao;
    private ArrayList<Inscricoes> inscritos;
    private ArrayList<Inscricoes> inscritosTodos;
    private ArrayList<String> eventos;

    public InscricoesDAO() {
        try {
            this.conexao = BDConnection.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(InscricoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Inscricoes> inscritosPorNome(String nomeEvento) {
        try {
            inscritos = new ArrayList<>();
            String sql = "Select * from incricoes where nomeEvento=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nomeEvento);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscricoes inscricao = new Inscricoes();
                inscricao.setId_Evento(rs.getInt("id_Evento"));
                inscricao.setId_Participante(rs.getInt("id_Participante"));
                inscricao.setNomeEvento(rs.getString("nomeEvento"));
                inscricao.setNomeParticipante(rs.getString("nomeParticipante"));
                inscricao.setStatus(rs.getString("statusIncricao"));
                inscricao.setTipo_Bilhete(rs.getString("tipo_bilhete"));
                java.sql.Date sqlDate = rs.getDate("dataIncricao");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = sdf.format(sqlDate);
                inscricao.setDataInscricao(formattedDate);
                inscritos.add(inscricao);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InscricoesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }return inscritos;

    }
    public ArrayList<Inscricoes> inscritosPorNomeConfirmados(String nomeEvento) {
        try {
            inscritos = new ArrayList<>();
            String sql = "Select * from incricoes where nomeEvento=? and statusIncricao=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nomeEvento);
            ps.setString(2,"Confirmado");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscricoes inscricao = new Inscricoes();
                inscricao.setId_Evento(rs.getInt("id_Evento"));
                inscricao.setId_Participante(rs.getInt("id_Participante"));
                inscricao.setNomeEvento(rs.getString("nomeEvento"));
                inscricao.setNomeParticipante(rs.getString("nomeParticipante"));
                inscricao.setStatus(rs.getString("statusIncricao"));
                inscricao.setTipo_Bilhete(rs.getString("tipo_bilhete"));
                java.sql.Date sqlDate = rs.getDate("dataIncricao");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = sdf.format(sqlDate);
                inscricao.setDataInscricao(formattedDate);
                inscritos.add(inscricao);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InscricoesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }return inscritos;

    }

    public ArrayList<Inscricoes> inscritosTodos() {
        ArrayList<Inscricoes> inscritosTodos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM incricoes";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscricoes inscricao = new Inscricoes();
                inscricao.setId_Evento(rs.getInt("id_Evento"));
                inscricao.setId_Participante(rs.getInt("id_Participante"));
                inscricao.setNomeEvento(rs.getString("nomeEvento"));
                inscricao.setNomeParticipante(rs.getString("nomeParticipante"));
                inscricao.setStatus(rs.getString("statusIncricao"));
                inscricao.setTipo_Bilhete(rs.getString("tipo_bilhete"));
                java.sql.Date sqlDate = rs.getDate("dataIncricao");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = sdf.format(sqlDate);
                inscricao.setDataInscricao(formattedDate);
                inscritosTodos.add(inscricao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InscricoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inscritosTodos;
    }

    public ArrayList<String> eventos() {
        try {
            eventos = new ArrayList<>();
            String sql = "SELECT DISTINCT nomeEvento FROM incricoes";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                eventos.add(rs.getString("nomeEvento"));

            }
            return eventos;
        } catch (SQLException ex) {
            Logger.getLogger(InscricoesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }

    }
    public boolean updateInscricao(Inscricoes inscricoes){
        try {
            String sql= "Update incricoes SET tipo_bilhete=?, statusIncricao=? where nomeEvento=? and nomeParticipante=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, inscricoes.getTipo_Bilhete());
            ps.setString(2, inscricoes.getStatus());
            ps.setString(3, inscricoes.getNomeEvento());
            ps.setString(4, inscricoes.getNomeParticipante());
           int rowsAffected= ps.executeUpdate();
           return rowsAffected>0;
        } catch (SQLException ex) {
            Logger.getLogger(InscricoesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
}
