package modell.DAO;

import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import modell.Eventos;

public class EventosDAO {

    private Connection connection;

    public EventosDAO() {

        try {
            this.connection = BDConnection.getConnection();

        } catch (SQLException | ClassNotFoundException ex) {
            //Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Método criado para guardar eventos na database Mysql
    public void guardarEvento(Eventos evento) {
        String sql = "INSERT INTO evento (nome,localizacao,data_,organizadores) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, evento.getNomeEvento());
            ps.setString(2, evento.getLocalEvento());
            // Tratar as datas para que entrem corretamente na base de Dados
            ps.setDate(3, evento.getDataEvento());
            ps.setString(4, evento.getOrganizadores());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Eventos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
