/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import modelos.Cliente;
import conexao.conectar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cliente_DAO {
     public boolean inserir(Cliente cliente) {
        String sql = "INSERT INTO Cliente (Nome, Data_Cadastro) VALUES (?, ?)";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, cliente.getNome());
            stmt.setDate(2, cliente.getDataCadastro());

            int rowsAffected = stmt.executeUpdate();

            // Pega o ID gerado
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    cliente.setID_Cliente(rs.getInt(1));
                }
            }

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
            return false;
        }
    }

    // Atualizar cliente existente
    public boolean atualizar(Cliente cliente) {
        String sql = "UPDATE Cliente SET Nome = ?, Data_Cadastro = ? WHERE ID_Cliente = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setDate(2, cliente.getDataCadastro());
            stmt.setInt(3, cliente.getID_Cliente());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
            return false;
        }
    }

    // Deletar cliente pelo ID
    public boolean deletar(int id) {
        String sql = "DELETE FROM Cliente WHERE ID_Cliente = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar cliente: " + e.getMessage());
            return false;
        }
    }

    // Buscar cliente pelo ID
    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM Cliente WHERE ID_Cliente = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setID_Cliente(rs.getInt("ID_Cliente"));
                    cliente.setNome(rs.getString("Nome"));
                    cliente.setDataCadastro(rs.getDate("Data_Cadastro"));
                    return cliente;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
        }
        return null;
    }

    // Listar todos os clientes
    public List<Cliente> listarTodos() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setID_Cliente(rs.getInt("ID_Cliente"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setDataCadastro(rs.getDate("Data_Cadastro"));
                lista.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }

        return lista;
    }
}

