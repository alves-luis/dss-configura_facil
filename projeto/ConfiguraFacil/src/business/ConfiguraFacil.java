import java.util.ArrayList;

public class ConfiguraFacil {
	public Modelo modelos;
	public Componente componentes;
	public Configuracao currentConfig;
	public ArrayList<ComponentePrimario> compPrimarios = new ArrayList<ComponentePrimario>();
	public ArrayList<ComponenteAcessorio> compAcessorios = new ArrayList<ComponenteAcessorio>();

	public List<Componente> getConfiguracaoOtima(double val) {
		throw new UnsupportedOperationException();
	}

	public List<Componente> getSelecionaveis() {
		throw new UnsupportedOperationException();
	}

	public Componente getComponente(int codComp) {
		throw new UnsupportedOperationException();
	}

	public List<Modelo> getModelos(int comp) {
		throw new UnsupportedOperationException();
	}

	public Modelo getModelo(int codMod) {
		throw new UnsupportedOperationException();
	}

	public double getPrecoTemporario() {
		throw new UnsupportedOperationException();
	}

	public List<Componente> getExtra(int codComp) {
		throw new UnsupportedOperationException();
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