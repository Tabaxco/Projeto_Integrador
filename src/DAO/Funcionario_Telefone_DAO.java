/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import modelos.Funcionario_Telefone;
import conexao.conectar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Funcionario_Telefone_DAO {
    public boolean inserir(Funcionario_Telefone telefoneFuncionario) {
        String sql = "INSERT INTO Funcionario_Telefone (ID_Funcionario, Telefone) VALUES (?, ?)";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, telefoneFuncionario.getID_Funcionario());
            stmt.setString(2, telefoneFuncionario.getTelefone());

            int rowsAffected = stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    telefoneFuncionario.setID_Telefone(rs.getInt(1));
                }
            }

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir telefone do funcionário: " + e.getMessage());
            return false;
        }
    }

    // Atualizar telefone do funcionário
    public boolean atualizar(Funcionario_Telefone telefoneFuncionario) {
        String sql = "UPDATE Funcionario_Telefone SET ID_Funcionario = ?, Telefone = ? WHERE ID_Telefone = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, telefoneFuncionario.getID_Funcionario());
            stmt.setString(2, telefoneFuncionario.getTelefone());
            stmt.setInt(3, telefoneFuncionario.getID_Telefone());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar telefone do funcionário: " + e.getMessage());
            return false;
        }
    }

    // Deletar telefone pelo ID
    public boolean deletar(int id) {
        String sql = "DELETE FROM Funcionario_Telefone WHERE ID_Telefone = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar telefone do funcionário: " + e.getMessage());
            return false;
        }
    }

    // Buscar telefone pelo ID
    public Funcionario_Telefone buscarPorId(int id) {
        String sql = "SELECT * FROM Funcionario_Telefone WHERE ID_Telefone = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Funcionario_Telefone telefoneFuncionario = new Funcionario_Telefone();
                    telefoneFuncionario.setID_Telefone(rs.getInt("ID_Telefone"));
                    telefoneFuncionario.setID_Funcionario(rs.getInt("ID_Funcionario"));
                    telefoneFuncionario.setTelefone(rs.getString("Telefone"));
                    return telefoneFuncionario;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar telefone do funcionário: " + e.getMessage());
        }
        return null;
    }

    // Listar todos os telefones
    public List<Funcionario_Telefone> listarTodos() {
        List<Funcionario_Telefone> lista = new ArrayList<>();
        String sql = "SELECT * FROM Funcionario_Telefone";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario_Telefone telefoneFuncionario = new Funcionario_Telefone();
                telefoneFuncionario.setID_Telefone(rs.getInt("ID_Telefone"));
                telefoneFuncionario.setID_Funcionario(rs.getInt("ID_Funcionario"));
                telefoneFuncionario.setTelefone(rs.getString("Telefone"));
                lista.add(telefoneFuncionario);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar telefones dos funcionários: " + e.getMessage());
        }

        return lista;
    }
}
