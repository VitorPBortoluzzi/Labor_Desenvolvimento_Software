package VIEW.Categorias;

import DAO.CategoriaDAO;
import VIEW.Util;
import beans.Categoria;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/** Tela única para cadastrar, editar, excluir e listar categorias. */
public class CadastroCategorias extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CadastroCategorias.class.getName());
    private Integer idSelecionado = null;

    public CadastroCategorias() {
        initComponents();
        carregarTabela();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_categoria = new javax.swing.JTable();
        txtF_nome = new javax.swing.JTextField(20);
        btn_salvar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        btn_novo = new javax.swing.JButton();

        setTitle("Categorias");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_categoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Nome"}
        ) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }
        });
        tbl_categoria.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_categoria.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) tbl_categoriaLinhaSelecionada();
        });
        jScrollPane1.setViewportView(tbl_categoria);

        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(this::btn_salvarActionPerformed);
        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(this::btn_excluirActionPerformed);
        btn_novo.setText("Novo");
        btn_novo.addActionListener(this::btn_novoActionPerformed);

        javax.swing.JPanel form = new javax.swing.JPanel(new java.awt.GridBagLayout());
        Util.addLinha(form, 0, "Nome:", txtF_nome);

        javax.swing.JPanel botoes = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        botoes.add(btn_novo);
        botoes.add(btn_salvar);
        botoes.add(btn_excluir);

        javax.swing.JPanel topo = new javax.swing.JPanel(new java.awt.BorderLayout());
        topo.add(form, java.awt.BorderLayout.CENTER);
        topo.add(botoes, java.awt.BorderLayout.SOUTH);

        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));
        getContentPane().add(topo, java.awt.BorderLayout.NORTH);
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        setSize(460, 400);
        setLocationRelativeTo(null);
    }

    private void tbl_categoriaLinhaSelecionada() {
        int linha = tbl_categoria.getSelectedRow();
        if (linha >= 0) {
            idSelecionado = (Integer) tbl_categoria.getValueAt(linha, 0);
            txtF_nome.setText((String) tbl_categoria.getValueAt(linha, 1));
        }
    }

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {
        String nome = txtF_nome.getText().trim();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o nome da categoria.");
            return;
        }

        CategoriaDAO cDAO = new CategoriaDAO();
        Categoria c = new Categoria();
        c.setNome(nome);

        if (idSelecionado == null) {
            cDAO.inserir(c);
        } else {
            c.setId(idSelecionado);
            cDAO.editar(c);
        }
        limparFormulario();
        carregarTabela();
    }

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {
        if (idSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma categoria na tabela.");
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir?", "Exclusão", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            CategoriaDAO cDAO = new CategoriaDAO();
            cDAO.excluir(idSelecionado);
            limparFormulario();
            carregarTabela();
        }
    }

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {
        limparFormulario();
    }

    private void limparFormulario() {
        idSelecionado = null;
        txtF_nome.setText("");
        tbl_categoria.clearSelection();
    }

    private void carregarTabela() {
        CategoriaDAO cDAO = new CategoriaDAO();
        List<Categoria> lista = cDAO.getCategorias();

        DefaultTableModel tabela = (DefaultTableModel) tbl_categoria.getModel();
        tabela.setRowCount(0);

        for (Categoria c : lista) {
            tabela.addRow(new Object[]{c.getId(), c.getNome()});
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new CadastroCategorias().setVisible(true));
    }

    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_categoria;
    private javax.swing.JTextField txtF_nome;
}
