/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author guilherme.lrodrigue1
 */
public class Estoque {
    private int ID_Estoque;
    private int ID_Produto;
    private int Quantidade;
    
    public Estoque () {}
    
    public Estoque(int ID_Estoque, int ID_Produto, int Quantidade) {
        this.ID_Estoque = ID_Estoque;
        this.ID_Produto = ID_Produto;
        this.Quantidade = Quantidade;
    }
    
    public int getID_Estoque() {return ID_Estoque;}
    public void setID_Estoque(int ID_Estoque) {this.ID_Estoque = ID_Estoque;}
    
    public int getID_Produto() {return ID_Produto;}
    public void setID_Produto(int ID_Produto) {this.ID_Produto = ID_Produto;}
    
    public int getQuantidade() {return Quantidade;}
    public void setQuantidade(int Quantidade) {this.Quantidade = Quantidade;}
}
