package com.example.shoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.shoppingapp.Adapters.MainAdapterFemale;
import com.example.shoppingapp.Adapters.MainAdapterMale;
import com.example.shoppingapp.Models.MainModel;
import com.example.shoppingapp.databinding.ActivityMaleClothingBinding;

import java.util.ArrayList;

public class Male_clothing extends AppCompatActivity {

    ActivityMaleClothingBinding bindingM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingM = ActivityMaleClothingBinding.inflate(getLayoutInflater());
        setContentView(bindingM.getRoot());

        ArrayList<MainModel> listM = new ArrayList<>();

        listM.add(new MainModel(R.drawable.aa,"T-shirt","499","Click for details"));
        listM.add(new MainModel(R.drawable.bb,"Black highneck","599","Click for details"));
        listM.add(new MainModel(R.drawable.cc,"Formal Pants","899","Click for details"));
        listM.add(new MainModel(R.drawable.dd,"Supima covered neck","849","Click for details"));
        listM.add(new MainModel(R.drawable.ee,"Combo@2","800","Click for details"));
        listM.add(new MainModel(R.drawable.ff,"Casual cargo","749","Click for details"));
        listM.add(new MainModel(R.drawable.gg,"Sweatshirt check","555","Click for details"));
        listM.add(new MainModel(R.drawable.hh,"Superman sweatshirt","899","Click for details"));
        listM.add(new MainModel(R.drawable.ii,"Partywear pant ","949","Click for details"));
        listM.add(new MainModel(R.drawable.jj,"Pullover","500","Click for details"));
        listM.add(new MainModel(R.drawable.kk,"Formal black pant","784","Click for details"));
        listM.add(new MainModel(R.drawable.ll,"Striped T-shirt","349","Click for details"));
        listM.add(new MainModel(R.drawable.mm,"Full T-shirt","750","Click for details"));
        listM.add(new MainModel(R.drawable.nn,"RoundNeck Combo","899","Click for details"));
        listM.add(new MainModel(R.drawable.oo,"Joggers","584","Click for details"));
        listM.add(new MainModel(R.drawable.pp,"Striped sweatshirt","599","Click for details"));
        listM.add(new MainModel(R.drawable.qq,"Premium cloth shirt","949","Click for details"));
        listM.add(new MainModel(R.drawable.rr,"Formal trouser","750","Click for details"));
        listM.add(new MainModel(R.drawable.ss,"Cargo pants","666","Click for details"));
        listM.add(new MainModel(R.drawable.tt,"Hoodie","999","Click for details"));
        listM.add(new MainModel(R.drawable.uu,"T-shirt","699","Click for details"));
        listM.add(new MainModel(R.drawable.vv,"Trousers","777","Click for details"));
        listM.add(new MainModel(R.drawable.ww,"T-shirt","699","Click for details"));
        listM.add(new MainModel(R.drawable.xx,"Pullover shirt","649","Click for details"));
        listM.add(new MainModel(R.drawable.yy,"Aqua full shirt","700","Click for details"));

        MainAdapterMale adapterMale = new MainAdapterMale(listM,this);
        bindingM.recyclerViewM.setAdapter(adapterMale);

        LinearLayoutManager layoutManagerM = new LinearLayoutManager(this);
        bindingM.recyclerViewM.setLayoutManager(layoutManagerM);
     }

     @Override
     public boolean onCreateOptionsMenu(Menu menuM){
        getMenuInflater().inflate(R.menu.menu,menuM);
        return super.onCreateOptionsMenu(menuM);
     }

     @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem itemM){
        switch(itemM.getItemId()){
            case R.id.orders:
                startActivity(new Intent(Male_clothing.this,OrderActivity.class));
        }
     return super.onOptionsItemSelected(itemM);
     }
}