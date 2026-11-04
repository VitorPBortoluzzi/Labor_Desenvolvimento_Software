package VIEW;

import VIEW.Categorias.CadastroCategorias;
import VIEW.Produtos.BuscarProduto;
import VIEW.Produtos.arquivoProduto;
import VIEW.Produtos.cadastroProduto;
import VIEW.Produtos.updateDeleteProduto;

public class Menu extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu.class.getName());

    public Menu() {
        initComponents();
    }

    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        Sair = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        Categorias_Cadastro = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        CadastroProdutos = new javax.swing.JMenuItem();
        EditarExcluirProdutos = new javax.swing.JMenuItem();
        ArquivoProdutos = new javax.swing.JMenuItem();
        BuscarProdutos = new javax.swing.JMenuItem();

        setTitle("Sistema de Estoque");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu3.setText("Arquivo");
        Sair.setText("Sair");
        Sair.addActionListener(this::SairActionPerformed);
        jMenu3.add(Sair);
        jMenuBar1.add(jMenu3);

        jMenu1.setText("Categorias");
        Categorias_Cadastro.setText("Cadastrar / Editar / Listar Categorias");
        Categorias_Cadastro.addActionListener(this::Categorias_CadastroActionPerformed);
        jMenu1.add(Categorias_Cadastro);
        jMenuBar1.add(jMenu1);

        jMenu4.setText("Produtos");
        CadastroProdutos.setText("Cadastro de Produtos");
        CadastroProdutos.addActionListener(this::CadastroProdutosActionPerformed);
        jMenu4.add(CadastroProdutos);

        EditarExcluirProdutos.setText("Editar e Excluir Produtos");
        EditarExcluirProdutos.addActionListener(this::EditarExcluirProdutosActionPerformed);
        jMenu4.add(EditarExcluirProdutos);

        ArquivoProdutos.setText("Arquivo Produtos");
        ArquivoProdutos.addActionListener(this::ArquivoProdutosActionPerformed);
        jMenu4.add(ArquivoProdutos);

        BuscarProdutos.setText("Buscar Produtos");
        BuscarProdutos.addActionListener(this::BuscarProdutosActionPerformed);
        jMenu4.add(BuscarProdutos);
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        setSize(480, 300);
        setLocationRelativeTo(null);
    }

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void Categorias_CadastroActionPerformed(java.awt.event.ActionEvent evt) {
        new CadastroCategorias().setVisible(true);
    }

    private void CadastroProdutosActionPerformed(java.awt.event.ActionEvent evt) {
        new cadastroProduto().setVisible(true);
    }

    private void EditarExcluirProdutosActionPerformed(java.awt.event.ActionEvent evt) {
        new updateDeleteProduto().setVisible(true);
    }

    private void ArquivoProdutosActionPerformed(java.awt.event.ActionEvent evt) {
        new arquivoProduto().setVisible(true);
    }

    private void BuscarProdutosActionPerformed(java.awt.event.ActionEvent evt) {
        new BuscarProduto().setVisible(true);
    }

    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(() -> new Menu().setVisible(true));
    }

    private javax.swing.JMenuItem ArquivoProdutos;
    private javax.swing.JMenuItem BuscarProdutos;
    private javax.swing.JMenuItem CadastroProdutos;
    private javax.swing.JMenuItem Categorias_Cadastro;
    private javax.swing.JMenuItem EditarExcluirProdutos;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
}
