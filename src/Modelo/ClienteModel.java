/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Beth
 */

import Banco.Banco;
import Objetos.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteModel {
    
    
    
    private Banco b;
    
    
    
    
    
        private void abrirConexao() {
        b = new Banco();
        b.conectar("Bela","root","123321");
        if (!b.getStatus()) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco código: " + b.getMensagemErro());
        } else {
            System.out.println("Banco conectado ! ClienteModel abrirConexao()");
        }
    }
    
    
    
        
        public void inserir(Cliente client) {
        abrirConexao();
        String sql = "insert into cliente(nomecliente,endereco) values('" + client.getNome() +
                 "'," + "'R: "+client.getEndereco() + "');";
        //System.out.println(sql+" ClienteModel inserir()");
        int res = b.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o cliente");
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
        }
    }
        
        
        
        public boolean atualizar(Cliente client) {
        abrirConexao();
        String sql = "update cliente set nomecliente = '" + client.getNome() + 
                "',endereco='" + client.getEndereco() +
                "' where idcliente=" + client.getCod();
        //System.out.println(sql+" ClienteModel atualizar()");
        int res = b.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o cliente");
        } else {
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
            return true;
        }
        return false;
    }
        
        
        
        
        
            public void excluir(int codigo) {
        abrirConexao();
        String sql = "delete from cliente where idcliente=" + codigo + ";";
        //System.out.println(sql+" ClienteModel excluir()");
            int res = b.manipular(sql);
            if (res == -1) {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir o cliente");
            } else {
                JOptionPane.showMessageDialog(null, "Exclusão do cliente realizada");
            }
    }
            
            
            
            
            
        public ArrayList pesquisar(String nomeCliente) {
        abrirConexao();
        ArrayList lista=new ArrayList();
        String sql="select * from cliente where nomecliente like '"+nomeCliente+"%';";
        //System.out.println(sql+" ClienteModel pesquisar()");
        ResultSet resultado=b.consultar(sql);
        try {
            while(resultado.next()){
                Cliente client = new Cliente();
                client.setCod(resultado.getInt("idCliente"));
                client.setNome(resultado.getString("nomecliente"));
                client.setEndereco(resultado.getString("endereco"));
                lista.add(client);
            }
            resultado.close();
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "CLIENTE NÃO EXISTE");
            Logger.getLogger(ClienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
        
        
    
}
