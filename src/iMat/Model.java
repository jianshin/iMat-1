package iMat;

import se.chalmers.cse.dat216.project.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Wrapper around the IMatDataHandler. The idea is that it might be useful to
 * add an extra layer that can provide special features
 *
 */
public class Model {

    private static Model instance = null;
    private IMatDataHandler iMatDataHandler;

    private final ArrayList<String> cardTypes = new ArrayList<String>(Arrays.asList("MasterCard", "Visa"));
    private final ArrayList<String> months = new ArrayList<String>(Arrays.asList("1", "2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12"));
    private final ArrayList<String> years = new ArrayList<String>(Arrays.asList("18", "19", "20", "21", "22", "23", "24"));

    /**
     * Constructor that should never be called, use getInstance() instead.
     */
    protected Model() {
        // Exists only to defeat instantiation.
    }

    /**
     * Returns the single instance of the Model class.
     */
    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
            instance.init();
        }
        return instance;
    }

    private void init() {

        iMatDataHandler = IMatDataHandler.getInstance();

    }

    public List<Product> getProducts(){
        return iMatDataHandler.getProducts();
    }

    // User functions
    public void addToShoppingCart(Product product){
        ShoppingCart shoppingcart = iMatDataHandler.getShoppingCart();
        shoppingcart.addProduct(product);
    }

    public void removeFromShoppingCart(Product product){
        ShoppingCart shoppingCart = iMatDataHandler.getShoppingCart();
        // TODO
    }

    // Users saved information
    public Customer getCustomer() {
        return iMatDataHandler.getCustomer();
    }

    public CreditCard getCreditCard(){
        return iMatDataHandler.getCreditCard();
    }

    public List<String> getCardTypes() {
        return cardTypes;
    }

    public List<String> getMonths(){
        return months;
    }

    public List<String> getYears(){
        return years;
    }

    // Shoppingcart funktion
    public ShoppingCart getShoppingCart(){
        return iMatDataHandler.getShoppingCart();
    }

    public void clearShoppingCart(){
        iMatDataHandler.getShoppingCart().clear();
    }

    public void placeOrder(){
        iMatDataHandler.placeOrder();
    }

    public int getNumberOfOrders() {

        return iMatDataHandler.getOrders().size();

    }

    // Save when program closes.
    public void shutDown(){
        iMatDataHandler.shutDown();
    }
}
