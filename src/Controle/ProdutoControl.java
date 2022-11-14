/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;


import Modelo.ProdutoModel;
import Objetos.Produto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Beth
 */
public class ProdutoControl {
    
    
    
    /*Última função a ser chamada, valida os campos de texto e com base no valor do código executa insert ou 
    update */
    public boolean validarCamposTexto(Produto prod) {
        if ("".equals(prod.getNome().trim())) {
            JOptionPane.showMessageDialog(null, "Digite um nome");
            return false;
        }
         else {
            ProdutoModel prodModel = new ProdutoModel();
            if (prod.getCod() == 0) {
                prodModel.inserir(prod);
            } else {
                prodModel.atualizar(prod);
            }
            return true;
        }
    }
    
    
    
    
    public void excluir(int codigo) {
        int res;
        ProdutoModel produtoModel = new ProdutoModel();


            res=JOptionPane.showConfirmDialog(null,"Deseja excluir o produto ?");
            if(res==0){
                produtoModel.excluir(codigo);
                
            }
               
    }




        public ArrayList validarNomePesquisa(String nome) {
        ProdutoModel prodModel = new ProdutoModel();
        return prodModel.pesquisar(nome);
    }
    
    
    
}
