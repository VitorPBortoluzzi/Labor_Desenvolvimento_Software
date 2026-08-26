/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pkg2_continuacao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author laboratorio
 */
public class Formulario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Formulario.class.getName());

    /**
     * Creates new form NewJFrame
     */
    public char sexo;
    public boolean astronomia,esportes,tecnologias;
    private Arquivo arquivo;
    private List<Pessoa> listaPessoas;
    
    private void limparCampos() {
        txtF_nome.setText("");
        
        btnGrp_sexo.clearSelection();

        chkBox_Tecnologia.setSelected(false);
        chkBox_Astronomia.setSelected(false);
        chkBox_Esportes.setSelected(false);

        cmbBox_idiomas.setSelectedIndex(0);

        txtF_nome.requestFocus();
    }
    
    private void carregarTabela(){
        DefaultTableModel tabela = (DefaultTableModel) jTable_arquivotxt.getModel();
        
        tabela.setRowCount(0);
        
        for (Pessoa p : listaPessoas) {
            txtA_area.append(p.toString() + "\n");
            tabela.addRow(p.obterDados());
        }  
    }
    
    public Formulario() {
        initComponents();
        arquivo = new Arquivo("Pessoas");
        listaPessoas = arquivo.leArquivo();
        carregarTabela();
        
        jTable_arquivotxt.getColumnModel().getColumn(0).setPreferredWidth(150); // Coluna 0: Nome
        jTable_arquivotxt.getColumnModel().getColumn(1).setPreferredWidth(80);  // Coluna 1: Sexo
        jTable_arquivotxt.getColumnModel().getColumn(2).setPreferredWidth(100); // Coluna 2: Idioma
        jTable_arquivotxt.getColumnModel().getColumn(3).setPreferredWidth(250); // Coluna 3: Interesses

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrp_sexo = new javax.swing.ButtonGroup();
        rdoBtn_masculino = new javax.swing.JRadioButton();
        rdoBtn_feminino = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtF_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_salvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA_area = new javax.swing.JTextArea();
        chkBox_Tecnologia = new javax.swing.JCheckBox();
        chkBox_Astronomia = new javax.swing.JCheckBox();
        chkBox_Esportes = new javax.swing.JCheckBox();
        lab_interesse = new javax.swing.JLabel();
        lab_idiomas = new javax.swing.JLabel();
        cmbBox_idiomas = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_arquivotxt = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGrp_sexo.add(rdoBtn_masculino);
        rdoBtn_masculino.setText("Masculino");

        btnGrp_sexo.add(rdoBtn_feminino);
        rdoBtn_feminino.setText("Feminino");

        jLabel1.setText("Nome:");

        jLabel2.setText("Sexo:");

        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtA_area.setColumns(20);
        txtA_area.setRows(5);
        jScrollPane1.setViewportView(txtA_area);

        chkBox_Tecnologia.setText("Tecnologia");

        chkBox_Astronomia.setText("Astronomia");

        chkBox_Esportes.setText("Esportes");

        lab_interesse.setText("Interesses:");

        lab_idiomas.setText("Idiomas:");

        cmbBox_idiomas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "n/a", "Chines", "Espanhol", "Inglês", "Japonês", "Português", " " }));

        jTable_arquivotxt.setBorder(new javax.swing.border.MatteBorder(null));
        jTable_arquivotxt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Sexo", "Idioma", "Interesses", "Title 5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_arquivotxt.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jTable_arquivotxt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtF_nome))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(rdoBtn_masculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoBtn_feminino)
                                .addGap(10, 10, 10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addComponent(btn_salvar)
                        .addGap(56, 56, 56))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lab_interesse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkBox_Tecnologia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkBox_Astronomia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkBox_Esportes))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lab_idiomas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBox_idiomas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtF_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salvar))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rdoBtn_masculino)
                    .addComponent(rdoBtn_feminino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab_interesse)
                    .addComponent(chkBox_Tecnologia)
                    .addComponent(chkBox_Astronomia)
                    .addComponent(chkBox_Esportes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab_idiomas)
                    .addComponent(cmbBox_idiomas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        
        /**Verifica se o campo nome está vazio
         * se vazio interrompe a execução
         **/
        String nome = txtF_nome.getText();
        
        if (nome.isBlank()) {
            JOptionPane.showMessageDialog(null, "Campo Nome está vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
            txtF_nome.requestFocus();
            return;
        }
        
        if(rdoBtn_masculino.isSelected()){
            sexo = 'M';           
        }
        else if(rdoBtn_feminino.isSelected()){
            sexo = 'F';            
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um sexo","Erro",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        /**Verifica se um idioma foi selecionado:
         * Se não selecionado interrompe a execução;
         **/
        String idioma = cmbBox_idiomas.getSelectedItem() + "";
        if(cmbBox_idiomas.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Selecione um idioma","Erro",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        /** Verifica se os chkBox estão selecionados: se sim adiciona ao ArrayList de interesses**/
        ArrayList<String> interesses = new ArrayList<>();

        if (chkBox_Tecnologia.isSelected()) {
            interesses.add("Tecnologia");
        }
        if (chkBox_Esportes.isSelected()) {
            interesses.add("Esportes");
        }
        if (chkBox_Astronomia.isSelected()) {
            interesses.add("Astronomia");
        }

        
        Pessoa p = new Pessoa(nome,sexo,idioma,interesses);
        
        DefaultTableModel tabela = (DefaultTableModel) jTable_arquivotxt.getModel();
        tabela.addRow(p.obterDados());
        
        listaPessoas.add(p);
        
        txtA_area.append(p+"\n");
        
        arquivo.gravaArquivo();
        
        System.out.println("Pessoa Adicionada");
        for (Pessoa pessoa : listaPessoas){
            System.out.println(pessoa);
        }
      
        limparCampos();
        
    }//GEN-LAST:event_btn_salvarActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Formulario().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrp_sexo;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JCheckBox chkBox_Astronomia;
    private javax.swing.JCheckBox chkBox_Esportes;
    private javax.swing.JCheckBox chkBox_Tecnologia;
    private javax.swing.JComboBox<String> cmbBox_idiomas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_arquivotxt;
    private javax.swing.JLabel lab_idiomas;
    private javax.swing.JLabel lab_interesse;
    private javax.swing.JRadioButton rdoBtn_feminino;
    private javax.swing.JRadioButton rdoBtn_masculino;
    private javax.swing.JTextArea txtA_area;
    private javax.swing.JTextField txtF_nome;
    // End of variables declaration//GEN-END:variables
}
