package com.ocsa.androidhelloworld;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class NewsActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        boolean is_landscape = getApplicationContext().getResources().getBoolean(R.bool.is_landscape);
        if(is_landscape) {
            ArticleFragment articleFragment = (ArticleFragment) getSupportFragmentManager().findFragmentById(R.id.article_fragment);
            HeadlineFragment headlineFragment = (HeadlineFragment) getSupportFragmentManager().findFragmentById(R.id.headline_fragment);
            Button btnBerita = headlineFragment.getButtonBerita();
            Button btnBerita2 = headlineFragment.getButtonBerita2();
            btnBerita.setOnClickListener(v -> {
                articleFragment.setArticle(Berita.isi[0]);
            });
            btnBerita2.setOnClickListener(v -> {
                articleFragment.setArticle(Berita.isi[1]);
            });
        } else {
            HeadlineFragment headlineFragment = new HeadlineFragment();
            headlineFragment.setOnHeadlineButtonClickListener(() -> {
                ArticleFragment articleFragment = new ArticleFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.main, articleFragment);
                    ft.addToBackStack(null);
                    ft.commit();
                    getSupportFragmentManager().executePendingTransactions();
                    articleFragment.setArticle(Berita.isi[0]);
            });
            headlineFragment.setOnHeadlineButton2ClickListener(() -> {
                ArticleFragment articleFragment = new ArticleFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.main, articleFragment);
                ft.addToBackStack(null);
                ft.commit();
                getSupportFragmentManager().executePendingTransactions();
                articleFragment.setArticle(Berita.isi[1]);
            });
            getSupportFragmentManager().beginTransaction().add(R.id.main, headlineFragment).commit();
            getSupportFragmentManager().executePendingTransactions();

        }
    }
}