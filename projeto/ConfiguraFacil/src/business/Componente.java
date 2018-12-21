package business;

import java.util.ArrayList;
import java.util.List;

public class Componente {

  private int id;
  private String name;
  private double price;
  private ArrayList<Integer> extras;
  private ArrayList<Integer> incompativeis;
  private int stock;

  public Componente(int id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.extras = new ArrayList<>();
    this.incompativeis = new ArrayList<>();
    stock = 0;
  }

  public List<Integer> getExtra() {
    return this.extras;
  }

  public List<Integer> getIncompatible() {
    return this.incompativeis;
  }

  public double getPrice() {
    return this.price;
  }

  public int getCod() {
    return this.id;
  }

  public int getNumDependencies() {
    return this.extras.size() + this.incompativeis.size();
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setPrice(double price) {
    this.price = price;
  }
  
  public void addStock(int qt) {
    this.stock += qt;
  }
  
  public void addIncompatibility(int in) {
    this.incompativeis.add(in);
  }
}
