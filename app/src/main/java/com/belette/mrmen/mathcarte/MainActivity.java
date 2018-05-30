package com.belette.mrmen.mathcarte;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private String[] cartesNames = new String[]{
            "Fonctions généralités",
            "Nombres relatifs",
            "Résolution d'équations",
            "Théorème de Thalès",
            "Théorème de Pythagore",
            "Trigonométrie",
    };
    private String[] cartesFiles = new String[] {
            "fonctions.png",
            "relatifs.png",
            "equations.png",
            "thales.png",
            "pythagore.png",
            "trigonometrie.png"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, cartesNames);
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View view, int arg2,long itemID) {
                Intent mintent = new Intent(MainActivity.this, ImageActivity.class);
                Bundle mbundle = new Bundle();
                mbundle.putString("image", cartesFiles[arg2]);
                mintent.putExtras(mbundle);
                startActivity(mintent);
            }
        });
    }
}
