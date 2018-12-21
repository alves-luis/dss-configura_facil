package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Facade {
  private HashMap<Integer,Modelo> modelos;
  private HashMap<Integer,Componente> componentes;
  private Configuracao currentConfig;
  private ArrayList<ComponentePrimario> compPrimarios;
  private ArrayList<ComponenteAcessorio> compAcessorios;

  public Facade() {
    modelos = new HashMap<>();
    componentes = new HashMap<>();
    currentConfig = new Configuracao();
    compPrimarios = new ArrayList<>();
    compAcessorios = new ArrayList<>();
    ComponentePrimario c1 = new ComponentePrimario(0, "Componente 1", 2);
    ComponentePrimario c2 = new ComponentePrimario(1, "Componente 2", 4);
    ComponentePrimario c3 = new ComponentePrimario(2, "Componente 3", 6);
    Modelo m1 = new Modelo(3,"Modelo a",4);
    Modelo m2 = new Modelo(4,"Modelo b",5);
    Modelo m3 = new Modelo(5,"Modelo c",6);
    c1.addModelo(m1);
    c2.addModelo(m2);
    c3.addModelo(m3);
    this.modelos.put(3, m1);
    this.modelos.put(4, m2);
    this.modelos.put(5, m3);
    this.componentes.put(3, m1);
    this.componentes.put(4,m2);
    this.componentes.put(5, m3);
    this.componentes.put(0, c1);
    this.componentes.put(1, c2);
    this.componentes.put(2, c3);
    this.compPrimarios.add(c1);
    this.compPrimarios.add(c2);
    this.compPrimarios.add(c3);
    this.adicionaCompTemporario(c3);
    this.adicionaCompTemporario(c2);
    this.adicionaCompTemporario(c1);
    this.confirmaComponentes();
  }

  /**
   * This methods returns a list of components that make up a quasi-optimal config
   * @param val
   * @return
   */
  public List<Componente> getConfiguracaoOtima(double val) {
    throw new UnsupportedOperationException();
  }

  public List<ComponentePrimario> getPrimariosSelecionaveis() {
    Set<Integer> incompatible = currentConfig.getUnavailable();
    List<ComponentePrimario> r = new ArrayList<>();
    for (ComponentePrimario c : compPrimarios)
      if (!incompatible.contains(c.getCod()))
        r.add(c);
    return r;
  }
  
  public List<ComponenteAcessorio> getSecundariosSelecionaveis() {
    Set<Integer> incompatible = currentConfig.getUnavailable();
    List<ComponenteAcessorio> r = new ArrayList<>();
    for(ComponenteAcessorio c : compAcessorios)
      if (!incompatible.contains(c.getCod()))
        r.add(c);
    return r;
  }

  public Componente getComponente(int codComp) {
    return this.componentes.get(codComp);
  }

  public List<Modelo> getModelos(int comp) {
    List<Modelo> r = new ArrayList<>();
    Componente c = this.componentes.get(comp);
    if (c instanceof ComponentePrimario) {
      List<Integer> mods = ((ComponentePrimario) c).getModelos();
      for(Integer cod : mods) {
        Modelo m = this.modelos.get(cod);
        if (m != null)
          r.add(m);
      }
    }
    return r;
  }

  /**
   * Given a code of a model, returns its instance or null if it does not exist
   * @param codMod
   * @return
   */
  public Modelo getModelo(int codMod) {
    return this.modelos.get(codMod);
  }

  /**
   * Returns the cost of temporary changes that haven't been accepted yet
   * @return
   */
  public double getPrecoTemporario() {
    return this.currentConfig.getTempPrice();
  }

  /**
   * Given a code of a component, returns a List of all the extra components it requires
   * @param codComp
   * @return
   */
  public List<Componente> getExtra(int codComp) {
    Componente c = this.componentes.get(codComp);
    List<Componente> r = new ArrayList<>();
    if (c != null) {
      List<Integer> extra = c.getExtra();
      for(Integer i : extra) {
        Componente e = this.componentes.get(i);
        if (e != null)
          r.add(e);
      }
    }
    return r;
  }

  /**
   * Given a code of a componente, returns a list of the incompatible components of
   * that component
   * @param codComp
   * @return
   */
  public List<Componente> getIncompativeis(int codComp) {
    Componente c = this.componentes.get(codComp);
    ArrayList<Componente> r = new ArrayList<>();
    if (c != null) {
      List<Integer> incomp = c.getIncompatible();
      for(Integer i : incomp) {
        Componente comp = this.componentes.get(i);
        if (comp != null)
          r.add(comp);
      }  
    }
    return r;
  }

  /**
   * Returns a list of all the components in the system
   * @return
   */
  public List<Componente> getComponentes() {
    return this.componentes.values().stream().collect(Collectors.toList());
  }

  /**
   * Given a component, adds it to the temporary set of components
   * @param comp
   */
  public void adicionaCompTemporario(Componente comp) {
    this.currentConfig.temporaryAddComponent(comp);
  }

  /**
   * Given a List of components, adds them to the temporary set of components
   * @param comps
   */
  public void adicionaCompTemporario(List<Componente> comps) {
    this.currentConfig.temporaryAddComponent(comps);
  }

  /**
   * Resets the temporary status of the config
   */
  public void cancelaConfiguracao() {
    this.currentConfig.clearTemporary();
  }

  /**
   * Given a list of components, removes them from the temporary set of components
   * @param codsComp
   */
  public void removeComponente(List<Componente> codsComp) {
    this.currentConfig.temporaryRemoveComponent(codsComp);
  }

  /**
   * Makes all the temporary set of components as final
   */
  public void confirmaComponentes() {
    this.currentConfig.updateTempToFinal();
  }

  /**
   * Given a quantity and the id of the component, updates its stock
   * @param qt
   * @param codComp
   */
  public void adicionaStock(int qt, int codComp) {
    throw new UnsupportedOperationException();
  }

}
