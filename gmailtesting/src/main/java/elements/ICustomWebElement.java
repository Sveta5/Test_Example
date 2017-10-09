package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public interface ICustomWebElement {
    String getText();

    void setText(String text);

    boolean isDisplayed();

    boolean isElementEnabled();

    void click();

    String getAttribute(String attributeName);

    WebElement getCurrentElement();

    WebElement waitUntilElementCondition(ExpectedCondition<WebElement> expectedCondition, long timeout);

    WebElement waitUntilElementIsVisible(long timeoutInSeconds);

    void clear();
}
