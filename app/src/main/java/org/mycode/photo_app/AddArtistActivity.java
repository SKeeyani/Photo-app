package org.mycode.photo_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddArtistActivity  extends AppCompatActivity{
    private Button addArtistBtn;
    private EditText artistNameTxt;
    private DBHandler db;
    CheckBox checkBox1;
    String role;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_artist);

        db = new DBHandler(this);

        addArtistBtn = findViewById(R.id.addArtistBtn);
        artistNameTxt = findViewById(R.id.artistNameTxt);
        checkBox1 = findViewById(R.id.checkBox);


        addArtistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertArtist();
            }
            private void insertArtist() {
                String artistName = artistNameTxt.getText().toString();
                Artist artist = new Artist(-1,artistName);
                if (checkBox1.isChecked()){
                    role = "student";
                }else {
                    role = "Lecture";
                }

                String statusMessage = "";

                if (db.addArtist(artist)){
                    statusMessage = "Added";
                    checkBox1.setChecked(false);
                }else {
                    statusMessage = "not added";
                }
            }
        });

    }



    }