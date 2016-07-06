package de.andreasschrade.inventoryapp.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gia on 7/6/2016.
 */
public class ProductDataHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "productInventory.db";
    Context context;

    public ProductDataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ProductDBContract.productTable.SQL_CREATE_ENTRY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ProductDBContract.productTable.SQL_DELETE_TABLE);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    // Add New Product to the Product Inventory Database
    public void addNewProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ProductDBContract.productTable.PRODUCT_NAME, product.getProductName());
        values.put(ProductDBContract.productTable.PRODUCT_QUANTITY, product.getProductQuantity());
        values.put(ProductDBContract.productTable.PRODUCT_PRICE, product.getProductPrice());
        values.put(ProductDBContract.productTable.PRODUCT_EMAIL, product.getProductEmail());
        db.insert(ProductDBContract.productTable.TABLE_NAME, null, values);
        db.close();
    }

    // Delete Product from the Product Inventory Database
    public void removeNewProduct(String productName) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(ProductDBContract.productTable.TABLE_NAME, ProductDBContract.productTable.PRODUCT_NAME + " = '" + productName + "'", null);
        sqLiteDatabase.close();
    }

    // Get Product Information
    public Cursor getProductInformation(String productName) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                ProductDBContract.productTable.TABLE_NAME,
                ProductDBContract.productTable.PRODUCT_COLUMNS,
                ProductDBContract.productTable.PRODUCT_NAME + " = ?",
                new String[]{productName}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        db.close();
        return cursor;
    }

    // Get All Products
    public List<Product> getInventoryInformation() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Product> listProducts = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + ProductDBContract.productTable.TABLE_NAME,null);
        if (cursor .moveToFirst()) {

            while (cursor.isAfterLast() == false) {
                Product product = new Product(cursor.getString(1),cursor.getInt(2),cursor.getString(3),cursor.getString(4));
                listProducts.add(product);
                Log.v("TEST",product.toString());
                cursor.moveToNext();
            }
        }
        db.close();
        return listProducts;
    }


    // Modify the product price
    public void modifyProductPrice(String productName, String productPrice) {
        Cursor cursor = getProductInformation(productName);
        if (cursor != null){
            Product product = new Product(cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getString(3));
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(ProductDBContract.productTable.PRODUCT_NAME, product.getProductName());
            values.put(ProductDBContract.productTable.PRODUCT_QUANTITY, product.getProductQuantity());
            values.put(ProductDBContract.productTable.PRODUCT_PRICE, productPrice);
            values.put(ProductDBContract.productTable.PRODUCT_EMAIL, product.getProductEmail());
            db.update(ProductDBContract.productTable.TABLE_NAME, values, ProductDBContract.productTable.PRODUCT_NAME + " = '" + productName + "'", null);
            db.close();
        }
    }

    // Increment Product Quantity
    public void incrementProductQuantity(String productName, int quantity) {
        Cursor cursor = getProductInformation(productName);
        Product product = new Product(cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4));
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        int totalQuantity = quantity + product.getProductQuantity();
        values.put(ProductDBContract.productTable.PRODUCT_NAME, product.getProductName());
        values.put(ProductDBContract.productTable.PRODUCT_QUANTITY,  + totalQuantity);
        values.put(ProductDBContract.productTable.PRODUCT_PRICE, product.getProductPrice());
        values.put(ProductDBContract.productTable.PRODUCT_EMAIL, product.getProductEmail());
        db.update(ProductDBContract.productTable.TABLE_NAME, values, ProductDBContract.productTable.PRODUCT_NAME + " = '" + productName + "'", null);
        db.close();
    }

    // Decrement Product Quantity
    public void decrementProductQuantity(String productName) {
        Cursor cursor = getProductInformation(productName);
        Product product = new Product(cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4));
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ProductDBContract.productTable.PRODUCT_NAME, product.getProductName());
        values.put(ProductDBContract.productTable.PRODUCT_QUANTITY, product.getProductQuantity() - 1);
        values.put(ProductDBContract.productTable.PRODUCT_PRICE, product.getProductPrice());
        values.put(ProductDBContract.productTable.PRODUCT_EMAIL, product.getProductEmail());
        db.update(ProductDBContract.productTable.TABLE_NAME, values, ProductDBContract.productTable.PRODUCT_NAME + " = '" + productName + "'", null);
        db.close();
    }

    // Delete all entries of the database
    public void deleteAllEntries(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ ProductDBContract.productTable.TABLE_NAME);
        db.close();
    }

    // Delete database
    public void deleteDatabase(){
        context.deleteDatabase(DATABASE_NAME);
    }
}
