package test.java.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ErrorPageImpl implements ErrorPage {

    private final WebDriver driver;

    public ErrorPageImpl(WebDriver driver){
        this.driver = driver;
    }

    @Override
    /*
     * String returns "Vehicle details could not be found"
     */
    public String getPageHeading () {
        return this.driver.findElement(By.className("heading-large")).getText();
    }

    @Override
    /*
     *String returns "Please contact vehicle enquiries:"
     */
    public String getErrorContactInfoString() {
        return this.driver.findElement(By.xpath("//div/p/strong")).getText();
    }

}
