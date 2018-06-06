package test.java.selenium.pages;


public interface Page {

    /**
     * Gets the page heading
     * @return String containing the page heading text
     */
    public String getPageHeading ();

    /**
     * Strings used in the tests from the web pages
     */
    public static String StartPage_HEADING = "Get vehicle information from DVLA";

    public static String RegEnterPage_HEADING = "Enter the registration number of the vehicle";
    public static String RegEnterPage_ERROR_HEADING = "There was a problem";
    public static String RegEnterPage_ERROR_STRING = "You must enter your registration number in a valid format";

    public static String VehicleCheckPage_HEADING = "Is this the vehicle you are looking for?";

    public static String ErrorPage_HEADING = "Vehicle details could not be found";
    public static String ErrorPage_CONTACT_INFO = "Please contact vehicle enquiries:";

}
