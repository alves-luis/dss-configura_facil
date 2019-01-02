
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

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 47 * hash + this.id;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Pacote other = (Pacote) obj;
    if (this.id != other.id) {
      return false;
    }
    return true;
  }
    
    

}

