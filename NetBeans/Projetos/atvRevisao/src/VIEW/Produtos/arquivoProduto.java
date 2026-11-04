package VIEW.Produtos;

import DAO.ProdutoDAO;
import VIEW.Util;

public class arquivoProduto extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(arquivoProduto.class.getName());

    public arquivoProduto() {
        initComponents();
        carregarTabela();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_produto = new javax.swing.JTable();
        btn_atualizar = new javax.swing.JButton();

        setTitle("Arquivo de Produtos");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_produto.setModel(Util.novoModeloProdutos());
        jScrollPane1.setViewportView(tbl_produto);

        btn_atualizar.setText("Atualizar");
        btn_atualizar.addActionListener(this::btn_atualizarActionPerformed);

        javax.swing.JPanel botoes = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        botoes.add(btn_atualizar);

        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
        getContentPane().add(botoes, java.awt.BorderLayout.SOUTH);

        setSize(640, 400);
        setLocationRelativeTo(null);
    }

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {
        carregarTabela();
    }

    private void carregarTabela() {
        ProdutoDAO pDAO = new ProdutoDAO();
        Util.preencherTabela(tbl_produto, pDAO.getProdutos());
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new arquivoProduto().setVisible(true));
    }

    private javax.swing.JButton btn_atualizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_produto;
}
