package com.ocsa.helloworldapi;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView txtFirstName, txtLastName, txtUniversity, txtAveragePrice;
    private Button btnGetUsers, btnGetProducts;

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

        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        txtUniversity = findViewById(R.id.txtUniversity);
        btnGetUsers = findViewById(R.id.btnGetUsers);
        btnGetUsers.setOnClickListener(view -> {
            APIInterface apiInterface = RetrofitClient.getApiService();
            Call<UserResponse> call = apiInterface.getAllUsers();
            call.enqueue(new Callback<>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        UserResponse userResponse = response.body();
                        List<User> users = userResponse.getUsers();
                        txtFirstName.setText(users.get(1).getFirstName());
                        txtLastName.setText(users.get(1).getLastName());
                        txtUniversity.setText(users.get(1).getUniversity());
                    }
                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {
                    Log.e("MainActivity", "Error fetching data: "+t.getMessage());
                    Toast.makeText(MainActivity.this,
                            "Failed to fetch data: " + t.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}