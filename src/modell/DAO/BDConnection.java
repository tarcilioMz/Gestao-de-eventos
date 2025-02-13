/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modell.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Muzime
 */
public class BDConnection {

    private String Host;
    private String BD;
    private String user;
    private String password;
    private String porta;

    public BDConnection() {
        this.Host = "localhost"; // 127.0.0.1 = localhost
        this.porta = "3306";
        this.BD = "gestaoeventos";
        this.user = "root";
        this.password = "4567"; // use your own
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        BDConnection bDconexao = new BDConnection();
        return DriverManager.getConnection("jdbc:mysql://" + bDconexao.Host + ":" + bDconexao.porta + "/" + bDconexao.BD + "?user=" + bDconexao.user + "&password=" + bDconexao.password + "&noAccessToProcedureBodies=true");
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String Host) {
        this.Host = Host;
    }

    public String getBD() {
        return BD;
    }

    public void setBD(String BD) {
        this.BD = BD;
    }

    public String getUser() {
        return user;
    }
}
