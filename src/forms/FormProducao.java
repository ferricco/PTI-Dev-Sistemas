
package forms;

import beans.Equipe;
import beans.Producao;
import dao.ProducaoDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormProducao extends javax.swing.JFrame {

    private final String[] tableColumns = {"ID", "Nome do Processo", "Data Inicio", "Data Final", "Status","Nome da Equipe", "ID Estoque"};
    DefaultTableModel tableModel;
    private final List<Producao> listaProducao = new ArrayList<>();
    private int editandoIndex = -1;
    
    private void preencherTabela(){
        ProducaoDAO producaoDAO = new ProducaoDAO();
        
        List<Producao> listaProducoes = producaoDAO.getProducoes();
        
        if(listaProducoes == null){
            JOptionPane.showMessageDialog(this, "Erro ao carregar Tabela");
            return;
        }
        
        DefaultTableModel tabelaProducao = (DefaultTableModel) tblProducao.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        tabelaProducao.setNumRows(0);
        
        for(Producao p : listaProducoes){
            String dataComeco = sdf.format(p.getDataInicio());
            String dataTermino = sdf.format(p.getDataFim());
            
            Object[] obj = new Object[]{
                p.getId(),
                p.getNomeProcesso(),
                dataComeco,
                dataTermino,
                p.getStatus(),
                p.getEquipe(),
                p.getIdEstoque()
            };
            tabelaProducao.addRow(obj);
        }
    }
    
    private void limparCampos(){
        txtProcesso.setText("");
        txtDatainicio.setText("");
        txtDatafinal.setText("");
        txtStatus.setText("");
        txtIdEquipe.setText("");
        editandoIndex = -1;
    }
    
    
    public FormProducao() {
        initComponents();
 
        tableModel = new DefaultTableModel(tableColumns, 0);
        tblProducao.setModel(tableModel);
        
        preencherTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtProcesso = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtIdEquipe = new javax.swing.JTextField();
        txtDatainicio = new javax.swing.JTextField();
        txtDatafinal = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Processo da Produção");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Produção");

        jLabel3.setText("Nome do Processo:");

        jLabel4.setText("Data Inicio:");

        jLabel5.setText("Data final:");

        jLabel6.setText("Status:");

        jLabel7.setText("ID da Equipe:");

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

        tblProducao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome do Processo", "Data Inicio", "Data Final", "Status", "ID Equipe", "ID Estoque"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProducao);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(301, 301, 301))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtIdEquipe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProcesso, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDatainicio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtDatafinal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDatainicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(jLabel5)
                    .addComponent(txtDatafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(txtIdEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        String processo = txtProcesso.getText();
        String dataInicio = txtDatainicio.getText();
        String dataFinal = txtDatafinal.getText();
        String status = txtStatus.getText();
        int idEquipe = Integer.parseInt(txtIdEquipe.getText());
        
        if(processo.isEmpty() || dataInicio.isEmpty() || dataFinal.isEmpty() || status.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");
        }
        
        
        Producao p = new Producao();
        p.setNomeProcesso(processo);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            p.setDataInicio(sdf.parse(txtDatainicio.getText()));
            p.setDataFim(sdf.parse(txtDatafinal.getText()));
        }catch (ParseException ex) {
            System.out.println("Erro ao cadastrar data");
        }
        
        p.setStatus(status);
        p.setIdEquipe(idEquipe);
        
        ProducaoDAO producaoDAO = new ProducaoDAO();
        producaoDAO.cadastrarProducao(p);
        
        preencherTabela();
        limparCampos();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int SelectedRow = tblProducao.getSelectedRow();
        if(SelectedRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha para editar");
            return;
        }
        
        int idProducao = Integer.parseInt(tblProducao.getValueAt(tblProducao.getSelectedRow(), 0).toString());
        
        String processo = txtProcesso.getText();
        String status = txtStatus.getText();
        int idEquipe = Integer.parseInt(txtIdEquipe.getText());
        
        Producao p = new Producao();
        p.setId(idProducao);
        p.setNomeProcesso(processo);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            p.setDataInicio(sdf.parse(txtDatainicio.getText()));
            p.setDataFim(sdf.parse(txtDatafinal.getText()));
        }catch (ParseException ex) {
            System.out.println("Erro ao cadastrar data");
        }
        
        p.setStatus(status);
        p.setIdEquipe(idEquipe);
        
        ProducaoDAO producaoDAO = new ProducaoDAO();
        try{
            producaoDAO.editarProducao(p);
            JOptionPane.showMessageDialog(null, "Processo de Produção atualizado com sucesso");
            
            preencherTabela();
            limparCampos();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Processo de Produção: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int SelectedRow = tblProducao.getSelectedRow();
        if(SelectedRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha para remover");
            return;
        }
        
        int confirmar = JOptionPane.showConfirmDialog(rootPane, "Deseja remover o funcionário selecionado?", "Confirmar Remoção", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION){
           
            int id = (int) tblProducao.getValueAt(SelectedRow, 0);
            
            ProducaoDAO producaoDAO = new ProducaoDAO();
            producaoDAO.excluir(id);
            
            JOptionPane.showMessageDialog(rootPane, "Processo de Producao removido com sucesso!");
            
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
            java.util.logging.Logger.getLogger(FormProducao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProducao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProducao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProducao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormProducao().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProducao;
    private javax.swing.JTextField txtDatafinal;
    private javax.swing.JTextField txtDatainicio;
    private javax.swing.JTextField txtIdEquipe;
    private javax.swing.JTextField txtProcesso;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
