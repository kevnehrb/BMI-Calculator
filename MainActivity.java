package com.example.prog5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton rbImperial, rbMetric;
    Button btn;
    EditText w, h;
    boolean english;
    boolean adviceViable = false;
    String calcNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.calculateBMIbutton);
        rbImperial = findViewById(R.id.imperialRadioButton);
        rbMetric = findViewById(R.id.metricRadioButton);
        Button secondActivityBtn = (Button)findViewById(R.id.advicebutton);
        secondActivityBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(adviceViable){
                    Intent startIntent = new Intent(getApplicationContext(), Main2Activity.class);
                    startIntent.putExtra("value", calcNum);
                    startActivity(startIntent);
                }else{
                    Toast.makeText(getApplicationContext(), "You must first calculate your BMI before getting advice.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void closeKeyBoard(){
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void rbClicked(View view){
        boolean isSelected = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.imperialRadioButton:
                if(isSelected){
                    w = (EditText) findViewById(R.id.weightnumedittext);
                    h = (EditText) findViewById(R.id.heightnumedittext);
                    w.setHint("Enter weight in pounds");
                    h.setHint("Enter height in inches");
                }
                break;
            case R.id.metricRadioButton:
                if(isSelected){
                    w = (EditText) findViewById(R.id.weightnumedittext);
                    h = (EditText) findViewById(R.id.heightnumedittext);
                    w.setHint("Enter weight in kilograms");
                    h.setHint("Enter height in meters");
                }
                break;
        }
        closeKeyBoard();
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
                Double num1 = Double.parseDouble(weight);
            } catch (NumberFormatException e) {
                n_weight = false;
            }

            try {
                Double num2 = Double.parseDouble(height);
            } catch (NumberFormatException e) {
                n_height = false;
            }

            if(n_weight && n_height){
                if(rbMetric.isChecked()) {
                    english = false;
                    bmi calc = new bmi(Double.parseDouble(weight), Double.parseDouble(height), english);
                    calcNum = calc.bmiCalculator();
                    TextView t = (TextView) findViewById(R.id.result);
                    t.setText(calcNum);
                    adviceViable = true;
                }
                else if(rbImperial.isChecked()){
                    english = true;
                    bmi calc = new bmi(Double.parseDouble(weight), Double.parseDouble(height), english);
                    calcNum = calc.bmiCalculator();
                    TextView t = (TextView) findViewById(R.id.result);
                    t.setText(calcNum);
                    adviceViable = true;
                }
                else
                    Toast.makeText(getApplicationContext(), "You must select either Imperial or Metric", Toast.LENGTH_LONG).show();
            }
            else{
                if(n_weight)
                    Toast.makeText(getApplicationContext(), "Height must be a numeric value!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Weight must be a numeric value!", Toast.LENGTH_LONG).show();
            }
            closeKeyBoard();
        }
    }
}
