package test.java.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegEnterPageImpl implements RegEnterPage {

    private final WebDriver driver;

    public RegEnterPageImpl(WebDriver driver){
        this.driver = driver;
    }

    @Override
    /*
     * String returns "Enter the registration number of the vehicle"
     */
    public String getPageHeading () {
        return this.driver.findElement(By.className("heading-large")).getText();
    }

    @Override
    /*
     * String returns "There was a problem"
     */
    public String getErrorStringHeading () {
        return this.driver.findElement(By.cssSelector(".heading-medium")).getText();
    }

    @Override
    public String registrationNumber() {
        System.out.println("registration number: " + this.driver.findElement(By.id("Vrm")).getText());
        return this.driver.findElement(By.id("Vrm")).getText();
    }

    @Override
    /*
     * String returns "You must enter your registration number in a valid format"
     */
    public String getErrorString() {
        return this.driver.findElement(By.id("Vrm-error")).getText();
    }
}
