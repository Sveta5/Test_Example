package page;

import driver.OneDriver;
import elements.CustomWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SearchPage extends BasePage {
    private CustomWebElement searchInputField = new CustomWebElement(By.id("lst-ib"));

    public SearchPage() {
    }

    public void openSearchPage() {
        OneDriver.get().get("https://encrypted.google.com/");
    }

    public void setSearchedText(String text) {
        searchInputField.waitUntilElementIsVisible(5);
        searchInputField.setText(text);
    }

    public void pressEnter() {
        searchInputField.getCurrentElement().sendKeys(Keys.ENTER);
    }
}
