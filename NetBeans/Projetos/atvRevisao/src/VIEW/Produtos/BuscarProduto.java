package VIEW.Produtos;

import DAO.ProdutoDAO;
import VIEW.Util;
import beans.Produto;
import java.util.List;

public class BuscarProduto extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BuscarProduto.class.getName());

    public BuscarProduto() {
        initComponents();
        carregarTabela();
    }

    private void initComponents() {

        btnGrup_busca = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_produto = new javax.swing.JTable();
        txtF_busca = new javax.swing.JTextField(18);
        rdo_nome = new javax.swing.JRadioButton();
        rdo_categoria = new javax.swing.JRadioButton();
        btn_limpar = new javax.swing.JButton();

        setTitle("Buscar Produtos");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_produto.setModel(Util.novoModeloProdutos());
        jScrollPane1.setViewportView(tbl_produto);

        txtF_busca.addCaretListener(this::txtF_buscaCaretUpdate);

        btnGrup_busca.add(rdo_nome);
        rdo_nome.setText("Nome");
        rdo_nome.setSelected(true);
        rdo_nome.addActionListener(this::rdoActionPerformed);

        btnGrup_busca.add(rdo_categoria);
        rdo_categoria.setText("Categoria");
        rdo_categoria.addActionListener(this::rdoActionPerformed);

        btn_limpar.setText("Limpar");
        btn_limpar.addActionListener(this::btn_limparActionPerformed);

        javax.swing.JPanel busca = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        busca.add(new javax.swing.JLabel("Buscar por:"));
        busca.add(rdo_nome);
        busca.add(rdo_categoria);
        busca.add(txtF_busca);
        busca.add(btn_limpar);

        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));
        getContentPane().add(busca, java.awt.BorderLayout.NORTH);
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        setSize(700, 400);
        setLocationRelativeTo(null);
    }

    private void txtF_buscaCaretUpdate(javax.swing.event.CaretEvent evt) {
        carregarTabela();
    }

    private void rdoActionPerformed(java.awt.event.ActionEvent evt) {
        carregarTabela();
    }

    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {
        txtF_busca.setText("");
        rdo_nome.setSelected(true);
        carregarTabela();
    }

    private void carregarTabela() {
        ProdutoDAO pDAO = new ProdutoDAO();
        List<Produto> lista;
        if (rdo_categoria.isSelected()) {
            lista = pDAO.getProdutosCategoria(txtF_busca.getText());
        } else {
            lista = pDAO.getProdutosNome(txtF_busca.getText());
        }
        Util.preencherTabela(tbl_produto, lista);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new BuscarProduto().setVisible(true));
    }

    private javax.swing.ButtonGroup btnGrup_busca;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdo_categoria;
    private javax.swing.JRadioButton rdo_nome;
    private javax.swing.JTable tbl_produto;
    private javax.swing.JTextField txtF_busca;
}
