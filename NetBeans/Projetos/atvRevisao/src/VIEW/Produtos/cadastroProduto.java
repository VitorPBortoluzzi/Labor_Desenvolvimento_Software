package VIEW.Produtos;

import DAO.CategoriaDAO;
import DAO.ProdutoDAO;
import VIEW.Util;
import beans.Categoria;
import beans.Produto;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;

public class cadastroProduto extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(cadastroProduto.class.getName());
    ProdutoDAO pdao = new ProdutoDAO();

    public cadastroProduto() {
        initComponents();
        preencherComboCategorias();
    }

    public void preencherComboCategorias() {
        Object atual = cmb_categoria.getSelectedItem();
        CategoriaDAO cDAO = new CategoriaDAO();
        List<Categoria> listaC = cDAO.getCategorias();
        cmb_categoria.removeAllItems();
        for (Categoria c : listaC) {
            cmb_categoria.addItem(c);
        }
        if (atual != null) cmb_categoria.setSelectedItem(atual);
    }

    private void limparFormulario() {
        txtF_nome.setText("");
        txtF_preco.setText("");
        txtF_quantidade.setText("");
        if (cmb_categoria.getItemCount() > 0) cmb_categoria.setSelectedIndex(0);
    }

    private void initComponents() {

        txtF_nome = new javax.swing.JTextField(20);
        txtF_preco = new javax.swing.JTextField();
        txtF_quantidade = new javax.swing.JTextField();
        cmb_categoria = new javax.swing.JComboBox<>();
        btn_cadastrar = new javax.swing.JButton();

        setTitle("Cadastro de Produtos");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        // Recarrega as categorias ao voltar para esta janela (caso tenha cadastrado novas)
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent e) {
                preencherComboCategorias();
            }
        });

        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.addActionListener(this::btn_cadastrarActionPerformed);

        javax.swing.JPanel form = new javax.swing.JPanel(new java.awt.GridBagLayout());
        Util.addLinha(form, 0, "Nome:", txtF_nome);
        Util.addLinha(form, 1, "Preço:", txtF_preco);
        Util.addLinha(form, 2, "Quantidade:", txtF_quantidade);
        Util.addLinha(form, 3, "Categoria:", cmb_categoria);

        javax.swing.JPanel botoes = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        botoes.add(btn_cadastrar);

        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));
        getContentPane().add(form, java.awt.BorderLayout.CENTER);
        getContentPane().add(botoes, java.awt.BorderLayout.SOUTH);

        setSize(400, 240);
        setLocationRelativeTo(null);
    }

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        String nome = txtF_nome.getText().trim();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome não inserido");
            return;
        }

        BigDecimal preco = Util.lerPreco(txtF_preco.getText());
        if (preco == null) {
            JOptionPane.showMessageDialog(this, "Preço inválido. Exemplo: 19.90");
            return;
        }

        Integer quantidade = Util.lerQuantidade(txtF_quantidade.getText());
        if (quantidade == null) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida. Informe um número inteiro.");
            return;
        }

        Categoria categoria = (Categoria) cmb_categoria.getSelectedItem();
        if (categoria == null) {
            JOptionPane.showMessageDialog(this, "Cadastre uma categoria antes de cadastrar produtos.");
            return;
        }

        Produto p = new Produto();
        p.setNome(nome);
        p.setPreco(preco);
        p.setQuantidade(quantidade);
        p.setCategoria(categoria);

        pdao.inserir(p);

        // o DAO preenche o ID gerado pelo banco; se continuar 0, a inserção falhou
        if (p.getId() > 0) {
            JOptionPane.showMessageDialog(this, "Produto cadastrado! ID: " + p.getId());
            limparFormulario();
        } else {
            JOptionPane.showMessageDialog(this, "Produto não inserido");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new cadastroProduto().setVisible(true));
    }

    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JComboBox<Categoria> cmb_categoria;
    private javax.swing.JTextField txtF_nome;
    private javax.swing.JTextField txtF_preco;
    private javax.swing.JTextField txtF_quantidade;
}
