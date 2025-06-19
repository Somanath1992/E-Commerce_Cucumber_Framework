package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
     @FindBy (xpath = "//td[@class='product-name']") private WebElement productNameFld;
     @FindBy (xpath = "//input[@type='number']") private WebElement productQuantityFld;
     @FindBy (xpath = "//a[normalize-space()='Proceed to checkout']") private WebElement proceedToCheckoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public String getProductName(){
        return productNameFld.getText();
    }
    public int getProductQuantity(){
        return Integer.parseInt(productQuantityFld.getAttribute("value"));
    }
    public void checkOut(){
        proceedToCheckoutBtn.click();
    }
}
