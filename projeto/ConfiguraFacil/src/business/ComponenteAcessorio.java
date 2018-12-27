package business;

import java.util.ArrayList;

public class ComponenteAcessorio extends Componente {

    public ComponenteAcessorio(int id, String name, double price) {
        super(id, name, price);
    }

    public ComponenteAcessorio(int ID, String name, double price, ArrayList<Integer> ID_extras, ArrayList<Integer> ID_incompativeis) {
        super(ID, name, price, ID_extras, ID_incompativeis);
    }
  
}