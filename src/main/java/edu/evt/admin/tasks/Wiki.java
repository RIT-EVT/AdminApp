package edu.evt.admin.tasks;

import edu.evt.admin.App;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wheeler on 11/2/16.
 */
public class Wiki {
    public static String START_URL = "https://wiki.rit.edu/customspacemgmt/permissions/docustompermissionsmanage.action?key=EVT&selectedGroup=EVT-members";

    private WebDriver driver;

    public Wiki(){
    }

    public byte[] setup(){
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        driver.get(START_URL);

        WebElement usernameField = driver.findElement(By.id("os_username"));
        usernameField.clear();
        usernameField.sendKeys(App.credentialProvider.get("wiki_username"));

        WebElement passwordField = driver.findElement(By.id("os_password"));
        passwordField.clear();
        passwordField.sendKeys(App.credentialProvider.get("wiki_password"));

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        byte[] scData = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

        // At this point, we should have reached the members list page.
        return scData;
    }

    public boolean addOne(){

        driver.get("https://wiki.rit.edu");
        return false;

    }

    public boolean teardown(){
        driver.quit();
        return true;

    }
}
