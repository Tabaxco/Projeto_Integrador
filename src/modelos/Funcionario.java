/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author guilherme.lrodrigue1
 */
public class Funcionario {
    private int ID_Funcionario;
    private String Nome;
    private String Cargo;
    
    public Funcionario() {}
    
    public Funcionario(int ID_Funcionario, String Nome, String Cargo) {
        this.ID_Funcionario = ID_Funcionario;
        this.Nome = Nome;
        this.Cargo = Cargo;
    }
    
    public int getID_Funcionario() {return ID_Funcionario;}
    public void setID_Funcionario(int ID_Funcionario) {this.ID_Funcionario = ID_Funcionario;}
    
    public String getNome () {return Nome;}
    public void setNome (String Nome) {this.Nome = Nome;}
    
    public String getCargo () {return Cargo;}
    public void setCargo (String Cargo) {this.Cargo = Cargo;}
}
