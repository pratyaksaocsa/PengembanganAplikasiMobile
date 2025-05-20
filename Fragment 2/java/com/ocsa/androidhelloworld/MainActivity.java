package com.ocsa.androidhelloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.username = findViewById(R.id.username);
        this.password = findViewById(R.id.password);
        this.btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                if(usernameValue.equals("admin") && passwordValue.equals("admin")) {
                    Toast.makeText(MainActivity.this,
                            "Login berhasil!",
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, TestActivity.class);
                    int[] data = {1, 2, 3};
                    intent.putExtra("username", usernameValue);
                    intent.putExtra("password", passwordValue);
                    intent.putExtra("data", data);

                    startActivity(intent);
                    finish();
                } else if (usernameValue.equals("") && passwordValue.equals("")) {
                    Toast.makeText(MainActivity.this,"Username dan password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Login gagal!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}