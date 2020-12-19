package bytessystem.com.dairymanagement;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;

public class CustomerListView extends AppCompatActivity {

    ListView customer_lv;
    ArrayList<Customer> Arry_lv;
    ArrayAdapter<Customer> Arry_adp;
    FloatingActionButton add_cust;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list_view);
        add_cust = findViewById(R.id.add_cust);
        customer_lv = findViewById(R.id.customer_lv);


        add_cust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (CustomerListView.this,CustomerRegistration.class);
                startActivity(intent);

            }
        });
                             }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] cols = {"cust_id","cust_name","cust_mob","cust_add","cust_area"};

        Cursor cursor = db.query("CUSTOMER_REG",cols,"",null,"","","");

        Arry_lv = new ArrayList<Customer>();

                while (cursor.moveToNext()){
                    String Cid  = cursor.getString(cursor.getColumnIndexOrThrow("cust_id"));
                    String Cname = cursor.getString(cursor.getColumnIndexOrThrow("cust_name"));
                    String Cmob = cursor.getString(cursor.getColumnIndexOrThrow("cust_mob"));
                    String Cadd = cursor.getString(cursor.getColumnIndexOrThrow("cust_add"));
                    String Carea = cursor.getString(cursor.getColumnIndexOrThrow("cust_area"));

                    Log.e("fetch data", Cid + "");
                    Log.e("fetch data", Cname + "");
                    Log.e("fetch data", Cmob + "");
                    Log.e("fetch data", Cadd + "");
                    Customer c1 = new Customer(""+Cname,""+Cmob,""+Cadd,""+Carea,""+Cid);
                    Arry_lv.add(c1);


                }
                cursor.close();
                Arry_adp = new CustomerAdapter(this,Arry_lv);
                customer_lv.setAdapter(Arry_adp);
}
}
