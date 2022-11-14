/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import javax.swing.JOptionPane;
import Objetos.Cliente;
import Modelo.ClienteModel;
import View.Inicial;
import View.cadastroCliente;
import java.util.ArrayList;

/**
 *
 * @author Beth
 */
public class ClienteControl {
    
    
    /*Última função a ser chamada, valida os campos de texto e com base no valor do código executa insert ou 
    update */
    public boolean validarCampos(Cliente client) {
        if ("".equals(client.getNome().trim())) {
            JOptionPane.showMessageDialog(null, "Digite um nome");
        } else if ("".equals(client.getEndereco().trim())) {
            JOptionPane.showMessageDialog(null, "Digite um endereço");
        } else {
            ClienteModel clientModel = new ClienteModel();
            if (client.getCod() == 0) {
                clientModel.inserir(client);
            } else {
                clientModel.atualizar(client);
            }
            return true;
        }
        return false;
     }
    
    
    
    
    
    public void excluir(int codigo) {
        int res;
        ClienteModel clientModel = new ClienteModel();


            res=JOptionPane.showConfirmDialog(null,"Deseja excluir o cliente ?");
            if(res==0){
                clientModel.excluir(codigo);
                
            }
               
    }
}
    
    
    
    
    
    

    
    
    

