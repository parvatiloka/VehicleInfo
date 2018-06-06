package test.java.selenium.pages;


public interface VehicleCheckPage extends Page {

    /**
     * Gets the vehicle information from the check details page
     * @return an array of strings that represents the registration number, model and colour
     * of the vehicle on the webpage.
     */
    public String[] getVehicleInfo();
}
