/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author guilherme.lrodrigue1
 */
public class Cliente_Telefone {
    private int ID_Telefone;
    private int ID_Cliente;
    private String Telefone;
    
    public Cliente_Telefone(){}
    
    public Cliente_Telefone(int ID_Telefone, int ID_Cliente, String Telefone) {
        this.ID_Telefone = ID_Telefone;
        this.ID_Cliente = ID_Cliente;
        this.Telefone = Telefone;
    }
    
    public int getID_Telefone() {return ID_Telefone;}
    public void setID_Telefone(int ID_Telefone) {this.ID_Telefone = ID_Telefone;}
    
    public int getID_Cliente() {return ID_Cliente;}
    public void setID_Cliente(int ID_Cliente) {this.ID_Cliente = ID_Cliente;}
    
    public String getTelefone() {return Telefone;}
    public void setTelefone(String Telefone) {this.Telefone = Telefone;}
}
