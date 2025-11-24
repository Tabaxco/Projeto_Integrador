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
        DAO.Cliente_Telefone_DAO.inserir(cliente);
        DAO.Email_Cliente_DAO.inserir(cliente);
    }
    
}


    
    public static void atualizar(Cliente cliente) throws SQLException {
    String sql = "UPDATE Cliente SET Nome = ? WHERE ID_Cliente = ?";

    try (Connection conn = conectar.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cliente.getNome());
        stmt.setInt(2, cliente.getID_Cliente());
        
        DAO.Cliente_Telefone_DAO.atualizar(cliente);
        DAO.Email_Cliente_DAO.atualizar(cliente);

        stmt.executeUpdate();
        
    }
    
}

  
    public static void deletar(Cliente cliente) throws SQLException {
    String sql = "DELETE FROM Cliente WHERE ID_Cliente = ?";

    try (Connection conn = conectar.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        DAO.Cliente_Telefone_DAO.deletar(cliente);
        DAO.Email_Cliente_DAO.deletar(cliente);

        stmt.setInt(1, cliente.getID_Cliente());
        stmt.executeUpdate();
        
    }
}

    
    public static Cliente buscarPorId(Cliente cliente) throws SQLException {
    
    String sqlCliente = "SELECT * FROM Cliente WHERE ID_Cliente = ?";

    try (Connection conn = conectar.getConexao();
         PreparedStatement stmtCliente = conn.prepareStatement(sqlCliente)) {

        stmtCliente.setInt(1, cliente.getID_Cliente());

        try (ResultSet rs = stmtCliente.executeQuery()) {
            if (rs.next()) {
                cliente.setNome(rs.getString("Nome"));
                cliente.setDataCadastro(rs.getDate("Data_Cadastro"));
            } else {
                return null; 
            }
        }

        
        String sqlTelefone = "SELECT Telefone FROM Cliente_Telefone WHERE ID_Cliente = ?";
        try (PreparedStatement stmtTel = conn.prepareStatement(sqlTelefone)) {
            stmtTel.setInt(1, cliente.getID_Cliente());
            try (ResultSet rsTel = stmtTel.executeQuery()) {
                if (rsTel.next()) {
                    cliente.setTelefone(rsTel.getString("Telefone")); 
                }
            }
        }

        
        String sqlEmail = "SELECT Email FROM Email_Cliente WHERE ID_Cliente = ?";
        try (PreparedStatement stmtEmail = conn.prepareStatement(sqlEmail)) {
            stmtEmail.setInt(1, cliente.getID_Cliente());
            try (ResultSet rsEmail = stmtEmail.executeQuery()) {
                if (rsEmail.next()) {
                    cliente.setEmail(rsEmail.getString("Email")); 
                }
            }
        }

        return cliente; 
    }
}
}
