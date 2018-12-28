
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafaelarodrigues
 */
public class Pacote {

  private int id;
  private String nome;
  private double desconto;
  private ArrayList<Componente> componentes;

  public Pacote(int id, String nome, double desconto) {
    this.id = id;
    this.nome = nome;
    this.desconto = desconto;
    this.componentes = new ArrayList<>();
  }

  public Pacote(int id, String nome, double desconto, ArrayList<Componente> comps) {
    this.id = id;
    this.nome = nome;
    this.desconto = desconto;
    this.componentes = comps;
  }
  
  public List<Componente> getComponentes() {
    return this.componentes;
  }
   
  public double getPreco() {
    double total = 0;
    for (Componente c : this.componentes) {
      total += c.getPrice();
    }
    total = total - total * this.desconto;
    return total;
  }
  
  public String getName() {
    return this.nome;
  }
  
  public int getId() {
    return this.id;
  }

    public Pacote clone(){
        int i = this.id;
        String n = this.nome;
        double d = this.desconto;
        ArrayList<Componente> t = new ArrayList<>();
        for(Componente s: this.componentes){
            t.add(s);
        }           
        return new Pacote(i,n,d,t);
    }
    
    public double getDesconto() {
        return this.desconto;
    }

}
/**
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
    
 */

