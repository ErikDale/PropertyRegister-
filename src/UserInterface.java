import java.util.Scanner; 
import java.util.ArrayList; 
/**
 * Write a description of class UserInterface here.
 *
 * @author Erik Dale
 * @version 07.11.19
 */
public class UserInterface
{
    private PropertyRegister propertyRegister; 
    private final int ADD_PROPERTY = 1;   
    private final int LIST_ALL_PROPERTIES = 2;
    private final int FIND_PROPERTY = 3;
    private final int CALCULATE_AVERAGE_AREA = 4;
    private final int CLEAR_TERMINAL = 5;
    private final int DELETE_PROPERTY = 6;
    private final int FIND_PROPERTY_BY_LOT_NUMBER = 7;
    private final int EXIT = 8;     
    
    /**
     * The constructer of the UserInterface-class
     */
    public UserInterface(){
        propertyRegister = new PropertyRegister(); 
        start(); 
    }
    /**
     * Presents the menu for the user, and awaits input from the user. The menu
     * choice selected by the user is being returned.
     *
     * @return the menu choice by the user as a positive number starting from 1.
     *                 If 0 is returned, the user has entered a wrong value
     */
    private int showMenu()

    {
        int menuChoice = 0;

        System.out.println("\n***** Property Register Application *****\n");
        System.out.println("1. Add property");
        System.out.println("2. List all properties");
        System.out.println("3. Search property by ID");
        System.out.println("4. Calculate average area");
        System.out.println("5. Clear terminal");
        System.out.println("6. Delete property"); 
        System.out.println("7. Search property by lot number"); 
        //TODO: Add more menus
        System.out.println("8. Quit");
        System.out.println("\nPlease enter a number between 1 and 8.\n");
        
        Scanner sc1 = new Scanner(System.in);

        if (sc1.hasNextInt()) {
            menuChoice = sc1.nextInt();
        } else {
            System.out.println("You must insert a number!"); 
        }
        return menuChoice;
    }
    /**
     * Starts the application. This is the main loop of the application,
     * presenting the menu, retrieving the selected menu choice from the user,
     * and executing the selected functionality.
     */
    public void start() {
        boolean finished = false;        
        // The while-loop will run as long as the user has not selected
        // to quit the application
        while (!finished) { 
            int menuChoice = this.showMenu();
            switch (menuChoice)
            {
                case ADD_PROPERTY:
                    this.addProperty(); 
                    break;
                    
                case LIST_ALL_PROPERTIES:
                    propertyRegister.listAllProperties();
                    System.out.println("Number of properties in register: "
                    + propertyRegister.numberOfProperties()); 
                    break;
                    
                case FIND_PROPERTY:
                    this.findPropertyID(); 
                    break;
                    
                case CALCULATE_AVERAGE_AREA:
                    this.calculateAverage(); 
                    break;
                
                case CLEAR_TERMINAL:
                    this.clearTerminal();
                    break; 
                    
                case DELETE_PROPERTY:
                    this.deleteProperty(); 
                    break; 
                
                case FIND_PROPERTY_BY_LOT_NUMBER:
                    this.findPropertyLotNumber();
                    break; 
                                
                case EXIT:
                    System.out.println("Thank you for using the Properties app!\n");
                    finished = true;
                    break;
                    
                default:
                    System.out.println("Unrecognized menu selected..");
                    break;
            }
        }
    }  
    /**
     * Adds a property to the register by using insertions from the user
     * and putting those as property-fields.
     */
    public void addProperty(){
        Scanner sc = new Scanner(System.in);      
        
        System.out.println("Insert municipality number: ");
        int municipalityNumber = 0;        
        boolean valid = false;
        do{          
            if(sc.hasNextInt()){                
                municipalityNumber = Integer.parseInt(sc.nextLine().trim());
                valid = propertyRegister.validMunicipalityNumber(municipalityNumber);
                if(!valid){
                    System.out.println("Insert a municipalitnumber betweern 101 and 5054.");                    
                }            
            }
            else{
                System.out.println("Insert a municipalitynumber betweern 101 and 5054.");
                sc.nextLine().trim(); 
            }
        }           
        
        while(!valid);              
        
        String municipalityName = "";
        while(municipalityName.isEmpty() || (!municipalityName.matches("[a-zA-z]*"))){ 
            System.out.println("Insert municipality name: ");
            municipalityName = sc.nextLine().trim();                            
        }        
        
        System.out.println("Insert lot number: ");
        int lotNumber = 0;
        boolean valid1 = false;
        do{
            if(sc.hasNextInt()){
                lotNumber = Integer.parseInt(sc.nextLine().trim());
                valid1 = propertyRegister.validLotNumber(lotNumber); 
                if(!valid1){
                    System.out.println("The lot number must be a number greater"
                    + " than 0. Now insert the number again.");
                }
            }
            else{
                System.out.println("The lot number must be a number greater"
                + " than 0. Now insert the number again.");
                sc.nextLine().trim();
            }
        }
        while(!valid1);       
        
        System.out.println("Insert section number: "); 
        int sectionNumber = 0; 
        boolean valid2 = false; 
        do{
            if(sc.hasNextInt()){
                sectionNumber = Integer.parseInt(sc.nextLine().trim());
                valid2 = propertyRegister.validSectionNumber(sectionNumber); 
                if(!valid2){
                    System.out.println("The section number must be a number greater"
                    + " than 0. Now insert the number again.");
                }
            }
            else{
                System.out.println("The section number must be a number greater"
                + " than 0. Now insert the number again.");
                sc.nextLine().trim();
            }
        }
        while(!valid2);       
        
        String name = "";
        System.out.println("Does the property have a name? Insert yes/no");
        if(sc.nextLine().equals("yes")){            
            while(name.isEmpty() || (!name.matches("[a-zA-z]*"))){
                System.out.println("Insert name of property: ");
                name = sc.nextLine().trim();
            }             
        }
        else{
            System.out.println("Yes was not registered, so name was set to: NONE.");     
            name = "NONE";            
        }      
        
                
        System.out.println("Insert property area (must use comma, not dot)"
        + ": "); 
        double area = 0.0; 
        boolean valid3 = false; 
        do{
            if(sc.hasNextDouble()){
                area = sc.nextDouble(); 
                valid3 = propertyRegister.validArea(area); 
                if(!valid3){
                    System.out.println("The area must be a number greater"
                    + " than 0. Now insert the number again.");
                }
            }
            else{
                System.out.println("The area must be a number greater"
                + " than 0. Now insert the number again.");
                sc.nextLine().trim();
            }
        }
        while(!valid3);  
        sc.nextLine();
        
        String nameOfOwner = "";
        while(nameOfOwner.isEmpty() || (!nameOfOwner.matches("[a-zA-z]*"))){
            System.out.println("Insert name of owner: ");
            nameOfOwner = sc.nextLine().trim();
        }  
        
        String ID = municipalityNumber + "-" + lotNumber + "/" 
        + sectionNumber;
        
        if(propertyRegister.validID(ID).equals("invalid")){
            System.out.println("You inserted a property that is already in the register." +
            " It was therefore removed from the register.");
        }
        else{
            propertyRegister.addProperty(municipalityNumber, municipalityName,
            lotNumber, sectionNumber, name, area, nameOfOwner); 
        }      
    }  
    /**
     * Finds the property with a specific ID on the special form:
     * (municipality number)-(lot number)/(section number)
     */
    public void findPropertyID(){
        Scanner sc2 = new Scanner(System.in); 
        System.out.println("Use the property's ID to search for it. "
        + "The ID has a special form: "
        + "(municipality number)-(lot number)/(section number)");
        System.out.println("Insert the property's ID:");
        
        String inputLine; 
        boolean valid4 = false;
        do{
            if(sc2.hasNextLine()){
                inputLine = sc2.nextLine();
                propertyRegister.findProperty(inputLine);
                valid4 = true; 
                if(!valid4){
                    System.out.println("Use the property's ID to search for it. "
                    + "The ID has a special form: "
                    + "(municipality number)-(lot number)/(section number)");
                    System.out.println("Insert the property's ID:");
                }
            }
            else{
                System.out.println("Use the property's ID to search for it. "
                + "The ID has a special form: "
                + "(municipality number)-(lot number)/(section number)");
                System.out.println("Insert the property's ID:");
                sc2.nextLine(); 
            }
        } 
        while(!valid4); 
    }
     /**
     * This method deletes a specific property by using its unique ID:
     * (municipality number)-(lot number)/(section number)
     */
    public void deleteProperty(){
        Scanner sc3 = new Scanner(System.in); 
        System.out.println("Use the property's ID to delete it. "
        + "The ID has a special form: "
        + "(municipality number)-(lot number)/(section number)");
        System.out.println("Insert the property's ID:");
        
        String inputLine; 
        boolean valid5 = false;
        do{
            if(sc3.hasNextLine()){
                inputLine = sc3.nextLine();
                propertyRegister.deleteProperty(inputLine);
                valid5 = true; 
                if(!valid5){
                    System.out.println("Use the property's ID to delete it. "
                    + "The ID has a special form: "
                    + "(municipality number)-(lot number)/(section number)");
                    System.out.println("Insert the property's ID:");
                }
            }
            else{
                System.out.println("Use the property's ID to delete it. "
                + "The ID has a special form: "
                + "(municipality number)-(lot number)/(section number)");
                System.out.println("Insert the property's ID:");
                sc3.nextLine(); 
            }
        } 
        while(!valid5);         
    }
     /**
     * This method finds properties with a specific lot number. 
     * More than one property can have the same lot number. 
     */
    public void findPropertyLotNumber(){
        Scanner sc4 = new Scanner(System.in); 
        System.out.println("Use the property's lot number to search for it.");
        System.out.println("Insert the property's lot number:");
        
        int inputLine = 0; 
        boolean valid6 = false; 
        do{
            if(sc4.hasNextInt()){
                inputLine = sc4.nextInt();               
                ArrayList<Property> properties = propertyRegister.getArrayList(inputLine); 
                for(Property property : properties){
                    property.printProperty(); 
                }
                valid6 = true; 
                if(!valid6){
                    System.out.println("Use the property's lot number to search for it.");
                    System.out.println("Insert the property's lot number:");
                }
            }
            else{
                System.out.println("Use the property's lot number to search for it.");
                System.out.println("Insert the property's lot number:");
                sc4.nextLine().trim();
            }
        }
       while(!valid6);
    }
    public void calculateAverage(){
        double averageArea = propertyRegister.calculateAverage(); 
        System.out.println(averageArea); 
    }
    /**
     * This method clears the terminal.
     */
    public void clearTerminal(){
        System.out.print('\u000C'); //I think this only works in blueJ
    }
}
