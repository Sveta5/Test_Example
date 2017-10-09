package elements;

import driver.OneDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CustomWebElement implements ICustomWebElement {

    By elementLocator;

    public CustomWebElement(By elementLocator) {
        this.elementLocator = elementLocator;
    }

    public String getText() {
        return getCurrentElement().getText();
    }

    public void setText(String text) {
        WebElement element = getCurrentElement();
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public boolean isDisplayed() {
        return getCurrentElement().isDisplayed();
    }

    public boolean isElementEnabled() {
        return getCurrentElement().isEnabled();
    }

    public void click() {
        getCurrentElement().click();
    }

    public String getAttribute(String attributeName) {
        return getCurrentElement().getAttribute(attributeName);
    }

    public WebElement getCurrentElement() {
        return OneDriver.get().findElement(elementLocator);
    }

    public WebElement waitUntilElementCondition(ExpectedCondition<WebElement> expectedCondition, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(OneDriver.get(), 15);

        return wait.until(expectedCondition);
    }

    public WebElement waitUntilElementIsVisible(long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(OneDriver.get(), timeoutInSeconds);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public void clear() {
        WebElement element = getCurrentElement();
        element.click();
        element.clear();
    }
}
