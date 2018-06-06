package test.java.selenium.pages;


public interface RegEnterPage extends Page {

    /**
     * Get the registration number
     * @return String representing registration number (plate) on the initial page
     */
    public String registrationNumber();

    /**
     * Get the error message heading
     * @return String stating "There was a problem" an error message that is specific to the initial page
     */
    public String getErrorStringHeading ();

    /**
     * Get the error message
     * @return String stating "You must enter your registration number in a valid format"
     */
    public String getErrorString();
}
