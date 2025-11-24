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
    private int ID_Salario;
    private int ID_Telefone;   
    private String Nome;
    private String Cargo;
    private String telefone;
    private double salario;
    
    public Funcionario() {}
    
    public Funcionario(int ID_Funcionario, int ID_Salario, int ID_Telefone, String Nome, String Cargo, String telefone, double salario) {
        this.ID_Funcionario = ID_Funcionario;
        this.ID_Salario = ID_Salario;
        this.ID_Telefone = ID_Telefone;
        this.Nome = Nome;
        this.Cargo = Cargo;
        this.telefone = telefone;
        this.salario = salario;
    }
    
    public int getID_Funcionario() {return ID_Funcionario;}
    public void setID_Funcionario(int ID_Funcionario) {this.ID_Funcionario = ID_Funcionario;}
    
    public int getID_Salario() {return ID_Salario;}
    public  void setID_Salario(int ID_Salario) {this.ID_Salario = ID_Salario;}
    
    public int getID_Telefone() { return ID_Telefone; }
    public void setID_Telefone(int ID_Telefone) { this.ID_Telefone = ID_Telefone; }
    
    public String getNome () {return Nome;}
    public void setNome (String Nome) {this.Nome = Nome;}
    
    public String getCargo () {return Cargo;}
    public void setCargo (String Cargo) {this.Cargo = Cargo;}
    
    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    
    public double getSalario() {return salario;}
    public void setSalario(double salario) {this.salario = salario;}
}
