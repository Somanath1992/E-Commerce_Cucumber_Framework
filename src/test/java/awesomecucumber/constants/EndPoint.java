package awesomecucumber.constants;

public enum EndPoint {
    STORE("/store"),
    ADD_TO_CART("/?wc-ajax=add_to_cart"),
    CHECKOUT("/checkout");
    public final String url;


    EndPoint(String url) {
        this.url = url;
    }
}
