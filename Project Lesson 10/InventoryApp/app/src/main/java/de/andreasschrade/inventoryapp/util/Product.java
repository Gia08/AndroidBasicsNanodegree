package de.andreasschrade.inventoryapp.util;

/**
 * Created by Gia on 7/6/2016.
 */
public class Product {

    private String productID;
    private String productName;
    private int productQuantity;
    private String productPrice;
    private String productEmail;
    private String productUri;

    public Product(){

    }

    public Product(String productName, int productQuantity, String productPrice, String productEmail,
                   String productUri){
        this.setProductName(productName);
        this.setProductQuantity(productQuantity);
        this.setProductPrice(productPrice);
        this.setProductEmail(productEmail);
        this.setProductUri(productUri);
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductEmail() {
        return productEmail;
    }

    public void setProductEmail(String productEmail) {
        this.productEmail = productEmail;
    }

    public String getProductUri() {  return productUri;  }

    public void setProductUri(String productUri) {  this.productUri = productUri; }

    @Override
    public String toString() {
        String outResult = "";
        outResult = outResult + "Product Name: " + getProductName() + "\n";
        outResult = outResult + "Product Quantity: " + getProductQuantity() + "\n";
        outResult = outResult + "Product Price: " + getProductPrice() + "\n";
        outResult = outResult + "Product Email: " + getProductEmail() + "\n";
        return outResult;
    }

}
