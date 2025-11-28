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
    private String imagem;
    private String peso;
    private String altura;
    private String largura;
    private String comprimento;

    public Produto() {}

    public Produto(int ID_Produto, String nomeProduto, double preco, String categoria, 
            int qtde, String imagem, String peso, String altura, String largura, String comprimento) {
        this.ID_Produto = ID_Produto;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.categoria = categoria;
        this.qtde = qtde;
        this.imagem = imagem;
        this.peso = peso;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
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
    
    public String getImagem() {return imagem;}
    public void setImagem(String imagem) {this.imagem = imagem;}
    
    public String getPeso() {return peso;}
    public void setPeso(String peso) {this.peso = peso;}
    
    public String getAltura() {return altura;}
    public void setAltura(String altura) {this.altura = altura;}
    
    public String getLargura() {return largura;}
    public void setLargura(String largura) {this.largura = largura;}
    
    public String getComprimento() {return comprimento;}
    public void setComprimento(String comprimento) {this.comprimento = comprimento;}

}
