/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pi_projeto;

import DAO.Cliente_DAO;
import DAO.Funcionario_DAO;
import java.sql.Date;
import modelos.Cliente;
import modelos.Funcionario;

/**
 *
 * @author guilherme.lrodrigue1
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente c = new Cliente();
        c.setNome("Guilherme Leite");
        c.setDataCadastro(Date.valueOf("2025-10-29")); // yyyy-MM-dd

        // Cria o DAO
        Cliente_DAO dao = new Cliente_DAO();

        // Insere o cliente no banco
        boolean sucesso = dao.inserir(c);

        if (sucesso) {
            System.out.println("✅ Cliente inserido com sucesso! ID gerado: " + c.getID_Cliente());
        } else {
            System.out.println("❌ Falha ao inserir cliente.");
        }
    }
}
