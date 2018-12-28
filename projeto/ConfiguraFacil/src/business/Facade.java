package business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Facade {
  private HashMap<Integer,Modelo> modelos;
  private HashMap<Integer,Componente> componentes;
  private Configuracao currentConfig;
  private ArrayList<ComponentePrimario> compPrimarios;
  private ArrayList<ComponenteAcessorio> compAcessorios;
  private HashMap<Integer,Pacote> pacotes;

  public Facade() {
    modelos = new HashMap<>();
    componentes = new HashMap<>();
    currentConfig = new Configuracao();
    compPrimarios = new ArrayList<>();
    compAcessorios = new ArrayList<>();
    pacotes= new HashMap<>();
    ComponentePrimario c1 = new ComponentePrimario(0, "Motor", 0);
    ComponentePrimario c2 = new ComponentePrimario(1, "Pneu", 0);
    ComponentePrimario c3 = new ComponentePrimario(2, "Transmissão", 0);
    Modelo m1 = new Modelo(3,"Motor V6",7500);
    Modelo m2 = new Modelo(4,"Pneu Extra-Fino",300);
    Modelo m3 = new Modelo(5,"Transmissão Automática",2000);
    Modelo m4 = new Modelo(6,"Motor V3",5000);
    m1.addIncompatibility(0);
    m1.addIncompatibility(3);
    m2.addIncompatibility(4);
    m2.addIncompatibility(1);
    m3.addIncompatibility(5);
    m3.addIncompatibility(2);
    m3.addIncompatibility(6);
    m4.addIncompatibility(0);
    m4.addIncompatibility(3);
    m4.addIncompatibility(5);
    m4.addIncompatibility(6);
    c1.addModelo(m1);
    c2.addModelo(m2);
    c3.addModelo(m3);
    c1.addModelo(m4);
    this.modelos.put(3, m1);
    this.modelos.put(4, m2);
    this.modelos.put(5, m3);
    this.modelos.put(6, m4);
    this.componentes.put(3, m1);
    this.componentes.put(4,m2);
    this.componentes.put(5, m3);
    this.componentes.put(6, m4);
    this.componentes.put(0, c1);
    this.componentes.put(1, c2);
    this.componentes.put(2, c3);
    this.compPrimarios.add(c1);
    this.compPrimarios.add(c2);
    this.compPrimarios.add(c3);
    //ACESSORIO
    ComponenteAcessorio b1 = new ComponenteAcessorio(22, "Para-Brisas Fixe", 200);
    ComponenteAcessorio b2 = new ComponenteAcessorio(23, "Escovas Super-Limpeza", 300);
    ComponenteAcessorio b3 = new ComponenteAcessorio(24,"Kit mãos-livres com interface USB", 100);
    ComponenteAcessorio b4 = new ComponenteAcessorio(25,"Informação de trânsito em tempo real",165);
    ComponenteAcessorio b5 = new ComponenteAcessorio(26,"Sistema de navegação Professional",1650);
    ComponenteAcessorio b6 = new ComponenteAcessorio(27,"Sistema de som HiFi",305);
    ComponenteAcessorio b7 = new ComponenteAcessorio(28,"Sistema de som Harman Kardon",800);
    ComponenteAcessorio b8 = new ComponenteAcessorio(29,"Para-brisas com faixa cinza",95);
    ComponenteAcessorio b9 = new ComponenteAcessorio(30,"Dispositivo de acoplamento de reboque",840);
    ComponenteAcessorio b10 = new ComponenteAcessorio(31,"Travão desportivo",640);
    ComponenteAcessorio b11 = new ComponenteAcessorio(32,"Traseira Rebaixada",739);
    b1.addIncompatibility(22);
    b2.addIncompatibility(23);
    b3.addIncompatibility(24);
    b4.addIncompatibility(25);
    b4.addIncompatibility(26);
    b5.addIncompatibility(26);
    b5.addIncompatibility(25);
    b6.addIncompatibility(27);
    b6.addIncompatibility(28);
    b7.addIncompatibility(28);
    b7.addIncompatibility(27);
    b8.addIncompatibility(29);
    b8.addExtra(22);
    b9.addIncompatibility(30);
    b9.addExtra(31);
    b9.addIncompatibility(32);
    b10.addIncompatibility(31);
    b11.addIncompatibility(30);
    b11.addIncompatibility(32);
    this.componentes.put(22,b1);
    this.componentes.put(23,b2);
    this.componentes.put(24,b3);
    this.componentes.put(25,b4);
    this.componentes.put(26,b5);
    this.componentes.put(27,b6);
    this.componentes.put(28,b7);
    this.componentes.put(29,b8);
    this.componentes.put(30,b9);
    this.componentes.put(31,b10);
    this.componentes.put(32,b11);
    this.compAcessorios.add(b1);
    this.compAcessorios.add(b2);
    this.compAcessorios.add(b3);
    this.compAcessorios.add(b4);
    this.compAcessorios.add(b5);
    this.compAcessorios.add(b6);
    this.compAcessorios.add(b7);
    this.compAcessorios.add(b8);
    this.compAcessorios.add(b9);
    this.compAcessorios.add(b10);
    this.compAcessorios.add(b11);
    //Pacotes
    new Pacote(0, "Sport", 0.8);
    /*
    Pacote sport= new Pacote();
    sport.packSport(this);
    Pacote confort= new Pacote();
    confort.packConfort(this);
    this.pacotes.add(sport);
    this.pacotes.add(confort);
    */
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
    
    for(ComponenteAcessorio c : aces)
      if (c.getPrice() <= val)
        orderedComps.add(c);
    
    double sum = 0;
    
    while (sum < val && orderedComps.size() > 0) {
      ComponenteAcessorio candidate = orderedComps.first();
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
        if (!listExtra.isEmpty())
          result.addAll(listExtra);
        sum += value;
        for(ComponenteAcessorio c : listExtra)
          orderedComps.remove(c);
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
