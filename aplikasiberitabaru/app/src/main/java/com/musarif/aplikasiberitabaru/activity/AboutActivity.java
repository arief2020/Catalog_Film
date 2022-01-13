package com.musarif.aplikasiberitabaru.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.musarif.aplikasiberitabaru.R;

public class AboutActivity extends AppCompatActivity {

    ImageView instagram, linkedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        instagram = findViewById(R.id.imgInstagram);
        linkedin = findViewById(R.id.imgLindedin);

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlInstagram = "https://www.instagram.com/m_syaifullah_al_arief/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlInstagram));
                startActivity(intent);
            }
        });

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlLinkedin = "https://www.linkedin.com/in/muhammad-syafullah-al-arief-214524151/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlLinkedin));
                startActivity(intent);
            }
        });

        if (getSupportActionBar()!= null){
            getSupportActionBar().setTitle("My Profile");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}