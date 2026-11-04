/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW.Funcionarios;

import DAO.FuncionarioDAO;
import beans.Funcionario;
import conexao.Conexao;
import javax.swing.JOptionPane;

/**
 *
 * @author laboratorio
 */
public class Cadastrar extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Cadastrar.class.getName());
    
    FuncionarioDAO fDAO = new FuncionarioDAO();
    
    public void Conectar(){
        Conexao c = new Conexao();
        c.getConexao();
    }

    
    public Cadastrar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bntG_genero = new javax.swing.ButtonGroup();
        txtF_nome = new javax.swing.JTextField();
        txtF_idade = new javax.swing.JTextField();
        rdoB_masculino = new javax.swing.JRadioButton();
        rdoB_feminino = new javax.swing.JRadioButton();
        rdoB_outro = new javax.swing.JRadioButton();
        cmb_cargo = new javax.swing.JComboBox<>();
        txtF_salario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_inserir = new javax.swing.JButton();
        btn_limpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bntG_genero.add(rdoB_masculino);
        rdoB_masculino.setText("Masculino");

        bntG_genero.add(rdoB_feminino);
        rdoB_feminino.setText("Feminino");

        bntG_genero.add(rdoB_outro);
        rdoB_outro.setText("Outro");

        cmb_cargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Gerente", "Analista", "Técnico", "Estágiario" }));

        jLabel1.setText("Nome:");

        jLabel2.setText("Idade:");

        jLabel3.setText("Genero");

        jLabel4.setText("Cargo:");

        jLabel5.setText("Salario:");

        btn_inserir.setText("Inserir");
        btn_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inserirActionPerformed(evt);
            }
        });

        btn_limpar.setText("Limpar");
        btn_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel2))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel3))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoB_masculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoB_feminino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoB_outro))
                            .addComponent(txtF_salario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtF_nome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(txtF_idade, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 115, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_inserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_limpar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtF_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtF_idade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoB_masculino)
                    .addComponent(rdoB_feminino)
                    .addComponent(rdoB_outro)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtF_salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_inserir)
                    .addComponent(btn_limpar))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inserirActionPerformed
        Funcionario objFuncionario = new Funcionario();
        
        if(txtF_nome.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Nome não Informado!");
            return;
        } else objFuncionario.setNome(txtF_nome.getText());

        if(txtF_idade.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Idade não Informada!");
            return;
        } else if(Integer.parseInt(txtF_idade.getText()) <= 0){
            JOptionPane.showMessageDialog(this, "Idade inválida!");
            return;
        } else {
            objFuncionario.setIdade(Integer.parseInt(txtF_idade.getText()));
        }
        
        if(rdoB_masculino.isSelected()){
            objFuncionario.setGenero(rdoB_masculino.getText());
        }else if (rdoB_feminino.isSelected()){
            objFuncionario.setGenero(rdoB_feminino.getText());
        } else if(rdoB_outro.isSelected()){
            objFuncionario.setGenero(rdoB_outro.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Sexo não selecionado!");
            return;
        }
        
        if(cmb_cargo.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Cargo não selecionado!");
            return;
        } else objFuncionario.setCargo(cmb_cargo.getSelectedItem()+"");
        
        objFuncionario.setSalario(Double.parseDouble(txtF_salario.getText()));
       
        try {
            fDAO.inserir(objFuncionario);

            int idCadastrado = objFuncionario.getId();

            JOptionPane.showMessageDialog(this, "Funcionario cadastrado com sucesso! ID:"+idCadastrado);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Falha ao realizar o cadastro!");
        }
        
        limparCampos();
    }//GEN-LAST:event_btn_inserirActionPerformed

    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparActionPerformed
        //Está só de enfeite
        //limparCampos();
    }//GEN-LAST:event_btn_limparActionPerformed

    private void limparCampos(){
        txtF_nome.setText("");
        txtF_idade.setText("");
        bntG_genero.clearSelection();
        cmb_cargo.setSelectedIndex(0);
        txtF_salario.setText("");
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Cadastrar().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bntG_genero;
    private javax.swing.JButton btn_inserir;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JComboBox<String> cmb_cargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton rdoB_feminino;
    private javax.swing.JRadioButton rdoB_masculino;
    private javax.swing.JRadioButton rdoB_outro;
    private javax.swing.JTextField txtF_idade;
    private javax.swing.JTextField txtF_nome;
    private javax.swing.JTextField txtF_salario;
    // End of variables declaration//GEN-END:variables
}
