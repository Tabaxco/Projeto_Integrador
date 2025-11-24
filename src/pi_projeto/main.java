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
import javax.swing.JFrame;
import view.Cliente_View;
import view.Estoque_View;
/**
 *
 * @author guilherme.lrodrigue1
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Teste do painel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Estoque_View());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
