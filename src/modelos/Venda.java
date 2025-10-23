/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.Date;

/**
 *
 * @author guilherme.lrodrigue1
 */
public class Venda {
    private int ID_Venda;
    private int ID_Cliente;
    private Date Data;
    private double Valor;
    private String Status;
    
    public Venda() {}
    
    public Venda(int ID_Venda, int ID_Cliente, Date Data, double Valor, String Status) {
        this.ID_Venda = ID_Venda;
        this.ID_Cliente = ID_Cliente;
        this.Data = Data;
        this.Valor = Valor;
        this.Status = Status;
    }
    
    public int getID_Venda() {return ID_Venda;}
    public void setID_Venda(int ID_Venda) {this.ID_Venda = ID_Venda;}
    
    public int getID_Cliente() {return ID_Cliente;}
    public void setID_Cliente(int ID_Cliente) {this.ID_Cliente = ID_Cliente;}
    
    public Date getData() {return Data;}
    public void setData(Date Data) {this.Data = Data;}
    
    public double getValor() {return Valor;}
    public void setValor(double Valor) {this.Valor = Valor;}
    
    public String getStatus() {return Status;}
    public void setStatus(String Status) {this.Status = Status;}
}
