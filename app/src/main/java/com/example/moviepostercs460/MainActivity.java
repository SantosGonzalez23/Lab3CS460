package com.example.moviepostercs460;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PostersListener {

    private Button buttonAddToWatchlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView postersRecyclerView = findViewById(R.id.posterRecyclerView);
        buttonAddToWatchlist = findViewById(R.id.buttonAddToWatchlist);

        //prepare data

        List<Poster> posterList = new ArrayList<>();

        Poster ForestGump =new Poster();
        ForestGump.image = R.drawable.forestgump;
        ForestGump.name = "Forest Gump";
        ForestGump.createdBy = "Robert Zemeckis";
        ForestGump.rating = 5f;
        ForestGump.story = "A story about the life journey of a man during the 20th century";
        posterList.add(ForestGump);

        Poster Frozen =new Poster();
        Frozen.image = R.drawable.frozen;
        Frozen.name = "Frozen";
        Frozen.createdBy = "abc";
        Frozen.rating = 4f;
        Frozen.story = "A tale of sisterhood, self-discovery, and breaking free from fear and isolation.";
        posterList.add(Frozen);

        Poster GodFather =new Poster();
        GodFather.image = R.drawable.godfather;
        GodFather.name = "Godfather";
        GodFather.createdBy = "Francis Ford Cappola";
        GodFather.rating = 5f;
        GodFather.story = "A story about a mafia family navigating loyalty, betrayal, and power struggles.";
        posterList.add(GodFather);

        Poster LongestYard =new Poster();
        LongestYard.image = R.drawable.longestyard;
        LongestYard.name = "The Longest Yard";
        LongestYard.createdBy = "Peter Segal";
        LongestYard.rating = 3.5f;
        LongestYard.story = "A comedy-drama about inmates forming a football team to compete against their guards.";
        posterList.add(LongestYard);

        Poster PulpFiction =new Poster();
        PulpFiction.image = R.drawable.pulpfiction;
        PulpFiction.name = "Pulp Fiction";
        PulpFiction.createdBy = "Quentin Tarantino";
        PulpFiction.rating = 5f;
        PulpFiction.story = "A darkly humorous and violent exploration of interconnected lives in Los Angeles' underworld.";
        posterList.add(PulpFiction);

        Poster SPR =new Poster();
        SPR.image = R.drawable.savingprivateryan;
        SPR.name = "Saving Private Ryan";
        SPR.createdBy = "Steven Spielberg";
        SPR.rating = 5f;
        SPR.story = "A portrayal of World War II as a group of soldiers embark on a mission to save one man.";
        posterList.add(SPR);

        Poster SchindlersList =new Poster();
        SchindlersList.image = R.drawable.schindlerslist;
        SchindlersList.name = "Schindler's List";
        SchindlersList.createdBy = "Steven Spielberg";
        SchindlersList.rating = 5f;
        SchindlersList.story = "A haunting recording of the Holocaust, where one man's actions saved hundreds.";
        posterList.add(SchindlersList);

        Poster Shawshank =new Poster();
        Shawshank.image = R.drawable.shawshank;
        Shawshank.name = "The Shawshank Redemption";
        Shawshank.createdBy = "Frank Darabont";
        Shawshank.rating = 5f;
        Shawshank.story = "Prison drama about a banker who is wrongly convicted of murder.";
        posterList.add(Shawshank);

        Poster StarWars =new Poster();
        StarWars.image = R.drawable.starwars;
        StarWars.name = "Star Wars: The phantom Menace";
        StarWars.createdBy = "George Lucas";
        StarWars.rating = 4f;
        StarWars.story = "A story about two jedis who come across a young boy who may bring balance to the force.";
        posterList.add(StarWars);

        Poster Titanic =new Poster();
        Titanic.image = R.drawable.titanic;
        Titanic.name = "Titanic";
        Titanic.createdBy = "James Cameron";
        Titanic.rating = 4f;
        Titanic.story = "A romantic disaster film about the sinking of the RMS Titanic.";
        posterList.add(Titanic);


        final PosterAdapter posterAdapter = new PosterAdapter(posterList, this);
        postersRecyclerView.setAdapter(posterAdapter);

        buttonAddToWatchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Poster> selectPosters = posterAdapter.getSelectedPosters();

                StringBuilder posterNames = new StringBuilder();
                for(int i=0;i<selectPosters.size();i++){
                    if(i==0) {
                        posterNames.append(selectPosters.get(i).name);
                    } else{
                            posterNames.append("\n").append(selectPosters.get(i).name);
                    }
                }
                Toast.makeText(MainActivity.this, posterNames.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onPosterAction(Boolean isSelected) {
        if(isSelected){
            buttonAddToWatchlist.setVisibility(View.VISIBLE);
        }else{
            buttonAddToWatchlist.setVisibility(View.GONE);
        }
    }
}









