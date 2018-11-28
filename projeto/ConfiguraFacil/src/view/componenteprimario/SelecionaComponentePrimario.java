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
public class SelecionaComponentePrimario extends javax.swing.JFrame {

    private Facade facade;

    private void centerFrame() {
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    /**
     * Creates new form SelecionaComponentePrimario
     */
    public SelecionaComponentePrimario(Facade f) {
        this.facade = f;
        centerFrame();
        initComponents();
        cardPanel.add(new ListaPrimariosSelecionaveis(f,this),"SELECIONAVEIS");
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel,"SELECIONAVEIS");
    }
    
    public JPanel getCardPanel() {
        return this.cardPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ConfiguraFacil");

        cardPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    // End of variables declaration//GEN-END:variables
}
