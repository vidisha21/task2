package com.example.unitconvertertask1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextValue;
    private TextView textViewResult;
    private Button buttonConvert;
    private RadioGroup radioGroupConversion;
    private RadioButton radioButtonCelsiusToFahrenheit;
    private RadioButton radioButtonFahrenheitToCelsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValue = findViewById(R.id.editTextValue);
        textViewResult = findViewById(R.id.textViewResult);
        buttonConvert = findViewById(R.id.buttonConvert);
        radioGroupConversion = findViewById(R.id.radioGroupConversion);
        radioButtonCelsiusToFahrenheit = findViewById(R.id.radioButtonCelsiusToFahrenheit);
        radioButtonFahrenheitToCelsius = findViewById(R.id.radioButtonFahrenheitToCelsius);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        String valueStr = editTextValue.getText().toString().trim();
        if (!valueStr.isEmpty()) {
            double inputValue = Double.parseDouble(valueStr);
            double result;

            if (radioGroupConversion.getCheckedRadioButtonId() == radioButtonCelsiusToFahrenheit.getId()) {
                // Convert Celsius to Fahrenheit
                result = (inputValue * 9 / 5) + 32;
                textViewResult.setText("Result: " + String.format("%.2f", result) + " °F");
            } else if (radioGroupConversion.getCheckedRadioButtonId() == radioButtonFahrenheitToCelsius.getId()) {
                // Convert Fahrenheit to Celsius
                result = (inputValue - 32) * 5 / 9;
                textViewResult.setText("Result: " + String.format("%.2f", result) + " °C");
            } else {
                // User didn't select any conversion option
                textViewResult.setText("Select a conversion option.");
            }
        } else {
            textViewResult.setText("Enter a value.");
        }
    }
}
