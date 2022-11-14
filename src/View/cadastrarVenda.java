/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controle.VendaControl;
import Modelo.ProdutosVendaModel;
import Modelo.VendaModel;
import Objetos.Cliente;
import Objetos.ProdutosVenda;
import Objetos.Venda;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Beth
 */
public class cadastrarVenda extends javax.swing.JFrame {

    /**
     * Creates new form cadastrarVenda
     */
    public cadastrarVenda() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    Cliente cl = new Cliente();
    Venda venda = new Venda();
    ProdutosVendaModel produtosVenda = new ProdutosVendaModel();
    private int codVenda ;
    ArrayList list = new ArrayList();
    
    
    
    
    
    public void arrumarTela(Cliente c){       
        ct_cliente.setText(c.getNome());
        ct_total.setEditable(false);
        bt_remover.setEnabled(false);
        bt_salvar.setEnabled(false);
        bt_alterar.setEnabled(false);
        bt_excluir.setEnabled(false);
        cl = c;
    }
    
    
        
        
        
    public void arrumaTela(Venda dados) {
        codVenda = dados.getCodVenda();
        ct_total.setText(String.valueOf(dados.getTot_venda()));
        ct_cliente.setText(String.valueOf(cl.getNome()));
        arrumaTabela(dados.retornarItens());
    }

    
    
    public void arrumaTelaUpdate(Venda dados) {
        ct_cliente.setText(dados.getNome());
        codVenda = dados.getCodVenda();
        ct_nomeProd.setEditable(false);
        ct_total.setText(String.valueOf(dados.getTot_venda()));
        ct_total.setEditable(false);
        t_venda.setEnabled(false);
        bt_remover.setEnabled(false);
        bt_pesquisar.setEnabled(false);
        bt_alterar.setEnabled(true);
        bt_salvar.setEnabled(false);
        bt_excluir.setEnabled(true);
        arrumaTabela(dados.retornarItens());
    }
    
    
    
    
    
    public void arrumaTabela(ArrayList valores) {
        float valorTotal = 0;
        DefaultTableModel modelo = (DefaultTableModel) t_venda.getModel();
        while (modelo.getRowCount() != 0) {
            modelo.removeRow(0);
        }
        for (int i = 0; i < valores.size(); i++) {
            ProdutosVenda prodVenda = (ProdutosVenda) valores.get(i);
            String[] linha = new String[4];
            linha[0] = prodVenda.getNomeProduto();
            linha[1] = String.valueOf(prodVenda.getQtdProduto());
            linha[2] = String.valueOf(prodVenda.getPreco());
            float total = prodVenda.getPreco()*prodVenda.getQtdProduto();
            prodVenda.setTotalProduto(total);
            linha[3] = String.valueOf(prodVenda.getTotalProduto());
            valorTotal += prodVenda.getTotalProduto();
            modelo.addRow(linha);
        }
        t_venda.setModel(modelo);
        list = valores;
        BigDecimal arredondar = new BigDecimal(valorTotal).setScale(2, RoundingMode.HALF_UP);
        valorTotal = arredondar.floatValue();
        ct_total.setText(String.valueOf(valorTotal));
        if (modelo.getRowCount() != 0) {
            if (codVenda == 0) {
                bt_salvar.setEnabled(true);
                System.out.println(codVenda);
                bt_excluir.setEnabled(false);
                bt_alterar.setEnabled(false);
                bt_remover.setEnabled(true);
            } else {
                bt_excluir.setEnabled(true);
                bt_alterar.setEnabled(true);
            }
        } else {
            //desativaBTela();
            System.out.println("-----ERRO cadastrarVenda.arrumaTabela----");
        }
    }
    
    
    
    
    
    
    public void organizarUpdate() {
        ct_nomeProd.setEditable(true);
        ct_nomeProd.requestFocus();
        t_venda.setEnabled(true);
        bt_pesquisar.setEnabled(true);
        bt_remover.setEnabled(false);
        bt_alterar.setEnabled(false);
        bt_salvar.setEnabled(true);
        bt_excluir.setEnabled(false);
    }
    
    
    
    public void constroiVenda() {
        venda.setCodVenda(codVenda);
        venda.setCodCliente(cl.getCod());
        if (!ct_total.getText().isEmpty()) {
            venda.setTot_venda(Float.parseFloat(ct_total.getText()));
        }
        venda.adicionarItens(list);
    }
    
    
    
    
    
    public void arrumaTelaTeste (Venda vend){
        
        ct_nomeProd.setEditable(false);
        bt_pesquisar.setEnabled(false);
        bt_remover.setEnabled(false);
        ct_total.setEditable(false);
        bt_salvar.setEnabled(false);
        cl.setCod(vend.getCodCliente());
        constroiVenda();
        ct_cliente.setText(vend.getNome());
        
        
        ArrayList produtos = produtosVenda.buscarVenda(vend.getCodVenda());
        DefaultTableModel modelo = (DefaultTableModel) t_venda.getModel();
            while (modelo.getRowCount() != 0) {
            modelo.removeRow(0);
        }
        
        if(produtos != null){
            
            for(int i = 0; i<produtos.size(); i++){
               ProdutosVenda prodven = new ProdutosVenda();
               prodven = (ProdutosVenda) produtos.get(i);
               String[] lin = new String[4];
               lin[0]=String.valueOf(prodven.getNomeProduto());
               lin[1]=String.valueOf(prodven.getQtdProduto());
               lin[2]=String.valueOf(prodven.getPreco());
               lin[3]=String.valueOf(prodven.getTotalProduto());
               modelo.addRow(lin);
                System.out.println(lin[0]);
            
            }   
            
        }
        ct_total.setText(String.valueOf(venda.getTot_venda()));
        venda.setCodVenda(vend.getCodVenda());
    }
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ct_nomeProd = new javax.swing.JTextField();
        bt_pesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_venda = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        ct_total = new javax.swing.JTextField();
        bt_remover = new javax.swing.JButton();
        bt_salvar = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_excluir = new javax.swing.JButton();
        ct_cliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar venda");

