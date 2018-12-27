package business;

import java.util.ArrayList;

public class Modelo extends Componente {

  public Modelo(int id, String name, double price) {
    super(id, name, price);
  }

  public Modelo(int id, String name, double price, ArrayList<Integer> extras, ArrayList<Integer> incompativeis){
    super(id, name, price, extras, incompativeis);
  }
}