/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import modelos.Email_Cliente;
import conexao.conectar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Email_Cliente_DAO {
     public boolean inserir(Email_Cliente emailCliente) {
        String sql = "INSERT INTO Email_Cliente (ID_Cliente, Email) VALUES (?, ?)";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, emailCliente.getID_Cliente());
            stmt.setString(2, emailCliente.getEmail());

            int rowsAffected = stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    emailCliente.setID_Email(rs.getInt(1));
                }
            }

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir email: " + e.getMessage());
            return false;
        }
    }

    // Atualizar email
    public boolean atualizar(Email_Cliente emailCliente) {
        String sql = "UPDATE Email_Cliente SET ID_Cliente = ?, Email = ? WHERE ID_Email = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, emailCliente.getID_Cliente());
            stmt.setString(2, emailCliente.getEmail());
            stmt.setInt(3, emailCliente.getID_Email());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar email: " + e.getMessage());
            return false;
        }
    }

    // Deletar email pelo ID
    public boolean deletar(int id) {
        String sql = "DELETE FROM Email_Cliente WHERE ID_Email = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar email: " + e.getMessage());
            return false;
        }
    }

    // Buscar email pelo ID
    public Email_Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM Email_Cliente WHERE ID_Email = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Email_Cliente emailCliente = new Email_Cliente();
                    emailCliente.setID_Email(rs.getInt("ID_Email"));
                    emailCliente.setID_Cliente(rs.getInt("ID_Cliente"));
                    emailCliente.setEmail(rs.getString("Email"));
                    return emailCliente;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar email: " + e.getMessage());
        }
        return null;
    }

    // Listar todos os emails
    public List<Email_Cliente> listarTodos() {
        List<Email_Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Email_Cliente";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Email_Cliente emailCliente = new Email_Cliente();
                emailCliente.setID_Email(rs.getInt("ID_Email"));
                emailCliente.setID_Cliente(rs.getInt("ID_Cliente"));
                emailCliente.setEmail(rs.getString("Email"));
                lista.add(emailCliente);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar emails: " + e.getMessage());
        }

        return lista;
    }
}
