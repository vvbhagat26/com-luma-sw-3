package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomanTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /*
    verifyTheSortByProductNameFilter
* Mouse Hover on Women Menu
* Mouse Hover on Tops
* Click on Jackets
* Select Sort By filter “Product Name”
* Verify the products name display in
alphabetical order

     */
    @Test

    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        //Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
        //Mouse Hover on Tops
        mouseHoverToElement(By.id("ui-id-9"));
        //Click on Jackets
        clickOnElement(By.id("ui-id-11"));
        //Store products before clicking on filter
        List<WebElement> beforeFilterProductNames = getMultipleElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        //Create arraylist
        List<String> beforeFilterProductNamesList = new ArrayList<>();
        //Store elements text to array list
        for (WebElement p : beforeFilterProductNames) {
            beforeFilterProductNamesList.add(p.getText());
        }
        //Sort arraylist to ascending oreder
        Collections.sort(beforeFilterProductNamesList);
        //Select Sort By filter “Product Name”
        selectByValueFromDropDown(By.id("sorter"), "name");
        Thread.sleep(2000);
        //Store elements after filtering
        List<WebElement> afterFilterProductNames = getMultipleElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        //Create anothor list to store text of elements after clicking on filter Z to A
        List<String> afterFilterProductNamesList = new ArrayList<>();
        for (WebElement s : afterFilterProductNames) {
            afterFilterProductNamesList.add(s.getText());
        }
        //Verify the products name display in alphabetical order
        //Compare both list
        Assert.assertEquals("Products are not sorted in alphabetical order", afterFilterProductNamesList, beforeFilterProductNamesList);
    }
    /*
     * 2. verifyTheSortByPriceFilter
     * * Mouse Hover on Women Menu
     * * Mouse Hover on Tops
     * * Click on Jackets
     * * Select Sort By filter “Price”
     * * Verify the products price display in
     * Low to High
     */

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        //Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
        //Mouse Hover on Tops
        mouseHoverToElement(By.id("ui-id-9"));
        //Click on Jackets
        clickOnElement(By.id("ui-id-11"));
        //Select Sort By filter “Price”
        List<WebElement> beforeFilterProductPrice = getMultipleElements(By.xpath("//span[@class='price-wrapper ']//span[@class='price']"));
        //Create arraylist
        List<Double> beforeFilterProductPriceList = new ArrayList<>();
        //Store elements text to array list
        for (WebElement p : beforeFilterProductPrice) {
            String beforeFilterPrice = p.getText().replaceAll("[E,x,T,a,x,£,:,$]", "").replace(",", "");
            Double priceValueBeforeFilter = Double.parseDouble(beforeFilterPrice);
            beforeFilterProductPriceList.add(priceValueBeforeFilter);
        }
        //Sort arraylist to ascending oreder
        Collections.sort(beforeFilterProductPriceList);
        //Select Sort By position "Price low to high"
        selectByValueFromDropDown(By.id("sorter"), "price");
        Thread.sleep(2000);
        //Store elements after filtering
        List<WebElement> afterFilterProductPrice = getMultipleElements(By.xpath("//span[@class='price-wrapper ']//span[@class='price']"));
        //Create anothor list to store text of elements after clicking on filter Price high to low
        List<Double> afterFilterProductPriceList = new ArrayList<>();
        for (WebElement s : afterFilterProductPrice) {
            String afterFilterPrice = s.getText().replaceAll("[E,x,T,a,x,£,:,$]", "").replace(",", "");
            Double afterFilterPriceValue = Double.parseDouble(afterFilterPrice);
            afterFilterProductPriceList.add(afterFilterPriceValue);
        }
        //Verify the products price display Low to High
        Assert.assertEquals("Products are not sorted in ascending order", afterFilterProductPriceList, beforeFilterProductPriceList);
    }
    @After
    public void tearDown () {
        //  closeBrowser();
    }
}
