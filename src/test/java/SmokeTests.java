import Pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import Driver.Driver;

public class SmokeTests {//extends BaseTest { //- nadpisane pezez klase Driver

    @Test
    public void openPageTest() {

        Assert.assertEquals("Wrong page title", "My Store", Driver.getTitle());
        Driver.quit();
    }

    @Test
    public void searchButtonTest() {
        new MainPage(Driver.getDriver())
                .clickSearchBtn();
        Assert.assertEquals("Wrong page title", "Search - My Store", Driver.getTitle());
        Driver.quit();
   }
//
//    @Test // zdublowane pierwsza wersja kodu
//    public void searchButtonTest() {
//        new Pages.MainPage(driver)
//                .clickSearchBtn();
//        Assert.assertEquals("Wrong page title", "Search - My Store", driver.getTitle());
//    }

    @Test
    public void searchFieldTest() {

        new MainPage(Driver.getDriver())
                .typeSearch("Summer Dress")
                .clickSearchBtn();
        Assert.assertEquals("Wrong page title", "Search - My Store",Driver.getTitle());
    }

    //    @Test ZDUBLOWANY TEST - pierwsza wersja
//    public void searchFieldTest() {
//
//        new Pages.MainPage(driver)
//                .typeSearch("Summer Dress")
//                .clickSearchBtn();
//        Assert.assertEquals("Wrong page title", "Search - My Store", driver.getTitle());
//    }

//// TEST DO POPRAWY POP
////    @Test
////    public void findElementsListTest1() {
////        int noOfElements = 7;
////        String productName = "dress";
////
////      new Pages.MainPage (driver)
////              .findProductkName(productName);
////
////        Assert.assertTrue("Wrong number of elements on page", ListOfCointainers.size() == noOfElements);
////        Assert.assertTrue("Proper product doesn't exist", exist);
////    }
//
////    @Test
////    public void findElementsListTest1Vol1() {
////        int noOfElements = 7;
////        String productName = "dress";
////
////        List<WebElement> ListOfElements = driver.findElements(By.cssSelector("ul#homefeatured div.product-container"));
////        boolean exist = false;
////        for (WebElement elements : ListOfElements) {
////            if (elements.findElement(By.cssSelector("a.product-name")).getText().toLowerCase().contains(productName)) ;
////            exist = true;
////            break;
////        }
////        Assert.assertTrue("Wrong number of elements on page", ListOfElements.size() == noOfElements);
////        Assert.assertTrue("Proper product doesn't exist", exist);
////    }
//    @Test
//    public void findElementsListTest2() {
//        int noOfElements = 7;
//        String productName = "dress";
//
//        List<WebElement> ListOfElements = driver.findElements(By.cssSelector("ul#homefeatured div.product-container a.product-name"));
//        boolean exist = false;
//        for (WebElement element : ListOfElements) {
//            if (element.getText().toLowerCase().contains(productName)) ;
//            exist = true;
//            break;
//        }
//        Assert.assertTrue("Wrong number of elements on page", ListOfElements.size() == noOfElements);
//        Assert.assertTrue("Proper product doesn't exist", exist);
//    }
}
