/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.componenteprimario;

import business.Facade;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Luís Alves
 */
public class ListaPrimariosExtra extends javax.swing.JPanel {

    private Facade facade;
    private SelecionaComponentePrimario parent;
    private JPanel cardPanel;
    
    /**
     * Creates new form ListaPrimariosExtra
     */
    public ListaPrimariosExtra(Facade f, SelecionaComponentePrimario c) {
        this.facade = f;
        this.parent = c;
        this.cardPanel = parent.getCardPanel();
        this.parent.setTitle("Componentes Extra");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelComponentesExtra = new javax.swing.JLabel();
        labelModelosExtra = new javax.swing.JLabel();
        scrollListaComponentesExtra = new javax.swing.JScrollPane();
        listaComponentesExtra = new javax.swing.JList<>();
        scrollListaModelosExtra = new javax.swing.JScrollPane();
        listaModelosExtra = new javax.swing.JList<>();
        butaoAdicionar = new javax.swing.JButton();
        butaoCancelar = new javax.swing.JButton();

        labelComponentesExtra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelComponentesExtra.setText("Componentes Extra");

        labelModelosExtra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelModelosExtra.setText("Modelos Extra");

        listaComponentesExtra.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scrollListaComponentesExtra.setViewportView(listaComponentesExtra);

        listaModelosExtra.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scrollListaModelosExtra.setViewportView(listaModelosExtra);

        butaoAdicionar.setText("Adicionar");
        butaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoAdicionarActionPerformed(evt);
            }
        });

        butaoCancelar.setText("Cancelar");
        butaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelComponentesExtra)
                            .addComponent(scrollListaComponentesExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(scrollListaModelosExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelModelosExtra)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(205, Short.MAX_VALUE)
                        .addComponent(butaoAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butaoCancelar)))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelComponentesExtra, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelModelosExtra, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(scrollListaModelosExtra, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(scrollListaComponentesExtra)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butaoCancelar)
                    .addComponent(butaoAdicionar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoAdicionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butaoAdicionarActionPerformed

    private void butaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoCancelarActionPerformed
        cardPanel.add(new ListaPrimariosSelecionaveis(facade,parent),"SELECIONAVEIS");
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel,"SELECIONAVEIS");
    }//GEN-LAST:event_butaoCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butaoAdicionar;
    private javax.swing.JButton butaoCancelar;
    private javax.swing.JLabel labelComponentesExtra;
    private javax.swing.JLabel labelModelosExtra;
    private javax.swing.JList<String> listaComponentesExtra;
    private javax.swing.JList<String> listaModelosExtra;
    private javax.swing.JScrollPane scrollListaComponentesExtra;
    private javax.swing.JScrollPane scrollListaModelosExtra;
    // End of variables declaration//GEN-END:variables
}