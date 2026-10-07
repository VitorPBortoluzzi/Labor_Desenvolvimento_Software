
package VIEW;


import conexao.Conexao;
import beans.Pessoa;
import DAO.PessoaDAO;

public class Cadastro extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Cadastro.class.getName());
    Pessoa pessoa = new Pessoa();
    PessoaDAO dao = new PessoaDAO();
    
public void conectar(){
    Conexao c = new Conexao();
    c.getConexao();
}


    
    public Cadastro() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grp_sexo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtF_nome = new javax.swing.JTextField();
        rdoBtn_Masculino = new javax.swing.JRadioButton();
        rdoBtn_Feminino = new javax.swing.JRadioButton();
        cmb_idioma = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Sexo:");

        jLabel3.setText("Idioma:");

        grp_sexo.add(rdoBtn_Masculino);
        rdoBtn_Masculino.setText("Masculino");

        grp_sexo.add(rdoBtn_Feminino);
        rdoBtn_Feminino.setText("Feminino");

        cmb_idioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Português", "Inglês", "Espanhol", "Alemão", "Francês" }));

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_idioma, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(rdoBtn_Masculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoBtn_Feminino))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtF_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtF_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rdoBtn_Masculino)
                    .addComponent(rdoBtn_Feminino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmb_idioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addContainerGap(247, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(!txtF_nome.getText().isBlank())
            pessoa.setNome(txtF_nome.getText());
        else System.err.print("Nome não Inserido");
            
        if(rdoBtn_Masculino.isSelected()){
            pessoa.setSexo("M");
        } else if (rdoBtn_Feminino.isSelected()){
            pessoa.setSexo("F");
        } else {
            System.err.print("Sexo não selecionado");
            return;
        }
        
        if(cmb_idioma.getSelectedIndex() == 0){
            System.err.print("Idioma não selecionado");
            return;
        } else pessoa.setIdioma(cmb_idioma.getSelectedItem()+"");
        
        try {
            dao.inserir(pessoa);

            // Aqui você já consegue puxar o ID que o banco acabou de gerar!
            int idCadastrado = pessoa.getId();

            System.out.println("Pessoa inserida com sucesso! O ID no banco é: " + idCadastrado);

        } catch (Exception e) {
            System.out.println(e + "\nPessoa não inserida");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Cadastro().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_idioma;
    private javax.swing.ButtonGroup grp_sexo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton rdoBtn_Feminino;
    private javax.swing.JRadioButton rdoBtn_Masculino;
    private javax.swing.JTextField txtF_nome;
    // End of variables declaration//GEN-END:variables
}
