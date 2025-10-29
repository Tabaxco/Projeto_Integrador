/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pi_projeto;

import DAO.Funcionario_DAO;
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
        Funcionario_DAO dao = new Funcionario_DAO();

        // 1️⃣ Inserir funcionário
        Funcionario f1 = new Funcionario();
        f1.setNome("Ana Silva");
        f1.setCargo("Gerente");
        if (dao.inserir(f1)) {
            System.out.println("✅ Funcionário inserido! ID: " + f1.getID_Funcionario());
        }
        
        
    }
    
}
