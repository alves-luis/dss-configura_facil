import java.util.ArrayList;

public class Componente {
	private int id;
	private String name;
	private double price;
	public ArrayList<Componente> extras = new ArrayList<Componente>();
	public ArrayList<Componente> incompativeis = new ArrayList<Componente>();

	public List<Integer> getExtra() {
		throw new UnsupportedOperationException();
	}

	public List<Integer> getIncompatible() {
		throw new UnsupportedOperationException();
	}

	public double getPrice() {
		return this.price;
	}

	public int getCod() {
		throw new UnsupportedOperationException();
	}

	public int getNumDependencies() {
		throw new UnsupportedOperationException();
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
}