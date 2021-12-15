package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.shoppingapp.databinding.ActivityPlaceOrderBinding;

public class PlaceOrder_Activity extends AppCompatActivity {


    ActivityPlaceOrderBinding placeOrderBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        placeOrderBinding = ActivityPlaceOrderBinding.inflate(getLayoutInflater());
        setContentView(placeOrderBinding.getRoot());

        DBHelper helper = new DBHelper(this);

        if(getIntent().getIntExtra("type",0) == 1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");

            placeOrderBinding.itemImage.setImageResource(image);
            placeOrderBinding.itemPrice.setText(String.format("%d", price));
            placeOrderBinding.itemName.setText(name);
            placeOrderBinding.detailDescription.setText(description);


            placeOrderBinding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean isInserted = helper.insertOrder(
                            placeOrderBinding.nameBox.getText().toString(),
                            placeOrderBinding.phoneBox.getText().toString(),
                            price,
                            image,
                            name,
                            description,
                            Integer.parseInt(placeOrderBinding.quantity.getText().toString())
                    );
                    if (isInserted)
                        Toast.makeText(PlaceOrder_Activity.this, "Data Success", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(PlaceOrder_Activity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            int id  = getIntent().getIntExtra("id",0);
            Cursor cursor =  helper.getOrderByid(id);
            final int image = cursor.getInt(4);

            placeOrderBinding.itemImage.setImageResource(cursor.getInt(4));
            placeOrderBinding.itemPrice.setText(String.format("%d", cursor.getInt(3)));
            placeOrderBinding.itemName.setText(cursor.getString(6));
            placeOrderBinding.detailDescription.setText(cursor.getString(5));

            placeOrderBinding.nameBox.setText(cursor.getString(1));
            placeOrderBinding.phoneBox.setText(cursor.getString(2));
            placeOrderBinding.insertBtn.setText("Update Now");
            placeOrderBinding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   boolean isUpdated =  helper.updateOrder(
                            placeOrderBinding.nameBox.getText().toString(),
                            placeOrderBinding.phoneBox.getText().toString(),
                            Integer.parseInt(placeOrderBinding.itemPrice.getText().toString()),
                            image,
                            placeOrderBinding.detailDescription.getText().toString(),
                            placeOrderBinding.itemName.getText().toString(),
                            1,
                            id
                    );
                   if(isUpdated)
                       Toast.makeText(PlaceOrder_Activity.this, "Updated", Toast.LENGTH_SHORT).show();
                   else
                       Toast.makeText(PlaceOrder_Activity.this,"Failed",Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}