package com.example.prog5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText w, h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.calculateBMIbutton);
    }

    public void bmiClick(View view) {
        w = (EditText) findViewById(R.id.weightnumedittext);
        h = (EditText) findViewById(R.id.heightnumedittext);
        String weight = w.getText().toString();
        String height = h.getText().toString();
        if(weight.isEmpty() || height.isEmpty())
            Toast.makeText(getApplicationContext(), "Weight and/or Height cannot be blank!", Toast.LENGTH_LONG).show();
        else{
            boolean n_weight = true;
            boolean n_height = true;
            try {
                Integer num1 = Integer.parseInt(weight);
            } catch (NumberFormatException e) {
                n_weight = false;
            }
            try {
                Integer num2 = Integer.parseInt(height);
            } catch (NumberFormatException e) {
                n_height = false;
            }

            if(n_weight && n_height){
                bmi calc = new bmi(Integer.parseInt(weight), Integer.parseInt(height), true);
                String calcNum = calc.bmiCalculator();
                Toast.makeText(getApplicationContext(), calcNum, Toast.LENGTH_LONG).show();
            }
            else{
                if(n_weight)
                    Toast.makeText(getApplicationContext(), "Height must be a numeric value!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Weight must be a numeric value!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
