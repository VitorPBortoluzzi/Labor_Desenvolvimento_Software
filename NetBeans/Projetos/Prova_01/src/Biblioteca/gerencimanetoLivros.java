/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Biblioteca;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class gerencimanetoLivros extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(gerencimanetoLivros.class.getName());

    char tipo;
    private int linhaEdicao = -1;
    
    private Arquivo arquivo;
    private List<Livro> listaLivros;
    
    public void limparCampos(){
        txtF_titulo.setText("");
        txtF_autor.setText("");
        txtF_anoPublicacao.setText("");
        
        rdoDigital.setSelected(false);
        rdoFisico.setSelected(false);
        cmb_categorias.setSelectedIndex(0);
        
        rdo_nIniciado.setSelected(false);
        rdo_emAndamento.setSelected(false);
        rdo_concluido.setSelected(false);
        
        txtF_titulo.requestFocus();
    }
    
    public void carregarTabela(){
        DefaultTableModel tabela = (DefaultTableModel) tbl_livros.getModel();
        tabela.setRowCount(0);
        
        for(Livro lTabela: listaLivros){
            tabela.addRow(lTabela.obterDados());
        }
    }
    
    
    public gerencimanetoLivros() {
        initComponents();
        arquivo = new Arquivo("Livros");
        listaLivros = arquivo.leArquivo();
        carregarTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnG_tipo = new javax.swing.ButtonGroup();
        btnG_sitLeitura = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rdoFisico = new javax.swing.JRadioButton();
        rdoDigital = new javax.swing.JRadioButton();
        cmb_categorias = new javax.swing.JComboBox<>();
        rdo_nIniciado = new javax.swing.JRadioButton();
        rdo_emAndamento = new javax.swing.JRadioButton();
        rdo_concluido = new javax.swing.JRadioButton();
        txtF_titulo = new javax.swing.JTextField();
        txtF_autor = new javax.swing.JTextField();
        txtF_anoPublicacao = new javax.swing.JTextField();
        btn_cadastrar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_livros = new javax.swing.JTable();
        btn_salvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Título:");

        jLabel2.setText("Autor:");

        jLabel3.setText("Ano Publicação:");

        jLabel4.setText("Tipo:");

        jLabel5.setText("Categorias");

        jLabel6.setText("Situação da Leitura");

        btnG_tipo.add(rdoFisico);
        rdoFisico.setText("Físico");

        btnG_tipo.add(rdoDigital);
        rdoDigital.setText("Digital");

        cmb_categorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Tecnologia", "Ficção", "Romance", "História", " " }));

        btnG_sitLeitura.add(rdo_nIniciado);
        rdo_nIniciado.setText("Não Iniciado");

        btnG_sitLeitura.add(rdo_emAndamento);
        rdo_emAndamento.setText("Em Andamento");

        btnG_sitLeitura.add(rdo_concluido);
        rdo_concluido.setText("Concluído");

        txtF_titulo.setText(" ");

        txtF_autor.setText(" ");

        txtF_anoPublicacao.setText(" ");

        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });

        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        tbl_livros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Autor", "Ano de Publicação", "Tipo", "Categoria", "Situação de Leitura"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_livros);

        btn_salvar.setText("Salvar");
        btn_salvar.setEnabled(false);
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(1, 1, 1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtF_anoPublicacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(txtF_autor, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtF_titulo, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_cadastrar)
                                    .addComponent(btn_editar)
                                    .addComponent(btn_salvar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoFisico)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdoDigital))
                                    .addComponent(cmb_categorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdo_nIniciado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdo_emAndamento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdo_concluido)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 107, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtF_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtF_autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtF_anoPublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdoFisico)
                    .addComponent(rdoDigital))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmb_categorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdo_nIniciado)
                    .addComponent(rdo_emAndamento)
                    .addComponent(rdo_concluido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        String titulo = txtF_titulo.getText();
        String autor = txtF_autor.getText();
        String anoPublicacao = txtF_anoPublicacao.getText();
        
        if(rdoDigital.isSelected()){
            tipo = 'D';   
        }
        else if(rdoFisico.isSelected()){
            tipo = 'F';
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um tipo","Erro",JOptionPane.ERROR_MESSAGE);
        }
        
        String categoria = cmb_categorias.getSelectedItem() + "";
        if(cmb_categorias.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Selecione uma categoria","Erro",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String sitLeitura;
        if(rdo_nIniciado.isSelected()){
            sitLeitura = "Nao Iniciado";
        } else if(rdo_emAndamento.isSelected()){
            sitLeitura = "Em Andamento";
        } else if(rdo_concluido.isSelected()){
            sitLeitura = "Concluido";
        } else {
            JOptionPane.showMessageDialog(null, "Selecione a situação da leitura","Erro",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
       
        Livro livroNovo = new Livro(titulo, autor, anoPublicacao, tipo, categoria,sitLeitura);
        listaLivros.add(livroNovo);
        carregarTabela();
        
        
        arquivo.gravarArquivo();
    }//GEN-LAST:event_btn_cadastrarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        int linha = tbl_livros.getSelectedRow();
        btn_cadastrar.setEnabled(false);
        btn_salvar.setEnabled(true);
        if(linha == -1){
            JOptionPane.showMessageDialog(null, "Selecione um Livro para editar");
            return;
        }
        linhaEdicao = linha;
        Livro l = listaLivros.get(linha);
        txtF_titulo.setText(l.getTitulo());
        txtF_autor.setText(l.getAutor());
        txtF_anoPublicacao.setText(l.getAnoPublicacao());
        
        if(l.getTipo() == 'D'){
            rdoDigital.setSelected(true);
        } else {
            rdoFisico.setSelected(true);
        }
        
        cmb_categorias.setSelectedItem(l.getCategorias());
        
        if(l.getSitLeitura().equals("Nao Iniciado")){
            rdo_nIniciado.setSelected(true);;
        } else if(l.getSitLeitura().equals("Em Andamento")){
            rdo_emAndamento.setSelected(true);
        } else if(l.getSitLeitura().equals("Concluido")){
            rdo_concluido.setSelected(true);
        }
        
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        String titulo = txtF_titulo.getText();
        String autor = txtF_autor.getText();
        String anoPublicacao = txtF_anoPublicacao.getText();
        
        if(rdoDigital.isSelected()){
            tipo = 'D';   
        }
        else if(rdoFisico.isSelected()){
            tipo = 'F';
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um tipo","Erro",JOptionPane.ERROR_MESSAGE);
        }
        
        String categoria = cmb_categorias.getSelectedItem() + "";
        if(cmb_categorias.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Selecione uma categoria","Erro",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String sitLeitura;
        if(rdo_nIniciado.isSelected()){
            sitLeitura = "Nao Iniciado";
        } else if(rdo_emAndamento.isSelected()){
            sitLeitura = "Em Andamento";
        } else if(rdo_concluido.isSelected()){
            sitLeitura = "Concluido";
        } else {
            JOptionPane.showMessageDialog(null, "Selecione a situação da leitura","Erro",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        Livro livroEdicao = listaLivros.get(linhaEdicao);
        livroEdicao.setTitulo(titulo);
        livroEdicao.setAutor(autor);
        livroEdicao.setAnoPublicacao(anoPublicacao);
        livroEdicao.setTipo(tipo);
        livroEdicao.setCategorias(categoria);
        livroEdicao.setSitLeitura(sitLeitura);

        carregarTabela();
        limparCampos();
        btn_cadastrar.setEnabled(true);
        btn_salvar.setEnabled(false);
        arquivo.gravarArquivo();
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
        java.awt.EventQueue.invokeLater(() -> new gerencimanetoLivros().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnG_sitLeitura;
    private javax.swing.ButtonGroup btnG_tipo;
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JComboBox<String> cmb_categorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoDigital;
    private javax.swing.JRadioButton rdoFisico;
    private javax.swing.JRadioButton rdo_concluido;
    private javax.swing.JRadioButton rdo_emAndamento;
    private javax.swing.JRadioButton rdo_nIniciado;
    private javax.swing.JTable tbl_livros;
    private javax.swing.JTextField txtF_anoPublicacao;
    private javax.swing.JTextField txtF_autor;
    private javax.swing.JTextField txtF_titulo;
    // End of variables declaration//GEN-END:variables
}
