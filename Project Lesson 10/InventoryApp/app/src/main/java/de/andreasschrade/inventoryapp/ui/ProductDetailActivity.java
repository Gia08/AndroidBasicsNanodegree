package de.andreasschrade.inventoryapp.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import de.andreasschrade.inventoryapp.R;
import de.andreasschrade.inventoryapp.ui.base.BaseActivity;
import de.andreasschrade.inventoryapp.util.ProductDataHelper;

public class ProductDetailActivity extends BaseActivity {

    // Definition of the variables
    String productName;
    String productPrice;
    String productQuantity;
    String productEmail;
    String productUri;

    TextView productNameValue;
    TextView productPriceValue;
    TextView productQuantityValue;

    ImageView productImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        setupToolbar();

        productNameValue = (TextView) findViewById(R.id.textProductNameValue);
        productPriceValue = (TextView) findViewById(R.id.textPriceValue);
        productQuantityValue = (TextView) findViewById(R.id.textQuantityValue);

        productImage = (ImageView) findViewById(R.id.imageProduct);

        Intent myIntent = getIntent();
        productName = myIntent.getStringExtra("productName");
        productPrice = myIntent.getStringExtra("productPrice");
        productQuantity = myIntent.getStringExtra("productQuantity");
        productEmail = myIntent.getStringExtra("productEmail");
        productUri = myIntent.getStringExtra("productUri");

        productNameValue.setText(productName);
        productPriceValue.setText(productPrice);
        productQuantityValue.setText(productQuantity);

        // Set product image
        Uri imageUri = Uri.parse(productUri);
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
            productImage.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }



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

    // Buttons Functions
    public void removeProduct(final View v){
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Remove Product Alert!")
                .setMessage("Are you sure you want to remove this product?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ProductDataHelper productDataHelper = new ProductDataHelper(v.getContext());
                        productDataHelper.removeNewProduct(productName);
                        Toast.makeText(ProductDetailActivity.this, "Product removed!", Toast.LENGTH_LONG).show();

                        //Stop the activity
                        ProductDetailActivity.this.finish();
                        Intent intent = new Intent(v.getContext(), ListProductsActivity.class);
                        startActivity(intent);
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    public void modifyProductQuantity(View v){
        ProductDetailActivity.this.finish();
        Intent intent = new Intent(this, IncrementProductQuantity.class);
        intent.putExtra("productName", productName);
        startActivity(intent);
    }

    public void modifyProductPrice(View v){
        ProductDetailActivity.this.finish();
        Intent intent = new Intent(this, EditProductPriceActivity.class);
        intent.putExtra("productName", productName);
        startActivity(intent);
    }

    public void contactProductDistributor(View v){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",productEmail, null));
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

}
