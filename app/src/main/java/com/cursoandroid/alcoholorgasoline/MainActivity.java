package com.cursoandroid.alcoholorgasoline;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText editAlcoholPrice, editGasPrice;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcoholPrice = findViewById(R.id.alcoholPrice);
        editGasPrice = findViewById(R.id.gasPrice);
        textResult = findViewById(R.id.result);
    }

    public void calculatePrice(View view) {
        String priceAlcohol = editAlcoholPrice.getText().toString();
        String priceGas = editGasPrice.getText().toString();

        Boolean validatedFields = validateFields(priceAlcohol, priceGas);

        if (validatedFields) {
            Double valueAlcohol = Double.parseDouble(priceAlcohol);
            Double valueGas = Double.parseDouble(priceGas);

            Double result = valueAlcohol / valueGas;

            if (result >= 0.7) {
                textResult.setText("You better use gas");
            } else {
                textResult.setText("You better use alcohol");
            }
        } else {
            textResult.setText("Fill in the prices first!");
        }
    }

    private Boolean validateFields(String priceAlcohol, String priceGas) {
        Boolean validatedFields = true;

        if (priceAlcohol == null || priceAlcohol.equals("")) {
            validatedFields = false;
        } else if (priceGas == null || priceGas.equals("")) {
            validatedFields = false;
        }
        return validatedFields;
    }
}
