/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


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

    
    public static Cliente buscarPorCliente(Cliente cliente) throws SQLException {
    String sql = "SELECT * FROM Cliente_Telefone WHERE ID_Cliente = ?";

    try (Connection conn = conectar.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, cliente.getID_Cliente());

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                cliente.setTelefone(rs.getString("Telefone"));
                return cliente;
            }
        }
    }

    return null; 
}
}
