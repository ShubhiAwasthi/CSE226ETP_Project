package com.example.shoppingapp.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingapp.DBHelper;
import com.example.shoppingapp.Models.OrdersModel;
import com.example.shoppingapp.PlaceOrder_Activity;
import com.example.shoppingapp.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder>{

    ArrayList<OrdersModel> list;
    Context context;

    public OrderAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final OrdersModel model = list.get(position);
        holder.product_image.setImageResource(model.getProduct_image());
        holder.product_name.setText(model.getProduct_name());
        holder.product_price.setText(model.getProduct_price());
        holder.order_number.setText(model.getOrder_number());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlaceOrder_Activity.class);
                intent.putExtra("id",Integer.parseInt(model.getOrder_number()));
                intent.putExtra("type",2);
                context.startActivity(intent);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Delete Item")
                        .setMessage("Are you sure to delete this item ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DBHelper helper = new DBHelper(context);
                                if(helper.deleteOrder(model.getOrder_number()) > 0){
                                    Toast.makeText(context, "Delete", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class viewHolder  extends RecyclerView.ViewHolder{
        ImageView product_image;
        TextView order_number,product_name,product_price;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            product_image = itemView.findViewById(R.id.product_image);
            product_name = itemView.findViewById(R.id.product_name);
            product_price = itemView.findViewById(R.id.product_price);
            order_number = itemView.findViewById(R.id.order_number);
        }
    }
}
