package com.example.meganoneill.newflicks.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meganoneill.newflicks.R;
import com.example.meganoneill.newflicks.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by meganoneill on 7/21/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie>{
    private static class ViewHolder {
        TextView title;
        TextView overview;
        ImageView image;
        int position;
    }

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);

        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.overview = (TextView) convertView.findViewById(R.id.tvOverview);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        convertView.setTag(viewHolder);

        viewHolder.title.setText(movie.getOriginalTitle());
        viewHolder.overview.setText(movie.getOverview());

        Picasso.with(getContext()).load(movie.getPosterPath()).into(viewHolder.image);

        return convertView;

    }
}
