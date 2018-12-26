package business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Configuracao {

  private double tempPrice;
  private double finalPrice;
  private ArrayList<Componente> tempSelected;
  private ArrayList<Componente> selected;

  public Configuracao() {
    tempPrice = 0;
    finalPrice = 0;
    tempSelected = new ArrayList<>();
    selected = new ArrayList<>();
  }
  
  /**
   * Returns the ids of all the Components who can't be selected with the current final config
   * @return
   */
  public Set<Integer> getUnavailable() {
    HashSet<Integer> r = new HashSet<>();
    for(Componente c : selected) {
      List<Integer> incomp = c.getIncompatible();
      for(Integer i : incomp)
        r.add(i);
    }
    return r;
  }
  
  /**
   * Returns all the components who need confirmation to be part of the config
   * @return
   */
  public List<Componente> getTemporarySelected() {
    return this.tempSelected;
  }
  
  /**
   * Returns all the components who have been confirmed as part of the config
   * @return
   */
  public List<Componente> getSelected() {
    return this.selected;
  }

  /**
   * Given a component, adds it to the unconfirmed components of  the config
   * @param comp
   */
  public void temporaryAddComponent(Componente comp) {
    tempSelected.add(comp);
    tempPrice += comp.getPrice();
  }

  /**
   * Given a list of components, adds them to the unconfirmed components of the config
   * @param listComp
   */
  public void temporaryAddComponent(List<Componente> listComp) {
    tempSelected.addAll(listComp);
    listComp.stream().forEach(c -> tempPrice += c.getPrice());
  }

  /**
   * Given a list of components, removes them from the confirmed components of the config
   * @param listComp
   */
  public void removeComponent(List<Componente> listComp) {
    selected.removeAll(listComp);
    listComp.stream().forEach(c -> tempPrice -= c.getPrice());
  }

  /** 
   * Removes all the unconfirmed components of the config
   */
  public void clearTemporary() {
    tempSelected.clear();
    tempPrice = 0;
  }

  /**
   * Returns the sum of cost of all the unconfirmed components
   * @return
   */
  public double getTempPrice() {
    return this.tempPrice;
  }
  
  /**
   * Returns the sum of cost of all the confirmed components
   * @return
   */
  public double getFinalPrice() {
    return this.finalPrice;
  }

  /**
   * Confirms all the unconfirmed components
   */
  public void updateTempToFinal() {
    selected.addAll(tempSelected);
    tempSelected.clear();
    finalPrice += tempPrice;
    tempPrice = 0;
  }

  /**
   * Resets the config to nothing selected
   */
  public void reset() {
    tempSelected.clear();
    selected.clear();
    tempPrice = 0;
    finalPrice = 0;
  }
}
