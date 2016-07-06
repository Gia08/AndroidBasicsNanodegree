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

public class EditProductPriceActivity extends BaseActivity {

    // Definition of the variables
    EditText inputProductName;
    EditText inputProductPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product_price);
        ButterKnife.bind(this);
        setupToolbar();

        // Initialization of the variables
        inputProductName = (EditText) findViewById(R.id.inputEditPriceName);
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
    protected int getSelfNavDrawerItem() {
        return R.id.nav_edit_price;
    }

    @Override
    public boolean providesActivityToolbar() {
        return true;
    }

    public void editProductPrice(View v){

        if (inputProductName.getText().toString().matches("") |
            inputProductPrice.getText().toString().matches("")  ) {

            Toast.makeText(EditProductPriceActivity.this, "Please fill all the information!", Toast.LENGTH_LONG).show();
        }
        else {
            ProductDataHelper productDataHelper = new ProductDataHelper(this);
            String productName = inputProductName.getText().toString();
            String productPrice = inputProductPrice.getText().toString();
            productDataHelper.modifyProductPrice(productName, productPrice);
            inputProductName.setText("");
            inputProductPrice.setText("");
            Toast.makeText(EditProductPriceActivity.this, "Product changed!", Toast.LENGTH_LONG).show();
        }

    }
}
