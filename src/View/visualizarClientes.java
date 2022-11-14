
package View;


import Objetos.Cliente;
import Modelo.ClienteModel;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;



public class visualizarClientes extends javax.swing.JFrame {

    
    
    
    
    
    
    
    
    ClienteModel clientModel = new ClienteModel();
    
    public visualizarClientes() {
        initComponents();
        this.setLocationRelativeTo(null);
        arrumarTela();
    }
    
    
    

    
    
    
        public void arrumarTela() {
        ct_nome.setText("");
        ct_nome.requestFocus();
        arrumaTabela();
    }
        
        
      
        
                public void arrumaTabela() {
        ArrayList resultado = clientModel.pesquisar(ct_nome.getText());
        if (resultado != null) {
            DefaultTableModel modelo = (DefaultTableModel) tabela_cli.getModel();
            //System.out.println(modelo.getRowCount());
            //System.out.println(resultado.size());
            while (modelo.getRowCount() != 0) {
                modelo.removeRow(0);
                            System.out.println(modelo.getRowCount());

            } 
            for (int i = 0; i < resultado.size(); i++) {
                Cliente client = new Cliente();
                client = (Cliente) resultado.get(i);
                String[] linha = new String[3];
                linha[0] = String.valueOf(client.getCod());
                linha[1] = client.getNome();
                linha[2] = client.getEndereco();
                modelo.addRow(linha);
                tabela_cli.setModel(modelo);
            }
        } else {
            System.out.println("\nArrayList retornou nulo");
        }
    }
        

   
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ct_nome = new javax.swing.JTextField();
        btn_pesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_cli = new javax.swing.JTable();
        btn_novo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Clientes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Nome:");

        btn_pesquisar.setText("Pesquisar");
        btn_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisarActionPerformed(evt);
            }
        });

        tabela_cli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Nome", "Endereço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabela_cli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_cliMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_cli);
        if (tabela_cli.getColumnModel().getColumnCount() > 0) {
            tabela_cli.getColumnModel().getColumn(0).setMinWidth(35);
            tabela_cli.getColumnModel().getColumn(0).setPreferredWidth(35);
            tabela_cli.getColumnModel().getColumn(0).setMaxWidth(40);
        }
        tabela_cli.getAccessibleContext().setAccessibleName("");

        btn_novo.setText("Novo");
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ct_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_pesquisar)
                        .addGap(72, 72, 72)
                        .addComponent(btn_novo)))
                .addContainerGap(90, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ct_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pesquisar)
                    .addComponent(btn_novo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisarActionPerformed
        // TODO add your handling code here:
        arrumaTabela();
        ct_nome.setText("");
        ct_nome.requestFocus();
    }//GEN-LAST:event_btn_pesquisarActionPerformed

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        // TODO add your handling code here:
        cadastroCliente cad = new cadastroCliente();
        this.setVisible(false);
        cad.arrumarTela();
        cad.setVisible(true);
    }//GEN-LAST:event_btn_novoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Inicial ini = new Inicial();
        ini.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void tabela_cliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_cliMouseClicked
        // TODO add your handling code here:
        int linha = tabela_cli.getSelectedRow();
        Cliente client = new Cliente();
        client.setCod(Integer.parseInt(tabela_cli.getValueAt(linha, 0).toString()));
        client.setNome(tabela_cli.getValueAt(linha, 1).toString());
        client.setEndereco(tabela_cli.getValueAt(linha, 2).toString());
        this.setVisible(false);
        cadastroCliente clicad = new cadastroCliente();
        clicad.arrumarTela(client);
        clicad.setVisible(true);
        ct_nome.setText("");
    }//GEN-LAST:event_tabela_cliMouseClicked

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
            java.util.logging.Logger.getLogger(visualizarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(visualizarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(visualizarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(visualizarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new visualizarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_pesquisar;
    private javax.swing.JTextField ct_nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_cli;
    // End of variables declaration//GEN-END:variables
}
