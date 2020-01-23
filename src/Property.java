
/**
 * The instances of this class represents properties. The class contains fields that
 * contains information about the properties. It contains accessors and mutators to return
 * and change the value of the fields.
 *
 * @author Erik Dale
 * @version 07.11.19
 */
public class Property {
    //All necessary fields a property needs to store information about it.
    private int municipalityNumber;
    private int inputYear;
    private String municipalityName;
    private int lotNumber;
    private int sectionNumber;
    private String name;
    private double area;
    private String nameOfOwner;

    /**
     * Constructor for objects of class Property
     */
    public Property(int municipalityNumber, String municipalityName,
                    int lotNumber, int sectionNumber, String name, double area, String nameOfOwner, int inputYear) {
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.name = name;
        this.area = area;
        this.nameOfOwner = nameOfOwner;
        this.inputYear = inputYear;
    }

    /**
     * Method to get the municipality number
     *
     * @return municicpality number of the property
     */
    public int getMunicipalityNumber() {
        return municipalityNumber;
    }

    /**
     * Method to get the municipality name
     *
     * @return municipality name of the property
     */
    public String getMunicipalityName() {
        return municipalityName;
    }

    /**
     * Method to get the lot number
     *
     * @return lot number of the property
     */
    public int getLotNumber() {
        return lotNumber;
    }

    /**
     * Method to get the section number
     *
     * @return section number of the property
     */
    public int getSectionNumber() {
        return sectionNumber;
    }

    /**
     * Method to get the name of the property
     *
     * @return name of the property
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get the property area
     *
     * @return area of the property
     */
    public double getArea() {
        return area;
    }

    /**
     * Method to get the property's owner's name
     *
     * @return name of the owner of the property
     */
    public String getNameOfOwner() {
        return nameOfOwner;
    }

    /**
     * Getter method to get the input year.
     * @return the year the property was input
     */
    public int getInputYear() {
        return inputYear;
    }

    /**
     * Method that prints out a property with all its fields
     */

    public void printProperty() {
        System.out.println("-------------------------");
        System.out.println("Municipality name: " + municipalityName);
        System.out.println("Municippality number: " + municipalityNumber);
        System.out.println("Lot number: " + lotNumber);
        System.out.println("Section number: " + sectionNumber);
        System.out.println("Name: " + name);
        System.out.println("Area: " + area);
        System.out.println("Name of owner: " + nameOfOwner);
        System.out.println("Year of input: " + inputYear);
        System.out.println("-------------------------");

    }

    /**
     * Method that creates a property-ID using its municipality number,
     * lot number and section number on the form
     * (municipality number)-(lot number)/(section number)
     *
     * @return name of the owner of the property
     */
    public String getID() {
        String ID = municipalityNumber + "-" + lotNumber + "/"
                + sectionNumber;
        return ID;
    }
}
