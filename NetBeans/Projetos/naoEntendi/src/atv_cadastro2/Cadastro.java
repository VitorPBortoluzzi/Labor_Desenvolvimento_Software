/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package atv_cadastro2;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author laboratorio
 */
public class Cadastro extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Cadastro.class.getName());

    /**
     * Creates new form Cadastro
     */
    private Arquivo arquivo;
    private List<Aluno> listaAlunos;
    

    private void carregarTabela() {
        DefaultTableModel tabela = (DefaultTableModel) jTable1.getModel();
        
        tabela.setRowCount(0);
        
        txtA_debug.setText(""); // Limpa o TextArea antes de recarregar

        for (Aluno a : listaAlunos) {
            txtA_debug.append(a.toString() + "\n");
            tabela.addRow(a.obterDados());
        }
    }
    
    private void limparCampos() {
        txtF_Nome.setText("");
        txtF_dataNasc.setText("");
        btnG_sexo.clearSelection();
        txtF_matricula.setText("");
        txtF_Curso.setText("");
        txtF_cpf.setText("");
        txtF_rua.setText("");
        txtF_nRua.setText("");
        txtF_Bairro.setText("");
        txtF_cidade.setText("");
        txtF_estado.setText("");
        txtF_cep.setText("");
        cmbBox_estadoCivil.setSelectedIndex(0);
        txtF_telefone.setText("");
        txtF_Nome.requestFocus();
    }

    public Cadastro() {
        initComponents();
        arquivo = new Arquivo("Alunos");
        listaAlunos = arquivo.leArquivo();

        if (listaAlunos == null) {
            listaAlunos = new ArrayList<>();
        }

        carregarTabela();

        //Gemini Frufrus
        txtF_dataNasc.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                String textoAtual = txtF_dataNasc.getText();

                // Aceita apenas dígitos e limita a 10 caracteres (DD/MM/AAAA)
                if (!Character.isDigit(c) || textoAtual.length() >= 10) {
                    evt.consume(); // Cancela o caractere digitado
                    return;
                }

                // Insere a barra '/' automaticamente após o Dia e após o Mês
                if (textoAtual.length() == 2 || textoAtual.length() == 5) {
                    txtF_dataNasc.setText(textoAtual + "/");
                }
            }
        });
        
        //Seguindo modelo do gemini
        txtF_cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                String textoAtual = txtF_cpf.getText();

                // Aceita apenas dígitos e limita a 14 caracteres (###.###.###-##)
                if (!Character.isDigit(c) || textoAtual.length() >= 14) {
                    evt.consume(); // Cancela o caractere digitado
                    return;
                }

                // Insere a barra '.' automaticamente após o 3 primeiros digitos
                if (textoAtual.length() == 3 || textoAtual.length() == 7) {
                    txtF_cpf.setText(textoAtual + ".");
                } else if (textoAtual.length() == 11){
                    txtF_cpf.setText(textoAtual + "-");
                }
            }
        });
        
        //Seguindo modelo do gemini
        txtF_cep.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                String textoAtual = txtF_cep.getText();

                // Aceita apenas dígitos e limita a 9 caracteres (#####-###)
                if (!Character.isDigit(c) || textoAtual.length() >= 9) {
                    evt.consume(); // Cancela o caractere digitado
                    return;
                }

                // Insere a barra '.' automaticamente após o 3 primeiros digitos
                if (textoAtual.length() == 5) {
                    txtF_cep.setText(textoAtual + "-");
                } 
            }
        });
        
