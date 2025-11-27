package DAO;

import modelos.Funcionario;
import conexao.conectar;

import java.sql.*;

public class Salario_DAO {

    // INSERIR
    public static void inserir(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO Salario (ID_Funcionario, Valor_Salario) VALUES (?, ?)";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, funcionario.getID_Funcionario());
            stmt.setDouble(2, funcionario.getSalario()); // <-- DOUBLE DIRETO

            stmt.executeUpdate();

            
        }
    }

  
    public static void atualizar(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE Salario SET Valor_Salario = ? WHERE ID_Funcionario = ?";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, funcionario.getSalario());  
            stmt.setInt(2, funcionario.getID_Funcionario());

            stmt.executeUpdate();
        }
    }

 
    public static void deletar(Funcionario funcionario) throws SQLException {
        String sql = "DELETE FROM Salario WHERE ID_Funcionario = ?";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, funcionario.getID_Funcionario());
            stmt.executeUpdate();
        }
    }


    public static Funcionario buscarPorId(Funcionario funcionario) throws SQLException {
        String sql = "SELECT Valor_Salario FROM Salario WHERE ID_Funcionario = ?";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, funcionario.getID_Funcionario());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    funcionario.setSalario(rs.getDouble("Valor_Salario")); 
                } else {
                    return null;
                }
            }
        }

        return funcionario;
    }
}