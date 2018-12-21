package configurafacil;

import business.Facade;
import view.menus.MenuPrincipal;



/**
 *
 * Main class
 */
public class ConfiguraFacil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Facade f = new Facade();
        
        MenuPrincipal mainMenu = new MenuPrincipal(f);
        
        mainMenu.setVisible(true);
    }
    
}
