package awesomecucumber.stepdef;

import awesomecucumber.constants.EndPoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class customer_stepdef {
    private final WebDriver driver;
    private final TestContext context;
    public customer_stepdef(TestContext context){
        this.context = context;
        driver = context.driver;
    }
    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }
    @Given("I'm guest customer")
    public void iMGuestCustomer() {
        new StorePage(driver).load(EndPoint.STORE.url);
    }

}
