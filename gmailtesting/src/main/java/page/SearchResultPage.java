package page;

import elements.CustomWebElement;
import elements.ICustomWebElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {
    private ICustomWebElement generalResultedLabel = new CustomWebElement(By.className("mod"));

    public SearchResultPage() {
    }

    public String getResultedLabelText() {
        generalResultedLabel.waitUntilElementIsVisible(7);
        return generalResultedLabel.getText();
    }
}
