package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ListView lvMovie;
    ArrayList<Movie> alMovieList;
    CustomAdapter caMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.listViewMovie);
        alMovieList = new ArrayList<>();

        Calendar date1 = Calendar.getInstance();
        date1.set(2014,11,15);

        Calendar date2 = Calendar.getInstance();
        date2.set(2015,5,15);

        Movie item1 = new Movie("The Avengers","2012","pg13","Action | Sci-Fi" ,date1 , "Golden Village - Bishan" , "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army." ,4);
        Movie item2 = new Movie("Planes","2013","pg" , "Animation | Comedy" , date2 , "Cathay - AMK Hub" , "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.",2);

        alMovieList.add(item1);
        alMovieList.add(item2);

        caMovie = new CustomAdapter(MainActivity.this,R.layout.row, alMovieList);

        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,SelectedMovie.class);
                intent.putExtra("Title",alMovieList.get(position).getTitle());
                intent.putExtra("Year",alMovieList.get(position).getYear());
                intent.putExtra("Rated",alMovieList.get(position).getRated());
                intent.putExtra("Genre",alMovieList.get(position).getGenre());
                intent.putExtra("Watched_on",alMovieList.get(position).getWatched_on().toString());
                intent.putExtra("In_theatre",alMovieList.get(position).getIn_theatre());
                intent.putExtra("Desc",alMovieList.get(position).getDescription());
                intent.putExtra("Rating",alMovieList.get(position).getRating());
                startActivity(intent);

            }
        });

    }
}
