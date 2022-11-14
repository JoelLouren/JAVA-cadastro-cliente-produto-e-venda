/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Banco.Banco;
import Objetos.Cliente;
import Objetos.Venda;
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
public class VendaModel {
    
  
 
    private Banco Banco;
    ArrayList lista = new ArrayList();
    

    
    

    private void abrirConexao() {
        Banco = new Banco();
        Banco.conectar("Bela","root","123321");
        if (!Banco.getStatus()) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco código: " + Banco.getMensagemErro());
        } else {
            System.out.println("Banco conectado !  VendaModel abrirConexao()");
        }
    }
    
    
    
    public boolean inserir(Venda vend) {
        abrirConexao();
        String sql = "insert into venda(cliente_idcliente,total_venda) values('" + vend.getCodCliente() + "','"
                + vend.getTot_venda() + "');";
        //System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir a venda");
        } else {
            //JOptionPane.showMessageDialog(null, "Venda inserida com sucesso");
            System.out.println("\n VENDA CADASTRADA \n");
            return true;
        }
        return false;
    }
    
    
    
    
    //Retorna dados de uma venda pesquisando pelo codigo
    public Venda pesquisar(int codCliente) {
        abrirConexao();
        String sql = "select * from venda where cliente_idcliente='" + codCliente + "';";
        ResultSet resultado = Banco.consultar(sql);
        try {
            if (resultado.next()) {
                Venda res = new Venda();
                res.setCodVenda(Integer.parseInt(resultado.getString("idvenda")));
                res.setCodCliente(Integer.parseInt(resultado.getString("cliente_idcliente")));
                res.setTot_venda(Float.parseFloat(resultado.getString("total_venda")));
                return res;
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma venda localizada para o dia");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    
    public boolean atualizar(Venda vend) {
        abrirConexao();
        String sql = "update venda set cliente_idcliente='" + vend.getCodCliente() + "',total_venda='" 
                + vend.getTot_venda() + "'"
                + " where idvenda=" + vend.getCodVenda() + ";";
        //System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar a venda");
        } else {
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
            return true;
        }
        return false;
    }
    


    
    
    public boolean excluir(int codigo) {
        abrirConexao();
        String sql = "delete from venda where idvenda=" + codigo + ";";
        System.out.println(sql);

            int res = Banco.manipular(sql);
            if (res == -1) {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir a venda");
            } else {
                JOptionPane.showMessageDialog(null, "Exclusão da venda realizada");
                return true;
            }
        return false;
    }
    
    
    
    


    
    
    //  RETORNA O ID DA ULTIMA VENDA INSERIDA NO BD
    public int qtdVendas( ) throws SQLException {
   
                  
        abrirConexao();
        String sql = "SELECT max(idvenda) as maxi_id_venda from venda;";
      
        ResultSet resultado = Banco.consultar(sql);
        //int cod = resultado.last()? resultado.getRow():0;    // contagem de registros gravados no BD
        resultado.next();
        int cod = resultado.getInt("maxi_id_venda");   // PEGA O ID DA ULTIMA VENDA INSERIDA NO BD PARA REGISTRAR
                                                     //              OS PRODUTOS DA VENDA
       // System.out.println("*** "+cod+" ***");         
        return cod;
    }

    
    
    
    
    
    
    //  RETORNA LISTA DE VENDAS PARA ALIMENTAR A TABELA DA TELA VISUALIZAR VENDAS QUANDO SE ABRE A PRIMEIRA VEZ
    public ArrayList pesquisar2(String sql) {
        
        abrirConexao();
        ArrayList lista=new ArrayList();
        ResultSet resultado=Banco.consultar(sql);
        try {
            while(resultado.next()){
                Venda vend = new Venda();
                vend.setCodVenda(resultado.getInt("codven"));
                vend.setNome(resultado.getString("nomecli"));
                vend.setEndereco(resultado.getString("endereco"));
                vend.setTot_venda(resultado.getFloat("tot"));
                lista.add(vend);
            }
            resultado.close();
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "CLIENTE NÃO EXISTE");
            Logger.getLogger(ClienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
        
        /*
create view listaven as select idvenda as codven , nomecliente as nomecli , endereco as endereco , 
total_venda as tot from venda , cliente where venda.cliente_idcliente = cliente.idcliente;
        */
        
    }

    
    
    
    public int retornaCliente(int codVenda) throws SQLException{
        
        abrirConexao();
        String sql = "select (cliente_idcliente) as ccli from venda where idvenda = '"+codVenda+"' ;";
        ResultSet resultado=Banco.consultar(sql);
        resultado.next();
        System.out.println(resultado);
        int codCli = resultado.getInt("ccli");
        return codCli;
    }
    
}
