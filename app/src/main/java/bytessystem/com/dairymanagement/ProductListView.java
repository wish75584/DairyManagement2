package bytessystem.com.dairymanagement;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ProductListView extends AppCompatActivity {

    ListView prod_lv;
    ArrayList<Product> Arry_lv1;
    ArrayAdapter<Product> Arry_adp1;
    FloatingActionButton add_prod;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_view);

        add_prod = findViewById(R.id.add_prod);
        prod_lv = findViewById(R.id.prod_lv);


        add_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (ProductListView.this,AddProduct.class);
                startActivity(intent);

            }
        });


        prod_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(ProductListView.this,ProductDetails.class);
                Product C = Arry_lv1.get(i);


                intent.putExtra("P_id1",C.getP_id());
                intent.putExtra("P_name1",C.getP_name());
                intent.putExtra("P_rate1",C.getP_rate());


                Log.e("list view", C.getP_id() + "");
                Log.e("list view", C.getP_name() + "");
                Log.e("list view", C.getP_rate() + "");

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] cols = {"prod_id","prod_name","prod_rate"};

        Cursor cursor = db.query("PRODUCT",cols,"",null,"","","");

        Arry_lv1 = new ArrayList<Product>();

        while (cursor.moveToNext()){
            String Pid  = cursor.getString(cursor.getColumnIndexOrThrow("prod_id"));
            String Pname = cursor.getString(cursor.getColumnIndexOrThrow("prod_name"));
            String Prate = cursor.getString(cursor.getColumnIndexOrThrow("prod_rate"));


            Log.e("fetch data", Pid + "");
            Log.e("fetch data", Pname + "");
            Log.e("fetch data", Prate + "");

            Product c1 = new Product(""+Pid,""+Pname,""+Prate);
            Arry_lv1.add(c1);


        }
        cursor.close();
        Arry_adp1 = new ProductAdapter(this,Arry_lv1);
        prod_lv.setAdapter(Arry_adp1);


    }
}
