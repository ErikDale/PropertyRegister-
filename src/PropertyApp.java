/**
 * The main class fo the Book Library application. Only contains
 * the main()-method to get the application started.
 * 
 * @author Arne Styve
 * @version 2019-10-16
 */
public class PropertyApp {
    /**
     * The main()-method, starting the application.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserInterface PropertyAppUi = new UserInterface();
        PropertyAppUi.start();    
    }    
}
