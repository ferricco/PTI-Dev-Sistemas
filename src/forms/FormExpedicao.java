
package forms;

import beans.Expedicao;
import dao.ExpedicaoDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormExpedicao extends javax.swing.JFrame {

    private final String[] tableColumns = {"ID", "Modo de Envio", "Data do Envio", "Status", "ID do Lote"};
    DefaultTableModel tableModel;
    private final List<Expedicao> listaExpedicao = new ArrayList<>();
    
    private void preencherTabela(){
        ExpedicaoDAO expedicaoDAO = new ExpedicaoDAO();
        
        List<Expedicao> listaExpedicoes = expedicaoDAO.getExpedicoes();
        
        if(listaExpedicoes == null){
            JOptionPane.showMessageDialog(this, "Erro ao carregar Tabela");
            return;
        }
        
        DefaultTableModel tabelaExpedicao = (DefaultTableModel) tblExpedicao.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        tabelaExpedicao.setNumRows(0);
        
        for(Expedicao ex: listaExpedicoes){
            String dataEnvio = sdf.format(ex.getDataEnvio());
            
            Object[] obj = new Object[]{
                ex.getId(),
                ex.getModoEnvio(),
                dataEnvio,
                ex.getStatus(),
                ex.getIdLote()
            };
            tabelaExpedicao.addRow(obj);
        }
    }
    
    private void limparCampos(){
        txtModoEnvio.setText("");
        txtDataEnvio.setText("");
        txtStatus.setText("");
        txtIdLote.setText("");
    }

    
    public FormExpedicao() {
        initComponents();
        
        tableModel = new DefaultTableModel(tableColumns, 0);
        tblExpedicao.setModel(tableModel);
        
        preencherTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtModoEnvio = new javax.swing.JTextField();
        txtDataEnvio = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtIdLote = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExpedicao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Expedição");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Expedição");

        jLabel3.setText("Modo de Envio:");

        jLabel4.setText("Data do Envio:");

        jLabel5.setText("Status:");

        jLabel6.setText("ID do Lote:");

        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(255, 51, 51));
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tblExpedicao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Modo de Envio", "Data do Envio", "Status", "ID do Lote"
            }
        ));
        jScrollPane1.setViewportView(tblExpedicao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtModoEnvio)
                            .addComponent(txtDataEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdLote, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(txtModoEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar)
                    .addComponent(txtDataEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        String envio = txtModoEnvio.getText();
        String dataEnvio = txtDataEnvio.getText();
        String status = txtStatus.getText();
        int idLote = Integer.parseInt(txtIdLote.getText());
        
        if(envio.isEmpty() || dataEnvio.isEmpty() || status.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");
        }
        
        Expedicao e = new Expedicao();
        e.setModoEnvio(envio);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            e.setDataEnvio(sdf.parse(txtDataEnvio.getText()));
        }catch (ParseException ex) {
            System.out.println("Erro ao cadastrar data");
        }
        
        e.setStatus(status);
        e.setIdLote(idLote);
        
        ExpedicaoDAO expedicaoDAO = new ExpedicaoDAO();
        expedicaoDAO.cadastrarExpedicao(e);
        
        preencherTabela();
        limparCampos();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int SelectedRow = tblExpedicao.getSelectedRow();
        if(SelectedRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha para editar");
            return;
        }
        
        int id = Integer.parseInt(tblExpedicao.getValueAt(tblExpedicao.getSelectedRow(), 0).toString());
        
        String modoEnvio = txtModoEnvio.getText();
        String status = txtStatus.getText();
        int idLote = Integer.parseInt(txtIdLote.getText());
        
        Expedicao e = new Expedicao();
        e.setId(id);
        e.setModoEnvio(modoEnvio);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            e.setDataEnvio(sdf.parse(txtDataEnvio.getText()));
        }catch(ParseException ex){
            System.out.println("Erro ao cadastrar Data");
        }
        
        e.setStatus(status);
        e.setIdLote(idLote);
        
        ExpedicaoDAO expedicaoDAO = new ExpedicaoDAO();
        try{
            expedicaoDAO.editarExpedicao(e);
            JOptionPane.showMessageDialog(null, "Expedição atualizada com sucesso");
            
            preencherTabela();
            limparCampos();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Expedição: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int SelectedRow = tblExpedicao.getSelectedRow();
        if(SelectedRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha para remover");
            return;
        }
        
        int confirmar = JOptionPane.showConfirmDialog(rootPane, "Deseja remover Expedição selecionada?", "Confirmar Remoção", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION){
            
            int id = (int) tblExpedicao.getValueAt(SelectedRow, 0);
            
            ExpedicaoDAO expedicaoDAO = new ExpedicaoDAO();
            expedicaoDAO.excluirExpedicao(id);
            
            JOptionPane.showMessageDialog(rootPane, "Expedição removido com sucesso");
            
            preencherTabela();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(FormExpedicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormExpedicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormExpedicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormExpedicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormExpedicao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblExpedicao;
    private javax.swing.JTextField txtDataEnvio;
    private javax.swing.JTextField txtIdLote;
    private javax.swing.JTextField txtModoEnvio;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
