
import Pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.abs;

public class WaitTests extends BaseTest {

    @Test
    public void implicitWaitTest() throws InterruptedException {
        String dressName = "Printed Dress";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        new MainPage(driver)
                .typeSearch(dressName)
                .clickSearchBtn()
                .chooseThisProduct()
                .addProductToCart();
        Thread.sleep(10000);

//wait zrobić, wywala asercje
        WebElement successfulAddingElm = driver.findElement(By.cssSelector("h2 .ajax_cart_product_txt"));
        String displayedMessage = successfulAddingElm.getText().trim();

        String expectedMessage = "There is 1 item in your cart.";
        Assert.assertTrue("Is displayed '" + displayedMessage + "' but should be " + expectedMessage,
                displayedMessage.contains(expectedMessage));
    }


    @Test //nie chce przejsc na POP bez pop wersja działa
    public void explicitWaitTest() {
        String dressName = "Printed Dress";
        String quantityOfProduct = "5";
        WebDriverWait wait = new WebDriverWait(driver, 20);

        new MainPage(driver)
                .typeSearch(dressName)
                .clickSearchBtn()
                .chooseThisProduct()
                .changeQuantity(quantityOfProduct)
                .chooseSizeOfDress()
                .addProductToCart();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".layer_cart_product>h2")));
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".layer_cart_product>h2"), "Product successfully added to your shopping cart"));

        WebElement successfulAddingElm = driver.findElement(By.cssSelector(".layer_cart_product>h2"));
        String displayedMessage = successfulAddingElm.getText().trim();
        String expectedMessage = "Product successfully added to your shopping cart";
        Assert.assertTrue("Is displayed: '" + displayedMessage + "' but should be: " + expectedMessage,
                displayedMessage.contains("Product successfully added to your shopping cart"));

    }

    @Test
    public void promotionTest() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".sf-menu>li>a[href*='id_category=8']")).click();

        List<WebElement> ListOfElements = driver.findElements(By.cssSelector(".right-block .content_price"));
        boolean isPromotionValid = false;
        for (WebElement element : ListOfElements) {
            if ((element.findElements(By.cssSelector(".price-percent-reduction")).size() != 0)) {
                double priceProductPrice = Double.parseDouble(element.findElement(By.cssSelector(".price.product-price")).getText().replaceAll("\\$", ""));         // Double.parseDouble - rzutowanie sitring na double, replaceALL - zamienianie znaków w stringu (dolar to znak specjalny w javie)
                double pricePercentReduction = abs(Double.parseDouble(element.findElement(By.cssSelector(".price-percent-reduction")).getText().replaceAll("%", ""))); // abs - wartość bezwzględna
                double oldPriceProductPrice = Double.parseDouble(element.findElement(By.cssSelector(".old-price.product-price")).getText().replaceAll("\\$", ""));
                double priceProductValid = (Math.round((oldPriceProductPrice * ((100 - pricePercentReduction) / 100))*100))/100d;
//                System.out.println(oldPriceProductPrice);
//                System.out.println(pricePercentReduction);
//                System.out.println(priceProductPrice);
//                System.out.println((priceProductValid) + "\n"); // należy dorobić zookrąglenie do 2 miejsca po przecinku (dzielenie modulo)

                if (priceProductValid == priceProductPrice)
                { // należy dorobić zookrąglenie do 2 miejsca po przecinku (dzielenie modulo) inaczej warunek się nie spełni (głupie długie liczny zmiennoprzecinkowe)
                    isPromotionValid = true;
                    System.out.println("promo Valid");

                }
                else {
                    isPromotionValid = false;
                    System.out.println("promo not Valid");
                }
// nie jest to do końca dobre. Należy dorobić  tablice(boolean array) dla przechowywania wyników true/false - Asercja powinna nastąpić tylko kiedy wszystkie wyniki są true.
            }
        }
        Assert.assertTrue("Prices in promotion aren't calculated right", isPromotionValid);
    }


    @Test
    public void explicitWaitTestVol1() {
        String dressName = "Printed Dress";
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement searchField = driver.findElement(By.cssSelector(".search_query"));
        searchField.clear();
        searchField.sendKeys("Printed Dress");
        driver.findElement(By.cssSelector(".button-search")).click();
        driver.findElement(By.cssSelector("a[class='product-name'][title=\"Printed Dress\"][href*='id_product=4']")).click();
        WebElement quantityField = driver.findElement(By.cssSelector("#quantity_wanted"));
        quantityField.clear();
        quantityField.sendKeys("5");
        driver.findElement(By.cssSelector("#group_1 option[value*='3']")).click();
        driver.findElement(By.cssSelector("#add_to_cart .exclusive")).click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".layer_cart_product>h2")));
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".layer_cart_product>h2"), "Product successfully added to your shopping cart"));

        WebElement successfulAddingElm = driver.findElement(By.cssSelector(".layer_cart_product>h2"));
        String displayedMessage = successfulAddingElm.getText().trim();
        String expectedMessage = "Product successfully added to your shopping cart";
        Assert.assertTrue("Is displayed: '" + displayedMessage + "' but should be: " + expectedMessage,
                displayedMessage.contains("Product successfully added to your shopping cart"));

    }

}
