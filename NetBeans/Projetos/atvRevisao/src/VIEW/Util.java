package VIEW;

import beans.Produto;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/** Métodos auxiliares compartilhados pelas telas. */
public class Util {

    public static void addLinha(JPanel painel, int linha, String texto, JComponent campo) {
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4, 6, 4, 6);
        g.gridy = linha;
        g.gridx = 0;
        g.anchor = GridBagConstraints.EAST;
        painel.add(new JLabel(texto), g);
        g.gridx = 1;
        g.weightx = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.WEST;
        painel.add(campo, g);
    }

    /** Retorna null se o texto não for um preço válido (aceita vírgula ou ponto). */
    public static BigDecimal lerPreco(String texto) {
        try {
            BigDecimal v = new BigDecimal(texto.trim().replace(",", "."));
            return v.signum() < 0 ? null : v.setScale(2, RoundingMode.HALF_UP);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /** Retorna null se o texto não for um inteiro >= 0. */
    public static Integer lerQuantidade(String texto) {
        try {
            int q = Integer.parseInt(texto.trim());
            return q < 0 ? null : q;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static DefaultTableModel novoModeloProdutos() {
        return new DefaultTableModel(new Object[][]{},
                new String[]{"ID", "Nome", "Preço", "Quantidade", "Categoria"}) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };
    }

    public static void preencherTabela(JTable tabela, List<Produto> lista) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
        if (lista != null) {
            for (Produto p : lista) {
                modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    String.format("R$ %.2f", p.getPreco()),
                    p.getQuantidade(),
                    p.getCategoria().getNome()
                });
            }
        }
    }
}
