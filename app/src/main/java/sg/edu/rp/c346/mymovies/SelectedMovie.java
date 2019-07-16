package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class SelectedMovie extends AppCompatActivity {
    ArrayList<Movie> alMovie;
    CustomAdapter caMovie;
    ListView lvMovie;
    Calendar cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_movie);

        lvMovie = findViewById(R.id.lvSelected);

        alMovie = new ArrayList<>();
        Intent intent = getIntent();
        cal = Calendar.getInstance();
        try {
            cal.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(intent.getStringExtra("watched_on")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        alMovie.add(new Movie(intent.getStringExtra("title"),intent.getStringExtra("year"),intent.getStringExtra("rated"),intent.getStringExtra("genre"),cal,intent.getStringExtra("in_theatre"),intent.getStringExtra("desc"),intent.getIntExtra("rating",0)));

        caMovie = new CustomAdapter(this,R.layout.row_selected,alMovie);
        lvMovie.setAdapter(caMovie);
    }
}
