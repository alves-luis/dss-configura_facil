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
  
  public List<Integer> getModelos() {
    return this.modelos;
  }
  
  public void addModelo(Modelo m) {
    if (m != null)
      this.modelos.add(m.getCod());
  }
  
  
}