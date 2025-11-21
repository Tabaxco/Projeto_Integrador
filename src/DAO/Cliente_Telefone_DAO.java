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
import modelos.Cliente;

public class Cliente_Telefone_DAO {
    public static int inserir(Cliente cliente) throws SQLException {
    String sql = "INSERT INTO Cliente_Telefone (ID_Cliente, Telefone) VALUES (?, ?)";

    try (Connection conn = conectar.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        stmt.setInt(1, cliente.getID_Cliente());
        stmt.setString(2, cliente.getTelefone());

        stmt.executeUpdate();

        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getInt(1); 
            }
        }
    }

    return -1;
}
    
    public static void atualizar(Cliente cliente) throws SQLException {
    String sql = "UPDATE Cliente_Telefone SET Telefone = ? WHERE ID_Cliente = ?";

    try (Connection conn = conectar.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cliente.getTelefone());
        stmt.setInt(2, cliente.getID_Cliente());

        stmt.executeUpdate();
    }
}
    
    
    public static void deletar(Cliente cliente) throws SQLException {
    String sql = "DELETE FROM Cliente_Telefone WHERE ID_Cliente = ?";

    try (Connection conn = conectar.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, cliente.getID_Cliente());
        stmt.executeUpdate();
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
