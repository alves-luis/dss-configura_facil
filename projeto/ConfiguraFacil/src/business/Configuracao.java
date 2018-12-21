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
  
  public Set<Integer> getUnavailable() {
    HashSet<Integer> r = new HashSet<>();
    for(Componente c : selected) {
      List<Integer> incomp = c.getIncompatible();
      for(Integer i : incomp)
        r.add(i);
    }
    return r;
  }
  
  public List<Componente> getTemporarySelected() {
    return this.tempSelected;
  }
  
  public List<Componente> getSelected() {
    return this.selected;
  }

  public void temporaryAddComponent(Componente comp) {
    tempSelected.add(comp);
    tempPrice += comp.getPrice();
  }

  public void temporaryAddComponent(List<Componente> listComp) {
    tempSelected.addAll(listComp);
    listComp.stream().forEach(c -> tempPrice += c.getPrice());
  }

  public void temporaryRemoveComponent(List<Componente> listComp) {
    tempSelected.removeAll(listComp);
    listComp.stream().forEach(c -> tempPrice -= c.getPrice());
  }

  public void clearTemporary() {
    tempSelected.clear();
    tempPrice = 0;
  }

  public double getTempPrice() {
    return this.tempPrice;
  }
  
  public double getFinalPrice() {
    return this.finalPrice;
  }

  public void updateTempToFinal() {
    selected.addAll(tempSelected);
    tempSelected.clear();
    finalPrice += tempPrice;
    tempPrice = 0;
  }
}
