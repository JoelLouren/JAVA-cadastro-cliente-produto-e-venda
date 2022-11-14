/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ProdutosVendaModel;
import Modelo.VendaModel;
import Objetos.ProdutosVenda;
    import Objetos.Venda;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author Beth
 */
public class VendaControl {
    
    
    
    VendaModel vendmodel = new VendaModel();
    
    
    public boolean verificarItens (Venda v){
        
        if(v.retornarItens().isEmpty()){
            return false;
        }
    return true;    
    }
    
 
       //INSERINDO DADOS NA TABELA VENDAS E PRODUTOS DA VENDA 
      //MUITA ALTERAÇÃO AQUI                     <<<-------------------------------
    public boolean salvarVenda(Venda vender) throws SQLException {
        boolean check = false;
        if (verificarItens(vender)) {
            VendaModel salvaVenda = new VendaModel();
            salvaVenda.inserir(vender);
            
            ArrayList itens = vender.retornarItens();
           int codV = salvaVenda.qtdVendas();
           //System.out.println("QTD DE REGISTROS BUSCADOS NO BANCO "+codV);
            for (int i = 0; i < itens.size(); i++) {
                ProdutosVenda item = (ProdutosVenda) itens.get(i);
                item.setCodVenda(codV);                      
                ProdutosVendaModel salvaItem = new ProdutosVendaModel();
                if (salvaItem.inserir(item)) {
                    check = true;
                }
            }
            return check;
        }
        return false;
    }
    
    
    
    
    
    
    public boolean atualizaVenda(Venda vender) {
        boolean check=false;
        if (verificarItens(vender)) {
            VendaModel atualizaVenda = new VendaModel();
            ProdutosVendaModel pv = new ProdutosVendaModel();
            atualizaVenda.atualizar(vender);
            ArrayList itens = vender.retornarItens();
            if (pv.excluirTodos(vender.getCodVenda())) {
                for (int i = 0; i < itens.size(); i++) {
                    ProdutosVenda item = (ProdutosVenda) itens.get(i);
                    ProdutosVendaModel salvaItem = new ProdutosVendaModel();
                    if(salvaItem.inserir(item)){
                        check=true;
                    }
                }
               return check; 
            }
        }
        return false;
    }
    
    
    
}
