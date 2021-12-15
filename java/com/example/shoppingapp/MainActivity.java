package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button maleActivity,femaleActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maleActivity = (Button) findViewById(R.id.maleActivity);
        maleActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vM) {
                openMaleActivity();
            }
        });

        femaleActivity = (Button) findViewById(R.id.femaleActivity);
        femaleActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vF) {
                openFemaleActivity();
            }
        });
    }
    public void openMaleActivity(){
        Intent intentMale = new Intent(this, Male_clothing.class);
        startActivity(intentMale);
    }

    public void openFemaleActivity(){
        Intent intentFemale = new Intent(this, Female_clothing.class);
        startActivity(intentFemale);
    }
}