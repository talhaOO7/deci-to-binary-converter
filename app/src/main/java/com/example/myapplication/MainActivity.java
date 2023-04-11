package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    public void convert(View view){
        String binary= "";


        ImageView arrow = findViewById(R.id.arrow);
        EditText decimalVal = findViewById(R.id.decimalinput);
        TextView output = findViewById(R.id.output);



        Button btn1 = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);

        if (decimalVal.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Please, Enter Something to Convert",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        int myNum = 0;

        try {
            myNum = Integer.parseInt(decimalVal.getText().toString());

        } catch(NumberFormatException nfe) {
            return;
        }
        decimalVal.setEnabled(false);
        btn1.setEnabled(false);
        btn2.setEnabled(true);
        arrow.animate().rotation(180).setDuration(500);

        while(myNum !=0){
            binary = String.valueOf(myNum%2) + binary;
            myNum = (int) Math.floor(myNum/2);
        }
        if (binary.length() >= 10) {
            output.setTextSize(16);
        } else {
            output.setTextSize(35);
        }
        output.setText(binary);

    }
    public void clear(View view){
        ImageView arrow = findViewById(R.id.arrow);
        EditText decimalVal = findViewById(R.id.decimalinput);
        TextView output = findViewById(R.id.output);

        Button btn1 = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);

        arrow.animate().rotation(0).setDuration(500);
        output.setText("0");
        decimalVal.setText("");

        decimalVal.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(false);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}