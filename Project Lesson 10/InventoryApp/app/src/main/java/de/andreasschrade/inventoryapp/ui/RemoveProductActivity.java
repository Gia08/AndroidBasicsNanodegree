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

public class RemoveProductActivity extends BaseActivity {

    // Definition of the variables
    EditText inputRemoveProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_product);
        ButterKnife.bind(this);
        setupToolbar();

        // Initialization of the variables
        inputRemoveProduct = (EditText) findViewById(R.id.inputRemoveProductName);
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
        return R.id.nav_remove;
    }

    @Override
    public boolean providesActivityToolbar() {
        return true;
    }

    public void removeProduct(View v){
        if (inputRemoveProduct.getText().toString().matches("")) {
            Toast.makeText(RemoveProductActivity.this, "Please fill all the information!", Toast.LENGTH_LONG).show();
        }
        else{
            ProductDataHelper productDataHelper = new ProductDataHelper(this);
            String productName = inputRemoveProduct.getText().toString();
            productDataHelper.removeNewProduct(productName);
            inputRemoveProduct.setText("");
            Toast.makeText(RemoveProductActivity.this, "Product removed!", Toast.LENGTH_LONG).show();
        }
    }
}
