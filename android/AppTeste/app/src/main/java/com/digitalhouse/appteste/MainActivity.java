package com.digitalhouse.appteste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText pesoEditText;
    private EditText alturaEditText;
    private Button okButton;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesoEditText = findViewById(R.id.peso_edit_text_id);
        alturaEditText = findViewById(R.id.altura_edit_text_id);
        okButton = findViewById(R.id.ok_button_id);
        resultadoTextView = findViewById(R.id.resultado_text_view_id);

    }
}
