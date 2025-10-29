/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import modelos.Venda;
import conexao.conectar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class Venda_DAO {
    public boolean inserir(Venda venda) {
        String sql = "INSERT INTO Venda (ID_Cliente, Data, Valor, Status) VALUES (?, ?, ?, ?)";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, venda.getID_Cliente());
            stmt.setDate(2, new java.sql.Date(venda.getData().getTime()));
            stmt.setBigDecimal(3, BigDecimal.valueOf(venda.getValor()));
            stmt.setString(4, venda.getStatus());

            int rowsAffected = stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    venda.setID_Venda(rs.getInt(1));
                }
            }

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir venda: " + e.getMessage());
            return false;
        }
    }

   
    public boolean atualizar(Venda venda) {
        String sql = "UPDATE Venda SET ID_Cliente = ?, Data = ?, Valor = ?, Status = ? WHERE ID_Venda = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, venda.getID_Cliente());
            stmt.setDate(2, new java.sql.Date(venda.getData().getTime()));
            stmt.setBigDecimal(3, BigDecimal.valueOf(venda.getValor()));
            stmt.setString(4, venda.getStatus());
            stmt.setInt(5, venda.getID_Venda());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar venda: " + e.getMessage());
            return false;
        }
    }

   
    public boolean deletar(int id) {
        String sql = "DELETE FROM Venda WHERE ID_Venda = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar venda: " + e.getMessage());
            return false;
        }
    }

    
    public Venda buscarPorId(int id) {
        String sql = "SELECT * FROM Venda WHERE ID_Venda = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Venda venda = new Venda();
                    venda.setID_Venda(rs.getInt("ID_Venda"));
                    venda.setID_Cliente(rs.getInt("ID_Cliente"));
                    venda.setData(rs.getDate("Data"));
                    venda.setValor(rs.getBigDecimal("Valor").doubleValue());
                    venda.setStatus(rs.getString("Status"));
                    return venda;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar venda: " + e.getMessage());
        }
        return null;
    }

    // Listar todas as vendas
    public List<Venda> listarTodos() {
        List<Venda> lista = new ArrayList<>();
        String sql = "SELECT * FROM Venda";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setID_Venda(rs.getInt("ID_Venda"));
                venda.setID_Cliente(rs.getInt("ID_Cliente"));
                venda.setData(rs.getDate("Data"));
                venda.setValor(rs.getBigDecimal("Valor").doubleValue());
                venda.setStatus(rs.getString("Status"));
                lista.add(venda);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar vendas: " + e.getMessage());
        }

        return lista;
    }
}
