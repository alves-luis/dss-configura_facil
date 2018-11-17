/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.componenteprimario;

import business.Facade;
import java.awt.Dimension;
import java.awt.Toolkit;
import view.menus.MenuPrincipal;

/**
 *
 * @author Luís Alves
 */
public class ListaComponentesPrimariosSelecionados extends javax.swing.JFrame {

    private Facade facade;
    
    /**
     * Creates new form ApresentaPrecoPrimario
     */
    public ListaComponentesPrimariosSelecionados(Facade f) {
        this.facade = f;
        initComponents();
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelSelecionados = new javax.swing.JLabel();
        scrollListaSelecionados = new javax.swing.JScrollPane();
        listaSelecionados = new javax.swing.JList<>();
        labelPrecoAtual = new javax.swing.JLabel();
        labelPreco = new javax.swing.JLabel();
        butaoAdicionarMais = new javax.swing.JButton();
        butaoConfirmar = new javax.swing.JButton();
        butaoSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Componentes Primários Selecionados"); // NOI18N

        labelSelecionados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSelecionados.setText("Componentes Selecionados");

        listaSelecionados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scrollListaSelecionados.setViewportView(listaSelecionados);

        labelPrecoAtual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPrecoAtual.setText("Preço Atual");

        labelPreco.setBackground(new java.awt.Color(255, 255, 255));
        labelPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPreco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPreco.setText("15500€");
        labelPreco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelPreco.setOpaque(true);

        butaoAdicionarMais.setText("Adicionar Mais");

        butaoConfirmar.setText("Confirmar");
        butaoConfirmar.setEnabled(false);
        butaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoConfirmarActionPerformed(evt);
            }
        });

        butaoSair.setText("Sair");
        butaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelSelecionados)
                            .addComponent(scrollListaSelecionados, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelPrecoAtual)
                            .addComponent(labelPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(butaoConfirmar)
                        .addGap(4, 4, 4)
                        .addComponent(butaoSair)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butaoAdicionarMais)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(labelSelecionados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelPrecoAtual)
                        .addGap(18, 18, 18)
                        .addComponent(labelPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(butaoAdicionarMais, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollListaSelecionados, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butaoConfirmar)
                    .addComponent(butaoSair))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoConfirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butaoConfirmarActionPerformed

    private void butaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoSairActionPerformed
        this.dispose();
        facade.cancelaConfiguracao();
        (new MenuPrincipal(facade)).setVisible(true);
    }//GEN-LAST:event_butaoSairActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butaoAdicionarMais;
    private javax.swing.JButton butaoConfirmar;
    private javax.swing.JButton butaoSair;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JLabel labelPrecoAtual;
    private javax.swing.JLabel labelSelecionados;
    private javax.swing.JList<String> listaSelecionados;
    private javax.swing.JScrollPane scrollListaSelecionados;
    // End of variables declaration//GEN-END:variables
}
