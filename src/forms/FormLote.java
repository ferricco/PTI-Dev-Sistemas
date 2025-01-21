
package forms;

import beans.Lote;
import dao.LoteDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormLote extends javax.swing.JFrame {

    private final String[] tableColumns = {"ID", "Prioridade", "Fragilidade", "Data do Lote", "Status", "ID do Processo"};
    DefaultTableModel tableModel;
    private final List<Lote> listaLote = new ArrayList<>();
    
    private void preencherTabela(){
        LoteDAO loteDAO = new LoteDAO();
        
        List<Lote> listaLotes = loteDAO.getLotes();
        
        if(listaLotes == null){
            JOptionPane.showMessageDialog(this, "Erro ao carregar Tabela");
            return;
        }
        
        DefaultTableModel tabelaLote = (DefaultTableModel) tblLote.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        tabelaLote.setNumRows(0);
        
        for(Lote l : listaLotes){
            String dataLote = sdf.format(l.getDataLote());
            
            Object[] obj = new Object[]{
                l.getId(),
                l.getPrioridade(),
                l.getFragilidade(),
                dataLote,
                l.getStatus(),
                l.getProducao()
            };
            tabelaLote.addRow(obj);
        }
    }
    
    private void limparCampos(){
        txtPrioridade.setText("");
        txtFragilidade.setText("");
        txtDataLote.setText("");
        txtStatus.setText("");
        txtIdProcesso.setText("");
    }
    
    
    public FormLote() {
        initComponents();
        
        tableModel =  new DefaultTableModel(tableColumns, 0);
        tblLote.setModel(tableModel);
        
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
        jLabel7 = new javax.swing.JLabel();
        txtPrioridade = new javax.swing.JTextField();
        txtFragilidade = new javax.swing.JTextField();
        txtDataLote = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtIdProcesso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLote = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lote");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Lote");

        jLabel3.setText("Prioridade:");

        jLabel4.setText("Fragilidade:");

        jLabel5.setText("Data do Lote:");

        jLabel6.setText("Status:");

        jLabel7.setText("ID do processo:");

        tblLote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Prioridade", "Fragilidade", "Data do Lote", "Status", "ID do processo"
            }
        ));
        jScrollPane1.setViewportView(tblLote);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel3)
                                .addGap(31, 31, 31)
                                .addComponent(txtPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDataLote, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFragilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExcluir)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFragilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(txtIdProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDataLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        String prioridade = txtPrioridade.getText();
        String fragilidade = txtFragilidade.getText();
        String dataLote = txtDataLote.getText();
        String status = txtStatus.getText();
        int idProcesso = Integer.parseInt(txtIdProcesso.getText());
        
        if(prioridade.isEmpty() || fragilidade.isEmpty() || dataLote.isEmpty() || status.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos!");
            return;
        }
        
        
        Lote l = new Lote();
        l.setPrioridade(prioridade);
        l.setFragilidade(fragilidade);
            
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            l.setDataLote(sdf.parse(txtDataLote.getText()));
        }catch (ParseException ex) {
            System.out.println("Erro ao cadastrar data");
        }

        l.setStatus(status);
        l.setIdProcesso(idProcesso);

        LoteDAO loteDAO = new LoteDAO();
        loteDAO.cadastrarLote(l);
        
        preencherTabela();
        limparCampos();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int SelectedRow = tblLote.getSelectedRow();
        if(SelectedRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha para editar");
            return;
        }
        
        int idLote = Integer.parseInt(tblLote.getValueAt(tblLote.getSelectedRow(), 0).toString());
        
        String prioridade = txtPrioridade.getText();
        String fragilidade = txtFragilidade.getText();
        String dataLote = txtDataLote.getText();
        String status = txtStatus.getText();
        int idProcesso = Integer.parseInt(txtIdProcesso.getText());
        
        if(prioridade.isEmpty() || fragilidade.isEmpty() || dataLote.isEmpty() || status.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");
        }
        
        
        Lote l = new Lote();
        l.setId(idLote);
        l.setPrioridade(prioridade);
        l.setFragilidade(fragilidade);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            l.setDataLote(sdf.parse(txtDataLote.getText()));
        }catch (ParseException ex) {
            System.out.println("Erro ao cadastrar data");
        }
        
        l.setStatus(status);
        l.setIdProcesso(idProcesso);
        
        LoteDAO loteDAO = new LoteDAO();
        try{
            loteDAO.editarLote(l);
            JOptionPane.showMessageDialog(null, "Lote atualizado com sucesso");
            
            limparCampos();
            preencherTabela();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Lote: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int SelectedRow = tblLote.getSelectedRow();
        if(SelectedRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha para remover");
            return;
        }
        
        int confirmar = JOptionPane.showConfirmDialog(rootPane, "Deseja remover o Lote selecionado?", "Confirmar Remoção", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION){
            
            int id = (int) tblLote.getValueAt(SelectedRow, 0);
            
            LoteDAO loteDAO = new LoteDAO();
            loteDAO.excluir(id);
            
            JOptionPane.showMessageDialog(rootPane, "Lote removido com sucesso!");
            
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
            java.util.logging.Logger.getLogger(FormLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLote().setVisible(true);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLote;
    private javax.swing.JTextField txtDataLote;
    private javax.swing.JTextField txtFragilidade;
    private javax.swing.JTextField txtIdProcesso;
    private javax.swing.JTextField txtPrioridade;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
