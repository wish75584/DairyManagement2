package bytessystem.com.dairymanagement;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerDetails extends AppCompatActivity  {

    EditText C_name,C_mob,C_add,C_area;
    Button edit,update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
            C_name = findViewById(R.id.C_name);
            C_mob = findViewById(R.id.C_mob);
            C_add = findViewById(R.id.C_add);
            C_area = findViewById(R.id.C_area);
            edit = findViewById(R.id.edit);
            update = findViewById(R.id.update);

            update.setVisibility(View.GONE);

            C_name.setTextColor(Color.BLACK);
            C_mob.setTextColor(Color.BLACK);
            C_add.setTextColor(Color.BLACK);
            C_area.setTextColor(Color.BLACK);


             C_name.setEnabled(false);
            C_mob.setEnabled(false);
            C_add.setEnabled(false);
            C_area.setEnabled(false);

            Bundle bundle = getIntent().getExtras();
            final  String Cid1 = bundle.getString("cid");
            final String Cname1 = bundle.getString("cname");
            final String Cmob1 = bundle.getString("cmob");
            final String Cadd1 = bundle.getString("cadd");
            final String Carea1 = bundle.getString("carea");

            Log.e("set text", Cid1 + "");
            Log.e("set text", Cname1 + "");
            Log.e("set text", Cmob1 + "");
            Log.e("set text", Cadd1 + "");
            Log.e("set text", Carea1 + "");

            C_name.setText(Cname1);
            C_mob.setText(Cmob1);
            C_add.setText(Cadd1);
            C_area.setText(Carea1);




        edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(edit == view) {
                        update.setVisibility(View.VISIBLE);

                        C_name.setEnabled(true);
                        C_mob.setEnabled(true);
                        C_add.setEnabled(true);
                        C_area.setEnabled(true);
                        edit.setVisibility(View.GONE);

                    }
            }
            });

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final  String C_name1 = C_name.getText().toString();
                    final  String C_mob1 = C_mob.getText().toString();
                    final  String C_add1 = C_name.getText().toString();
                    final  String C_area1 = C_area.getText().toString();

                    Log.e("b4 update", C_name1 + "");
                    Log.e("b4 update", C_mob1 + "");
                    Log.e("b4 update", C_add1 + "");
                    Log.e("b4 update", C_area1 + "");
                    DbHelper dbHelper = new DbHelper(CustomerDetails.this);
                    final SQLiteDatabase db = dbHelper.getWritableDatabase();

                 String SQL_UPDATE_CUSTOMER = "UPDATE CUSTOMER_REG SET cust_name ='"+C_name1+"'," +
                            " cust_mob='"+C_mob1+"',cust_add='"+C_add1+"',cust_area='"+C_area1+"' WHERE cust_id="+Cid1;
                    db.execSQL(SQL_UPDATE_CUSTOMER);

                    Toast.makeText(CustomerDetails.this,"data updated",Toast.LENGTH_LONG).show();

               }

            });

              }
}
