package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    /**
     * 1. userShouldAddProductSuccessFullyToShoppinCart()
     * Mouse Hover on Men Menu
     * Mouse Hover on Bottoms
     * Click on Pants
     * Mouse Hover on product name
     * ‘Cronus Yoga Pant’ and click on size 32.
     * Mouse Hover on product name
     * ‘Cronus Yoga Pant’ and click on colour Black.
     * Mouse Hover on product name
     * ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
     * Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
     * Click on ‘shopping cart’ Link into message
     * Verify the text ‘Shopping Cart.’
     * Verify the product name ‘Cronus Yoga Pant’
     * Verify the product size ‘32’
     * Verify the product colour ‘Black’
     */
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        mouseHoverToElement(By.id("ui-id-5"));  // mouse hover on men
        mouseHoverToElement(By.id("ui-id-18")); //mouse hover on bottoms
        clickOnElement(By.id("ui-id-23")); //click on pants
        // Mouse Hover on product name ‘Cronus Yoga Pant’
        mouseHoverToElement(By.xpath("(//div[@class='product-item-info'])[1]"));
        //click on size 32.
        clickOnElement(By.id("option-label-size-143-item-175"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’
        mouseHoverToElement(By.xpath("(//div[@class='product-item-info'])[1]"));
        //click on colour Black.
        clickOnElement(By.id("option-label-color-93-item-49"));
        //  Mouse Hover on product name ‘Cronus Yoga Pant’
        mouseHoverToElement(By.xpath("(//div[@class='product-item-info'])[1]"));
        //click on ‘Add To Cart’ Button
        clickOnElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));
        // Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        Assert.assertEquals("text is not displayed", "You added Cronus Yoga Pant to your shopping cart.", getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")));
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.linkText("shopping cart"));
        // Verify the text ‘Shopping Cart.’
        //Assert.assertEquals("text is not displayed", "Shopping Cart.", getTextFromElement(By.xpath("//span[text()='Shopping Cart']")));
        // Verify the product name ‘Cronus Yoga Pant’
        Assert.assertEquals("product text is incorrect", "Cronus Yoga Pant", getTextFromElement(By.linkText("Cronus Yoga Pant")));
        //   Verify the product size ‘32’
        Assert.assertEquals("product size in incorrect", "32", getTextFromElement(By.xpath("//dd[contains(text(),'32')]")));
        //   Verify the product colour ‘Black’
        Assert.assertEquals("product color is not black", "Black", getTextFromElement(By.xpath("//dd[contains(text(),'Black')]")));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
