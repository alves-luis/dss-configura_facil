/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.pacote;

import business.Componente;
import business.Facade;
import business.Pacote;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JPanel;
import view.menus.MenuEscolha;

/**
 *
 * @author Luís Alves
 */
public class ListaPacotes extends javax.swing.JPanel {

    private Facade facade;
    private SelecionaPacote parent;
    private JPanel cardPanel;

  public ListaPacotes(Facade f, SelecionaPacote parent) {
    this.facade = f;
    this.parent = parent;
    this.cardPanel = parent.getCardPanel();
    initComponents();
    this.parent.setTitle("Lista Pacotes");
    List<Pacote> primario = f.getPacotes();
    String[] comps = new String[primario.size()];
    for (int i = 0; i < comps.length; i++) {
      comps[i] = primario.get(i).getName();
    }
    listaPacotes.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = comps;

      public int getSize() {
        return strings.length;
      }

      public String getElementAt(int i) {
        return strings[i];
      }
    });
  }


  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    scrollListaComponentes = new javax.swing.JScrollPane();
    listaComponentes = new javax.swing.JList<>();
    butaoSair = new javax.swing.JButton();
    butaoSelecionar = new javax.swing.JButton();
    labelPacotes = new javax.swing.JLabel();
    labelComponentes = new javax.swing.JLabel();
    scrollListaPacotes = new javax.swing.JScrollPane();
    listaPacotes = new javax.swing.JList<>();

    listaComponentes.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = {};
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    scrollListaComponentes.setViewportView(listaComponentes);

    butaoSair.setText("Sair");
    butaoSair.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        butaoSairActionPerformed(evt);
      }
    });

    butaoSelecionar.setText("Selecionar");
    butaoSelecionar.setEnabled(false);
    butaoSelecionar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        butaoSelecionarActionPerformed(evt);
      }
    });

    labelPacotes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelPacotes.setText("Pacotes");

    labelComponentes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelComponentes.setText("Componentes");

    listaPacotes.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    listaPacotes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        listaPacotesValueChanged(evt);
      }
    });
    scrollListaPacotes.setViewportView(listaPacotes);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(35, 35, 35)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollListaPacotes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
              .addGap(43, 43, 43)
              .addComponent(labelPacotes)))
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollListaComponentes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addComponent(butaoSelecionar)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(butaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addComponent(labelComponentes)
              .addGap(30, 30, 30)))
          .addGap(36, 36, 36)))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(20, 20, 20)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelPacotes, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(labelComponentes, javax.swing.GroupLayout.Alignment.TRAILING))
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
              .addGap(18, 18, 18)
              .addComponent(scrollListaComponentes, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
              .addGap(18, 18, 18)
              .addComponent(scrollListaPacotes)))
          .addGap(18, 18, 18)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(butaoSair)
            .addComponent(butaoSelecionar))
          .addGap(21, 21, 21)))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void butaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoSairActionPerformed
    this.parent.dispose();
    this.facade.cancelaConfiguracao();
    (new MenuEscolha(facade)).setVisible(true);
  }//GEN-LAST:event_butaoSairActionPerformed

  private void butaoSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoSelecionarActionPerformed

    int pack = listaPacotes.getSelectedIndex();
    CardLayout cl = (CardLayout) cardPanel.getLayout();   
    Pacote pacote = facade.getPacotes().get(pack);
    List<Componente> incompatible = facade.getIncompativeisFromSelected(pacote);
    if (incompatible.size() > 0) {
      cardPanel.add(new ListaPacoteIncompativeis(facade, parent,incompatible,pacote), "INCOMPATIVEL");
      cl.show(cardPanel, "INCOMPATIVEL");
    } else {
      facade.adicionaCompTemporario(pacote);
      cardPanel.add(new ApresentaPrecoPacote(facade, parent,pacote), "PRECO");
      cl.show(cardPanel, "PRECO");
    }
  }//GEN-LAST:event_butaoSelecionarActionPerformed

  private void listaPacotesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPacotesValueChanged
    if (!evt.getValueIsAdjusting()) {
      butaoSelecionar.setEnabled(true);
      String row = listaPacotes.getSelectedValue();
      if (row == null)
        return;
      Pacote p = facade.getPacoteWithString(row);
      if(p == null)
          return;
      int idPack = p.getId();
      List<Componente> selecionaveis = facade.getComponentes(idPack);

      String[] comps = new String[selecionaveis.size()];
      for (int i = 0; i < comps.length; i++) {
        comps[i] = selecionaveis.get(i).getName();
      }
      listaComponentes.setModel(new javax.swing.AbstractListModel<String>() {
        String[] strings = comps;

        public int getSize() {
          return strings.length;
        }

        public String getElementAt(int i) {
          return strings[i];
        }
      });
    }

  }//GEN-LAST:event_listaPacotesValueChanged


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton butaoSair;
  private javax.swing.JButton butaoSelecionar;
  private javax.swing.JLabel labelComponentes;
  private javax.swing.JLabel labelPacotes;
  private javax.swing.JList<String> listaComponentes;
  private javax.swing.JList<String> listaPacotes;
  private javax.swing.JScrollPane scrollListaComponentes;
  private javax.swing.JScrollPane scrollListaPacotes;
  // End of variables declaration//GEN-END:variables
}
