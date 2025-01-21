
package forms;

import beans.Equipe;
import beans.Estoque;
import beans.Membro;
import dao.EquipeDAO;
import dao.MembroDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormEquipe extends javax.swing.JFrame {
    
    private void preencherTabelaEquipe(){
        EquipeDAO equipeDAO = new EquipeDAO();
        
        List<Equipe> listaEquipe = equipeDAO.getEquipes();
        
        if(listaEquipe == null){
            JOptionPane.showMessageDialog(this, "Erro ao carregar os dados da Equipe");
            return;
        }
        
        DefaultTableModel tabelaEquipe =(DefaultTableModel) tblEquipe.getModel();
        
        tabelaEquipe.setNumRows(0);
        
        for(Equipe e : listaEquipe){
            Object[] obj = new Object[]{
                e.getIdEquipe(),
                e.getNomeEquipe(),
                e.getFuncionario()
            };
            tabelaEquipe.addRow(obj);
        }
    }
    
    private void preencherTabelaMembro(){
        MembroDAO membroDAO = new MembroDAO();
        
        List<Membro> listaMembro = membroDAO.getMembros();
        
        if(listaMembro == null){
            JOptionPane.showMessageDialog(this, "Erro ao caregar os dados dos Membros");
            return;
        }
        
        DefaultTableModel tabelaMembro =(DefaultTableModel) tblMembro.getModel();
        
        tabelaMembro.setNumRows(0);
        
        for(Membro m : listaMembro){
            Object[] obj = new Object[]{
                m.getIdMembro(),
                m.getNomeMembro(),
                m.getEquipe()
            };
            tabelaMembro.addRow(obj);
        }
    }
    
    public FormEquipe() {
        initComponents();
        configurarTabelas();
        preencherTabelaEquipe();
        preencherTabelaMembro();
    }
    
    private void configurarTabelas(){
        String[] colunasEquipe = {"ID", "Nome da Equipe", "Nome do Líder"};
        tblEquipe.setModel(new DefaultTableModel(colunasEquipe, 0));
        
        String[] colunasMembro = {"ID", "Nome do Membro", "Nome da Equipe"};
        tblMembro.setModel(new DefaultTableModel(colunasMembro, 0));
    }
    
    private void limparCamposEquipe(){
        txtIdEquipe.setText("");
        txtNomeEquipe.setText("");
        txtIdLider.setText("");
    }
    
    private void limparCamposMembro(){
        txtIdEquipeMembro.setText("");
        txtNomeMembro.setText("");
        txtIdMembro.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdEquipe = new javax.swing.JTextField();
        txtNomeEquipe = new javax.swing.JTextField();
        txtIdLider = new javax.swing.JTextField();
        btnAddEquipe = new javax.swing.JButton();
        btnEditarEquipe = new javax.swing.JButton();
        btnExcluirEquipe = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdEquipeMembro = new javax.swing.JTextField();
        txtNomeMembro = new javax.swing.JTextField();
        btnAddMembro = new javax.swing.JButton();
        btnEditarMembro = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtIdMembro = new javax.swing.JTextField();
        btnExcluirMembro = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMembro = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEquipe = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Equipe ");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar Equipe"));

        jLabel1.setText("ID Equipe:");

        jLabel2.setText("Nome Equipe:");

        jLabel3.setText("ID Líder:");

        btnAddEquipe.setText("Adicionar");
        btnAddEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEquipeActionPerformed(evt);
            }
        });

        btnEditarEquipe.setText("Editar");
        btnEditarEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEquipeActionPerformed(evt);
            }
        });

        btnExcluirEquipe.setBackground(new java.awt.Color(255, 51, 51));
        btnExcluirEquipe.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirEquipe.setText("Excluir");
        btnExcluirEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirEquipeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeEquipe)
                            .addComponent(txtIdLider, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAddEquipe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(btnEditarEquipe)
                        .addGap(33, 33, 33)
                        .addComponent(btnExcluirEquipe)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdLider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddEquipe)
                    .addComponent(btnEditarEquipe)
                    .addComponent(btnExcluirEquipe))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar Membros da Equipe"));

        jLabel4.setText("ID Equipe:");

        jLabel5.setText("Nome Membro:");

        btnAddMembro.setText("Adicionar");
        btnAddMembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMembroActionPerformed(evt);
            }
        });

        btnEditarMembro.setText("Editar");
        btnEditarMembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMembroActionPerformed(evt);
            }
        });

        jLabel6.setText("ID Membro:");

        btnExcluirMembro.setBackground(new java.awt.Color(255, 51, 51));
        btnExcluirMembro.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirMembro.setText("Excluir");
        btnExcluirMembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirMembroActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("(ao cadastrar deixar em branco)");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnAddMembro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarMembro)
                        .addGap(27, 27, 27)
                        .addComponent(btnExcluirMembro))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdEquipeMembro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeMembro, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdMembro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIdEquipeMembro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNomeMembro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdMembro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddMembro)
                    .addComponent(btnEditarMembro)
                    .addComponent(btnExcluirMembro))
                .addContainerGap())
        );

        tblMembro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome do Membro", "Nome da Equipe"
            }
        ));
        jScrollPane3.setViewportView(tblMembro);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        tblEquipe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome da Equipe", "Nome do Líder"
            }
        ));
        tblEquipe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEquipeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEquipe);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(324, 324, 324))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEquipeActionPerformed
        
        int id = Integer.parseInt(txtIdEquipe.getText());
        String nome = txtNomeEquipe.getText();
        int lider = Integer.parseInt(txtIdLider.getText());
            
        Equipe eq = new Equipe();
        eq.setIdEquipe(id);
        eq.setNomeEquipe(nome);
        eq.setIdLider(lider);
            
        EquipeDAO equipeDAO = new EquipeDAO();
        
        try{
            equipeDAO.cadastrarEquipe(eq);
            JOptionPane.showMessageDialog(null, "Equipe cadastrada com sucesso");
            
            preencherTabelaEquipe();
            limparCamposEquipe();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Equipe: " + e.getMessage());
        }
           
    }//GEN-LAST:event_btnAddEquipeActionPerformed

    private void btnAddMembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMembroActionPerformed
        
            int idEquipe = Integer.parseInt(txtIdEquipeMembro.getText());
            String nomeMembro = txtNomeMembro.getText();
            int idMembro = Integer.parseInt(txtIdEquipeMembro.getText());
            
            
            
            Membro m = new Membro();
            m.setIdEquipe(idEquipe);
            m.setNomeMembro(nomeMembro);
            m.setIdMembro(idMembro);
                
            MembroDAO membroDAO = new MembroDAO();
            
            try{
                membroDAO.cadastrarMembro(m);
                JOptionPane.showMessageDialog(null, "Membro de Equipe cadastrado com sucesso");
                
                preencherTabelaMembro();
                limparCamposMembro();
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar Membro de Equipe: " + e.getMessage());
            }
            
            
            
            
        
    }//GEN-LAST:event_btnAddMembroActionPerformed

    private void tblEquipeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEquipeMouseClicked
        
    }//GEN-LAST:event_tblEquipeMouseClicked

    private void btnEditarEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEquipeActionPerformed
        int selectedRow = tblEquipe.getSelectedRow();
        if (selectedRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Selecione uma equipe para editar");
            return;
        }
        int id = Integer.parseInt(txtIdEquipe.getText());
        String nome = txtNomeEquipe.getText();
        int lider = Integer.parseInt(txtIdLider.getText());
        
        Equipe eq = new Equipe();
        eq.setIdEquipe(id);
        eq.setNomeEquipe(nome);
        eq.setIdLider(lider);
        
        EquipeDAO equipeDAO = new EquipeDAO();
        
        try{
            equipeDAO.editarEquipe(eq);
            JOptionPane.showMessageDialog(null, "Equipe atualizada com sucesso");
            
            preencherTabelaEquipe();
            limparCamposEquipe();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Equipe: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnEditarEquipeActionPerformed

    private void btnEditarMembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMembroActionPerformed
        int selectedRow = tblMembro.getSelectedRow();
        if (selectedRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Selecione um membro para editar ");
            return;
        }
        
        int idEquipe = Integer.parseInt(txtIdEquipeMembro.getText());
        String nomeMembro = txtNomeMembro.getText();
        int idMembro = Integer.parseInt(txtIdMembro.getText());
            
        Membro m = new Membro();
        m.setIdEquipe(idEquipe);
        m.setNomeMembro(nomeMembro);
        m.setIdMembro(idMembro);
                
        MembroDAO membroDAO = new MembroDAO();
            
        try{
            membroDAO.editarMembro(m);
            JOptionPane.showMessageDialog(null, "Membro de Equipe atualizado com sucesso");
                
            preencherTabelaMembro();
            limparCamposMembro();
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Membro de Equipe: " + e.getMessage());
        }
        
        
    }//GEN-LAST:event_btnEditarMembroActionPerformed

    private void btnExcluirEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirEquipeActionPerformed
        int selectedRow = tblEquipe.getSelectedRow();
        if (selectedRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Selecione uma Equipe para excluir ");
            return;
        }
        
        int confirmar = JOptionPane.showConfirmDialog(rootPane, "Deseja remover a Equipe selecionada?", "Confirmar remoção", JOptionPane.YES_NO_OPTION);
        if(confirmar == JOptionPane.YES_OPTION){
            
            int id = (int) tblEquipe.getValueAt(selectedRow, 0);
            
            EquipeDAO equipeDAO = new EquipeDAO();
            equipeDAO.excluir(id);
            
            JOptionPane.showMessageDialog(rootPane, "Equipe excluída com sucesso");
            
            preencherTabelaEquipe();
        }
    }//GEN-LAST:event_btnExcluirEquipeActionPerformed

    private void btnExcluirMembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirMembroActionPerformed
        int selectedRow = tblMembro.getSelectedRow();
        if (selectedRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Selecione um Membro para excluir ");
            return;
        }
        
        int confirmar = JOptionPane.showConfirmDialog(rootPane, "Deseja remover o Membro selecionado?", "Confirmar remoção", JOptionPane.YES_NO_OPTION);
        if(confirmar == JOptionPane.YES_OPTION){
            
            int id = (int) tblMembro.getValueAt(selectedRow, 0);
            
            MembroDAO membroDAO = new MembroDAO();
            membroDAO.excluir(id);
            
            JOptionPane.showMessageDialog(rootPane, "Membro excluído com sucesso");
            
            preencherTabelaMembro();
        }
    }//GEN-LAST:event_btnExcluirMembroActionPerformed

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
            java.util.logging.Logger.getLogger(FormEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormEquipe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEquipe;
    private javax.swing.JButton btnAddMembro;
    private javax.swing.JButton btnEditarEquipe;
    private javax.swing.JButton btnEditarMembro;
    private javax.swing.JButton btnExcluirEquipe;
    private javax.swing.JButton btnExcluirMembro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblEquipe;
    private javax.swing.JTable tblMembro;
    private javax.swing.JTextField txtIdEquipe;
    private javax.swing.JTextField txtIdEquipeMembro;
    private javax.swing.JTextField txtIdLider;
    private javax.swing.JTextField txtIdMembro;
    private javax.swing.JTextField txtNomeEquipe;
    private javax.swing.JTextField txtNomeMembro;
    // End of variables declaration//GEN-END:variables
}
