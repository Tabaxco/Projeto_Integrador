package DAO;

import modelos.Funcionario;
import conexao.conectar;

import java.sql.*;

public class Funcionario_Telefone_DAO {
    
    
    public static void inserir(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO Funcionario_Telefone (ID_Funcionario, Telefone) VALUES (?, ?)";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, funcionario.getID_Funcionario());
            stmt.setString(2, funcionario.getTelefone());

            stmt.executeUpdate();

        }
    }

    
 
    public static void atualizar(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE Funcionario_Telefone SET Telefone = ? WHERE ID_Funcionario = ?";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getTelefone());
            stmt.setInt(2, funcionario.getID_Funcionario());

            stmt.executeUpdate();
        }
    }

    

    public static void deletar(Funcionario funcionario) throws SQLException {
        String sql = "DELETE FROM Funcionario_Telefone WHERE ID_Funcionario = ?";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, funcionario.getID_Funcionario());

            stmt.executeUpdate();
        }
    }


   
    public static Funcionario buscarPorId(Funcionario funcionario) throws SQLException {
        String sql = "SELECT * FROM Funcionario_Telefone WHERE ID_Funcionario = ?";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, funcionario.getID_Funcionario());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    funcionario.setTelefone(rs.getString("Telefone"));
                } else {
                    return null;
                }
            }
        }

        return funcionario;
    }
}