package de.andreasschrade.inventoryapp.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import de.andreasschrade.inventoryapp.R;
import de.andreasschrade.inventoryapp.ui.base.BaseActivity;
import de.andreasschrade.inventoryapp.util.Product;
import de.andreasschrade.inventoryapp.util.ProductDataHelper;

public class IncrementProductQuantity extends BaseActivity {

    // Definition of the variables
    EditText inputProductName;
    EditText inputProductQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_increment_product_quantity);
        ButterKnife.bind(this);
        setupToolbar();

        // Initialization of the variables
        inputProductName = (EditText) findViewById(R.id.inputIncrementProductName);
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
    protected int getSelfNavDrawerItem() {
        return R.id.nav_increment_quantity;
    }

    @Override
    public boolean providesActivityToolbar() {
        return true;
    }

    public void incrementProductQuantity(View v){

        if (inputProductName.getText().toString().matches("") |
            inputProductQuantity.getText().toString().matches("")) {

            Toast.makeText(IncrementProductQuantity.this, "Please fill all the information!", Toast.LENGTH_LONG).show();
        }
        else {
            ProductDataHelper productDataHelper = new ProductDataHelper(this);
            String productName = inputProductName.getText().toString();
            int productQuantity = Integer.parseInt(inputProductQuantity.getText().toString());
            productDataHelper.incrementProductQuantity(productName, productQuantity);
            inputProductName.setText("");
            inputProductQuantity.setText("");
            Toast.makeText(IncrementProductQuantity.this, "Product Quantity changed!", Toast.LENGTH_LONG).show();
        }

    }
}
