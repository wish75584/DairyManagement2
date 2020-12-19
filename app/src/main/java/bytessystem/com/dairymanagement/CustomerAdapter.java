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

public class CustomerAdapter extends ArrayAdapter  {

    ArrayList<Customer> cust_adp;
    Context context;
    TextView cst_name;
    ImageView head,note;
      String cid,cname,cmob,cadd,carea;

    public CustomerAdapter(@NonNull Context context,ArrayList<Customer> objects) {
        super(context, R.layout.customer,objects);
        this.context=context;
        cust_adp = objects;
    }

    @NonNull
    @Override
    public View getView (final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

   if(convertView == null) {
       LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       convertView = inflater.inflate(R.layout.customer, null);
              }
            head = convertView.findViewById(R.id.head);
            note = convertView.findViewById(R.id.note);

            head.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("Inside the head","inside the head");
                    Intent intent = new Intent (context,CustomerDetails.class);
                    intent.putExtra("cid",cid);
                    intent.putExtra("cname",cname);
                    intent.putExtra("cmob",cmob);
                    intent.putExtra("cadd",cadd);
                    intent.putExtra("carea",carea);

                    Log.e("list view", cid + "");
                    Log.e("list view", cname + "");
                    Log.e("list view", cmob + "");
                    Log.e("list view", cadd+ "");
                    Log.e("list view", carea+ "");
                    context.startActivity(intent);
                }
            });
            note.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     /* Intent intent = new Intent (context,);
                        context.startActivity(intent);*/
                }
            });

            cst_name = convertView.findViewById(R.id.cst_name);
            cst_name.setText(cust_adp.get(position).getCst_name());

              cid = cust_adp.get(position).getCst_id();
             cname = cust_adp.get(position).getCst_name();
             cmob = cust_adp.get(position).getCst_mob();
             cadd = cust_adp.get(position).getCst_add();
             carea = cust_adp.get(position).getCst_area();

        return  convertView;
   }

    }


