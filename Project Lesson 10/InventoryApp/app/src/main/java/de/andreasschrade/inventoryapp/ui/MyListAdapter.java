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

    private static final String TAG = MyListAdapter.class.getSimpleName();
    List<Product> listArray;
    int newQuantity;

    public MyListAdapter(List<Product> listArray) {
        this.listArray = new ArrayList<Product>(listArray);
        newQuantity= 0;
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

        Button button = (Button) convertView.findViewById(R.id.listItemButton);

        this.notifyDataSetChanged();

        newQuantity = product.getProductQuantity();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProductDataHelper productDataHelper = new ProductDataHelper(view.getContext());
                if (newQuantity == 0) {
                    Toast.makeText(container.getContext(), "No more stock of " + product.getProductName(), Toast.LENGTH_SHORT).show();
                }
                else {
                    productDataHelper.decrementProductQuantity(product.getProductName());
                    newQuantity = newQuantity - 1;
                    productAvailable.setText("" + newQuantity);
                    Toast.makeText(container.getContext(), "Quantity for " + product.getProductName() + " decremented", Toast.LENGTH_SHORT).show();
                }
                productAvailable.setText(""+newQuantity);
                productDataHelper.close();

            }
        });
    return convertView;
    }

}
