/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author guilherme.lrodrigue1
 */
public class Funcionario_Telefone {
    private int ID_Telefone;
    private int ID_Funcionario;
    private String Telefone;
    
    public Funcionario_Telefone(){}
    
    public Funcionario_Telefone(int ID_Telefone, int ID_Funcionario, String telefone) {
        this.ID_Telefone = ID_Telefone;
        this.ID_Funcionario = ID_Funcionario;
        this.Telefone = Telefone;
    }
    
    public int getID_Telefone() {return ID_Telefone;}
    public void setID_Telefone(int ID_Telefone){this.ID_Telefone = ID_Telefone;}
    
    public int getID_Funcionario() {return ID_Funcionario;}
    public void setID_Funcionario(int ID_Funcionario) {this.ID_Funcionario = ID_Funcionario;}
    
    public String getTelefone() {return Telefone;}
    public void setTelefone(String Telefone) {this.Telefone = Telefone;}
    
}
