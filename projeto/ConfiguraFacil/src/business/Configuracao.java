import java.util.ArrayList;

public class Configuracao {
	private double tempPrice;
	private double finalPrice;
	public ArrayList<Componente> tempSelected = new ArrayList<Componente>();
	public ArrayList<Componente> selected = new ArrayList<Componente>();

	public List<Componente> getUnavailable() {
		throw new UnsupportedOperationException();
	}

	public void temporaryAddComponent(Componente comp) {
		throw new UnsupportedOperationException();
	}

	public void temporaryAddComponent(List<Componente> listComp) {
		throw new UnsupportedOperationException();
	}

	public void temporaryRemoveComponent(List<Componente> listComp) {
		throw new UnsupportedOperationException();
	}

	public void clearTemporary() {
		throw new UnsupportedOperationException();
	}

	public double getTempPrice() {
		return this.tempPrice;
	}

	public void updateTempToFinal() {
		throw new UnsupportedOperationException();
	}
}