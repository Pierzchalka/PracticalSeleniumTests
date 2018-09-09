package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (null == driver) {
            //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            //driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.setCapability("browserName", "chrome");
            options.setCapability("platform", "WIN10");
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


            driver.manage().window().maximize();
            driver.navigate().to("http://automationpractice.com");
        }
        return driver;
    }


//        public class Driver {
//            private static WebDriver driver;
//
//            public static WebDriver getDriver() {
//                if (null == driver) {
//                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//
//                    //linijka do nowego poma prezentacja
//                    driver = new ChromeDriver();
//                    driver.manage().window().maximize();
//                    driver.navigate().to("http://automationpractice.com");
//                }
//                return driver;
//
//



    public static void quit() {
        if (null != driver) {
            getDriver().quit();
        }
        driver = null;
    }

    public static String getTitle() {
        return getDriver().getTitle();

    }
}
