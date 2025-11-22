/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author guilherme.lrodrigue1
 */
public class Produto {
    private int ID_Produto;
    private String nomeProduto;
    private double preco;
    private String categoria;
    private int qtde;
    private int ID_Estoque;

    public Produto() {}

    public Produto(int ID_Produto, String nomeProduto, double preco, String categoria, int qtde, int ID_Estoque) {
        this.ID_Produto = ID_Produto;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.categoria = categoria;
        this.qtde = qtde;
        this.ID_Estoque = ID_Estoque;
    }

    public int getIdProduto() { return ID_Produto; }
    public void setIdProduto(int ID_Produto) { this.ID_Produto = ID_Produto; }

    public String getNomeProduto() { return nomeProduto; }
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    
    public int getQtde() { return qtde; }
    public void setQtde(int qtde) { this.qtde = qtde; }
    
    public int getIdEstoque() { return ID_Estoque; }
    public void setIdEstoque(int ID_Estoque) { this.ID_Estoque = ID_Estoque; }
}
