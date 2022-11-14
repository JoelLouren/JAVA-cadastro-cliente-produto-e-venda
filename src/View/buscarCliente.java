/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Modelo.ClienteModel;
import Objetos.Cliente;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Beth
 */
public class buscarCliente extends javax.swing.JFrame {

    
    
    ClienteModel cli = new ClienteModel();
    /**
     * Creates new form buscarCliente
     */
    public buscarCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        //arrumaTab();
    }
    


    
    
    public void arrumaTab (){
       
        ArrayList resultado = cli.pesquisar("");
        if (resultado != null) {
            DefaultTableModel modelo = (DefaultTableModel) tabela_clie.getModel();
            System.out.println(modelo.getRowCount());
            System.out.println(resultado.size());
            while (modelo.getRowCount() != 0) {
                modelo.removeRow(0);
            }   
            for (int i = 0; i < resultado.size(); i++) {
                Cliente client = new Cliente();
                client = (Cliente) resultado.get(i);
                String[] linha = new String[3];
                linha[0] = String.valueOf(client.getCod());
                linha[1] = client.getNome();
                linha[2] = client.getEndereco();
                modelo.addRow(linha);
                tabela_clie.setModel(modelo);
            }
        } else {
            System.out.println("\nArrayList retornou nulo");
        }
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_clie = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busca de clientes");
        setMinimumSize(new java.awt.Dimension(600, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Clientes encontrados ");

        tabela_clie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cod", "Nome", "Endereço"
            }
        ));
        tabela_clie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_clieMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_clie);
        if (tabela_clie.getColumnModel().getColumnCount() > 0) {
            tabela_clie.getColumnModel().getColumn(0).setMinWidth(60);
            tabela_clie.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        Inicial i = new Inicial();
        i.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void tabela_clieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_clieMouseClicked
        // TODO add your handling code here:
        int linhaTab = tabela_clie.getSelectedRow();
        Cliente c = new Cliente();
        c.setCod(Integer.parseInt(tabela_clie.getValueAt(linhaTab, 0).toString()));
        c.setNome(tabela_clie.getValueAt(linhaTab, 1).toString());
        c.setEndereco(tabela_clie.getValueAt(linhaTab, 2).toString());
        cadastrarVenda cv = new cadastrarVenda();
        cv.arrumarTela(c);
        cv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tabela_clieMouseClicked

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
            java.util.logging.Logger.getLogger(buscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buscarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabela_clie;
    // End of variables declaration//GEN-END:variables
}
