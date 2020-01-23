import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class contains the list of all the properties in the register.
 * The class has methods for adding properties, listing all the properties.
 * returning the number of properties, deleting a specific property,
 * finding a specific property, calculating the average area of all the
 * properties. You can also search for properties with their lot numbers
 *
 * @author Erik Dale
 * @version 14.11.2019
 */
public class PropertyRegister {
    //creates an arraylist of properties
    private ArrayList<Property> properties;

    /**
     * Constructor for objects of class PropertyRegister
     */
    public PropertyRegister() {
        properties = new ArrayList<>();
    }

    /**
     * This method adds a book to the register
     *
     * @param the parameters are the fields of the property-class
     */
    public void addProperty(int municipalityNumber, String municipalityName,
                            int lotNumber, int sectionNumber, String name, double area, String nameOfOwner) {
        properties.add(new Property(municipalityNumber, municipalityName,
                lotNumber, sectionNumber, name, area, nameOfOwner));

        System.out.println("A property with ID: " + municipalityNumber +
                "-" + lotNumber + "/" + sectionNumber + " has just been added.");
    }

    /**
     * This method lists all the properties in the register
     */
    /*public void listAllProperties() {
        if (properties.size() > 0) {
            for (Property property : properties) {
                property.printProperty();
            }
        } else {
            System.out.println("There are no properties in the register");
        }
    }*/

    /**
     * This method lists all the properties in the register
     */
    public void listAllProperties() {
        properties
                .stream()
                .forEach(s -> s.printProperty());
    }

    /**
     * This method returns the number of properties in the register.
     *
     * @return an int that represents the number of properties in the register.
     */
    public int numberOfProperties() {
        int properties1 = 0;
        if (properties.size() > 0) {
            for (Property property : properties) {
                properties1++;
            }
            return properties1;
        } else {
            return 0;
        }
    }

    /**
     * This method deletes a specific property in the register
     *
     * @param the parameter is the property's ID that the user inserts
     */
    /*public void deleteProperty(String searchString) {
        for (int i = 0; i < properties.size(); i++) {
            Property property = properties.get(i);
            if (property.getID().trim().contains(searchString.trim())) {
                properties.remove(property);
                System.out.println("The property with ID: " +
                        property.getID() + " has been removed.");
            } else {
                System.out.println("There is no property with that ID"
                        + " in the register.");
            }
        }
    }*/

    /**
     * This method deletes a specific property in the register
     *
     * @param the parameter is the property's ID that the user inserts
     */
    public void deleteProperty(String searchString) {
        properties
                .stream()
                .map(n -> n.getID().trim().contains(searchString.trim()))
                .collect(Collectors.toList());

        try {
            for (Property property : properties) {
                properties.remove(property);
                System.out.println("The property with ID: " +
                        property.getID() + " has been removed.");
            }
        }
        catch(java.util.ConcurrentModificationException exception){
            for (Property property : properties) {
            System.out.println("The property with ID: " +
                    property.getID() + " has been removed.");
            }
        }
    }

    /**
     * This method searches for a property using its ID.
     *
     * @param the user inserts the property's ID.
     */
    public void findProperty(String searchString) {
        properties
                .stream()
                .map(p -> p.getID().toLowerCase().trim().contains(searchString.trim().toLowerCase()))
                .collect(Collectors.toList());
        for (Property property : properties) {
            property.printProperty();
        }
    }
    /**
     * This method searches for a property using its ID.
     *
     * @param the user inserts the property's ID.
     */
    /*public void findProperty(String searchString) {
        for (Property property : properties) {
            if (property.getID().toLowerCase().trim().contains(searchString.trim().toLowerCase())) {
                property.printProperty();
            } else {
                System.out.println("There is no property with that ID"
                        + " in the register.");
            }
        }
    }*/

    /**
     * This method calculates the average area of all the properties
     */
    public double calculateAverage() {
        return properties
                .stream()
                .map(s -> s.getArea())
                .reduce(0.0, (total, count) -> total + count);

    }
    /**
     * This method calculates the average area of all the properties
     */
    /*public double calculateAverage() {
        double average = 0;
        for (Property property : properties) {
            average = average + property.getArea();
        }
        double averageArea = (average / numberOfProperties());
        return averageArea;
    }*/

    /**
     * This method searches for the properties with a specific
     * lot number inserted by the user.
     *
     * @param the users input (the lot number)
     * @return returns an arraylist of the properties
     * with that specific lot number
     */
    public ArrayList<Property> getArrayList(int searchInt) {
        ArrayList<Property> properties2 = new ArrayList<>();
        for (Property property : properties) {
            if (property.getLotNumber() == searchInt) {
                properties2.add(property);
            } else if (property.getLotNumber() != searchInt) {
                System.out.println("There are no properties with that"
                        + " lot number.");
            }
        }
        return properties2;
    }

    /**
     * This method chech the validity of a municipality number.
     * The number must be between and including 101 and 5054.
     *
     * @param the municipality number that the user inserts.
     */
    public boolean validMunicipalityNumber(int municipalityNumber) {
        int municipalityNumber1 = municipalityNumber;
        if (municipalityNumber1 >= 101 && municipalityNumber1 <= 5054) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method chech the validity of a lot number.
     * The number must be greater than 0.
     *
     * @param the lot number that the user inserts.
     */
    public boolean validLotNumber(int lotNumber) {
        int lotNumber1 = lotNumber;
        if (lotNumber1 > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method chech the validity of a section number.
     * The number must be greater than 0.
     *
     * @param the section number that the user inserts.
     */
    public boolean validSectionNumber(int sectionNumber) {
        int sectionNumber1 = sectionNumber;
        if (sectionNumber1 > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method chech the validity of a property's area.
     * The number must be greater than 0.
     *
     * @param the area that the user inserts.
     */
    public boolean validArea(double area) {
        double area1 = area;
        if (area1 > 0.0) {
            return true;
        } else {
            return false;
        }
    }

    public String validID(String ID) {
        int IDnumber = 0;
        for (Property property : properties) {
            if (property.getID().toLowerCase().equals(ID)) {
                IDnumber++;
            }
        }
        if (IDnumber == 0) {
            return ID;
        } else if (IDnumber > 0) {
            ID = "invalid";
        }
        return ID;
    }
}
