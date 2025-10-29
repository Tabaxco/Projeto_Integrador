/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import modelos.Funcionario;
import conexao.conectar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Funcionario_DAO {
    public boolean inserir(Funcionario funcionario) {
        String sql = "INSERT INTO Funcionario (Nome, Cargo) VALUES (?, ?)";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());

            int rowsAffected = stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    funcionario.setID_Funcionario(rs.getInt(1));
                }
            }

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir funcionário: " + e.getMessage());
            return false;
        }
    }


    public boolean atualizar(Funcionario funcionario) {
        String sql = "UPDATE Funcionario SET Nome = ?, Cargo = ? WHERE ID_Funcionario = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setInt(3, funcionario.getID_Funcionario());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar funcionário: " + e.getMessage());
            return false;
        }
    }

    
    public boolean deletar(int id) {
        String sql = "DELETE FROM Funcionario WHERE ID_Funcionario = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar funcionário: " + e.getMessage());
            return false;
        }
    }

    
    public Funcionario buscarPorId(int id) {
        String sql = "SELECT * FROM Funcionario WHERE ID_Funcionario = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setID_Funcionario(rs.getInt("ID_Funcionario"));
                    funcionario.setNome(rs.getString("Nome"));
                    funcionario.setCargo(rs.getString("Cargo"));
                    return funcionario;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar funcionário: " + e.getMessage());
        }
        return null;
    }

   
    public List<Funcionario> listarTodos() {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Funcionario";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setID_Funcionario(rs.getInt("ID_Funcionario"));
                funcionario.setNome(rs.getString("Nome"));
                funcionario.setCargo(rs.getString("Cargo"));
                lista.add(funcionario);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar funcionários: " + e.getMessage());
        }

        return lista;
    }
}
