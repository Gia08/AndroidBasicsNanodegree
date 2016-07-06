package de.andreasschrade.inventoryapp.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import de.andreasschrade.inventoryapp.R;
import de.andreasschrade.inventoryapp.ui.base.BaseActivity;
import de.andreasschrade.inventoryapp.util.Product;
import de.andreasschrade.inventoryapp.util.ProductDataHelper;

public class ListProductsActivity extends BaseActivity {

    List<Product> listProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);

        ListView listView = (ListView) findViewById(R.id.inventory_listView);

        ProductDataHelper productDataHelper = new ProductDataHelper(this);

        listProduct = productDataHelper.getInventoryInformation();
        if (listProduct.size() == 0) {
            Toast.makeText(ListProductsActivity.this, "Empty Inventory!", Toast.LENGTH_LONG).show();
        }

        MyListAdapter listAdapter = new MyListAdapter(listProduct);
        listAdapter.notifyDataSetChanged();
        listView.setAdapter(listAdapter);

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
    public boolean providesActivityToolbar() {
        return true;
    }
}
