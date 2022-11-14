/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.VendaModel;
import Banco.Banco;
import Objetos.ProdutosVenda;
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
public class ProdutosVendaModel {
    
    
    
    
    
    private Banco Banco;
    

    private void abrirConexao() {
        Banco = new Banco();
        Banco.conectar("Bela","root","123321");
        if (!Banco.getStatus()) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco código: " + Banco.getMensagemErro());
        } else {
            System.out.println("Banco conectado !");
        }
    }    
    
    
    
    public boolean inserir(ProdutosVenda itens) {
       
        abrirConexao();
        String sql = "insert into produtos_da_venda(produto_idproduto,venda_idvenda,qtd,total_produto) values("
                + itens.getCodProduto() + "," + itens.getCodVenda() + "," + itens.getQtdProduto()
                + ",'" + itens.getTotalProduto() + "');";
        //System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            System.out.println("\n Não foi possível inserir os produtos na venda");
        } else {
            System.out.println( "\n Produto "+itens.getNomeProduto()+" registrados com sucesso");
            return true;
        }
        return false;    
    }                   
    
    
    
    
    
    

    
    
    
    
    
    //Exclui TODOS os produtos da venda    
    public boolean excluirTodos(int codigoVenda) {
        abrirConexao();
        String sql = "delete from produtos_da_venda where venda_idvenda=" + codigoVenda + ";";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            System.out.println("\nNão foi possível excluir todos os produtos da venda");
        } else {
            System.out.println("\nExclusão dos produtos realizada");
            return true;
        }
        return false;
    }
    
   
    
    
  
    public ArrayList pesquisar(int codigoVenda) {
        abrirConexao();
        ArrayList lista = new ArrayList();
        String sql = "select * from produtos_da_venda where venda_idvenda = " + codigoVenda + ";";
        System.out.println(sql);
        ResultSet registro = Banco.consultar(sql);
        try {
            while (registro.next()) {
                System.out.println("\nProdutos encontrados");
                ProdutosVenda item = new ProdutosVenda();
                item.setCodProduto(registro.getInt("produto_idproduto"));
                item.setCodVenda(registro.getInt("venda_idvenda"));
                item.setQtdProduto(registro.getInt("qtd"));
                item.setTotalProduto(registro.getFloat("total_produto"));
                lista.add(item);
            }
            registro.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosVendaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    
    
    
    
    // CONSTROI DADOS PEDIDO PELO METODO arrumaTelaTeste da classe cadastrarVenda
    public ArrayList buscarVenda(int codigoVenda) {
        abrirConexao();
        ArrayList lista = new ArrayList();
        String sql = "select nomeproduto , preco , qtd , total_produto , total_venda from \n" +
"produto , produtos_da_venda , venda where idvenda = venda_idvenda and idproduto = produto_idproduto "
                + "and idvenda = "+codigoVenda+" ;";
        System.out.println(sql);
        ResultSet registro = Banco.consultar(sql);
        try {
            while (registro.next()) {
                System.out.println("\nProdutos encontrados");
                ProdutosVenda item = new ProdutosVenda();
                item.setNomeProduto(registro.getString("nomeproduto"));
                item.setQtdProduto(registro.getInt("qtd"));
                item.setPreco(registro.getFloat("preco"));
                item.setTotalProduto(registro.getFloat("total_produto"));
                item.setTotalvenda(registro.getFloat("total_venda"));
                lista.add(item);
            }
            registro.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosVendaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    
    
    
}
