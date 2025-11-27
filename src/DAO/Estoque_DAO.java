package DAO;

import modelos.Estoque;
import modelos.Produto;
import conexao.conectar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Estoque_DAO {

    // INSERIR — recebe Produto (como no seu original)
    public static void inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO Estoque (ID_Produto, Quantidade) VALUES (?, ?)";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, produto.getIdProduto());
            stmt.setInt(2, produto.getQtde());

            stmt.executeUpdate();
        }
    }

    
    public static void atualizar(Produto produto) throws SQLException {
        String sql = "UPDATE Estoque SET Quantidade = ? WHERE ID_Produto = ?";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, produto.getIdProduto());
            stmt.setInt(2, produto.getQtde());

            stmt.executeUpdate();
        }
    }

    // DELETAR — recebe Estoque, igual padrão do Cliente_DAO
    public static void deletar(Produto produto) throws SQLException {
        String sql = "DELETE FROM Estoque WHERE ID_Produto = ?";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, produto.getIdProduto());
            stmt.executeUpdate();
        }
    }
    

    // BUSCAR POR ID — recebe Estoque igual ao padrão do Cliente_DAO
    public static Estoque buscarPorId(Estoque estoque) throws SQLException {
        String sql = "SELECT * FROM Estoque WHERE ID_Produto = ?";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, estoque.getID_Estoque());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    estoque.setID_Produto(rs.getInt("ID_Produto"));
                    estoque.setQuantidade(rs.getInt("Quantidade"));
                    return estoque;
                }
            }
        }

        return null;
    }
}