        jLabel1.setText("Produto :");

        bt_pesquisar.setText("Pesquisar");
        bt_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarActionPerformed(evt);
            }
        });

        t_venda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto", "Qtd", "Valor und", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_vendaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(t_venda);
        if (t_venda.getColumnModel().getColumnCount() > 0) {
            t_venda.getColumnModel().getColumn(1).setMinWidth(95);
            t_venda.getColumnModel().getColumn(1).setMaxWidth(95);
            t_venda.getColumnModel().getColumn(2).setMinWidth(95);
            t_venda.getColumnModel().getColumn(2).setMaxWidth(95);
            t_venda.getColumnModel().getColumn(3).setMinWidth(95);
            t_venda.getColumnModel().getColumn(3).setMaxWidth(95);
        }

        jLabel2.setText("Total :");

        bt_remover.setText("Remover Item");

        bt_salvar.setText("Salvar");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        bt_alterar.setText("Alterar");

        bt_excluir.setText("Excluir");
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });

        ct_cliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ct_cliente.setText("cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ct_nomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_pesquisar)
                        .addGap(105, 105, 105))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ct_total, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt_remover)
                                .addGap(57, 57, 57)
                                .addComponent(bt_salvar)
                                .addGap(18, 18, 18)
                                .addComponent(bt_alterar)
                                .addGap(18, 18, 18)
                                .addComponent(bt_excluir)
                                .addGap(56, 56, 56))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(ct_cliente)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(ct_cliente)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ct_nomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ct_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(bt_remover)
                    .addComponent(bt_salvar)
                    .addComponent(bt_alterar)
                    .addComponent(bt_excluir))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarActionPerformed
        // TODO add your handling code here:

             constroiVenda();
        
            buscarProduto buscar = new buscarProduto();
            buscar.armazenarDados(venda);
            buscar.setCliente(cl);
            buscar.arrumaTabela(ct_nomeProd.getText());
            buscar.setVisible(true);
            //fechar = true;
            buscar.setVisible(true);
            this.dispose();
       
           // CT_produto.requestFocus();
        
    }//GEN-LAST:event_bt_pesquisarActionPerformed

    private void t_vendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_vendaKeyReleased
        // TODO add your handling code here:
        int posicao = t_venda.getSelectedRow();
        int qtd = Integer.parseInt(t_venda.getValueAt(posicao, 1).toString());
        if(qtd <= 0){
            JOptionPane.showMessageDialog(null, "Valor Inválido");
            qtd = 1;
        }
        ProdutosVenda prodVenda = (ProdutosVenda) list.get(posicao);
        
        float total = prodVenda.getPreco()*qtd;
        BigDecimal formatar = new BigDecimal(total).setScale(2,RoundingMode.UP);
        total = formatar.floatValue();
        prodVenda.setTotalProduto(total);
        prodVenda.setQtdProduto(qtd);
        list.remove(posicao);
        list.add(posicao, prodVenda);
        arrumaTabela(list);
        
    }//GEN-LAST:event_t_vendaKeyReleased

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        // TODO add your handling code here:
        
        VendaControl vendaControle = new VendaControl();
        constroiVenda();
        if (!vendaControle.verificarItens(venda)) {
            JOptionPane.showMessageDialog(null, "Insira algum produto na venda");
        }
            if (codVenda == 0) {
            try {
                if (vendaControle.salvarVenda(venda)) {
                    //  retornarInicio();
                    this.dispose();
                      Inicial i = new Inicial();
                      i.setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(cadastrarVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            } else {
                if (vendaControle.atualizaVenda(venda)) {
                   // retornarInicio();
                   this.dispose();
                   Inicial i = new Inicial();
                   i.setVisible(true);
                }
            }
        
        
    }//GEN-LAST:event_bt_salvarActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        // TODO add your handling code here:
        produtosVenda.excluirTodos(venda.getCodVenda());
        VendaModel v = new VendaModel();
        v.excluir(venda.getCodVenda());
        visualizarVendas visu = new visualizarVendas();
        this.dispose();
        visu.setVisible(true);
        
    }//GEN-LAST:event_bt_excluirActionPerformed

    
    

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cadastrarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastrarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastrarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastrarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastrarVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_pesquisar;
    private javax.swing.JButton bt_remover;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JLabel ct_cliente;
    private javax.swing.JTextField ct_nomeProd;
    private javax.swing.JTextField ct_total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_venda;
    // End of variables declaration//GEN-END:variables


}
