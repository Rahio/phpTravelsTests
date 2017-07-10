package com.selenium.test.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Rahi on 2017-06-27.
 */
public class ActionBot {

    private final WebDriver driver;

    public ActionBot(WebDriver driver) {
        this.driver = driver;
    }

    public void type(WebElement element, String text) {
            element.clear();
            element.sendKeys(text);
    }

    public void waitUntilElementIsClickable(WebElement element, int seconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void waitUntilElementIsClickableAndClickOnIt(WebElement element, int seconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void waitUntilElementIsVisibleAndCllickIt(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void waitUntilElementIsVisible(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String waitUntilElementIsVisibleAndGetText(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public void moveToElementAndClickOnIt(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        element.click();
    }

    public void selectFromDropdownByVisibleText(WebElement element, String text)
    {
        new Select(element).selectByVisibleText(text);
    }

    public void acceptSimpleAlert()
    {
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
    }
}
