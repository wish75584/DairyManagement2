package bytessystem.com.dairymanagement;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProductDetails extends AppCompatActivity {


    EditText P_name,P_rate;
    Button edit,update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        P_name = findViewById(R.id.P_name);
        P_rate = findViewById(R.id.P_rate);


        edit = findViewById(R.id.edit);
        update = findViewById(R.id.update);

        update.setVisibility(View.GONE);

        P_name.setTextColor(Color.BLACK);
        P_rate.setTextColor(Color.BLACK);



        P_name.setEnabled(false);
        P_rate.setEnabled(false);


        Bundle bundle = getIntent().getExtras();
        final  String Pid1 = bundle.getString("P_id1");
        final String Pname1 = bundle.getString("P_name1");
        final String Prate1 = bundle.getString("P_rate1");


        Log.e("set text", Pid1 + "");
        Log.e("set text", Pname1 + "");
        Log.e("set text", Prate1 + "");


        P_name.setText(Pname1);
        P_rate.setText(Prate1);



        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edit == view) {
                    update.setVisibility(View.VISIBLE);

                    P_name.setEnabled(true);
                    P_rate.setEnabled(true);

                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final  String P_name1 = P_name.getText().toString();
                final  String P_rate1 = P_rate.getText().toString();


                Log.e("b4 update", P_name1 + "");
                Log.e("b4 update", P_rate1 + "");

                DbHelper dbHelper = new DbHelper(ProductDetails.this);
                final SQLiteDatabase db = dbHelper.getWritableDatabase();

                String CREATE_TABLE_PRODUCT = "UPDATE PRODUCT SET prod_name ='"+P_name1+"'," +
                        " prod_rate='"+P_rate1+"' WHERE prod_id="+Pid1;
                db.execSQL(CREATE_TABLE_PRODUCT);

                Toast.makeText(ProductDetails.this,"data updated",Toast.LENGTH_LONG).show();

            }

        });
    }
}
