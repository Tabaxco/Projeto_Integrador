/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author guilherme.lrodrigue1
 */
public class Email_Cliente {
    private int ID_Email;
    private int ID_Cliente;
    private String Email;
    
    public Email_Cliente (){}
    
    public Email_Cliente (int ID_Email, int ID_Cliente, String Email) {
        this.ID_Email = ID_Email;
        this.ID_Cliente = ID_Cliente;
        this.Email = Email;
    }
    
    public int getID_Email() {return ID_Email;}
    public void setID_Email(int ID_Email) {this.ID_Email = ID_Email;}
    
    public int getID_Cliente() {return ID_Cliente;}
    public void setID_Cliente(int ID_Cliente) {this.ID_Cliente = ID_Cliente;}
    
    public String getEmail() {return Email;}
    public void setEmail(String Email) {this.Email = Email;}
}
