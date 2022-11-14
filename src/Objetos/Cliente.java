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
public class Cliente {
    
    
    private int cod;
    private String nome , endereco;
    

    //  CONSTRUTOR PARA ARRAYLIST DO METODO PESQUISAR CLIENTE DA CLASSE CLIENTEMODEL
    public Cliente() {
        
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
    
    public Cliente(int cod, String nome, String endereco) {
        this.cod = cod;
        this.nome = nome;
        this.endereco = endereco;
    }
    
    
    
    
    
    
    
    
}
