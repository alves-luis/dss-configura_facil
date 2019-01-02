package business;

import data.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Facade {
  //private HashMap<Integer,Pacote> pacotes;
  //private HashMap<Integer,Modelo> modelos;    
  //private HashMap<Integer,Componente> componentes;
  private Configuracao currentConfig;
  private ArrayList<ComponentePrimario> compPrimarios;
  private ArrayList<ComponenteAcessorio> compAcessorios;      
    private ModeloDAO modelos;
    private ComponenteDAO componentes;  
    private PacoteDAO pacotes;
          
    public Facade(){
        this.modelos = new ModeloDAO();
        this.componentes = new ComponenteDAO();
        this.pacotes = new PacoteDAO();
        this.currentConfig = new Configuracao();
        this.compPrimarios = new ArrayList<>();
        this.compAcessorios = new ArrayList<>();
        
        ArrayList<Pacote> p = new ArrayList<>(this.pacotes.values());
        
        ArrayList<Componente> comp = new ArrayList<>(this.componentes.values());
        for (int i = 0; i < comp.size(); i++) {
            if(comp.get(i).getClass() == ComponenteAcessorio.class)
                this.compAcessorios.add((ComponenteAcessorio) comp.get(i));
            if(comp.get(i).getClass() == ComponentePrimario.class)
                this.compPrimarios.add((ComponentePrimario) comp.get(i));
	}      
    } 
  /**
   * This methods returns a list of components that make up a quasi-optimal config
   * Uses constructive heuristic
   * @param val
   * @return
   */
  public List<Componente> getConfiguracaoOtima(double val) {
    List<Componente> result = new ArrayList<>();
    TreeSet<ComponenteAcessorio> orderedComps = new TreeSet<>(Comparator.reverseOrder());
    List<ComponenteAcessorio> aces = this.getSecundariosSelecionaveis();
    Set<Integer> incomps = new HashSet<>();
    
    for(ComponenteAcessorio c : aces)
      if (c.getPrice() <= val)
        orderedComps.add(c);
    
    double sum = 0;
    
    while (sum < val && orderedComps.size() > 0) {
      ComponenteAcessorio candidate = orderedComps.first();
      if (!incomps.contains(candidate.getCod())) {
        double value = candidate.getPrice();
        List<Integer> extra = candidate.getExtra();
        List<ComponenteAcessorio> listExtra = new ArrayList<>();
        for(Integer id : extra) {
          ComponenteAcessorio compExtra = (ComponenteAcessorio) this.componentes.get(id);
          value += compExtra.getPrice();
          listExtra.add(compExtra);
        }
        if (value + sum <= val) {
          result.add(candidate);
          incomps.addAll(candidate.getIncompatible());
          if (!listExtra.isEmpty())
            result.addAll(listExtra);
          sum += value;
          for(ComponenteAcessorio c : listExtra)
            orderedComps.remove(c);
        }
      }
      orderedComps.remove(candidate);
    }
    return result;
  }

  /**
   * Returns a list of all the primary components that are not incompatible with the ones
   * selected
   * @return
   */
  public List<ComponentePrimario> getPrimariosSelecionaveis() {
    Set<Integer> incompatible = currentConfig.getUnavailable();
    List<ComponentePrimario> r = new ArrayList<>();
    for (ComponentePrimario c : compPrimarios)
      if (!incompatible.contains(c.getCod()))
        r.add(c);
    return r;
  }
  
  /**
   * Returns a list of all the secondary components that are not incompatible with the ones
   * selected
   * @return
   */
  public List<ComponenteAcessorio> getSecundariosSelecionaveis() {
    Set<Integer> incompatible = currentConfig.getUnavailable();
    List<ComponenteAcessorio> r = new ArrayList<>();
    for(ComponenteAcessorio c : compAcessorios)
      if (!incompatible.contains(c.getCod()))
        r.add(c);
    return r;
  }

  /**
   * Given an id of a component, returns that component
   * @param codComp
   * @return
   */
  public Componente getComponente(int codComp) {
    return this.componentes.get(codComp);
  }

  /**
   * Given an id of a primary component, returns a list of all its models
   * @param comp
   * @return
   */
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
   * Given a code of a component, returns a list of the incompatible components of
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
   * Given a code of component, returns the components already selected that are incompatible
   * @param codComp
   * @return
   */
  public List<Componente> getIncompativeisFromSelected(int codComp) {
    List<Componente> r = new ArrayList<>();
    Set<Componente> incomp = this.currentConfig.getIncompatibleFromSelected(codComp);
    for(Componente c : incomp)
      r.add(c);
    return r;
  }

  /**
   * Returns a list of all the components in the system
   * @return
   */
  public List<Componente> getComponentes() {
    List<Componente> r = new ArrayList<>();
    r.addAll(this.compAcessorios);
    r.addAll(this.modelos.values());
    return r;
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
   * Given a package with components, adds them to the temporary set of components
   * @param pac
   */
  public void adicionaCompTemporario(Pacote pac) {
    List<Componente> all=pac.getComponentes();
    this.currentConfig.temporaryAddComponent(all);
  }  
  

  /**
   * Resets the temporary status of the config
   */
  public void cancelaConfiguracao() {
    this.currentConfig.clearTemporary();
  }
  
  /**
   * Resets the config to 0 components selected
   */
  public void resetConfiguracao() {
    this.currentConfig.reset();
  }

  /**
   * Given a list of components, removes them from the temporary set of components
   * @param codsComp
   */
  public void removeComponente(List<Componente> codsComp) {
    this.currentConfig.removeComponent(codsComp);
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
    Componente c = this.componentes.get(codComp);
    if (c != null)
      c.addStock(qt);
  }
  
  /**
   * Returns the components that are temporary
   * @return
   */
  public List<Componente> getPreSelected() {
    return this.currentConfig.getTemporarySelected();
  }
  
  /**
   * This method of returning final Price is terrible. Just saying
   */
  public double getPrecoFinal() {
    double priceWithoutPack = this.currentConfig.getFinalPrice();
    List<Componente> selected = this.currentConfig.getSelected();
    for(Pacote p : this.pacotes.values()) {
      boolean all = true;
      double priceSum = 0;
      for(Componente c : p.getComponentes()) {
        if (!selected.contains(c)) {
          all = false;
          break;
        }
        else
          priceSum += c.getPrice();
      }
      if (all) {
        double pricePack = p.getPreco();
        priceWithoutPack -= priceSum;
        priceWithoutPack += pricePack;
      }
    }
    return priceWithoutPack;
  }

  public List<Componente> getSelecionados() {
    return this.currentConfig.getSelected();
  }

  /**
   * Returns the models who have been selected
   * @return
   */
  public List<Modelo> getModelosSelecionados() {
    List<Componente> selected = this.currentConfig.getSelected();
    List<Modelo> r = new ArrayList<>();
    for(Componente c : selected)
      if (c instanceof Modelo)
        r.add((Modelo) c);
    return r;
  }
  
  public List<ComponenteAcessorio> getAcessoriosSelecionados() {
    List<Componente> selected = this.currentConfig.getSelected();
    List<ComponenteAcessorio> r = new ArrayList<>();
    for(Componente c : selected)
      if (c instanceof ComponenteAcessorio)
        r.add((ComponenteAcessorio)c);
    return r;
  }

  public Pacote getPacoteWithString(String i){
        ArrayList<Pacote> p = new ArrayList<>(this.pacotes.values());
        for (Pacote s : p)
            if(i.equals(s.getName()))
                return s.clone();
        return null;
  }
  /**
   * Returns all the available packages.
   */
  
  public List<Pacote> getPacotes(){
      return this.pacotes.values().stream().collect(Collectors.toList());
  }
  
  /**
   * Given the identifier of a package, returns the package.
   * @param pack
   */
  public Pacote getPacote(int pack){
      return this.pacotes.get(pack);
  }
  
  /**
   * Given a package, returns a list of all the components that are
   * incompatible, from the ones selected
   *
   * @param pack
   */
  public List<Componente> getIncompativeisFromSelected(Pacote pack) {
    List <Componente> comps = pack.getComponentes();
    List<Componente> r = new ArrayList<>();
    for (Componente init : comps) {
      List<Componente> incompativeis = getIncompativeisFromSelected(init.getCod());
      for(Componente c : incompativeis)
        if (!r.contains(c))
          r.add(c);
    }
    return r;
  }
  

  public double getPrecoPacote(int idPack){
      double r = 0;
      Pacote p = this.pacotes.get(idPack);
      if (p != null)
        return p.getPreco();
      else
        return r;
  }
  
  public List<Componente> getComponentes(int idPack) {
    Pacote p = this.pacotes.get(idPack);
    if (p != null)
      return p.getComponentes();
    else
      return new ArrayList<>();
  }
}
