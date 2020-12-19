package bytessystem.com.dairymanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABSE_VERSION = 1;
    public static final String DATABSE_NAME = "dairy_management";
    private static final String CREATE_TABLE_CUSTOMER_REG
            = "CREATE TABLE CUSTOMER_REG (cust_id INTEGER PRIMARY KEY AUTOINCREMENT,cust_name TEXT ,cust_mob TEXT" +
            ",cust_add TEXT,cust_area TEXT)";

    private static final String CREATE_TABLE_PRODUCT
            = "CREATE TABLE PRODUCT (prod_id INTEGER PRIMARY KEY AUTOINCREMENT,prod_name TEXT,prod_rate TEXT )";

    private static final String CREATE_TABLE_DAILY_BOOK
            = "CREATE TABLE DAILY_BOOK (book_id INTEGER PRIMARY KEY AUTOINCREMENT,cust_id REFERENCES INTEGER,prod_id  INTEGER REFERENCES TEXT,prod_rate REFERENCES TEXT)";

    public DbHelper(Context context) {
        super(context, DATABSE_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CUSTOMER_REG);
        db.execSQL(CREATE_TABLE_PRODUCT);
        db.execSQL(CREATE_TABLE_DAILY_BOOK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(CREATE_TABLE_CUSTOMER_REG);
        db.execSQL(CREATE_TABLE_PRODUCT);
        db.execSQL(CREATE_TABLE_DAILY_BOOK);
    }
}
