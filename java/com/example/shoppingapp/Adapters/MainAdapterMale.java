package com.example.shoppingapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingapp.Models.MainModel;
import com.example.shoppingapp.PlaceOrder_Activity;
import com.example.shoppingapp.R;

import java.util.ArrayList;

public class MainAdapterMale extends RecyclerView.Adapter<MainAdapterMale.viewholderM> {

    ArrayList<MainModel> listM;
    Context contextM;

    public MainAdapterMale(ArrayList<MainModel> listM, Context contextM){
        this.listM = listM;
        this.contextM = contextM;
    }

    @NonNull
    @Override
    public viewholderM onCreateViewHolder(@NonNull ViewGroup parentM, int viewTypeM) {
        View viewM = LayoutInflater.from(contextM).inflate(R.layout.sample_products_male,parentM,false);
        return new viewholderM(viewM);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholderM holderM, int positionM) {

        final MainModel model = listM.get(positionM);
        holderM.productImageM.setImageResource(model.getImage());
        holderM.mainNameM.setText(model.getName());
        holderM.priceM.setText(model.getPrice());
        holderM.descriptionM.setText(model.getDescription());

        holderM.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewM) {
                Intent intentM = new Intent(contextM, PlaceOrder_Activity.class);
                intentM.putExtra("image",model.getImage());
                intentM.putExtra("price",model.getPrice());
                intentM.putExtra("desc",model.getDescription());
                intentM.putExtra("name",model.getName());
                intentM.putExtra("type",1);
                contextM.startActivity(intentM);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listM.size();
    }

    public class viewholderM extends RecyclerView.ViewHolder {

        ImageView productImageM;
        TextView mainNameM,priceM,descriptionM;
        public viewholderM(@NonNull View itemViewM) {
            super(itemViewM);

            productImageM = itemViewM.findViewById(R.id.imageViewM);
            mainNameM= itemViewM.findViewById(R.id.p_nameM);
            priceM = itemViewM.findViewById(R.id.priceM);
            descriptionM = itemViewM.findViewById(R.id.descriptionM);
        }
    }
}
