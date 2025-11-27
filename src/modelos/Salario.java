/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author guilherme.lrodrigue1
 */
public class Salario {
    private int ID_Funcionario;
    private double Valor_Salario;
    
    public Salario() {}
    
    public Salario ( int ID_Funcionario, double Valor_Funcionario) {
        this.ID_Funcionario = ID_Funcionario;
        this.Valor_Salario = Valor_Funcionario;
    }
    
    public int getID_Funcionario() {return ID_Funcionario;}
    public void setID_Funcionario(int ID_Funcionario) {this.ID_Funcionario = ID_Funcionario;}
    
    public double getValor_Salario() {return Valor_Salario;}
    public void setValor_Salario(double Valor_Salario) {this.Valor_Salario = Valor_Salario;}
}
