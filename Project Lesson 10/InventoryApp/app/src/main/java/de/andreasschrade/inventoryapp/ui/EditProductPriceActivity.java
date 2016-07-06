package de.andreasschrade.inventoryapp.ui;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import de.andreasschrade.inventoryapp.R;
import de.andreasschrade.inventoryapp.ui.base.BaseActivity;
import de.andreasschrade.inventoryapp.util.ProductDataHelper;

public class EditProductPriceActivity extends BaseActivity {

    // Definition of the variables
    EditText inputProductPrice;

    String productName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product_price);
        setupToolbar();

        Intent myIntent = getIntent();
        productName = myIntent.getStringExtra("productName");

        // Initialization of the variables
        inputProductPrice = (EditText) findViewById(R.id.inputEditPrice);
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
    public boolean providesActivityToolbar() {
        return true;
    }

    public void editProductPrice(View v){

        if (inputProductPrice.getText().toString().matches("")  ) {

            Toast.makeText(EditProductPriceActivity.this, "Please fill all the information!", Toast.LENGTH_LONG).show();
        }
        else {
            ProductDataHelper productDataHelper = new ProductDataHelper(this);
            String productPrice = inputProductPrice.getText().toString();
            productDataHelper.modifyProductPrice(productName, productPrice);
            inputProductPrice.setText("");
            Toast.makeText(EditProductPriceActivity.this, "Product changed!", Toast.LENGTH_LONG).show();

            EditProductPriceActivity.this.finish();
            Intent intent = new Intent(v.getContext(), ListProductsActivity.class);
            startActivity(intent);
        }

    }
}
