package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(Context context , int resource , ArrayList<Movie> objects){
        super(context, resource , objects);

        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View rowView = inflater.inflate(layout_id, parent, false);

        ImageView ivMovie = rowView.findViewById(R.id.imageViewRated);
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvGenre = rowView.findViewById(R.id.textViewGenre);



        Movie currentMovie = movieList.get(position);

        tvTitle.setText(currentMovie.getTitle());
        tvYear.setText(currentMovie.getYear() + " - ");
        tvGenre.setText(currentMovie.getGenre());

        if(currentMovie.getRated().equalsIgnoreCase("g")) {
            ivMovie.setImageResource(R.drawable.rating_g);
        }
        else if(currentMovie.getRated().equalsIgnoreCase("pg")){
            ivMovie.setImageResource(R.drawable.rating_pg);
        }
        else if(currentMovie.getRated().equalsIgnoreCase("pg13")){
            ivMovie.setImageResource(R.drawable.rating_pg13);
        }
        else if(currentMovie.getRated().equalsIgnoreCase("nc16")){
            ivMovie.setImageResource(R.drawable.rating_nc16);
        }
        else if(currentMovie.getRated().equalsIgnoreCase("m18")){
            ivMovie.setImageResource(R.drawable.rating_m18);
        }
        else{
            ivMovie.setImageResource(R.drawable.rating_r21);
        }
        //remove
        try{
            TextView tvWatched = rowView.findViewById(R.id.tvWatched);
            TextView tvTheatre = rowView.findViewById(R.id.tvTheatre);
            TextView tvDesc = rowView.findViewById(R.id.tvDesc);
            RatingBar rb =rowView.findViewById(R.id.ratingBar);
            tvDesc.setText("\n" + currentMovie.getDescription());
            tvWatched.setText("\nWatched on : " + new SimpleDateFormat("dd/MM/yyyy").format(currentMovie.getWatched_on().getTime()));
            tvTheatre.setText("In Theatre : " + currentMovie.getIn_theatre());
            rb.setRating(currentMovie.getRating());


        }
        catch(NullPointerException e) {

        }








        return rowView;
    }
}
