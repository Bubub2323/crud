
package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Koneksimysql {
    private Connection connect;
    private String driverName = "com.mysql.jdbc.Driver"; //Driver Untuk koneksi ke MYSQL
    private String jdbc = "jdbc:mysql://";
    private String host = "localhost:"; // bisa menggunakan ip anda, cnth : 192.168.100.100
    private String port = "3306/"; // port ini port mysql
    private String database = "crud3232"; // ini databse yang digunakan
    private String url = jdbc + host + port + database;
    private String username = "root"; // usernmae default mysql
    private String password = "";
    public Connection getKoneksi() throws SQLException {
        if ( connect == null) {
            try {
                Class.forName(driverName);
                System.out.println("Class driver ditemukan");
                try {
                    connect = DriverManager.getConnection(url, username, password);
                    System.out.println("Koneksi database sukses");
                } catch (SQLException se) {
                    System.out.println("Koneksi database gagal : " + se);
                    System.exit(0);
                }
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Class driver tidak ditemukan, terjadi kesalahan : "+ cnfe);
                System.exit(0);
            }
        }
        return connect;
    }

}