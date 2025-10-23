/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;


import java.sql.Date;

public class Cliente {
    private int ID_Cliente;
    private String nome;
    private Date dataCadastro;

    public Cliente() {}

    public Cliente(int ID_Cliente, String nome, Date dataCadastro) {
        this.ID_Cliente = ID_Cliente;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
    }

    public int getID_Cliente() { return ID_Cliente; }
    public void setID_Cliente(int ID_Cliente) { this.ID_Cliente = ID_Cliente; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Date getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(Date dataCadastro) { this.dataCadastro = dataCadastro; }
}
