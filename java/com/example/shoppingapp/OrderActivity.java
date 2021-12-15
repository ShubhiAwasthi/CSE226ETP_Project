package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.shoppingapp.Adapters.OrderAdapter;
import com.example.shoppingapp.Models.OrdersModel;
import com.example.shoppingapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding bindingOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingOrder = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(bindingOrder.getRoot());

        DBHelper helper = new DBHelper(this);
        ArrayList<OrdersModel> list = helper.getOrders();


        OrderAdapter adapterOrder = new OrderAdapter(list,this);
        bindingOrder.orderRv.setAdapter(adapterOrder);

        LinearLayoutManager layoutManagerOrder = new LinearLayoutManager(this);
        bindingOrder.orderRv.setLayoutManager(layoutManagerOrder);
    }
}