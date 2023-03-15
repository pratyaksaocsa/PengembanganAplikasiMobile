package com.ocsa.tutorialandroid;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int READ_CONTACTS_PERMISSION = 2;
    private ActivityResultLauncher<Intent> activityResultLaunch;

    private Button showContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] PERMISSIONS = {Manifest.permission.READ_CONTACTS};
        if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)) {
            for (String permission : PERMISSIONS) {
                if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, PERMISSIONS, READ_CONTACTS_PERMISSION);
                }
            }
        }

        activityResultLaunch = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Uri selectedContactUri = result.getData().getData();
                    if(result.getResultCode() == RESULT_OK) {
                        final String[] projection = new String[] { ContactsContract.Contacts.DISPLAY_NAME };
                        Cursor cursor = getContentResolver().query(selectedContactUri,
                                projection, null, null, null);
                        if(cursor != null) {
                            if(cursor.moveToFirst()) {
                                int columnIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                                String name = cursor.getString(columnIndex);
                                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
                            }
                            cursor.close();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "User cancel", Toast.LENGTH_LONG).show();
                    }
                });

        showContact = findViewById(R.id.btnShowContact);
        showContact.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
            activityResultLaunch.launch(intent);
        });
    }
}