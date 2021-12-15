package com.example.shoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.shoppingapp.Adapters.MainAdapterFemale;
import com.example.shoppingapp.Models.MainModel;
import com.example.shoppingapp.databinding.ActivityFemaleClothingBinding;

import java.util.ArrayList;

public class Female_clothing extends AppCompatActivity {

    ActivityFemaleClothingBinding bindingF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingF = ActivityFemaleClothingBinding.inflate(getLayoutInflater());
        setContentView(bindingF.getRoot());

        ArrayList<MainModel> listF =  new ArrayList<>();

        listF.add(new MainModel(R.drawable.no,"Crop Top","369","Lymio\n" + "Crop Red Half"+ "Sleeves Top"));
        listF.add(new MainModel(R.drawable.a,"Frilled Sweater","599","Anytime fit"));
        listF.add(new MainModel(R.drawable.b,"Jacket","1066","Double sided Jacket"));
        listF.add(new MainModel(R.drawable.c,"Flat jeans","899","Retro fit jeans"));
        listF.add(new MainModel(R.drawable.d,"Printed Dress","769","Black printed casual\n"+"dress"));
        listF.add(new MainModel(R.drawable.e,"Tie Dye T-shirt","349","JUNEBERRY\n"+"Tie Dye T-Shirt for Women/Girls"));
        listF.add(new MainModel(R.drawable.f,"Denim jacket","999","All purpose denim jacket"));
        listF.add(new MainModel(R.drawable.g,"Long floral dress","679","Miril Long dress"));
        listF.add(new MainModel(R.drawable.h,"Fur jacket","1176","TDs Fur jacket"));
        listF.add(new MainModel(R.drawable.i,"Regular bottoms","299","299/pc regular bottoms"));
        listF.add(new MainModel(R.drawable.j,"Printed Rayon Top","349","DHRUVI TRENDZ\n" + "Women Printed Slub Rayon Top"));
        listF.add(new MainModel(R.drawable.k,"Satin dress","699","Bloom satin dress"));
        listF.add(new MainModel(R.drawable.l,"Leather Jacket","2899","Leather jacket with furry base"));
        listF.add(new MainModel(R.drawable.m,"Cotton Top","639","Floral Print\n"+"Top"));
        listF.add(new MainModel(R.drawable.n,"Joggers","499","Cotton joggers"));
        listF.add(new MainModel(R.drawable.o,"Lower SetOf2","599","Comfy Lower set of 2"));
        listF.add(new MainModel(R.drawable.p,"Women's Top","316","God Bless\n" + "Women's Top"));
        listF.add(new MainModel(R.drawable.q,"Regular Top","379","Lymio\n"+ "Women's Regular Top"));
        listF.add(new MainModel(R.drawable.r,"Long kurta dress","499","Nice wear Long Kurta"));
        listF.add(new MainModel(R.drawable.s,"Crop Top","599","Supima's collection"));
        listF.add(new MainModel(R.drawable.t,"Lycra Regular fit","599","Quarter sleeves Top"));
        listF.add(new MainModel(R.drawable.u,"Trousers","899","Roadster @2 trosers"));
        listF.add(new MainModel(R.drawable.v,"Toront blue Kurta","799","Toront sky blue kurta"));
        listF.add(new MainModel(R.drawable.w,"Shoulder style Top","349","Twiffy regular fit"));
        listF.add(new MainModel(R.drawable.x,"Half sleeve Jacket","899","Woodland Black Jacket7"));
        listF.add(new MainModel(R.drawable.y,"Salwar-suit set","899","GoSriki salwar-suit"));
        listF.add(new MainModel(R.drawable.z,"Midie","599","Denim short dress"));

        MainAdapterFemale adapterFemale = new MainAdapterFemale(listF,this);
        bindingF.recyclerViewF.setAdapter(adapterFemale);

        LinearLayoutManager layoutManagerF = new LinearLayoutManager(this);
        bindingF.recyclerViewF.setLayoutManager(layoutManagerF);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menuF){
        getMenuInflater().inflate(R.menu.menu,menuF);
        return super.onCreateOptionsMenu(menuF);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem itemF){
        switch(itemF.getItemId()){
            case R.id.orders:
                startActivity(new Intent(Female_clothing.this,OrderActivity.class));
        }
        return super.onOptionsItemSelected(itemF);
    }
}