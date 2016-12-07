package pt.isec.a21240085.popoiuc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by francisco on 28-11-2016.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "popoIuc.db";
    public static final String TABLE_NAME = "CARRO";
    public static final String COLUMN_NAME = "ANO";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }

    public Cursor getMarcas(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res=db.rawQuery("Select * from MARCA",null);
        return res;
    }
    public Cursor getMotor(){
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor res=db.rawQuery("Select * from MOTOR",null);
        return res;
    }
    public Cursor getModelo(){
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor res=db.rawQuery("Select * from MODELO",null);
        return res;
    }
    public Cursor getCarro(){
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor res=db.rawQuery("Select * from CARRO",null);
        return res;
    }
    public ArrayList<String> getAllCotacts() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Carro", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}
