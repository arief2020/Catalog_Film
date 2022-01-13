package com.musarif.aplikasiberitabaru.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.musarif.aplikasiberitabaru.R;
import com.musarif.aplikasiberitabaru.model.Result;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    String title, overview, image, rilisdate;
    Integer countvote;
    Double ratings;
    ImageView imageDetail;
    TextView tvTitle, tvDetail, tvreleaseDate, tvvoteCount, tvrating;
    Result result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        tvTitle = findViewById(R.id.tvDetailTitle);
        tvDetail = findViewById(R.id.tVDetailDeskription);
        imageDetail = findViewById(R.id.imgDetailMovie);
        tvreleaseDate = findViewById(R.id.tvReleaseDate);
        tvvoteCount = findViewById(R.id.tvVoteCount);
        tvrating = findViewById(R.id.tvRating);

        result = getIntent().getParcelableExtra(EXTRA_MOVIE);

        title = result.getOriginalTitle();
        overview = result.getOverview();
        image = result.getPosterPath();
        rilisdate = result.getReleaseDate();
        countvote = result.getVoteCount();
        ratings = result.getVoteAverage();
        String strCount = String.valueOf(countvote);
        String strRating = String.valueOf(ratings);

        tvTitle.setText(title);
        tvDetail.setText(overview);
        tvreleaseDate.setText(getString(R.string.tanggal_rilis) + rilisdate);
        tvvoteCount.setText(getString(R.string.vote)+strCount);
        tvrating.setText(getString(R.string.rating) + strRating);
        Glide.with(getApplicationContext()).
                load("https://image.tmdb.org/t/p/w185" + image).
                into(imageDetail);

        if (getSupportActionBar()!= null){
            getSupportActionBar().setTitle(title);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}