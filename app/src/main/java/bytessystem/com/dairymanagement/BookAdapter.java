package bytessystem.com.dairymanagement;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter {

    ArrayList<Book> db_adp;
    Context context;
    TextView customer,product;



    public BookAdapter(@NonNull Context context, ArrayList<Book> objects) {
        super(context, R.layout.dailybook,objects);
        this.context=context;
        db_adp = objects;
    }

    @NonNull
    @Override
    public View getView (final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.customer, null);
        }


        customer = convertView.findViewById(R.id.customer);
        customer.setText(db_adp.get(position).getDb_name());

        product = convertView.findViewById(R.id.product);
        product.setText(db_adp.get(position).getDb_prod());

            return  convertView;
    }

}
