package Pages;

import Driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrintedDressPage extends SeleniumBasePage {
    public PrintedDressPage(WebDriver driver) {
        //super(driver);
    }

    @FindBy(css = "#add_to_cart .exclusive")
    private WebElement addToCartBtn;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityFld;

    @FindBy(id = "uniform-group_1")
    private WebElement playBtn;

    @FindBy(id = "group_1>option[value*='3']")
    private WebElement chooseSizeL;


    public PrintedDressPage addProductToCart() {
        addToCartBtn.click();
        return new PrintedDressPage(Driver.getDriver());
    }

    public PrintedDressPage changeQuantity(String quantity) {
        quantityFld.clear();
        quantityFld.sendKeys(quantity);
        return new PrintedDressPage(Driver.getDriver());
    }

    public PrintedDressPage chooseSizeOfDress() {


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(chooseSizeL));
        playBtn.click();
        chooseSizeL.click();
        return new PrintedDressPage(Driver.getDriver());
    }
}
