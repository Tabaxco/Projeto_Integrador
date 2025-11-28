package DAO;

import modelos.Funcionario;
import conexao.conectar;

import java.sql.*;

public class Funcionario_DAO {

    public static void inserir(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO Funcionario (Nome, Cargo, Email, Usuario, Senha, Data_Contratacao, Departamento) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getUsuario());
            stmt.setString(5, funcionario.getSenha());
            stmt.setDate(6, funcionario.getDataCadastro());
            stmt.setString(7, funcionario.getDepartamento());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    funcionario.setID_Funcionario(rs.getInt(1));
                }
            }
            DAO.Funcionario_Telefone_DAO.inserir(funcionario);
            DAO.Salario_DAO.inserir(funcionario);
        }
    }


    public static void atualizar(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE Funcionario SET Nome = ?, Cargo = ?, Usuario = ?, Senha = ? WHERE ID_Funcionario = ?";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getUsuario());
            stmt.setString(4, funcionario.getSenha());
            stmt.setInt(5, funcionario.getID_Funcionario());
            
            DAO.Funcionario_Telefone_DAO.atualizar(funcionario);
            DAO.Salario_DAO.atualizar(funcionario);

            stmt.executeUpdate();
        }
    }


    public static void deletar(Funcionario funcionario) throws SQLException {
        String sql = "DELETE FROM Funcionario WHERE ID_Funcionario = ?";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, funcionario.getID_Funcionario());
            
            DAO.Funcionario_Telefone_DAO.deletar(funcionario);
            DAO.Salario_DAO.deletar(funcionario);

            stmt.executeUpdate();
        }
    }


    public static Funcionario buscarPorId(Funcionario funcionario) throws SQLException {

    String sqlFuncionario = "SELECT * FROM Funcionario WHERE ID_Funcionario = ?";
    String sqlTelefone = "SELECT Telefone FROM Funcionario_Telefone WHERE ID_Funcionario = ?";
    String sqlSalario = "SELECT Valor_Salario FROM Salario WHERE ID_Funcionario = ?";

    try (Connection conn = conectar.getConexao()) {

        
        try (PreparedStatement stmt = conn.prepareStatement(sqlFuncionario)) {
            stmt.setInt(1, funcionario.getID_Funcionario());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    funcionario.setNome(rs.getString("Nome"));
                    funcionario.setCargo(rs.getString("Cargo"));
                    funcionario.setDepartamento(rs.getString("Departamento"));
                    funcionario.setUsuario(rs.getString("Usuario"));
                    funcionario.setSenha(rs.getString("Senha"));
                    funcionario.setEmail(rs.getString("Email"));
                    funcionario.setDataCadastro(rs.getDate("Data_Contratacao"));
                } else {
                    return null; 
                }
            }
        }

        
        try (PreparedStatement stmt2 = conn.prepareStatement(sqlTelefone)) {
            stmt2.setInt(1, funcionario.getID_Funcionario());

            try (ResultSet rs2 = stmt2.executeQuery()) {
                if (rs2.next()) {
                    funcionario.setTelefone(rs2.getString("Telefone"));
                } else {
                    funcionario.setTelefone(null); 
                }
            }
        }

        
        try (PreparedStatement stmt3 = conn.prepareStatement(sqlSalario)) {
            stmt3.setInt(1, funcionario.getID_Funcionario());

            try (ResultSet rs3 = stmt3.executeQuery()) {
                if (rs3.next()) {
                    funcionario.setSalario(rs3.getDouble("Valor_Salario"));
                } else {
                    funcionario.setSalario(0.0); 
                }
            }
        }
    }

    return funcionario;
}
}