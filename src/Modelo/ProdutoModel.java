/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Banco.Banco;
import Objetos.Cliente;
import Objetos.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Beth
 */
public class ProdutoModel {
    
    
    private Banco b;
    
    
        private void abrirConexao() {
        b = new Banco();
        b.conectar("Bela","root","123321");
        if (!b.getStatus()) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco código: " + b.getMensagemErro());
        } else {
            System.out.println("Banco conectado !  ProdutoModel abrirConexao()");
        }
    }
        
        
        
        public void inserir(Produto prod) {
        abrirConexao();
        String sql = "insert into Produto(nomeproduto,preco) values('" + prod.getNome() +
                 "'," + "'"+prod.getPreco() + "');";
        //System.out.println(sql);
        int res = b.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o produto");
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
        }
    }
        
        
        
        public boolean atualizar(Produto prod ) {
        abrirConexao();
        String sql = "update produto set nomeproduto = '" + prod.getNome() + 
                "',preco='" + prod.getPreco() +
                "' where idproduto=" + prod.getCod();
        //System.out.println(sql);
        int res = b.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o produto");
        } else {
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
            return true;
        }
        return false;
    } 
        
        
        
            public void excluir(int codigo) {
        abrirConexao();
        String sql = "delete from produto where idproduto=" + codigo + ";";
        //System.out.println(sql);
            int res = b.manipular(sql);
            if (res == -1) {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir o produto");
            } else {
                JOptionPane.showMessageDialog(null, "Exclusão do produto realizada");
            }
    }
            
            
        public ArrayList pesquisar(String nomeProduto) {
        abrirConexao();
        ArrayList lista=new ArrayList();
        String sql="select * from produto where nomeproduto like '"+nomeProduto+"%';";
        //System.out.println(sql);
        ResultSet resultado=b.consultar(sql);
        try {
            while(resultado.next()){
                Produto prod = new Produto();
                prod.setCod(resultado.getInt("idproduto"));
                prod.setNome(resultado.getString("nomeproduto"));
                prod.setPreco(resultado.getFloat("preco"));
                lista.add(prod);
            }
            resultado.close();
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "PRODUTO NÃO EXISTE");
            Logger.getLogger(ClienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
