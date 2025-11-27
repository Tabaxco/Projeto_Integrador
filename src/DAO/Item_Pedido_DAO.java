/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import modelos.Item_Pedido;
import conexao.conectar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Item_Pedido_DAO {
    public boolean inserir(Item_Pedido item) {
        String sql = "INSERT INTO Item_Pedido (ID_Venda, ID_Produto) VALUES (?, ?)";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, item.getID_Venda());
            stmt.setInt(2, item.getID_Produto());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir item do pedido: " + e.getMessage());
            return false;
        }
    }

  
    public boolean atualizar(Item_Pedido item) {
        String sql = "UPDATE Item_Pedido SET Qtde WHERE ID_Venda = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, item.getID_Venda());
            stmt.setInt(2, item.getID_Produto());
            stmt.setInt(3, item.getQtde());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar item do pedido: " + e.getMessage());
            return false;
        }
    }

    
    public boolean deletar(int id) {
        String sql = "DELETE FROM Item_Pedido WHERE ID_Item_Pedido = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar item do pedido: " + e.getMessage());
            return false;
        }
    }

    
    public Item_Pedido buscarPorId(int id) {
        String sql = "SELECT * FROM Item_Pedido WHERE ID_Venda = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Item_Pedido item = new Item_Pedido();
                    item.setID_Venda(rs.getInt("ID_Venda"));
                    item.setID_Produto(rs.getInt("ID_Produto"));
                    return item;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar item do pedido: " + e.getMessage());
        }
        return null;
    }
}