package com.example.terrierexchange;

import android.database.sqlite.SQLiteOpenHelper;

import io.grpc.Context;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mylist.db";
    public static final String TABLE_NAME = "mylist_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "ITEM1";

    public DatabaseHelper(Context context) {super(context,DATABASE_NAME, null, 1);}
}
