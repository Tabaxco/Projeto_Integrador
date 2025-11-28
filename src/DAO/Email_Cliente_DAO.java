package DAO;

import modelos.Cliente;
import conexao.conectar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Email_Cliente_DAO {

    
    public static int inserir(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Email_Cliente (ID_Cliente, Email) VALUES (?, ?)";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, cliente.getID_Cliente());
            stmt.setString(2, cliente.getEmail());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); 
                }
            }
        }

        return -1; 
    }

    
    public static void atualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE Email_Cliente SET Email = ? WHERE ID_Cliente = ?";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getEmail());
            stmt.setInt(2, cliente.getID_Cliente());

            stmt.executeUpdate();
        }
    }

    
    public static void deletar(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM Email_Cliente WHERE ID_Cliente = ?";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cliente.getID_Cliente());
            stmt.executeUpdate();
        }
    }

    
    public static Cliente buscarUmEmail(Cliente cliente) throws SQLException {
    String sql = "SELECT * FROM Email_Cliente WHERE ID_Cliente = ? LIMIT 1";

    try (Connection conn = conectar.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, cliente.getID_Cliente());

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                cliente.setEmail(rs.getString("Email"));
                return cliente;
            }
        }
    }

    return null; 
}
}