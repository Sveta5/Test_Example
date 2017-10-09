package base;

import driver.BrowserFactory;
import driver.OneDriver;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class BaseTest {

    protected Logger log;

    @BeforeClass(alwaysRun = true)
    protected void serUpClass(ITestContext testContext) {
        String testName = testContext.getCurrentXmlTest().getName();
        log = Logger.getLogger(testName);
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browser) {
        log.info("Method set up");
        OneDriver.setDriver(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tierDown() {
        log.info("Method tier down");
        OneDriver.get().quit();
    }
}
