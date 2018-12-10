/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import DAO.ContaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Conta;
import model.Conta;

/**
 *
 * @author Lucas
 */
public class CRUDConta extends javax.swing.JFrame {

    /**
     * Creates new form CRUDConta
     */
    
    Connection conexao = Conexao.ConnectionFactory.getConexao();
    ContaDAO dDAO = new ContaDAO(conexao);
    Conta c = new Conta();
    private List<Conta> listaContas;
    private Conta conta = null;
    
    public CRUDConta() {
        initComponents();
        setLocationRelativeTo( null );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        TxtIDCliente = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtRemove = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro Conta Corrente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel9.setText("Saldo");

        jLabel10.setText("ID DO CLIENTE");

        jLabel3.setText("ID");

        txtId.setEditable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtIDCliente)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setText("Limpar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtRemove.setText("Remover");
        txtRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRemoveActionPerformed(evt);
            }
        });

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Saldo", "ID Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(txtRemove)
                    .addComponent(jButton1))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.limpa();
        jTable1.getSelectionModel().clearSelection();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRemoveActionPerformed
      String sid = txtRemove.getText();
        int id = Integer.valueOf(sid);
        try {
            dDAO.deleta(id);
        } catch (SQLException ex) {
            Logger.getLogger(CRUDConta.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
        JOptionPane.showMessageDialog(null, "Cliente deletado!");
    }//GEN-LAST:event_txtRemoveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Double Saldo = new Double(txtSaldo.getText());        
        String sid = TxtIDCliente.getText();
        int Idc = Integer.valueOf(sid);
        c.setIdCliente(Idc);
        this.adiciona();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      /*  String rg;
        String n;
        String uf;
        this.txtId.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        this.txtSaldo.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        this.txtCpf.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        rg = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
        uf = rg.substring(0, 2);
        n = rg.substring(3, 13);
        this.txtRg.setText(n);
        this.txtUf.setSelectedItem(uf);
        this.txtSenha.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        this.txtNap.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());*/
    }//GEN-LAST:event_jTable1MouseClicked
     private void msgValidacao() {
        String dados1 = "";
        String dados2 = "";
        if (txtNome.getText().isEmpty()) {
            dados1 += "\nNome";
        }
       /* if (txtCpf.getText().contains(" ") || cpf.isCPF(txtCpf.getText()) == false) {
            dados1 += "\nCPF";
        }*/
        if (txtNiver.getText().contains(" "))
        {
            dados1 += "\nNiver";
        }
        if (c.getSenha().length() == 0) {
            dados1 += "\nSenha";
        }
        if (dados1 != "") {
            dados1 = "Os seguintes dados sÃ£o invÃ¡lidos ou nÃ£o foram preenchidos corretamente: " + dados1;
            JOptionPane.showMessageDialog(this, dados1);

        }

        if (cDAO.checkCpf(txtCpf.getText()) && (jTable1.getSelectedRow() != -1)) {
            dados2 = "\n\nCPF jÃ¡ cadastrado!";

        }

        if ((dados2 != "") && (jTable1.getSelectedRow() == -1)) {
            dados2 = "Os seguintes dados jÃ¡ foram cadastrados no sistema: " + dados2;
            JOptionPane.showMessageDialog(this, dados2);

        }
        if (c.getSenha().length() < 8 && c.getSenha().length() > 0) {
            JOptionPane.showMessageDialog(this, "Sua senha Ã© fraca! VocÃª deve usar pelo menos 8 caracteres para sua seguranÃ§a.");

        }

    }

    private void alterar() {
        String msg = "";
        String cpf;
        String niver;
        Cliente c1 = new Cliente();
        if (c != null
                && !txtNome.getText().isEmpty()                
                && !txtCpf.getText().contains(" ")
                && !txtNiver.getText().contains(" ")
                //&& this.cpf.isCPF(txtCpf.getText()) == true                
                && c.getSenha().length() >= 8
                ) {

            int id = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            c1 = cDAO.mostrar(id);
            cpf = txtCpf.getText();
            niver = txtNiver.getText();

            if ((!c1.getCpf().equals(cpf)) && cDAO.checkCpf(txtCpf.getText())) {
                msg += "\n\nCPF";
            }

            /*if ((!c1.getDataNasc().equals(niver)) && cDAO.checkRg(txtNiver.getText())) {
                msg += "\n\nAniversario";
            }*/
            if (msg != "") {
                msg = "Os seguintes dados jÃ¡ estÃ£o cadastrados no sistema: " + msg;
                JOptionPane.showMessageDialog(this, msg);

            } else {
                this.alteracao();
            }

        } else {
            this.msgValidacao();
        }

    }

    private void adicionar() {

        if (c != null
                && !txtNome.getText().isEmpty()
                && !txtCpf.getText().contains(" ")
                && !txtNiver.getText().contains(" ")
                //&& this.cpf.isCPF(txtCpf.getText()) == true                
                && c.getSenha().length() >= 8
                && !cDAO.checkCpf(txtCpf.getText())
                ) {

            cDAO.inserir(c);
            this.atualiza();
            this.limpa();            
            JOptionPane.showMessageDialog(this, "Cliente adicionado com sucesso.");
            System.out.println(cDAO.mostrarTodos());

        } else {
            this.msgValidacao();

        }

    }

    private void alteracao() {
        
        int id1 = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        c.setIdCliente(id1);
        cDAO.alterar(c);
        this.limpa();
        this.atualiza();
        JOptionPane.showMessageDialog(this, "Cliente alterado com sucesso.");
    }
    
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        TelaADM tADM = new TelaADM();
        dispose();
        tADM.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    /*
    public void atualiza() {
        List<Conta> clientes = this.cDAO.mostrarTodos();
        System.out.println(clientes.toString());

        modeloTabela.setRowCount(0);
        for (Cliente i : clientes) {
            this.modeloTabela.addRow(new Object[]{i.getIdCliente(), i.getNome(), i.getCpf(), i.getDataNasc(), i.getSenha()});
        }

    }
*/
    private void limpa() {
        this.txtSaldo.setText("");
        this.TxtIDCliente.setText("");

    }
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
            java.util.logging.Logger.getLogger(CRUDConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtIDCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtId;
    private javax.swing.JButton txtRemove;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
