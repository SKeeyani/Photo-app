package org.mycode.photo_app;

import android.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;

public class AddPhotograph extends AppCompatActivity {

    private EditText photoNameTxt;
    private Spinner artistNameSpinner;
    private Spinner categorySpinner;
    private ImageView imageView;
    private Button addBtn;

    private DBHandler db;
    private ArrayList<Artist> artistList;
    private Bitmap image = null;
    
    private static final int READ_REQUEST_CODE = 42;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.add_photograph);

        db = new DBHandler(this); photoNameTxt = findViewById(R.id.photoNameTxt);
        artistNameSpinner = findViewById(R.id.artistNameSpinner);
        categorySpinner = findViewById(R.id.photoCatSpinner);
        imageView = findViewById(R.id.photoImageView);
        addBtn = findViewById(R.id.addPhotoBtn);
        //Load artists
        artistList = db.loadArtist();
        //extract artist names
        ArrayList<String> artistNameList = new ArrayList<>();
        for (Artist artist : artistList){
            artistNameList.add(artist.getName());

            Spinner spinner = (Spinner) findViewById(R.id.photoCatSpinner);
// Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.planets_array, layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
            spinner.setAdapter(adapter);
        }
        //set the artist name into spinnerData
        ArrayAdapter<String>artistNameAdaptor = new ArrayAdapter<>(this, layout.simple_list_item_1, artistNameList);
        artistNameSpinner.setAdapter(artistNameAdaptor);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadPhoto();
            }

            private void loadPhoto() {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);

                intent.setType("image/*");
                startActivityForResult(intent,READ_REQUEST_CODE);
            }
            protected void onActivityResult(int requestCode,int resultCode){

            }

            private void savePhotograph(){
                String photoName = photoNameTxt.getText().toString();

                int selectedArtistPosition = artistNameSpinner.getSelectedItemPosition();
            }
        });
    }
}
