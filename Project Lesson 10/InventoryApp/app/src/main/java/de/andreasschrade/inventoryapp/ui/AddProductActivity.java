package de.andreasschrade.inventoryapp.ui;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import de.andreasschrade.inventoryapp.R;
import de.andreasschrade.inventoryapp.ui.base.BaseActivity;
import de.andreasschrade.inventoryapp.util.Product;
import de.andreasschrade.inventoryapp.util.ProductDataHelper;

public class AddProductActivity extends BaseActivity {

    // Definition of the variables
    EditText inputProductName;
    EditText inputProductQuantity;
    EditText inputProductPrice;
    EditText inputProductEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        // Initialization of the variables
        inputProductName = (EditText) findViewById(R.id.inputProductName);
        inputProductQuantity = (EditText) findViewById(R.id.inputProductQuantity);
        inputProductPrice = (EditText) findViewById(R.id.inputProductPrice);
        inputProductEmail = (EditText) findViewById(R.id.inputEmail);

        setupToolbar();
    }

    private void setupToolbar() {
        final ActionBar ab = getActionBarToolbar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                openDrawer();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return R.id.nav_add;
    }

    @Override
    public boolean providesActivityToolbar() {
        return true;
    }


    public void addProduct(View v){

        if (inputProductName.getText().toString().matches("") |
            inputProductQuantity.getText().toString().matches("") |
            inputProductEmail.getText().toString().matches("") |
            inputProductPrice.getText().toString().matches("")) {

            Toast.makeText(AddProductActivity.this, "Please fill all the information!", Toast.LENGTH_LONG).show();
        }
        else {
            ProductDataHelper productDataHelper = new ProductDataHelper(this);
            String productName = inputProductName.getText().toString();
            int productQuantity = Integer.parseInt(inputProductQuantity.getText().toString());
            String productPrice = inputProductPrice.getText().toString();
            String productEmail = inputProductEmail.getText().toString();
            productDataHelper.addNewProduct(new Product(productName, productQuantity, productPrice, productEmail));
            inputProductName.setText("");
            inputProductQuantity.setText("");
            inputProductPrice.setText("");
            inputProductEmail.setText("");
            Toast.makeText(AddProductActivity.this, "Product added!", Toast.LENGTH_LONG).show();
        }

    }
}
