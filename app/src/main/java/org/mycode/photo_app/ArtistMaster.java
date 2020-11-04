package org.mycode.photo_app;

import android.provider.BaseColumns;

public class ArtistMaster {
    private ArtistMaster(){

    }

        /* Inner class that defines the table contents */
        public static class Photograph implements BaseColumns {
            public static final String TABLE_NAME = "photographdetails";
            public static final String COLUMN_1 = "photographName";
            public static final String COLUMN_2 = "artistID";
            public static final String COLUMN_3 = "photographCategory";
            public static final String COLUMN_4 = "image";
        }
    public static class Artist implements BaseColumns {
        public static final String TABLE_NAME = "artistDetails";
        public static final String COLUMN_1 = "artistName";
    }

}
