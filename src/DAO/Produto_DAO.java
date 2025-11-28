package DAO;

import modelos.Produto;
import conexao.conectar;

import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Produto_DAO {

    
    public static void inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO Produto (Nome_Produto, Preco, Categoria, Imagem, Altura, Largura, Comprimento, Peso) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, produto.getNomeProduto());
            stmt.setBigDecimal(2, BigDecimal.valueOf(produto.getPreco())); 
            stmt.setString(3, produto.getCategoria());
            stmt.setString(4, produto.getImagem());
            stmt.setString(5, produto.getAltura());
            stmt.setString(6, produto.getLargura());
            stmt.setString(7, produto.getComprimento());
            stmt.setString(8, produto.getPeso());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    produto.setIdProduto(rs.getInt(1));
                }
            }
            DAO.Estoque_DAO.inserir(produto);
        }
    }

    
    public static void atualizar(Produto produto) throws SQLException {
        String sql = "UPDATE Produto SET Nome_Produto = ?, Preco = ?, Categoria = ?, Imagem = ?, Altura = ?, Largura = ?, Comprimento = ?, Peso = ? WHERE ID_Produto = ?";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNomeProduto());
            stmt.setBigDecimal(2, BigDecimal.valueOf(produto.getPreco()));
            stmt.setString(3, produto.getCategoria());
            stmt.setString(4, produto.getImagem());
            stmt.setString(5, produto.getAltura());
            stmt.setString(6, produto.getLargura());
            stmt.setString(7, produto.getComprimento());
            stmt.setString(8, produto.getPeso());
            stmt.setInt(9, produto.getIdProduto());

            stmt.executeUpdate();
            DAO.Estoque_DAO.atualizar(produto);
        }
    }

    
    public static void deletar(Produto produto) throws SQLException {
        String sql = "DELETE FROM Produto WHERE ID_Produto = ?";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            DAO.Estoque_DAO.deletar(produto);

            stmt.setInt(1, produto.getIdProduto());
            stmt.executeUpdate();
            
        }
    }

    public static Produto buscarPorId(Produto produto) throws SQLException {
    String sqlProduto = "SELECT * FROM Produto WHERE ID_Produto = ?";
    String sqlEstoque = "SELECT Quantidade FROM Estoque WHERE ID_Produto = ?";

    try (Connection conn = conectar.getConexao()) {

        try (PreparedStatement stmt = conn.prepareStatement(sqlProduto)) {
            stmt.setInt(1, produto.getIdProduto());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    produto.setNomeProduto(rs.getString("Nome_Produto"));
                    produto.setPreco(rs.getBigDecimal("Preco").doubleValue());
                    produto.setCategoria(rs.getString("Categoria"));
                    produto.setAltura(rs.getString("Altura"));
                    produto.setComprimento(rs.getString("Comprimento"));
                    produto.setLargura(rs.getString("Largura"));
                    produto.setImagem(rs.getString("Imagem"));
                    produto.setPeso(rs.getString("Peso"));
                } else {
                    return null; 
                }
            }
        }


        try (PreparedStatement stmt2 = conn.prepareStatement(sqlEstoque)) {
            stmt2.setInt(1, produto.getIdProduto());

            try (ResultSet rs2 = stmt2.executeQuery()) {
                if (rs2.next()) {
                    produto.setQtde(rs2.getInt("Quantidade"));
                } else {
                    produto.setQtde(0); 
                }
            }
        }
    }

    return produto;
}
}