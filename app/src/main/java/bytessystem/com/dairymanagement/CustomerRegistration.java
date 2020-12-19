package bytessystem.com.dairymanagement;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomerRegistration extends AppCompatActivity implements View.OnClickListener {

    EditText customer_name,customer_mobile,customer_add,customer_area;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);
        customer_name = findViewById(R.id.customer_name);
        customer_mobile = findViewById(R.id.customer_mobile);
        customer_add = findViewById(R.id.customer_add);
        customer_area = findViewById(R.id.customer_area);
        save = findViewById(R.id.save);

        save.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {

        if (view == save){

            DbHelper dbhelper = new DbHelper(this);
            SQLiteDatabase db =dbhelper.getWritableDatabase();

          String cust_name1 = customer_name.getText().toString();
          String cust_mob1= customer_mobile.getText().toString();
          String cust_add1 = customer_add.getText().toString();
          String cust_area1 = customer_area.getText().toString();

            ContentValues values = new ContentValues();
                values.put("cust_name",cust_name1);
                values.put("cust_mob",cust_mob1);
                values.put("cust_add",cust_add1);
                values.put("cust_area",cust_area1);

                long newRowId = db.insert("CUSTOMER_REG",null,values);
                Log.e("newRowId",newRowId+"");
                Toast.makeText(this,"New Customer Record Updated",Toast.LENGTH_SHORT).show();


                        }
                }


}
