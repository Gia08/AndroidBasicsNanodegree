package de.andreasschrade.inventoryapp.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.andreasschrade.inventoryapp.R;
import de.andreasschrade.inventoryapp.util.Product;
import de.andreasschrade.inventoryapp.util.ProductDataHelper;

/**
 * Created by Gia on 7/6/2016.
 */
public class MyListAdapter extends BaseAdapter {

    List<Product> listArray;

    public MyListAdapter(List<Product> listArray) {
        this.listArray = new ArrayList<Product>(listArray);
    }

    @Override
    public int getCount() {
    return listArray.size();
}

    @Override
    public Object getItem(int position) {
    return listArray.get(position);
}

    @Override
    public long getItemId(int position) {
    return position;
}

    @Override
    public View getView(int position, View convertView, final ViewGroup container) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(container.getContext());
            convertView = inflater.inflate(R.layout.include_product_item, container, false);
        }

        final Product product = listArray.get(position);


        final TextView productName = (TextView) convertView.findViewById(R.id.productName);
        productName.setText(product.getProductName());

        final TextView productAvailable = (TextView) convertView.findViewById(R.id.productAvailable);
        productAvailable.setText("" + product.getProductQuantity());

        final TextView productPrice = (TextView) convertView.findViewById(R.id.productPrice);
        productPrice.setText("$" + product.getProductPrice());

        Button btnSaleProduct = (Button) convertView.findViewById(R.id.listItemButton);

        this.notifyDataSetChanged();

        btnSaleProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProductDataHelper productDataHelper = new ProductDataHelper(view.getContext());
                if (product.getProductQuantity() == 0) {
                    Toast.makeText(container.getContext(), "No more stock of " + product.getProductName(), Toast.LENGTH_SHORT).show();
                }
                else {
                    productDataHelper.decrementProductQuantity(product.getProductName());
                    productAvailable.setText("" + product.getProductQuantity());
                    Toast.makeText(container.getContext(), "Quantity for " + product.getProductName() + " decremented", Toast.LENGTH_SHORT).show();
                }
                productAvailable.setText(""+ product.getProductQuantity());
                productDataHelper.close();
                Intent intent = new Intent(view.getContext(), ListProductsActivity.class);
                view.getContext().startActivity(intent);

            }
        });

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent details = new Intent(container.getContext(), ProductDetailActivity.class);
                String productQuantity = Integer.toString(product.getProductQuantity());
                details.putExtra("productName", product.getProductName());
                details.putExtra("productQuantity", productQuantity);
                details.putExtra("productPrice", product.getProductPrice());
                details.putExtra("productEmail", product.getProductEmail());
                container.getContext().startActivity(details);

            }
        });
    return convertView;
    }


}
