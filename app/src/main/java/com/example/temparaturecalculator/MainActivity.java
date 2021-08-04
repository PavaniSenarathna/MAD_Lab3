package com.example.temparaturecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_value;
    RadioButton btn_celcius;
    RadioButton btn_faranhite;
    Button btn_calculate;
    TextView tv_displayValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_value=findViewById(R.id.et_value);
        btn_celcius=findViewById(R.id.btn_celcius);
        btn_faranhite=findViewById(R.id.btn_faranhite);
        btn_calculate=findViewById(R.id.btn_calculate);
        tv_displayValue=findViewById(R.id.tv_displayValue);
    }

    @Override protected void onResume() {
        super.onResume();
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

        private void calculateAnswer(){
        Calculations calculations = new Calculations();
        String temperature_value = et_value.getText().toString();

        if(TextUtils.isEmpty(temperature_value)){
            Toast.makeText(this,"Please enter a temperature value",Toast.LENGTH_LONG).show();
        }
        else{
            Float temp=Float.parseFloat(temperature_value);
            if(btn_celcius.isChecked()){
                temp=calculations.convertCelciusToFahrenheit(temp);
            }
            else if(btn_faranhite.isChecked()){
                temp=calculations.convertFahrenheitToCelcius(temp);
            }
            else{
                Toast.makeText(this,"Select ome option to move forward!",Toast.LENGTH_LONG).show();
                temp=0.0f;
            }
            tv_displayValue.setText(new Float(temp).toString());
        }

    }
}