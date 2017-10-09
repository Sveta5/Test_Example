package driver;

import org.openqa.selenium.WebDriver;

public class OneDriver {
    private static final ThreadLocal<WebDriver> driverInstance = new ThreadLocal<WebDriver>();

    public OneDriver() {
    }

    public static WebDriver get() {
        return driverInstance.get();
    }

    public static synchronized void setDriver(String driver) {
        if (get() == null) {
            WebDriver webDriver = BrowserFactory.getDriver(driver);
            driverInstance.set(webDriver);
        }
    }

    public void close() {
        if (get() != null) {
            get().close();
            get().quit();
            driverInstance.remove();
        }
    }

}
