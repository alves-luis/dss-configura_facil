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
public class ListaComponentesPrimariosSelecionaveis extends javax.swing.JFrame {

    
    private Facade facade;
    
    /**
     * Creates new form ListaComponentesPrimariosSelecionaveis
     */
    public ListaComponentesPrimariosSelecionaveis(Facade f) {
        this.facade = f;
        this.setResizable(false);
        initComponents();
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

        labelComponentes = new javax.swing.JLabel();
        labelModelos = new javax.swing.JLabel();
        scrollListaComponentes = new javax.swing.JScrollPane();
        listaComponentes = new javax.swing.JList<>();
        scrollListaModelos = new javax.swing.JScrollPane();
        listaModelos = new javax.swing.JList<>();
        butaoSair = new javax.swing.JButton();
        butaoSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Componentes Primários Selecionáveis"); // NOI18N

        labelComponentes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelComponentes.setText("Componentes");

        labelModelos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelModelos.setText("Modelos");

        listaComponentes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scrollListaComponentes.setViewportView(listaComponentes);

        listaModelos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scrollListaModelos.setViewportView(listaModelos);

        butaoSair.setText("Sair");
        butaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoSairActionPerformed(evt);
            }
        });

        butaoSelecionar.setText("Selecionar");
        butaoSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(scrollListaComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(labelComponentes)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelModelos)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollListaModelos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(butaoSelecionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(butaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelComponentes)
                    .addComponent(labelModelos))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(scrollListaModelos, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(scrollListaComponentes)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butaoSair)
                    .addComponent(butaoSelecionar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoSairActionPerformed
        this.dispose();
        facade.cancelaConfiguracao();
        (new MenuPrincipal(facade)).setVisible(true);
    }//GEN-LAST:event_butaoSairActionPerformed

    private void butaoSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoSelecionarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        (new ListaComponentesPrimariosExtra(facade)).setVisible(true);
    }//GEN-LAST:event_butaoSelecionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butaoSair;
    private javax.swing.JButton butaoSelecionar;
    private javax.swing.JLabel labelComponentes;
    private javax.swing.JLabel labelModelos;
    private javax.swing.JList<String> listaComponentes;
    private javax.swing.JList<String> listaModelos;
    private javax.swing.JScrollPane scrollListaComponentes;
    private javax.swing.JScrollPane scrollListaModelos;
    // End of variables declaration//GEN-END:variables
}