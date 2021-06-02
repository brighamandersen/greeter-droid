package com.brighamband.sayhellogreeter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nameText;
    private Button buttonSayHello;
    private TextView greeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find widgets
        nameText = findViewById(R.id.nameText);
        buttonSayHello = findViewById(R.id.buttonSayHello);
        greeting = findViewById(R.id.greeting);

        // Set defaults
        buttonSayHello.setEnabled(false);

        // Hook up widgets
        buttonSayHello.setOnClickListener(v -> onButtonClick());

        nameText.addTextChangedListener(textWatcher);
    }

    private void onButtonClick() {
        greeting.setText("Hello, " + nameText.getText().toString() + "!");
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            greeting.setText("");   // Reset greeting

            if (nameText.getText().toString().equals("")) {
                buttonSayHello.setEnabled(false);
            } else {
                buttonSayHello.setEnabled(true);
            }
        }
    };
}