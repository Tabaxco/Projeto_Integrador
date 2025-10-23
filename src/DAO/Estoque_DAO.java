/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import modelos.Estoque;
import conexao.conectar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Estoque_DAO {
public boolean inserir(Estoque estoque) {
        String sql = "INSERT INTO Estoque (ID_Produto, Quantidade) VALUES (?, ?)";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, estoque.getID_Produto());
            stmt.setInt(2, estoque.getQuantidade());

            int rowsAffected = stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    estoque.setID_Estoque(rs.getInt(1));
                }
            }

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir estoque: " + e.getMessage());
            return false;
        }
    }

    // Atualizar estoque
    public boolean atualizar(Estoque estoque) {
        String sql = "UPDATE Estoque SET ID_Produto = ?, Quantidade = ? WHERE ID_Estoque = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, estoque.getID_Produto());
            stmt.setInt(2, estoque.getQuantidade());
            stmt.setInt(3, estoque.getID_Estoque());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar estoque: " + e.getMessage());
            return false;
        }
    }

    // Deletar estoque pelo ID
    public boolean deletar(int id) {
        String sql = "DELETE FROM Estoque WHERE ID_Estoque = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar estoque: " + e.getMessage());
            return false;
        }
    }

    // Buscar estoque pelo ID
    public Estoque buscarPorId(int id) {
        String sql = "SELECT * FROM Estoque WHERE ID_Estoque = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Estoque estoque = new Estoque();
                    estoque.setID_Estoque(rs.getInt("ID_Estoque"));
                    estoque.setID_Produto(rs.getInt("ID_Produto"));
                    estoque.setQuantidade(rs.getInt("Quantidade"));
                    return estoque;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar estoque: " + e.getMessage());
        }
        return null;
    }

    // Listar todos os estoques
    public List<Estoque> listarTodos() {
        List<Estoque> lista = new ArrayList<>();
        String sql = "SELECT * FROM Estoque";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Estoque estoque = new Estoque();
                estoque.setID_Estoque(rs.getInt("ID_Estoque"));
                estoque.setID_Produto(rs.getInt("ID_Produto"));
                estoque.setQuantidade(rs.getInt("Quantidade"));
                lista.add(estoque);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar estoques: " + e.getMessage());
        }

        return lista;
    }
}
