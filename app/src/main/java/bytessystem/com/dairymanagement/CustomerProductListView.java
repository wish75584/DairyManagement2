package bytessystem.com.dairymanagement;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CustomerProductListView extends AppCompatActivity {

    FloatingActionButton add_cust_prod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_product_list_view);

        add_cust_prod = findViewById(R.id.add_cust_prod);

        add_cust_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (CustomerProductListView.this,AddCustomerProduct.class);
                startActivity(intent);

            }
        });

    }
}
