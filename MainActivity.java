package com.kanika.unitconverter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.kanika.unitconverter.R;

public class MainActivity extends AppCompatActivity {

    private EditText etInput;
    private Spinner spinnerUnits;
    private Button btnConvert;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        etInput = findViewById(R.id.etInput);
        spinnerUnits = findViewById(R.id.spinnerUnits);
        btnConvert = findViewById(R.id.btnConvert);
        tvResult = findViewById(R.id.tvResult);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnits();
            }
        });
    }

    private void convertUnits() {
        String selectedUnit = spinnerUnits.getSelectedItem().toString().trim();  // Define it first

        Log.d("UnitConverter", "Selected Unit: " + selectedUnit);  // Now it's defined
        Toast.makeText(this, "Selected: " + selectedUnit, Toast.LENGTH_SHORT).show();

        String input = etInput.getText().toString().trim();

        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
            return;
        }

        double value = Double.parseDouble(input);
        double result = 0.0;
        String resultText = "";

        switch (selectedUnit) {
            case "Centimeters to Meters":
                result = value / 100;
                resultText = value + " cm = " + result + " m";
                break;
            case "Meters to Centimeters":
                result = value * 100;
                resultText = value + " m = " + result + " cm";
                break;
            case "Grams to Kilograms":
                result = value / 1000;
                resultText = value + " g = " + result + " kg";
                break;
            case "Kilograms to Grams":
                result = value * 1000;
                resultText = value + " kg = " + result + " g";
                break;
            default:
                resultText = "Invalid conversion";
        }

        tvResult.setText("Result: " + resultText);
    }

}
