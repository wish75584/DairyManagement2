package bytessystem.com.dairymanagement;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {

    EditText prod_name,prod_rate;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        prod_name = findViewById(R.id.prod_name);
        prod_rate = findViewById(R.id.prod_rate);
        save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbhelper = new DbHelper(AddProduct.this);
                SQLiteDatabase db =dbhelper.getWritableDatabase();

                String prod_name1 = prod_name.getText().toString();
                String prod_rate1 = prod_rate.getText().toString();


                ContentValues values = new ContentValues();
                values.put("prod_name",prod_name1);
                values.put("prod_rate",prod_rate1);


                long newRowId = db.insert("PRODUCT",null,values);
                Log.e("newRowId",newRowId+"");
                Toast.makeText(AddProduct.this,"New Customer Record Updated",Toast.LENGTH_SHORT).show();

            }
        });


    }
}
