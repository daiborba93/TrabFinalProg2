
package view;

public class FPrincipal extends javax.swing.JFrame {

    public FPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        mCadastroPedido = new javax.swing.JMenuItem();
        mCadastroEquipamento = new javax.swing.JMenuItem();
        mCadastroCidade = new javax.swing.JMenuItem();
        mCadastroFuncionario = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mPesquisarPedido = new javax.swing.JMenuItem();
        mPesquisarEquipamento = new javax.swing.JMenuItem();
        mPesquisarCidade = new javax.swing.JMenuItem();
        mPesquisarFuncionario = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestão de Chamados");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Daiane\\Desktop\\chamado sistema 02.PNG")); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Daiane\\Desktop\\chamado sistema.PNG")); // NOI18N

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(new javax.swing.border.MatteBorder(null));

        jMenu2.setBorder(null);
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/Notes.png"))); // NOI18N
        jMenu2.setText("Cadastrar");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        mCadastroPedido.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mCadastroPedido.setBackground(new java.awt.Color(255, 255, 255));
        mCadastroPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/Paste.png"))); // NOI18N
        mCadastroPedido.setText("Cadastrar Pedido");
        mCadastroPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCadastroPedidoActionPerformed(evt);
            }
        });
        jMenu2.add(mCadastroPedido);

        mCadastroEquipamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mCadastroEquipamento.setBackground(new java.awt.Color(255, 255, 255));
        mCadastroEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/Computer 16x16.png"))); // NOI18N
        mCadastroEquipamento.setText("Cadastrar Equipamento");
        mCadastroEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCadastroEquipamentoActionPerformed(evt);
            }
        });
        jMenu2.add(mCadastroEquipamento);

        mCadastroCidade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mCadastroCidade.setBackground(new java.awt.Color(255, 255, 255));
        mCadastroCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/Company.png"))); // NOI18N
        mCadastroCidade.setText("Cadastrar Cidade");
        mCadastroCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCadastroCidadeActionPerformed(evt);
            }
        });
        jMenu2.add(mCadastroCidade);

        mCadastroFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        mCadastroFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        mCadastroFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/Person.png"))); // NOI18N
        mCadastroFuncionario.setText("Cadastrar Funcionário");
        jMenu2.add(mCadastroFuncionario);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/Zoom.png"))); // NOI18N
        jMenu3.setText("Pesquisar");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        mPesquisarPedido.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        mPesquisarPedido.setBackground(new java.awt.Color(255, 255, 255));
        mPesquisarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/Paste.png"))); // NOI18N
        mPesquisarPedido.setText("Pesquisar Pedido");
        jMenu3.add(mPesquisarPedido);

        mPesquisarEquipamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        mPesquisarEquipamento.setBackground(new java.awt.Color(255, 255, 255));
        mPesquisarEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/Computer 16x16.png"))); // NOI18N
        mPesquisarEquipamento.setText("Pesquisar Equipamento");
        mPesquisarEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mPesquisarEquipamentoActionPerformed(evt);
            }
        });
        jMenu3.add(mPesquisarEquipamento);

        mPesquisarCidade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        mPesquisarCidade.setBackground(new java.awt.Color(255, 255, 255));
        mPesquisarCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/Company.png"))); // NOI18N
        mPesquisarCidade.setText("Pesquisar Cidade");
        mPesquisarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mPesquisarCidadeActionPerformed(evt);
            }
        });
        jMenu3.add(mPesquisarCidade);

        mPesquisarFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK));
        mPesquisarFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        mPesquisarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/Person.png"))); // NOI18N
        mPesquisarFuncionario.setText("Pesquisar Funcionário");
        jMenu3.add(mPesquisarFuncionario);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mCadastroEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCadastroEquipamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mCadastroEquipamentoActionPerformed

    private void mPesquisarEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mPesquisarEquipamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mPesquisarEquipamentoActionPerformed

    private void mCadastroCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCadastroCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mCadastroCidadeActionPerformed

    private void mPesquisarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mPesquisarCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mPesquisarCidadeActionPerformed

    private void mCadastroPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCadastroPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mCadastroPedidoActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JMenuItem mCadastroCidade;
    public javax.swing.JMenuItem mCadastroEquipamento;
    public javax.swing.JMenuItem mCadastroFuncionario;
    public javax.swing.JMenuItem mCadastroPedido;
    public javax.swing.JMenuItem mPesquisarCidade;
    public javax.swing.JMenuItem mPesquisarEquipamento;
    public javax.swing.JMenuItem mPesquisarFuncionario;
    public javax.swing.JMenuItem mPesquisarPedido;
    // End of variables declaration//GEN-END:variables
}
