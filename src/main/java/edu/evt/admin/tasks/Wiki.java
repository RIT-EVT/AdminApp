package edu.evt.admin.tasks;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by wheeler on 11/2/16.
 */
public class Wiki {
    public static String START_URL = "https://wiki.rit.edu/customspacemgmt/permissions/docustompermissionsmanage.action?key=EVT&selectedGroup=EVT-members";

    private WebDriver driver;

    public Wiki(){
    }

    public boolean setup(){
        driver = new FirefoxDriver();
        driver.get(START_URL);

        WebElement usernameField = driver.findElement(By.id("os_username"));
        usernameField.clear();
        usernameField.sendKeys("evt");

        WebElement passwordField = driver.findElement(By.id("os_password"));
        passwordField.clear();
        passwordField.sendKeys("somePassword"); // TODO: need to implement some sort of encrypted credentials provider so I dont have to put them in code.

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // At this point, we should have reached the members list page. 
        return true;
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
