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
     public static void inserir(Cliente cliente) throws SQLException {
    String sql = "INSERT INTO Cliente (Nome, Data_Cadastro) VALUES (?, ?)";

    try (Connection conn = conectar.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        stmt.setString(1, cliente.getNome());
        stmt.setDate(2, cliente.getDataCadastro());

        stmt.executeUpdate();

        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                cliente.setID_Cliente(rs.getInt(1));
            }
        }
    }
    DAO.Cliente_Telefone_DAO.inserir(cliente);
    
}


    
    public static void atualizar(Cliente cliente) throws SQLException {
    String sql = "UPDATE Cliente SET Nome = ? WHERE ID_Cliente = ?";

    try (Connection conn = conectar.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cliente.getNome());
        stmt.setInt(2, cliente.getID_Cliente());

        stmt.executeUpdate();
    }
    DAO.Cliente_Telefone_DAO.atualizar(cliente);
    
}

  
    public static void deletar(Cliente cliente) throws SQLException {
    String sql = "DELETE FROM Cliente WHERE ID_Cliente = ?";

    try (Connection conn = conectar.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, cliente.getID_Cliente());
        stmt.executeUpdate();
    }
    DAO.Cliente_Telefone_DAO.deletar(cliente);
}

    
    public Cliente buscarPorId(Cliente cliente) throws SQLException {
    String sql = "SELECT * FROM Cliente WHERE ID_Cliente = ?";

    try (Connection conn = conectar.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, cliente.getID_Cliente());

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                cliente.setNome(rs.getString("Nome"));
                cliente.setDataCadastro(rs.getDate("Data_Cadastro"));
                cliente.setTelefone(rs.getString("Telefone"));
                cliente.setEmail(rs.getString("Email"));
                return cliente;
            }
        }
    }

    return null; 
}

  
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

