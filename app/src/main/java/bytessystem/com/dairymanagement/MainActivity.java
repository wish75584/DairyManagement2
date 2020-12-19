package bytessystem.com.dairymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView create,create_prod,cust_prod;
    Button show,show_prod,show_cust_prod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create = findViewById(R.id.create);
        show = findViewById(R.id.show);
        create_prod = findViewById(R.id.create_prod);
        show_prod = findViewById(R.id.show_prod);
        cust_prod = findViewById(R.id.cust_prod);
        show_cust_prod = findViewById(R.id.show_cust_prod);

        create.setOnClickListener(this);
        show.setOnClickListener(this);
        create_prod.setOnClickListener(this);
        show_prod.setOnClickListener(this);
        cust_prod.setOnClickListener(this);
        show_cust_prod.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (create ==  view){

            Intent intent = new Intent (MainActivity.this,CustomerListView.class);
            startActivity(intent);
        }

        /*if(show ==  view) {
            Intent intent = new Intent(MainActivity.this, .class);
            startActivity(intent);
        }*/
        if (create_prod ==  view){

            Intent intent = new Intent (MainActivity.this,ProductListView.class);
            startActivity(intent);
        }

        /*if(show_prod ==  view) {
            Intent intent = new Intent(MainActivity.this, .class);
            startActivity(intent);
        }*/

        if (cust_prod ==  view){

            Intent intent = new Intent (MainActivity.this,DailyBook.class);
            startActivity(intent);
        }

       /* if(show_cust_prod ==  view) {
            Intent intent = new Intent(MainActivity.this,.class);
            startActivity(intent);
        }*/
    }
}
