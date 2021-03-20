package com.ocsa.tutorialandroidgallery;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.File;

public class GalleryPreview extends AppCompatActivity {

    ImageView galleryPreview;
    String path;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_preview);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        path = intent.getStringExtra("path");
        galleryPreview = findViewById(R.id.GalleryPreviewTag);
        Glide.with(GalleryPreview.this).load(new File(path)).into(galleryPreview);
    }
}
