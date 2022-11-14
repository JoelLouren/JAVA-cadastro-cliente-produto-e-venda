
package View;

import Banco.Banco;
import Objetos.Cliente;
//import Modelo.ClienteModel;
import Controle.ClienteControl;
//import javax.swing.JOptionPane;


public class cadastroCliente extends javax.swing.JFrame {

    private Banco banco;
    private int cod;
    
    
    
    
    
    
    
    
    
            
    public cadastroCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
   

  
    
        // ARRUMAR TELA PARA INSERT
        public void arrumarTela() {
        ct_nome.setText("");
        ct_endereco.setText("");
        bt_salvar.setEnabled(true);
        bt_atualizar.setEnabled(false);
        bt_excluir.setEnabled(false);
    }
        
        
        //Coloca os valores nos campos para update
        public void arrumarTela(Cliente client) {
        ct_nome.setText(client.getNome());
        ct_endereco.setText(client.getEndereco());
        ct_nome.setEditable(false);
        ct_endereco.setEditable(false);
        bt_excluir.setEnabled(true);
        bt_atualizar.setEnabled(true);
        bt_salvar.setEnabled(false);
        cod = client.getCod();
    }
    
    
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ct_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ct_endereco = new javax.swing.JTextField();
        bt_salvar = new javax.swing.JButton();
        bt_atualizar = new javax.swing.JButton();
        bt_excluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Clientes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel2.setText("Endereço::");

        bt_salvar.setText("Salvar");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        bt_atualizar.setText("Alterar");
        bt_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_atualizarActionPerformed(evt);
            }
        });

        bt_excluir.setText("Excluir");
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(ct_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                    .addComponent(ct_endereco)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_salvar)
                        .addGap(83, 83, 83)
                        .addComponent(bt_atualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_excluir)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ct_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ct_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_salvar)
                    .addComponent(bt_atualizar)
                    .addComponent(bt_excluir))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
  
        ClienteControl validar= new ClienteControl();
        Cliente client = new Cliente();

            client.setNome(ct_nome.getText());
            client.setCod(cod);
            client.setEndereco(ct_endereco.getText());
            if(validar.validarCampos(client)){
            arrumarTela();
            this.dispose();
            visualizarClientes v = new visualizarClientes();
            v.setVisible(true);
            }       
    }//GEN-LAST:event_bt_salvarActionPerformed

    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        visualizarClientes visu = new visualizarClientes();
        visu.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    
    private void bt_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_atualizarActionPerformed
        // TODO add your handling code here:
        ct_nome.setEditable(true);
        ct_endereco.setEditable(true);
        bt_salvar.setEnabled(true);
        bt_atualizar.setEnabled(false);
        bt_excluir.setEnabled(false);
        ct_nome.requestFocus();
    }//GEN-LAST:event_bt_atualizarActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        
        ClienteControl validar=new ClienteControl();
        validar.excluir(cod);
        this.dispose();
        Inicial i = new Inicial();
        i.setVisible(true);
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
            java.util.logging.Logger.getLogger(cadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_atualizar;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JTextField ct_endereco;
    private javax.swing.JTextField ct_nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
