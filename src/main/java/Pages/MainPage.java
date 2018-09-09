package Pages;

import Driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends SeleniumBasePage {

    public MainPage(WebDriver driver) {
      //  super(driver);
    }


    @FindBy(css = "button.button-search")
    public WebElement searchBtn;

    @FindBy(id = "search_query_top")
    public WebElement searchQueryFld;

    @FindBy(css = "a[class='product-name'][title=\'Printed Dress\'][href*='id_product=4']")
    public WebElement dressNamePrintedDress;

    @FindBy(css = "ul#homefeatured div.product-container")
    public List<WebElement> ListOfCointainers;

    @FindBy(css = "a.product-name")
    public WebElement produktName;


    public MainPage clickSearchBtn() {
        searchBtn.click();
        return this;
    }

    public MainPage typeSearch(String text) {
        searchQueryFld.clear();
        searchQueryFld.sendKeys(text);
        return new MainPage(Driver.getDriver());
    }

    public PrintedDressPage chooseThisProduct() {
        dressNamePrintedDress.click();
        return new PrintedDressPage(Driver.getDriver());
    }

    public MainPage findProductkName(String productName) {

        boolean exist = false;
        for (WebElement elements : ListOfCointainers) {
            if (produktName.getText().toLowerCase().contains(productName)) ;
            exist = true;
            break;
        }
        return new MainPage(Driver.getDriver());

    }

}
