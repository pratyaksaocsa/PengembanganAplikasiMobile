package com.ocsa.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtViewNama;
    private EditText editTextNama;
    private Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtViewNama = findViewById(R.id.txtViewNama);
        editTextNama = findViewById(R.id.editTextNama);
        btnSimpan = findViewById(R.id.btnSimpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = editTextNama.getText().toString();
                txtViewNama.setText(nama);
            }
        });
    }
}