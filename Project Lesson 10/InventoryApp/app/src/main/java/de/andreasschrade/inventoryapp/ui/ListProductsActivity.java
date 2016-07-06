package de.andreasschrade.inventoryapp.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import de.andreasschrade.inventoryapp.R;
import de.andreasschrade.inventoryapp.ui.base.BaseActivity;
import de.andreasschrade.inventoryapp.util.Product;
import de.andreasschrade.inventoryapp.util.ProductDataHelper;

public class ListProductsActivity extends BaseActivity {

    List<Product> listProduct;
    TextView emptyIndicator;
    Context content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);

        setupToolbar();

        ListView listView = (ListView) findViewById(R.id.inventory_listView);
        emptyIndicator = (TextView) findViewById(R.id.textEmptyIndicator);

        content = this.getApplicationContext();

        ProductDataHelper productDataHelper = new ProductDataHelper(this);

        listProduct = productDataHelper.getInventoryInformation();
        if (listProduct.size() == 0) {
            emptyIndicator.setText("Empty Inventory!");
        }
        else{
            emptyIndicator.setText("");
        }

        MyListAdapter listAdapter = new MyListAdapter(listProduct);
        listView.setAdapter(listAdapter);
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

    @Override
    public void onBackPressed() {   }
}
