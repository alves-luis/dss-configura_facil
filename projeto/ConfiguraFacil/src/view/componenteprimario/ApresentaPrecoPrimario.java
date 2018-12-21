/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.componenteprimario;

import business.Componente;
import business.Facade;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Luís Alves
 */
public class ApresentaPrecoPrimario extends javax.swing.JPanel {

    private Facade facade;
    private SelecionaComponentePrimario parent;
    private JPanel cardPanel;
    
    /**
     * Creates new form ApresentaPrecoPrimario
     */
  public ApresentaPrecoPrimario(Facade f, SelecionaComponentePrimario c) {
    this.facade = f;
    this.parent = c;
    this.cardPanel = parent.getCardPanel();
    parent.setTitle("Preço");
    initComponents();
    List<Componente> selecionados = facade.getPreSelected();
    String[] comps = new String[selecionados.size()];
    for (int i = 0; i < comps.length; i++) {
      comps[i] = selecionados.get(i).getName();
    }
    listaAAdicionar.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = comps;

      public int getSize() {
        return strings.length;
      }

      public String getElementAt(int i) {
        return strings[i];
      }
    });
    double tempPrice = facade.getPrecoTemporario();
    double finalPrice = facade.getPrecoFinal() + tempPrice;
    labelActualPrecoExtras.setText(tempPrice + "");
    labelActualPrecoTotal.setText(finalPrice+"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelComponentesAAdicionar = new javax.swing.JLabel();
        scrollListaAAdicionar = new javax.swing.JScrollPane();
        listaAAdicionar = new javax.swing.JList<>();
        labelPrecoExtras = new javax.swing.JLabel();
        labelActualPrecoExtras = new javax.swing.JLabel();
        labelPrecoTotal = new javax.swing.JLabel();
        labelActualPrecoTotal = new javax.swing.JLabel();
        butaoAdicionar = new javax.swing.JButton();
        butaoCancelar = new javax.swing.JButton();

        labelComponentesAAdicionar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelComponentesAAdicionar.setText("Componentes a Adicionar");

        listaAAdicionar.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scrollListaAAdicionar.setViewportView(listaAAdicionar);

        labelPrecoExtras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPrecoExtras.setText("Preço de Extras");

        labelActualPrecoExtras.setBackground(new java.awt.Color(255, 255, 255));
        labelActualPrecoExtras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelActualPrecoExtras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelActualPrecoExtras.setText("5500€");
        labelActualPrecoExtras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelActualPrecoExtras.setOpaque(true);

        labelPrecoTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPrecoTotal.setText("Preço Total");

        labelActualPrecoTotal.setBackground(new java.awt.Color(255, 255, 255));
        labelActualPrecoTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelActualPrecoTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelActualPrecoTotal.setText("15500€");
        labelActualPrecoTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelActualPrecoTotal.setOpaque(true);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelComponentesAAdicionar)
                    .addComponent(scrollListaAAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelPrecoExtras)
                    .addComponent(labelActualPrecoExtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPrecoTotal)
                    .addComponent(labelActualPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butaoAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butaoCancelar)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(labelPrecoExtras)
                        .addGap(18, 18, 18)
                        .addComponent(labelActualPrecoExtras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelPrecoTotal)
                        .addGap(18, 18, 18)
                        .addComponent(labelActualPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(labelComponentesAAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollListaAAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butaoAdicionar)
                    .addComponent(butaoCancelar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoAdicionarActionPerformed
      this.facade.confirmaComponentes();
      cardPanel.add(new ListaPrimariosSelecionados(facade, parent), "SELECIONADOS");
      CardLayout cl = (CardLayout) cardPanel.getLayout();
      cl.show(cardPanel, "SELECIONADOS");
    }//GEN-LAST:event_butaoAdicionarActionPerformed

    private void butaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoCancelarActionPerformed
      this.facade.cancelaConfiguracao();
      cardPanel.add(new ListaPrimariosSelecionados(facade, parent), "SELECIONADOS");
      CardLayout cl = (CardLayout) cardPanel.getLayout();
      cl.show(cardPanel, "SELECIONADOS");
    }//GEN-LAST:event_butaoCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butaoAdicionar;
    private javax.swing.JButton butaoCancelar;
    private javax.swing.JLabel labelActualPrecoExtras;
    private javax.swing.JLabel labelActualPrecoTotal;
    private javax.swing.JLabel labelComponentesAAdicionar;
    private javax.swing.JLabel labelPrecoExtras;
    private javax.swing.JLabel labelPrecoTotal;
    private javax.swing.JList<String> listaAAdicionar;
    private javax.swing.JScrollPane scrollListaAAdicionar;
    // End of variables declaration//GEN-END:variables
}
