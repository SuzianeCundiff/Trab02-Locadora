package br.edu.icomp.trab02_locadora.connection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "PlainText.db";
    private static final String SQL_CREATE_PASS = "CREATE TABLE passwords (";
    private static final String SQL_POPULATE_PASS = "INSERT INTO passwords (";
    private static final String SQL_DELETE_PASS = "DROP TABLE IF EXISTS passwords";

    private static SQLiteDatabase instance;

    public SQLiteDatabase getInstance(){
        return instance;
    }

    public BancoDeDados(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        instance = getWritableDatabase();
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_PASS);
        db.execSQL(SQL_POPULATE_PASS);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_PASS);
        onCreate(db);
    }
}
