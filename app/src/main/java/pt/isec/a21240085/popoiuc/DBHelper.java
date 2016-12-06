package pt.isec.a21240085.popoiuc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by francisco on 28-11-2016.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "popoIUC.db";
    public static final String CONTACTS_TABLE_NAME = "contacts";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*
        public ArrayList<Marca> BuscaMarca () {
            string  = "Select nome From Marcas;";
            sqLiteDatabase.execSQL(string);
            SQLiteDatabase.CursorFactory = sqLiteDatabase.rawQuery(string, )
            ArrayList<Marca> marcas = new ArrayList<Marca>();


            return marcas;


        }*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
