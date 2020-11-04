package org.mycode.photo_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "addinfor.db";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES_ARTIST);
        db.execSQL(SQL_CREATE_ENTRIES_PHOTOGRAPHER);

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over

    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    private static final String SQL_CREATE_ENTRIES_PHOTOGRAPHER =
            "CREATE TABLE " + ArtistMaster.Photograph.TABLE_NAME + " (" +
                    ArtistMaster.Photograph._ID + " INTEGER PRIMARY KEY," +
                    ArtistMaster.Photograph.COLUMN_1 + " TEXT," +
                    ArtistMaster.Photograph.COLUMN_2 + " INTEGER,"+
                    ArtistMaster.Photograph.COLUMN_3 + " TEXT,"+
                    ArtistMaster.Photograph.COLUMN_4 + " BLOB)";

    private static final String SQL_CREATE_ENTRIES_ARTIST =
            "CREATE TABLE " + ArtistMaster.Artist.TABLE_NAME + " (" +
                    ArtistMaster.Artist._ID + " INTEGER PRIMARY KEY," +
                    ArtistMaster.Artist.COLUMN_1 + " TEXT)";


    public ArrayList<Artist> loadArtist() {
        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                ArtistMaster.Artist.COLUMN_1,
        };

// Filter results WHERE "title" = 'My Title'
        String selection = ArtistMaster.Artist.COLUMN_1+ " = ?";
        String[] selectionArgs = { "My Title" };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                ArtistMaster.Artist.COLUMN_1 + " DESC";

        Cursor cursor = db.query(
                ArtistMaster.Artist.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
        List artistIds = new ArrayList<>();
        List artistname = new ArrayList<>();
        while(cursor.moveToNext()) {
            long artistId = cursor.getLong(cursor.getColumnIndexOrThrow(ArtistMaster.Artist._ID));
            long artis = cursor.getLong(cursor.getColumnIndexOrThrow(ArtistMaster.Artist._ID));
            artistIds.add(artistId);
            artistname.add(artis);
        }
        cursor.close();
        return (ArrayList<Artist>) artistname;
    }

    public boolean addArtist(Artist artist) {

        return false;
    }
}