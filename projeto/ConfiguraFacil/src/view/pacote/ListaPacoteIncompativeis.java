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

/**
 *
 * @author Luís Alves
 */
public class ListaPacoteIncompativeis extends javax.swing.JPanel {

  private Facade facade;
  private SelecionaPacote parent;
  private JPanel cardPanel;
  private List<Componente> incomp;
  private Pacote pack;
  
  /**
   * Creates new form ListaPacoteIncompativeis
   */
  public ListaPacoteIncompativeis(Facade facade, SelecionaPacote parent, List<Componente> incompatible, Pacote pacote) {
    initComponents();
    this.facade = facade;
    this.parent = parent;
    this.incomp = incompatible;
    this.cardPanel = parent.getCardPanel();
    this.pack = pacote;
    String[] incomps = new String[incomp.size()];
    for (int i = 0; i < incomps.length; i++) {
      incomps[i] = incomp.get(i).getName();
    }
    jList1.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = incomps;

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

    jTextArea1 = new javax.swing.JTextArea();
    jScrollPane1 = new javax.swing.JScrollPane();
    jList1 = new javax.swing.JList<>();
    butaoRetirar = new javax.swing.JButton();
    butaoCancelar = new javax.swing.JButton();

    jTextArea1.setEditable(false);
    jTextArea1.setBackground(new java.awt.Color(204, 204, 204));
    jTextArea1.setColumns(20);
    jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jTextArea1.setLineWrap(true);
    jTextArea1.setRows(5);
    jTextArea1.setText("  O pacote escolhido é                             incompatível com os seguintes              componentes:");
    jTextArea1.setWrapStyleWord(true);
    jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jList1.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane1.setViewportView(jList1);

    butaoRetirar.setText("Retirar");
    butaoRetirar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        butaoRetirarActionPerformed(evt);
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
      .addGap(0, 400, Short.MAX_VALUE)
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(15, 15, 15)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(jTextArea1)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(butaoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(butaoRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGap(16, 16, 16)))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(22, 22, 22)
          .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
              .addComponent(butaoRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGap(74, 74, 74)
              .addComponent(butaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGap(23, 23, 23)))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void butaoRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoRetirarActionPerformed
    facade.removeComponente(incomp);
    facade.adicionaCompTemporario(pack);
    cardPanel.add(new ApresentaPrecoPacote(facade,parent,pack.getId()),"PRECO");
    CardLayout cl = (CardLayout) cardPanel.getLayout();
    cl.show(cardPanel,"PRECO");
  }//GEN-LAST:event_butaoRetirarActionPerformed

  private void butaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoCancelarActionPerformed
    facade.cancelaConfiguracao();
    cardPanel.add(new ListaPacotes(facade, parent), "PACOTES");
    CardLayout cl = (CardLayout) cardPanel.getLayout();
    cl.show(cardPanel, "PACOTES");
  }//GEN-LAST:event_butaoCancelarActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton butaoCancelar;
  private javax.swing.JButton butaoRetirar;
  private javax.swing.JList<String> jList1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea jTextArea1;
  // End of variables declaration//GEN-END:variables
}
