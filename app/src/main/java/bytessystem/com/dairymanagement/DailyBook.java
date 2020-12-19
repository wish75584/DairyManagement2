package bytessystem.com.dairymanagement;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DailyBook extends AppCompatActivity {


    ListView db_lv;
    ArrayList<Book> Arry_lv2;
    ArrayAdapter<Book> Arry_adp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_book);

        db_lv = findViewById(R.id.db_lv);

    }
        @Override
        protected void onPostResume() {
            super.onPostResume();

            DbHelper dbHelper = new DbHelper(this);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            String[] cols = {"book_id","book_name","book_prod"};

            Cursor cursor = db.query("DAILY_BOOK",cols,"",null,"","","");

            Arry_lv2 = new ArrayList<Book>();

            while (cursor.moveToNext()){
                int dbid  = cursor.getInt(cursor.getColumnIndexOrThrow("book_id"));
                String dbname = cursor.getString(cursor.getColumnIndexOrThrow("book_name"));
                String dbprod = cursor.getString(cursor.getColumnIndexOrThrow("book_prod"));

                Log.e("fetch data", dbid + "");
                Log.e("fetch data", dbname + "");
                Log.e("fetch data", dbprod + "");
                Book b1 = new Book(""+dbname,""+dbprod,""+dbid);
                Arry_lv2.add(b1);
            }
            cursor.close();
            Arry_adp2 = new BookAdapter(this,Arry_lv2);
            db_lv.setAdapter(Arry_adp2);

        }

    }

