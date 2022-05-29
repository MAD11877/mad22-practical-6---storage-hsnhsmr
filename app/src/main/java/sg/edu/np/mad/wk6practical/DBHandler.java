package sg.edu.np.mad.wk6practical;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Random;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context c){

        super(c,"user.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =
                "CREATE TABLE User (name TEXT, description TEXT, id TEXT, followed TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int i1) {
        db.execSQL("DROP TABLE IF EXISTS User");
        onCreate(db);
    }

    /*
    public void insertMsg(Message m){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO Message VALUES(\"" + m.username + "\", \"" + m.message + "\", \"datetime\")");
        //
         //(INSERT INTO Message VALUES("USERNAME", "MESSAGE", "DT")
         //
        db.close();
    } */

    public void insertUser(User u){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO User VALUES(\"" + u.name + "\", \"" + u.description + "\", " +
                "\"" + u.id + "\", \"" + u.followed + "\")");
        db.close();
    }

    public void updateUser(User u){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE User SET followed = \"" + u.followed + "\" WHERE name = \"" + u.name + "\"");

        db.close();
    }

    /*
    public ArrayList<Message> getMessages(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Message> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM MESSAGE", null);
        while(cursor.moveToNext())
        {
            Message m = new Message();
            m.username = cursor.getString(0);
            m.message = cursor.getString(1);
            m.dateTime = cursor.getString(2);
            list.add(m);
        }
        return list;
    }
    */

    public ArrayList<User> getUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<User> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM User", null);
        while (cursor.moveToNext()) {
            User u = new User();
            u.name = cursor.getString(0);
            u.description = cursor.getString(1);
            u.id = cursor.getInt(2);
            u.followed = cursor.getInt(3) > 0;
            list.add(u);
        }
        return list;
    }
}