/*
 * Este package inclui todos os elementos da View
 */
package view.menus;

import business.Facade;
import java.awt.Dimension;
import java.awt.Toolkit;
import view.componenteprimario.ListaComponentesPrimariosSelecionaveis;

/**
 *
 * @author Luís
 */
public class MenuPrincipal extends javax.swing.JFrame {
    
    private Facade facade;

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal(Facade f) {
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

        bemVindo = new javax.swing.JLabel();
        funcionario = new javax.swing.JButton();
        configura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bemVindo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bemVindo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bemVindo.setText("Bem-Vindo ao ConfiguraFacil!");

        funcionario.setText("Funcionário");
        funcionario.setMaximumSize(new java.awt.Dimension(79, 23));
        funcionario.setMinimumSize(new java.awt.Dimension(79, 23));
        funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionarioActionPerformed(evt);
            }
        });

        configura.setText("Configura");
        configura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configuraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(bemVindo, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addGap(131, 131, 131))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(configura, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(bemVindo)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(funcionario, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(configura, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                .addGap(101, 101, 101))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_funcionarioActionPerformed

    private void configuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configuraActionPerformed
        this.dispose();
        (new ListaComponentesPrimariosSelecionaveis(facade)).setVisible(true);
    }//GEN-LAST:event_configuraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bemVindo;
    private javax.swing.JButton configura;
    private javax.swing.JButton funcionario;
    // End of variables declaration//GEN-END:variables
}