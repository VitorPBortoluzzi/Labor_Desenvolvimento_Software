package VIEW.Produtos;

import DAO.CategoriaDAO;
import DAO.ProdutoDAO;
import VIEW.Util;
import beans.Categoria;
import beans.Produto;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;

public class updateDeleteProduto extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(updateDeleteProduto.class.getName());

    public updateDeleteProduto() {
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
        txtF_ID.setText("");
        txtF_idEditar.setText("");
        txtF_nome.setText("");
        txtF_preco.setText("");
        txtF_quantidade.setText("");
        if (cmb_categoria.getItemCount() > 0) cmb_categoria.setSelectedIndex(0);
    }

    private void initComponents() {

        txtF_ID = new javax.swing.JTextField();
        txtF_idEditar = new javax.swing.JTextField();
        txtF_nome = new javax.swing.JTextField(20);
        txtF_preco = new javax.swing.JTextField();
        txtF_quantidade = new javax.swing.JTextField();
        cmb_categoria = new javax.swing.JComboBox<>();
        btn_consultar = new javax.swing.JButton();
        btn_atualizar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();

        setTitle("Editar / Excluir Produtos");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent e) {
                preencherComboCategorias();
            }
        });

        txtF_idEditar.setEditable(false);

        btn_consultar.setText("Consultar");
        btn_consultar.addActionListener(this::btn_consultarActionPerformed);
        btn_atualizar.setText("Atualizar");
        btn_atualizar.addActionListener(this::btn_atualizarActionPerformed);
        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(this::btn_excluirActionPerformed);

        javax.swing.JPanel busca = new javax.swing.JPanel(new java.awt.BorderLayout(5, 0));
        busca.add(txtF_ID, java.awt.BorderLayout.CENTER);
        busca.add(btn_consultar, java.awt.BorderLayout.EAST);

        javax.swing.JPanel form = new javax.swing.JPanel(new java.awt.GridBagLayout());
        Util.addLinha(form, 0, "ID:", busca);
        Util.addLinha(form, 1, "ID p/Editar:", txtF_idEditar);
        Util.addLinha(form, 2, "Nome:", txtF_nome);
        Util.addLinha(form, 3, "Preço:", txtF_preco);
        Util.addLinha(form, 4, "Quantidade:", txtF_quantidade);
        Util.addLinha(form, 5, "Categoria:", cmb_categoria);

        javax.swing.JPanel botoes = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        botoes.add(btn_atualizar);
        botoes.add(btn_excluir);

        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));
        getContentPane().add(form, java.awt.BorderLayout.CENTER);
        getContentPane().add(botoes, java.awt.BorderLayout.SOUTH);

        setSize(440, 330);
        setLocationRelativeTo(null);
    }

    private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {
        int idProduto;
        try {
            idProduto = Integer.parseInt(txtF_ID.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe um ID válido.");
            return;
        }

        ProdutoDAO pDAO = new ProdutoDAO();
        Produto p = pDAO.getProduto(idProduto);

        if (p == null) {
            limparFormulario();
            JOptionPane.showMessageDialog(this, "Produto não encontrado!");
        } else {
            txtF_idEditar.setText(String.valueOf(p.getId()));
            txtF_nome.setText(p.getNome());
            txtF_preco.setText(p.getPreco().toPlainString());
            txtF_quantidade.setText(String.valueOf(p.getQuantidade()));
            cmb_categoria.setSelectedItem(p.getCategoria()); // usa Categoria.equals (por id)
        }
    }

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtF_idEditar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Consulte um produto antes de atualizar.");
            return;
        }

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
            JOptionPane.showMessageDialog(this, "Selecione uma categoria.");
            return;
        }

        Produto p = new Produto();
        p.setId(Integer.parseInt(txtF_idEditar.getText()));
        p.setNome(nome);
        p.setPreco(preco);
        p.setQuantidade(quantidade);
        p.setCategoria(categoria);

        ProdutoDAO pDAO = new ProdutoDAO();
        pDAO.editar(p);
        limparFormulario();
    }

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtF_idEditar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Consulte um produto antes de excluir.");
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir?", "Exclusão", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            ProdutoDAO pDAO = new ProdutoDAO();
            pDAO.excluir(Integer.parseInt(txtF_idEditar.getText()));
            limparFormulario();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new updateDeleteProduto().setVisible(true));
    }

    private javax.swing.JButton btn_atualizar;
    private javax.swing.JButton btn_consultar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JComboBox<Categoria> cmb_categoria;
    private javax.swing.JTextField txtF_ID;
    private javax.swing.JTextField txtF_idEditar;
    private javax.swing.JTextField txtF_nome;
    private javax.swing.JTextField txtF_preco;
    private javax.swing.JTextField txtF_quantidade;
}
