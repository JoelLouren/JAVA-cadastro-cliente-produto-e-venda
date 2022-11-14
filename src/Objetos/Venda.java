/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;

/**
 *
 * @author Beth
 */
public class Venda {
    
    
    
    private int codVenda , codCliente;
    private float tot_venda;
    private String nome , endereco;
    ArrayList vendaProdutos = new ArrayList();//lista com os produtos da venda

    public Venda() {
        
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public float getTot_venda() {
        return tot_venda;
    }

    public void setTot_venda(float tot_venda) {
        this.tot_venda = tot_venda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    
    
    

    public Venda(int codVenda, int codCliente, float tot_venda) {
        this.codVenda = codVenda;
        this.codCliente = codCliente;
        this.tot_venda = tot_venda;
    }
    
    
    
    // METODOS ESPECIAIS
    
    public void adicionarItens(ArrayList itens){
        vendaProdutos = itens;
    }
    
    public ArrayList retornarItens(){
        return vendaProdutos;
    }
    
    public void addItem(ProdutosVenda elemento){
        vendaProdutos.add(elemento);
    }

    
    
    
    // CONSTRUTOR PARA GERAR SQL VIEW PARA ALIMENTAÇÃO TABELA VISUALIZAR VENDAS

    public Venda(int codVenda, int codCliente, float tot_venda, String nome, String endereco) {
        this.codVenda = codVenda;
        this.codCliente = codCliente;
        this.tot_venda = tot_venda;
        this.nome = nome;
        this.endereco = endereco;
    }

    
    
    
    
    
    
    
}
