package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ConfiguraFacil {
  private HashMap<Integer,Modelo> modelos;
  private HashMap<Integer,Componente> componentes;
  private Configuracao currentConfig;
  private ArrayList<ComponentePrimario> compPrimarios;
  private ArrayList<ComponenteAcessorio> compAcessorios;

  public ConfiguraFacil() {
    modelos = new HashMap<>();
    componentes = new HashMap<>();
    currentConfig = new Configuracao();
    compPrimarios = new ArrayList<>();
    compAcessorios = new ArrayList<>();
  }


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

  public List<Componente> getIncompativeis(int codComp) {
    throw new UnsupportedOperationException();
  }

  public List<Componente> getComponentes() {
    throw new UnsupportedOperationException();
  }

  public void adicionaCompTemporario(Componente comp) {
    throw new UnsupportedOperationException();
  }

  public void adicionaCompTemporario(List<Componente> comps) {
    throw new UnsupportedOperationException();
  }

  public void cancelaConfiguracao() {
    throw new UnsupportedOperationException();
  }

  public void removeComponente(List<Componente> codsComp) {
    throw new UnsupportedOperationException();
  }

  public void confirmaComponentes() {
    throw new UnsupportedOperationException();
  }

  private List<Componente> getAllExtraComponente(int codComp) {
    throw new UnsupportedOperationException();
  }

  private List<Componente> getAllIncompatible(int codComp) {
    throw new UnsupportedOperationException();
  }

  public void adicionaStock(int qt, int codComp) {
    throw new UnsupportedOperationException();
  }

  public List<ComponenteAcessorio> getComponentesAcessorios() {
    throw new UnsupportedOperationException();
  }
}
