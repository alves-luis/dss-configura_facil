package business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComponentePrimario extends Componente {
  
  private ArrayList<Integer> modelos;

  public ComponentePrimario(int id, String name, double price) {
    super(id, name, price);
    modelos = new ArrayList<>();
  }

    public ComponentePrimario(int ID, String name, double price, ArrayList<Integer> ID_extras, ArrayList<Integer> ID_incompativeis, ArrayList<Integer> ID_modelos) {
        super(ID, name, price, ID_extras,ID_incompativeis);
        this.modelos = ID_modelos;
    }
  
  public List<Integer> getModelos() {
    return this.modelos;
  }
  
  public void addModelo(Modelo m) {
    if (m != null)
      this.modelos.add(m.getCod());
  }
  
  
}