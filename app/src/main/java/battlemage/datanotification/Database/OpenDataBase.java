package battlemage.datanotification.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by battlemage on 5/21/2017.
 */

public class OpenDataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="MYDATA";
    public static final String TABLE_NAME = "NOTES";
    public static final int DATABASE_VERSION = 15;
    private Context context;

    public OpenDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+TABLE_NAME+" (_id INTEGER PRIMARY KEY AUTOINCREMENT,TITLE TEXT,DETAILS TEXT,DATE INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + TABLE_NAME); //if previous db found, delete it exists
        onCreate(db);
    }
}
