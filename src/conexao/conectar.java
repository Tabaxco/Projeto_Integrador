/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectar {
    private static final String URL = "jdbc:mysql://localhost:3306/DAHO";
    private static final String USER = "root";
    private static final String PASSWORD = "rodrigues123";

    public static Connection getConexao() {
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
            
         } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar: " + e.getMessage());
        }
        return null;
    }
}
