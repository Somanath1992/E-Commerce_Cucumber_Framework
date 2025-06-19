package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage{
    @FindBy(xpath = "//a[@title='View cart']") private WebElement viewCartLink;


    public StorePage(WebDriver driver) {
        super(driver);
    }
    public void addToCart(String productName){
       WebElement addToCartBtn=driver.findElement(By.xpath("//a[@aria-label='Add “" + productName + "” to your cart']"));
       addToCartBtn.click();
       wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }
}
