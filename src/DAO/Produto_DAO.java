/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import modelos.Produto;
import conexao.conectar;
import java.math.BigDecimal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Produto_DAO {
     public boolean inserir(Produto produto) {
        String sql = "INSERT INTO Produto (Nome_Produto, Preco, Categoria) VALUES (?, ?, ?)";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, produto.getNomeProduto());
            stmt.setBigDecimal(2, BigDecimal.valueOf(produto.getPreco())); // converte double -> BigDecimal
            stmt.setString(3, produto.getCategoria());

            int rowsAffected = stmt.executeUpdate();

            // Pega o ID gerado
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    produto.setIdProduto(rs.getInt(1));
                }
            }

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
            return false;
        }
    }

    // Atualizar produto
    public boolean atualizar(Produto produto) {
        String sql = "UPDATE Produto SET Nome_Produto = ?, Preco = ?, Categoria = ? WHERE ID_Produto = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNomeProduto());
            stmt.setBigDecimal(2, BigDecimal.valueOf(produto.getPreco())); // converte double -> BigDecimal
            stmt.setString(3, produto.getCategoria());
            stmt.setInt(4, produto.getIdProduto());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
            return false;
        }
    }

    // Deletar produto pelo ID
    public boolean deletar(int id) {
        String sql = "DELETE FROM Produto WHERE ID_Produto = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar produto: " + e.getMessage());
            return false;
        }
    }

    // Buscar produto pelo ID
    public Produto buscarPorId(int id) {
        String sql = "SELECT * FROM Produto WHERE ID_Produto = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Produto produto = new Produto();
                    produto.setIdProduto(rs.getInt("ID_Produto"));
                    produto.setNomeProduto(rs.getString("Nome_Produto"));
                    produto.setPreco(rs.getBigDecimal("Preco").doubleValue()); // converte BigDecimal -> double
                    produto.setCategoria(rs.getString("Categoria"));
                    return produto;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto: " + e.getMessage());
        }
        return null;
    }

    // Listar todos os produtos
    public List<Produto> listarTodos() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Produto";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("ID_Produto"));
                produto.setNomeProduto(rs.getString("Nome_Produto"));
                produto.setPreco(rs.getBigDecimal("Preco").doubleValue()); // BigDecimal -> double
                produto.setCategoria(rs.getString("Categoria"));
                lista.add(produto);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }

        return lista;
    }
}
