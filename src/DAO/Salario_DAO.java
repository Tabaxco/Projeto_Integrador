/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import modelos.Salario;
import conexao.conectar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class Salario_DAO {
     public boolean inserir(Salario salario) {
        String sql = "INSERT INTO Salario (ID_Funcionario, Valor_Salario) VALUES (?, ?)";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, salario.getID_Funcionario());
            stmt.setBigDecimal(2, BigDecimal.valueOf(salario.getValor_Salario()));

            int rowsAffected = stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    salario.setID_Salario(rs.getInt(1));
                }
            }

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir salário: " + e.getMessage());
            return false;
        }
    }

    // Atualizar salário
    public boolean atualizar(Salario salario) {
        String sql = "UPDATE Salario SET ID_Funcionario = ?, Valor_Salario = ? WHERE ID_Salario = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, salario.getID_Funcionario());
            stmt.setBigDecimal(2, BigDecimal.valueOf(salario.getValor_Salario()));
            stmt.setInt(3, salario.getID_Salario());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar salário: " + e.getMessage());
            return false;
        }
    }

    // Deletar salário pelo ID
    public boolean deletar(int id) {
        String sql = "DELETE FROM Salario WHERE ID_Salario = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar salário: " + e.getMessage());
            return false;
        }
    }

    // Buscar salário pelo ID
    public Salario buscarPorId(int id) {
        String sql = "SELECT * FROM Salario WHERE ID_Salario = ?";
        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Salario salario = new Salario();
                    salario.setID_Salario(rs.getInt("ID_Salario"));
                    salario.setID_Funcionario(rs.getInt("ID_Funcionario"));
                    salario.setValor_Salario(rs.getBigDecimal("Valor_Salario").doubleValue());
                    return salario;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar salário: " + e.getMessage());
        }
        return null;
    }

    // Listar todos os salários
    public List<Salario> listarTodos() {
        List<Salario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Salario";

        try (Connection conn = conectar.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Salario salario = new Salario();
                salario.setID_Salario(rs.getInt("ID_Salario"));
                salario.setID_Funcionario(rs.getInt("ID_Funcionario"));
                salario.setValor_Salario(rs.getBigDecimal("Valor_Salario").doubleValue());
                lista.add(salario);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar salários: " + e.getMessage());
        }

        return lista;
    }
}