//        txtF_dataNasc.addKeyListener(new java.awt.event.KeyAdapter() {
//            @Override
//            public void keyTyped(java.awt.event.KeyEvent evt) {
//                char c = evt.getKeyChar();
//                String textoAtual = txtF_dataNasc.getText();
//                if (!Character.isDigit(c) || textoAtual.length() >= 10) {
//                    evt.consume();
//                    return;
//                }
//                if (textoAtual.length() == 2 || textoAtual.length() == 5) {
//                    txtF_dataNasc.setText(textoAtual + "/");
//                }
//            }
//        });
//
//        txtF_cpf.addKeyListener(new java.awt.event.KeyAdapter() {
//            @Override
//            public void keyTyped(java.awt.event.KeyEvent evt) {
//                char c = evt.getKeyChar();
//                String textoAtual = txtF_cpf.getText();
//                if (!Character.isDigit(c) || textoAtual.length() >= 14) {
//                    evt.consume();
//                    return;
//                }
//                if (textoAtual.length() == 3 || textoAtual.length() == 7) {
//                    txtF_cpf.setText(textoAtual + ".");
//                } else if (textoAtual.length() == 11) {
//                    txtF_cpf.setText(textoAtual + "-");
//                }
//            }
//        });
//            
//        txtF_cep.addKeyListener(new java.awt.event.KeyAdapter() {
//                    @Override
//                    public void keyTyped(java.awt.event.KeyEvent evt) {
//                        char c = evt.getKeyChar();
//                        String textoAtual = txtF_cep.getText();
//                        if (!Character.isDigit(c) || textoAtual.length() >= 9) {
//                            evt.consume();
//                            return;
//                        }
//                        if (textoAtual.length() == 5) {
//                            txtF_cep.setText(textoAtual + "-");
//                        } 
//                    }
//                });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnG_sexo = new javax.swing.ButtonGroup();
        jLab_nomeCompleto = new javax.swing.JLabel();
        jLab_dataNascimento = new javax.swing.JLabel();
        jLab_sexo = new javax.swing.JLabel();
        jLab_matricula = new javax.swing.JLabel();
        jLab_curso = new javax.swing.JLabel();
        jLab_cpf = new javax.swing.JLabel();
        jLab_rua = new javax.swing.JLabel();
        jLab_nRua = new javax.swing.JLabel();
        jLab_bairro = new javax.swing.JLabel();
        jLab_cidade = new javax.swing.JLabel();
        jLab_cep = new javax.swing.JLabel();
        jLab_estadoCivil = new javax.swing.JLabel();
        jLab_estado = new javax.swing.JLabel();
        jLab_telefone = new javax.swing.JLabel();
        txtF_Nome = new javax.swing.JTextField();
        txtF_dataNasc = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        txtF_matricula = new javax.swing.JTextField();
        txtF_Curso = new javax.swing.JTextField();
        txtF_cpf = new javax.swing.JTextField();
        txtF_rua = new javax.swing.JTextField();
        txtF_nRua = new javax.swing.JTextField();
        txtF_Bairro = new javax.swing.JTextField();
        txtF_cidade = new javax.swing.JTextField();
        txtF_estado = new javax.swing.JTextField();
        txtF_cep = new javax.swing.JTextField();
        txtF_telefone = new javax.swing.JTextField();
        cmbBox_estadoCivil = new javax.swing.JComboBox<>();
        btn_Cadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA_debug = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLab_nomeCompleto.setText("Nome Completo:");

        jLab_dataNascimento.setText("Data de Nascimento:");

        jLab_sexo.setText("Sexo:");

        jLab_matricula.setText("Matricula:");

        jLab_curso.setText("Curso:");

        jLab_cpf.setText("CPF:");

        jLab_rua.setText("Rua:");

        jLab_nRua.setText("nºRua:");

        jLab_bairro.setText("Bairro:");

        jLab_cidade.setText("Cidade:");

        jLab_cep.setText("CEP:");

        jLab_estadoCivil.setText("Estado Civil:");

        jLab_estado.setText("Estado:");

        jLab_telefone.setText("Telefone");

        txtF_dataNasc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtF_dataNascKeyTyped(evt);
            }
        });

        btnG_sexo.add(jRadioButton1);
        jRadioButton1.setText("Masculino");

        btnG_sexo.add(jRadioButton2);
        jRadioButton2.setText("Feminino");

        txtF_cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtF_cpfKeyTyped(evt);
            }
        });

        cmbBox_estadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "n/a", "Solteiro", "Casado", "Separado Júdicialmente", "Divorciado", "Viúvo" }));

        btn_Cadastrar.setText("Cadastrar");
        btn_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CadastrarActionPerformed(evt);
            }
        });

        txtA_debug.setColumns(20);
        txtA_debug.setRows(5);
        jScrollPane1.setViewportView(txtA_debug);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome Completo", "Data Nascimento", "Sexo", "Matricula", "Curso", "CPF", "Rua", "nº Rua", "Bairro", "Cidade", "Estado", "CEP", "Estado Civil", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Cadastrar)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLab_rua)
                                .addGap(18, 18, 18)
                                .addComponent(txtF_rua, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLab_telefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtF_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLab_dataNascimento)
                                .addGap(26, 26, 26)
                                .addComponent(txtF_dataNasc))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLab_cep)
                                .addGap(18, 18, 18)
                                .addComponent(txtF_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLab_nomeCompleto)
                                .addGap(44, 44, 44)
                                .addComponent(txtF_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLab_cidade)
                                .addGap(4, 4, 4)
                                .addComponent(txtF_cidade))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLab_bairro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtF_Bairro))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLab_nRua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtF_nRua))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLab_cpf)
                                .addGap(18, 18, 18)
                                .addComponent(txtF_cpf))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLab_curso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtF_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLab_estado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtF_estado))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLab_matricula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtF_matricula))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLab_estadoCivil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBox_estadoCivil, 0, 1, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLab_sexo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2)))
                        .addGap(0, 731, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_nomeCompleto)
                    .addComponent(txtF_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_dataNascimento)
                    .addComponent(txtF_dataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_sexo)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_matricula)
                    .addComponent(txtF_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_curso)
                    .addComponent(txtF_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_cpf)
                    .addComponent(txtF_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_rua)
                    .addComponent(txtF_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_nRua)
                    .addComponent(txtF_nRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_bairro)
                    .addComponent(txtF_Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_cidade)
                    .addComponent(txtF_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtF_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLab_estado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_cep)
                    .addComponent(txtF_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_estadoCivil)
                    .addComponent(cmbBox_estadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_telefone)
                    .addComponent(txtF_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Cadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    private void salvarEmArquivo() {
//        String conteudo = txtA_debug.getText();
//
//        // Evita salvar se o TextArea estiver completamente vazio
//        if (conteudo.trim().isEmpty()) {
//            return;
//        }
//
//        // Utiliza BufferedWriter para gravar os dados de forma eficiente
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("alunos_cadastrados.txt"))) {
//            writer.write(conteudo);
//            JOptionPane.showMessageDialog(this, "Dados salvos em 'alunos_cadastrados.txt' com sucesso!", "Arquivo Salvo", JOptionPane.INFORMATION_MESSAGE);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    private void btn_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CadastrarActionPerformed
        char sexo;
        if(jRadioButton1.isSelected()){
            sexo = 'M'; 
        } else if (jRadioButton2.isSelected()){
            sexo = 'F';
        } else {
            JOptionPane.showMessageDialog(this, "Selecione o sexo do aluno!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int matricula;
        try {
            matricula = Integer.parseInt(txtF_matricula.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "A matrícula deve conter apenas números inteiros válidos!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // 3. Verificação de Duplicidade (usando getMatricula())
        for (Aluno a : listaAlunos) {
            if (a.getMatricula() == matricula) {
                JOptionPane.showMessageDialog(this, "A matrícula " + matricula + " já pertence a outro aluno cadastrado!", "Matrícula Duplicada", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
//        boolean matriculaJaExiste = false;
//        for (Aluno a : listaAlunos) {
//            if (a.matricula == matricula) {
//                matriculaJaExiste = true;
//                break;
//            }
//        }
//        
//        if (matriculaJaExiste) {
//            JOptionPane.showMessageDialog(this, "A matrícula " + matricula + " já pertence a outro aluno cadastrado!", "Matrícula Duplicada", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
        
        Endereco objEndereco = new Endereco(
            txtF_rua.getText(),
            txtF_nRua.getText(),
            txtF_Bairro.getText(),
            txtF_cidade.getText(),
            txtF_estado.getText(),
            txtF_cep.getText()
        );
        
        Aluno objAluno = new Aluno(
            txtF_Nome.getText(),
            txtF_dataNasc.getText(),
            sexo,
            matricula,
            txtF_Curso.getText(),
            txtF_cpf.getText(),
            objEndereco,
            String.valueOf(cmbBox_estadoCivil.getSelectedItem()),
            txtF_telefone.getText()
        );
        
        listaAlunos.add(objAluno);
        arquivo.setListaAlunos(listaAlunos);
        arquivo.gravaArquivo();
        
        carregarTabela();
        
        //txtA_debug.append(objAluno.toString() + "\n");
        
        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        
   
    }//GEN-LAST:event_btn_CadastrarActionPerformed

    private void txtF_dataNascKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtF_dataNascKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtF_dataNascKeyTyped

    private void txtF_cpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtF_cpfKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtF_cpfKeyTyped

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
        java.awt.EventQueue.invokeLater(() -> new Cadastro().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnG_sexo;
    private javax.swing.JButton btn_Cadastrar;
    private javax.swing.JComboBox<String> cmbBox_estadoCivil;
    private javax.swing.JLabel jLab_bairro;
    private javax.swing.JLabel jLab_cep;
    private javax.swing.JLabel jLab_cidade;
    private javax.swing.JLabel jLab_cpf;
    private javax.swing.JLabel jLab_curso;
    private javax.swing.JLabel jLab_dataNascimento;
    private javax.swing.JLabel jLab_estado;
    private javax.swing.JLabel jLab_estadoCivil;
    private javax.swing.JLabel jLab_matricula;
    private javax.swing.JLabel jLab_nRua;
    private javax.swing.JLabel jLab_nomeCompleto;
    private javax.swing.JLabel jLab_rua;
    private javax.swing.JLabel jLab_sexo;
    private javax.swing.JLabel jLab_telefone;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea txtA_debug;
    private javax.swing.JTextField txtF_Bairro;
    private javax.swing.JTextField txtF_Curso;
    private javax.swing.JTextField txtF_Nome;
    private javax.swing.JTextField txtF_cep;
    private javax.swing.JTextField txtF_cidade;
    private javax.swing.JTextField txtF_cpf;
    private javax.swing.JTextField txtF_dataNasc;
    private javax.swing.JTextField txtF_estado;
    private javax.swing.JTextField txtF_matricula;
    private javax.swing.JTextField txtF_nRua;
    private javax.swing.JTextField txtF_rua;
    private javax.swing.JTextField txtF_telefone;
    // End of variables declaration//GEN-END:variables
}
