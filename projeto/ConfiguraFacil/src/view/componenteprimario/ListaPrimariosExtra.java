/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.componenteprimario;

import business.Componente;
import business.Facade;
import business.Modelo;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.JPanel;

/**
 *
 * @author Luís Alves
 */
public class ListaPrimariosExtra extends javax.swing.JPanel {

    private Facade facade;
    private SelecionaComponentePrimario parent;
    private JPanel cardPanel;
    private List<Componente> extra;
    private Modelo mod;
    
  /**
   * Creates new form ListaPrimariosExtra
   */
  public ListaPrimariosExtra(Facade f, SelecionaComponentePrimario c, List<Componente> ex, Modelo mod) {
    this.facade = f;
    this.parent = c;
    this.cardPanel = parent.getCardPanel();
    this.parent.setTitle("Componentes Extra");
    initComponents();
    this.extra = ex;
    this.mod = mod;
    String[] comps = new String[extra.size()];
    for (int i = 0; i < comps.length; i++) {
      comps[i] = ex.get(i).getName();
    }
    listaComponentesExtra.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = comps;

      public int getSize() {
        return strings.length;
      }

      public String getElementAt(int i) {
        return strings[i];
      }
    });
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
    scrollListaComponentesExtra = new javax.swing.JScrollPane();
    listaComponentesExtra = new javax.swing.JList<>();
    butaoAdicionar = new javax.swing.JButton();
    butaoCancelar = new javax.swing.JButton();

    labelComponentesExtra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelComponentesExtra.setText("Modelos Extra");

    listaComponentesExtra.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    scrollListaComponentesExtra.setViewportView(listaComponentesExtra);

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
        .addContainerGap(27, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(butaoAdicionar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(butaoCancelar))
          .addComponent(scrollListaComponentesExtra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(37, 37, 37))
      .addGroup(layout.createSequentialGroup()
        .addGap(152, 152, 152)
        .addComponent(labelComponentesExtra)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(30, 30, 30)
        .addComponent(labelComponentesExtra)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(scrollListaComponentesExtra, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        .addGap(25, 25, 25)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(butaoCancelar)
          .addComponent(butaoAdicionar))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

    private void butaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoAdicionarActionPerformed
      facade.adicionaCompTemporario(extra);
      CardLayout cl = (CardLayout) cardPanel.getLayout();
      List<Componente> incompatibleList = facade.getIncompativeisFromSelected(mod.getCod());
      if (incompatibleList.size() > 0) {
        cardPanel.add(new ListaPrimariosIncompativeis(facade,parent,incompatibleList,mod),"INCOMPATIVEL");
        cl.show(cardPanel,"INCOMPATIVEL");
      } else {
        facade.adicionaCompTemporario(mod);
        cardPanel.add(new ApresentaPrecoPrimario(facade,parent),"PRECO");
        cl.show(cardPanel,"PRECO");
      }
    }//GEN-LAST:event_butaoAdicionarActionPerformed

    private void butaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoCancelarActionPerformed
      facade.cancelaConfiguracao();
      cardPanel.add(new ListaPrimariosSelecionaveis(facade, parent), "SELECIONAVEIS");
      CardLayout cl = (CardLayout) cardPanel.getLayout();
      cl.show(cardPanel, "SELECIONAVEIS");
    }//GEN-LAST:event_butaoCancelarActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton butaoAdicionar;
  private javax.swing.JButton butaoCancelar;
  private javax.swing.JLabel labelComponentesExtra;
  private javax.swing.JList<String> listaComponentesExtra;
  private javax.swing.JScrollPane scrollListaComponentesExtra;
  // End of variables declaration//GEN-END:variables
}
