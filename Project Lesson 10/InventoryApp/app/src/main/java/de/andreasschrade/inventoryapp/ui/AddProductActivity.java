package de.andreasschrade.inventoryapp.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

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

    ImageView imageProduct;
    String productUri;

    private static int RESULT_LOAD_IMG = 100;
    String imagePicturePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        // Initialization of the variables
        inputProductName = (EditText) findViewById(R.id.inputProductName);
        inputProductQuantity = (EditText) findViewById(R.id.inputProductQuantity);
        inputProductPrice = (EditText) findViewById(R.id.inputProductPrice);
        inputProductEmail = (EditText) findViewById(R.id.inputEmail);

        imageProduct = (ImageView) findViewById(R.id.imageNewProduct);

        productUri = "";

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

        if (productUri.matches("")){
            Toast.makeText(AddProductActivity.this, "Please select an image for the new product!",
                    Toast.LENGTH_LONG).show();
        }
        else if (inputProductName.getText().toString().matches("") |
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
            productDataHelper.addNewProduct(new Product(productName, productQuantity, productPrice,
                                            productEmail, productUri));
            inputProductName.setText("");
            inputProductQuantity.setText("");
            inputProductPrice.setText("");
            inputProductEmail.setText("");
            imageProduct.setImageResource(android.R.color.transparent);
            Toast.makeText(AddProductActivity.this, "Product added!", Toast.LENGTH_LONG).show();
        }
    }

    public void addImageProduct(View v){
        Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, RESULT_LOAD_IMG);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);


        if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                && null != imageReturnedIntent) {
            if(resultCode == RESULT_OK){
                Uri selectedImage = imageReturnedIntent.getData();
                productUri = selectedImage.toString();

                InputStream imageStream = null;
                try {
                    imageStream = getContentResolver().openInputStream(selectedImage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Bitmap imageResult = BitmapFactory.decodeStream(imageStream);
                imageProduct.setImageBitmap(imageResult);
            }
        }
    }
}
