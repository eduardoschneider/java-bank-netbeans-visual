package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eduardo.schneider
 */
public class ConnectionFactory {


    Connection con;
    String url = "jdbc:mysql://127.0.0.1/banco";
    String driver = "com.mysql.jdbc.Driver";
    String user = "root";
    String password = "";


    public ConnectionFactory() {
    }

    public Connection conectar(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            System.out.println(con);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Não foi possível encontrar o Driver!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não foi possível conectar ao banco!");
        }
        return con;
    }

    public void desconectar(){
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}