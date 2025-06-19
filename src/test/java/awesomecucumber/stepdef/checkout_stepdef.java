package awesomecucumber.stepdef;

import awesomecucumber.constants.EndPoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class checkout_stepdef {
    private final TestContext context;
    private final CheckoutPage checkoutPage;
    public checkout_stepdef(TestContext context){
        this.context = context;
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
        checkoutPage.setBillingDetails(context.billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        checkoutPage.placeOrder();
    }

    @Then("Order should be placed successfully")
    public void orderShouldBePlacedSuccessfully() {
        Assert.assertEquals(checkoutPage.getOrderMsg(),
                "Thank you. Your order has been received.");
    }
    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
       checkoutPage.load(EndPoint.CHECKOUT.url);
    }
}
