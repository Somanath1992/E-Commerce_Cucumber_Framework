package awesomecucumber.pages;

import awesomecucumber.domainobjects.BillingDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
    @FindBy(xpath = "//input[@name='billing_first_name']")
    private WebElement billing_first_nameFld;
    @FindBy(xpath = "//input[@name='billing_last_name']")
    private WebElement billing_last_nameFld;
    @FindBy(xpath = "//input[@name='billing_address_1']")
    private WebElement billing_address_one_Fld;
    @FindBy(xpath = "//input[@name='billing_city']")
    private WebElement billing_city_nameFld;
    @FindBy(xpath = "//select[@name='billing_state']")
    private WebElement billing_state_drpdwn;
    @FindBy(xpath = "//input[@name='billing_postcode']")
    private WebElement billing_zip_codeFld;
    @FindBy(xpath = "//input[@name='billing_email']")
    private WebElement billing_email_Fld;
    @FindBy(xpath = "//button[@id='place_order']")
    private WebElement placeOrderBtn;
    @FindBy(xpath = "//p[text()='Thank you. Your order has been received.']")
    private WebElement orderMsg;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterBillingFirstName(String billingFirstName) {
        billing_first_nameFld.clear();
        billing_first_nameFld.sendKeys(billingFirstName);
        return this;

    }

    public CheckoutPage enterBillingLastName(String billingLastName) {
        billing_last_nameFld.clear();
        billing_last_nameFld.sendKeys(billingLastName);
        return this;
    }

    public CheckoutPage enterBillingAddressLineOne(String billingAddressLineOne) {
        billing_address_one_Fld.clear();
        billing_address_one_Fld.sendKeys(billingAddressLineOne);
        return this;
    }

    public CheckoutPage enterBillingCity(String billingCity) {
        billing_city_nameFld.clear();
        billing_city_nameFld.sendKeys(billingCity);
        return this;
    }

    public CheckoutPage selectBillingState(String billingStateName) {
        Select select = new Select(billing_state_drpdwn);
        select.selectByVisibleText(billingStateName);
        return this;
    }

    public CheckoutPage enterBillingZip(String billingZip) {
        billing_zip_codeFld.clear();
        billing_zip_codeFld.sendKeys(billingZip);
        return this;
    }

    public CheckoutPage enterBillingEmail(String billingEmail) {
        billing_email_Fld.clear();
        billing_email_Fld.sendKeys(billingEmail);
        return this;
    }

    public CheckoutPage setBillingDetails(BillingDetails billingDetails) {
        return enterBillingFirstName(billingDetails.getBillingFirstName()).
                enterBillingLastName(billingDetails.getBillingLastName())
                .enterBillingAddressLineOne(billingDetails.getBillingAddressOne())
                .enterBillingCity(billingDetails.getBillingCity()).
                selectBillingState(billingDetails.getBillingStateName())
                .enterBillingZip(billingDetails.getBillingZip()).
                enterBillingEmail(billingDetails.getBillingEmail());
    }

    public CheckoutPage placeOrder() {
        wait.until(ExpectedConditions.visibilityOf(placeOrderBtn)).click();
        return this;
    }

    public String getOrderMsg() {
        return wait.until(ExpectedConditions.visibilityOf(orderMsg)).getText();
    }
}
