package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    EditText dollarText;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dollarText = findViewById(R.id.dollarText);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.dollarText.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(7,2)});
    }

    public void convertCurrency(View view){
        if(!binding.dollarText.getText().toString().equals("")){
            Float dollarValue = Float.valueOf(binding.dollarText.getText().toString());
            Float euroValue = dollarValue * 0.85F;
            binding.textView.setText(euroValue.toString());
        } else {
            binding.textView.setText(R.string.no_value_string);
        }
    }
}