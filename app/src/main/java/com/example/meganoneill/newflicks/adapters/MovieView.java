package com.example.meganoneill.newflicks.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meganoneill.newflicks.R;
import com.squareup.picasso.Picasso;

public class MovieView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_view);

        String title = getIntent().getStringExtra("title");
        String popularity = getIntent().getStringExtra("popularity");
        String overview = getIntent().getStringExtra("overview");
        String rating = getIntent().getStringExtra("rating");
        String date = getIntent().getStringExtra("date");
        String poster = getIntent().getStringExtra("poster");

        TextView t_title = (TextView) findViewById(R.id.textView);
        t_title.setText(title);

        TextView t_date = (TextView) findViewById(R.id.textView2);
        t_date.setText(date);

        TextView t_rating = (TextView) findViewById(R.id.textView3);
        t_rating.setText(rating);

        TextView t_overview = (TextView) findViewById(R.id.textView4);
        t_overview.setText(overview);

        Context context = this;
        ImageView image = (ImageView) findViewById(R.id.imageView);
        Picasso.with(context).load(poster).into(image);



    }
}
