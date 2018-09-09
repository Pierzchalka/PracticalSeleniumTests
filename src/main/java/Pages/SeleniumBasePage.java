package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import Driver.Driver;

public class SeleniumBasePage {

    //protected WebDriver driver;
    public SeleniumBasePage() {
        //this.driver=driver;
        PageFactory.initElements(Driver.getDriver(), this);
    }

}

