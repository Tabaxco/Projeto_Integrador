/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import modelos.Cliente_Telefone;
import conexao.conectar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cliente_Telefone_DAO {
    public boolean inserir(Cliente_Telefone telefoneCliente) {
        String sql = "INSERT INTO Cliente_Telefone (ID_Cliente, Telefone) VALUES (?, ?)";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, telefoneCliente.getID_Cliente());
            stmt.setString(2, telefoneCliente.getTelefone());

            int rowsAffected = stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    telefoneCliente.setID_Telefone(rs.getInt(1));
                }
            }

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir telefone: " + e.getMessage());
            return false;
        }
    }

    
    public boolean atualizar(Cliente_Telefone telefoneCliente) {
        String sql = "UPDATE Cliente_Telefone SET ID_Cliente = ?, Telefone = ? WHERE ID_Telefone = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, telefoneCliente.getID_Cliente());
            stmt.setString(2, telefoneCliente.getTelefone());
            stmt.setInt(3, telefoneCliente.getID_Telefone());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar telefone: " + e.getMessage());
            return false;
        }
    }

    
    public boolean deletar(int id) {
        String sql = "DELETE FROM Cliente_Telefone WHERE ID_Telefone = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar telefone: " + e.getMessage());
            return false;
        }
    }

    
    public Cliente_Telefone buscarPorId(int id) {
        String sql = "SELECT * FROM Cliente_Telefone WHERE ID_Telefone = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Cliente_Telefone telefoneCliente = new Cliente_Telefone();
                    telefoneCliente.setID_Telefone(rs.getInt("ID_Telefone"));
                    telefoneCliente.setID_Cliente(rs.getInt("ID_Cliente"));
                    telefoneCliente.setTelefone(rs.getString("Telefone"));
                    return telefoneCliente;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar telefone: " + e.getMessage());
        }
        return null;
    }

    
    public List<Cliente_Telefone> listarTodos() {
        List<Cliente_Telefone> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cliente_Telefone";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente_Telefone telefoneCliente = new Cliente_Telefone();
                telefoneCliente.setID_Telefone(rs.getInt("ID_Telefone"));
                telefoneCliente.setID_Cliente(rs.getInt("ID_Cliente"));
                telefoneCliente.setTelefone(rs.getString("Telefone"));
                lista.add(telefoneCliente);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar telefones: " + e.getMessage());
        }

        return lista;
    }
}
