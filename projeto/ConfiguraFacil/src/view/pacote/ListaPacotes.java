/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.pacote;

/**
 *
 * @author andreg18
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import business.Componente;
import business.ComponentePrimario;
import business.Facade;
import business.Modelo;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JPanel;
import view.menus.MenuPrincipal;

/**
 *
 * @author Luís Alves
 */
public class ListaPacotes extends javax.swing.JPanel {

    private Facade facade;
    private SelecionaPacote parent;
    private JPanel cardPanel;
    
    /**
     * Creates new form ListaPrimariosSelecionaveis
     */
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


    private void initComponents() {//GEN-BEGIN:initComponents
        setLayout(new java.awt.BorderLayout());

    }//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
