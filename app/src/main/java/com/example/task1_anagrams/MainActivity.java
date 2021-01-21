package com.example.task1_anagrams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextStringForReverse;
    private TextView textViewReversedText;
    private EditText editTextIgnoredCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextStringForReverse = findViewById(R.id.edit_text_string_for_reverse);
        editTextIgnoredCharacters = findViewById(R.id.edit_text_ignored_characters);
        textViewReversedText = findViewById(R.id.text_view_reversed_text);
        editTextStringForReverse.addTextChangedListener(textWatcher);
        editTextIgnoredCharacters.addTextChangedListener(textWatcher);
    }

    public final TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            textViewReversedText.setText(
                    Reverser.reverse(editTextStringForReverse.getText().toString(), editTextIgnoredCharacters.getText().toString()));
        }
    };
}