package bytessystem.com.dairymanagement;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddCustomerProduct extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner planets_spinner1, planets_spinner2;
    ArrayList<String> Arry_lv;
    ArrayAdapter<String> Arry_adp;
    ArrayList<String> Arry_lv1;
    ArrayAdapter<String> Arry_adp1;
    Button store;
    String c_name,p_name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer_product);

        planets_spinner1 = findViewById(R.id.planets_spinner1);
        planets_spinner2 = findViewById(R.id.planets_spinner2);
        store = findViewById(R.id.store);

        planets_spinner1.setOnItemSelectedListener(this);
        planets_spinner2.setOnItemSelectedListener(this);

        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* Intent intent = new Intent (AddCustomerProduct.this,CustomerProductListView.class);
                    intent.putExtra("customer_name",c_name);
                    intent.putExtra("product_name",c_name);
                startActivity(intent);*/
            }
        });

       /*****code for spinner of customer****/

        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] cols = {"cust_id", "cust_name", "cust_mob", "cust_add", "cust_area"};

        Cursor cursor = db.query("CUSTOMER_REG", cols, "", null, "", "", "");

        Arry_lv = new ArrayList<String>();

        while (cursor.moveToNext()) {
            String Cid = cursor.getString(cursor.getColumnIndexOrThrow("cust_id"));
            String Cname = cursor.getString(cursor.getColumnIndexOrThrow("cust_name"));
            String Cmob = cursor.getString(cursor.getColumnIndexOrThrow("cust_mob"));
            String Cadd = cursor.getString(cursor.getColumnIndexOrThrow("cust_add"));
            String Carea = cursor.getString(cursor.getColumnIndexOrThrow("cust_area"));

            Log.e("fetch data", Cid + "");
            Log.e("fetch data", Cname + "");
            Log.e("fetch data", Cmob + "");
            Log.e("fetch data", Cadd + "");

            Arry_lv.add(Cname);
        }
        cursor.close();
        Arry_adp = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Arry_lv);
        planets_spinner1.setAdapter(Arry_adp);

       /*************** //code for spinner of product****************/

        String[] cols2 = {"prod_id","prod_name","prod_rate"};

        Cursor cursor2 = db.query("PRODUCT",cols2,"",null,"","","");

        Arry_lv1 = new ArrayList<String>();

        while (cursor2.moveToNext()){
            String Pid  = cursor2.getString(cursor2.getColumnIndexOrThrow("prod_id"));
            String Pname = cursor2.getString(cursor2.getColumnIndexOrThrow("prod_name"));
            String Prate = cursor2.getString(cursor2.getColumnIndexOrThrow("prod_rate"));

            Log.e("fetch data", Pid + "");
            Log.e("fetch data", Pname + "");
            Log.e("fetch data", Prate + "");

            Arry_lv1.add(Pname);


        }
        cursor.close();
        Arry_adp1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Arry_lv1);
        planets_spinner2.setAdapter(Arry_adp1);

    }


       @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(planets_spinner1.getId() == R.id.planets_spinner1) {
            c_name = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(this, c_name + "customers name", Toast.LENGTH_LONG).show();
        }
        if(planets_spinner2.getId() == R.id.planets_spinner2){
            p_name = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(this,p_name + "customers name",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}