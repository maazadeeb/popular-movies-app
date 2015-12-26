package com.udacity.android.maaz.popularmovies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.udacity.android.maaz.popularmovies.R;
import com.udacity.android.maaz.popularmovies.model.MovieData;

import java.util.List;

public class DiscoverMovieAdapter extends ArrayAdapter<MovieData> {

    private static final String BASE_POSTER_URI = "http://image.tmdb.org/t/p/w185";

    public DiscoverMovieAdapter(Context context, List<MovieData> movieDataResults) {
        super(context, 0, movieDataResults);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MovieData movieData = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movie_item, parent, false);
        }

        ImageView movieView = (ImageView) convertView.findViewById(R.id.image_movie);
        String moviePosterUri = BASE_POSTER_URI + movieData.getPosterPath();

        Picasso.with(getContext()).load(moviePosterUri).into(movieView);

        return convertView;
    }
}
