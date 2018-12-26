package business;

import business.Componente;
import business.Facade;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pacote {
  
  private ArrayList<Componente> pack;
  private double preco;
  private String name;
  
  public Pacote() {
    preco=0;
    pack = new ArrayList<>();
    name="";
  }
  

  public void packSport(Facade f) {
      this.pack.add(f.getComponente(1));
      this.pack.add(f.getComponente(2));
      this.pack.add(f.getComponente(3));
      this.pack.add(f.getComponente(4));
      this.pack.add(f.getComponente(5));
      this.preco=5000;
      this.name="sport";
  }
  
  public void packConfort(Facade f) {
      this.pack.add(f.getComponente(11));
      this.pack.add(f.getComponente(22));
      this.pack.add(f.getComponente(33));
      this.pack.add(f.getComponente(44));
      this.pack.add(f.getComponente(55));
      this.preco=5000;
      this.name="confort";
  }
    
  public double getPreco() {
    return this.preco*0.8;
  }
  
}