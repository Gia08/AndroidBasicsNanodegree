package de.andreasschrade.inventoryapp.util;

import android.provider.BaseColumns;

/**
 * Created by Gia on 7/6/2016.
 */
public class ProductDBContract {

    public ProductDBContract(){}

    public static abstract class productTable implements BaseColumns {
        public static final String TABLE_NAME = "productInventory";
        public static final String PRODUCT_NAME = "productName";
        public static final String PRODUCT_QUANTITY = "productQuantity";
        public static final String PRODUCT_PRICE= "productPrice";
        public static final String PRODUCT_EMAIL= "productEmail";
        public static final String PRODUCT_URI= "productUri";

        private static final String TEXT_TYPE = " TEXT NOT NULL";
        private static final String INTEGER_TYPE = " INTEGER DEFAULT 0";
        private static final String COMMA_SEP = ",";

        static final String[] PRODUCT_COLUMNS = {
                _ID,
                PRODUCT_NAME,
                PRODUCT_QUANTITY,
                PRODUCT_PRICE,
                PRODUCT_EMAIL,
                PRODUCT_URI
        };


        // Set the create sentence
        public static final String SQL_CREATE_ENTRY=
                "CREATE TABLE " + productTable.TABLE_NAME + " (" +
                        productTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        productTable.PRODUCT_NAME + TEXT_TYPE + COMMA_SEP +
                        productTable.PRODUCT_QUANTITY + INTEGER_TYPE + COMMA_SEP +
                        productTable.PRODUCT_PRICE +  TEXT_TYPE + COMMA_SEP +
                        productTable.PRODUCT_EMAIL +  TEXT_TYPE + COMMA_SEP +
                        productTable.PRODUCT_URI +  TEXT_TYPE + " )";

        // Set the drop table sentence
        public static final String SQL_DELETE_TABLE =
                "DROP TABLE IF EXISTS " + productTable.TABLE_NAME;

    }
}
