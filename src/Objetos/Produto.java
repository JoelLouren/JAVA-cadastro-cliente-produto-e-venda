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
public class Produto {
    
    
    
    private int cod;
    private String nome;
    private float preco;

    
    //  CONSTRUTOR PARA ARRAYLIST DO METODO PESQUISAR PRODUTO DA CLASSE PRODUTOMODEL
    public Produto() {

    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Produto(int cod, String nome, float preco) {
        this.cod = cod;
        this.nome = nome;
        this.preco = preco;
    }
    
    
    
    
    
    
    
    
}
