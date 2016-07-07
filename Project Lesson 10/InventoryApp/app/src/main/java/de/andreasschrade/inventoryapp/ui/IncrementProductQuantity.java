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

public class IncrementProductQuantity extends BaseActivity {

    // Definition of the variables
    EditText inputProductQuantity;
    String productName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_increment_product_quantity);
        setupToolbar();

        Intent myIntent = getIntent();
        productName = myIntent.getStringExtra("productName");

        // Initialization of the variables
        inputProductQuantity = (EditText) findViewById(R.id.inputIncrementQuantity);
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

    public void incrementProductQuantity(View v){

        if (inputProductQuantity.getText().toString().matches("")) {

            Toast.makeText(IncrementProductQuantity.this, "Please fill all the information!", Toast.LENGTH_LONG).show();
        }
        else {
            ProductDataHelper productDataHelper = new ProductDataHelper(this);
            int productQuantity = Integer.parseInt(inputProductQuantity.getText().toString());
            productDataHelper.incrementProductQuantity(productName, productQuantity);
            inputProductQuantity.setText("");
            Toast.makeText(IncrementProductQuantity.this, "Product Quantity changed!", Toast.LENGTH_LONG).show();

            IncrementProductQuantity.this.finish();
            Intent intent = new Intent(v.getContext(), ListProductsActivity.class);
            startActivity(intent);
        }

    }
}
