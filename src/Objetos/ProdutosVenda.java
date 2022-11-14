/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Beth
 */
public class ProdutosVenda {
    
    
    
    private int codProduto , codVenda , qtdProduto;
    private float totalProduto , preco , totalvenda;
    private String nomeProduto;

    public ProdutosVenda() {

    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public float getTotalProduto() {
        return totalProduto;
    }

    public void setTotalProduto(float totalProduto) {
        this.totalProduto = totalProduto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getTotalvenda() {
        return totalvenda;
    }

    public void setTotalvenda(float totalvenda) {
        this.totalvenda = totalvenda;
    }
    
    
    
    
    
    
    
    
    

    public ProdutosVenda(int codProduto, int codVenda, int qtdProduto, float totalProduto, float preco, String nomeProduto) {
        this.codProduto = codProduto;
        this.codVenda = codVenda;
        this.qtdProduto = qtdProduto;
        this.totalProduto = totalProduto;
        this.preco = preco;
        this.nomeProduto = nomeProduto;
    }

    public ProdutosVenda(int qtdProduto, float totalProduto, float preco, float totalvenda, String nomeProduto) {
        this.qtdProduto = qtdProduto;
        this.totalProduto = totalProduto;
        this.preco = preco;
        this.totalvenda = totalvenda;
        this.nomeProduto = nomeProduto;
    }


    
    
    
    
    

    
    
    
    
    
    
    
    
}
