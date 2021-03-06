package com.example.meganoneill.newflicks.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by meganoneill on 7/20/16.
 */
public class Movie {
    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getLandPath(){  return String.format("https://image.tmdb.org/t/p/w780/%s", landPath);
    }

    String posterPath;
    String originalTitle;
    String overview;
    String landPath;
    String release;
    String avgRating;
    String popularity;

    public String getAvgRating() {
        return avgRating;
    }

    public String getRelease() {
        return release;
    }

    public String getPopularity() {
        return popularity;
    }

    public Movie(JSONObject jsonObject) throws JSONException{
        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.landPath = jsonObject.getString("backdrop_path");
        this.release = jsonObject.getString("release_date");
        this.avgRating = jsonObject.getString("vote_average");
        this.popularity = jsonObject.getString("popularity");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array){
        ArrayList<Movie> results = new ArrayList<>();

        for(int x = 0; x < array.length(); x++){
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return results;
    }
}
