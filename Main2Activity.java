/*
Kevin Nehrbauer and Chris Woolley
 */
package com.example.prog5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        if(getIntent().hasExtra("value")) {
            TextView advice = (TextView)findViewById(R.id.adviceText);
            ImageView image = (ImageView)findViewById(R.id.weightImage);
            String text = getIntent().getExtras().getString("value");
            Double bmiVal = Double.parseDouble(text);
            if(bmiVal < 18.5){
                advice.setText("Underweight");
                image.setImageResource(R.drawable.underweight);
            }else if((bmiVal >= 18.5) && (bmiVal < 25)){
                advice.setText("Normal");
                image.setImageResource(R.drawable.normal);
            } else if((bmiVal >= 25) && (bmiVal < 30)){
                advice.setText("Overweight");
                image.setImageResource(R.drawable.overweight);
            } else{
                advice.setText("Obese");
                image.setImageResource(R.drawable.obese);
            }
        }

        Button backBtn = (Button)findViewById(R.id.backButton);
        backBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });
    }



}
