/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author guilherme.lrodrigue1
 */
public class Item_Pedido {
    private int ID_Venda;
    private int ID_Produto;
    private int Qtde;
    
    public Item_Pedido() {}
    
    public Item_Pedido( int Venda, int ID_Produto, int Qtde) {
        this.ID_Venda = ID_Venda;
        this.ID_Produto = ID_Produto;
        this.Qtde = Qtde;
    }
    
    
            
    public int getID_Venda() {return ID_Venda;}
    public void setID_Venda(int ID_Venda) {this.ID_Venda = ID_Venda;}
    
    public int getID_Produto() {return ID_Produto;}
    public void setID_Produto(int ID_Produto) {this.ID_Produto = ID_Produto;}
    
    public int getQtde() {return Qtde;}
    public void setQtde(int Qtde) {this.Qtde = Qtde;}
}
