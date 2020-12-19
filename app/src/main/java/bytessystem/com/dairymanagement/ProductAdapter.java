package bytessystem.com.dairymanagement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter {

    ArrayList<Product> prod_adp;
    Context context;
    TextView Prod_name;



    public ProductAdapter(@NonNull Context context,ArrayList<Product> objects) {
        super(context, R.layout.product,objects);
        this.context=context;
        prod_adp = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.customer, null);
        }
        Prod_name = convertView.findViewById(R.id.cst_name);
        Prod_name.setText(prod_adp.get(position).getP_name());

        return  convertView;
    }
}

