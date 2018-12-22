/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.componenteacessorio;

import business.Componente;
import business.Facade;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JPanel;
import view.menus.MenuEscolha;

/**
 *
 * @author grupo
 */
public class ListaAcessoriosIncompativeis extends javax.swing.JPanel {

    private Facade facade;
    private SelecionaComponenteAcessorio parent;
    private JPanel cardPanel;
    private int componente;
    
    public ListaAcessoriosIncompativeis(Facade f, SelecionaComponenteAcessorio parent, int escolhido) {
        this.facade=f;
        this.parent=parent;
        this.componente= escolhido;
        this.cardPanel=parent.getCardPanel();
        initComponents();
        this.parent.setTitle("Componentes Extras");
        List<Componente> incomps= facade.getIncompativeisFromSelected(this.componente);
         String[] comps = new String[incomps.size()];
        for (int i = 0; i < comps.length; i++) {
            comps[i] = incomps.get(i).getName();
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text = new javax.swing.JLabel();
        adicionar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaIncompatíveis = new javax.swing.JList<>();

        text.setFont(new java.awt.Font("Oriya Sangam MN", 1, 14)); // NOI18N
        text.setText("O componente escolhido é incompatível com os seguintes componentes:");

        adicionar.setText("Adicionar");
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        listaIncompatíveis.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaIncompatíveis);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(text)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(text)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(55, 55, 55))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed
        facade.adicionaCompTemporario(facade.getIncompativeisFromSelected(this.componente));
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cardPanel.add(new PrecoFinalDoAcessorio(facade, parent,this.componente), "PRECO");
        cl.show(cardPanel, "PRECO");
    }//GEN-LAST:event_adicionarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.facade.cancelaConfiguracao();
        this.parent.dispose();
        (new MenuEscolha(facade)).setVisible(true);
    }//GEN-LAST:event_cancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JButton cancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaIncompatíveis;
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}
