/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.configotima;

import business.Componente;
import business.Facade;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JPanel;
import view.menus.MenuFinal;

/**
 *
 * @author Luís Alves
 */
public class ListaSugeridos extends javax.swing.JPanel {

  private Facade facade;
  private SelecionaConfiguracaoOtima parent;
  private JPanel cardPanel;

  /**
   * Creates new form ListaSugeridos
   */
  public ListaSugeridos(Facade f, SelecionaConfiguracaoOtima p, List<Componente> sug) {
    facade = f;
    parent = p;
    cardPanel = p.getCardPanel();
    initComponents();
    parent.setTitle("Componentes Sugeridos");
    String[] sugs = new String[sug.size()];
    for (int i = 0; i < sugs.length; i++) {
      sugs[i] = sug.get(i).getName();
    }
    listSugeridos.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = sugs;

      public int getSize() {
        return strings.length;
      }

      public String getElementAt(int i) {
        return strings[i];
      }
    });
    double otim = sug.stream().mapToDouble(c -> c.getPrice()).sum();
    this.labelGetPrecoConfig.setText(otim+"");
    this.labelGetPrecoTot.setText(facade.getPrecoFinal()+otim+"");
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    novoValorButton = new javax.swing.JButton();
    confirmarButton = new javax.swing.JButton();
    labelPrecoConfig = new javax.swing.JLabel();
    labelGetPrecoConfig = new javax.swing.JLabel();
    labelPrecoTot = new javax.swing.JLabel();
    labelGetPrecoTot = new javax.swing.JLabel();
    labelSugeridos = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    listSugeridos = new javax.swing.JList<>();

    setMaximumSize(new java.awt.Dimension(400, 300));
    setMinimumSize(new java.awt.Dimension(400, 300));

    novoValorButton.setText("Inserir Novo valor");
    novoValorButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        novoValorButtonActionPerformed(evt);
      }
    });

    confirmarButton.setText("Confirmar");
    confirmarButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        confirmarButtonActionPerformed(evt);
      }
    });

    labelPrecoConfig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    labelPrecoConfig.setText("Preço da Configuração");

    labelGetPrecoConfig.setBackground(new java.awt.Color(255, 255, 255));
    labelGetPrecoConfig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    labelGetPrecoConfig.setText("2109");
    labelGetPrecoConfig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    labelGetPrecoConfig.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    labelGetPrecoConfig.setOpaque(true);

    labelPrecoTot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    labelPrecoTot.setText("Preço Total");

    labelGetPrecoTot.setBackground(new java.awt.Color(255, 255, 255));
    labelGetPrecoTot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    labelGetPrecoTot.setText("17609");
    labelGetPrecoTot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    labelGetPrecoTot.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    labelGetPrecoTot.setOpaque(true);

    labelSugeridos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    labelSugeridos.setText("Componentes Sugeridos");

    listSugeridos.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane1.setViewportView(listSugeridos);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(21, 21, 21)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(labelSugeridos, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(labelGetPrecoTot, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(labelPrecoTot, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
          .addComponent(labelGetPrecoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(labelPrecoConfig))
        .addGap(16, 16, 16))
      .addGroup(layout.createSequentialGroup()
        .addGap(22, 22, 22)
        .addComponent(confirmarButton)
        .addGap(18, 18, 18)
        .addComponent(novoValorButton)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelSugeridos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(labelPrecoConfig)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(labelGetPrecoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(26, 26, 26)
            .addComponent(labelPrecoTot)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(labelGetPrecoTot, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(novoValorButton)
          .addComponent(confirmarButton))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

    private void novoValorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoValorButtonActionPerformed
      this.facade.cancelaConfiguracao();
      cardPanel.add(new InsereValorObjetivo(facade, parent), "INSERE");
      CardLayout cl = (CardLayout) cardPanel.getLayout();
      cl.show(cardPanel, "INSERE");
    }//GEN-LAST:event_novoValorButtonActionPerformed

  private void confirmarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarButtonActionPerformed
    this.facade.confirmaComponentes();
    this.parent.dispose();
    (new MenuFinal(facade)).setVisible(true);
  }//GEN-LAST:event_confirmarButtonActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton confirmarButton;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel labelGetPrecoConfig;
  private javax.swing.JLabel labelGetPrecoTot;
  private javax.swing.JLabel labelPrecoConfig;
  private javax.swing.JLabel labelPrecoTot;
  private javax.swing.JLabel labelSugeridos;
  private javax.swing.JList<String> listSugeridos;
  private javax.swing.JButton novoValorButton;
  // End of variables declaration//GEN-END:variables
}
