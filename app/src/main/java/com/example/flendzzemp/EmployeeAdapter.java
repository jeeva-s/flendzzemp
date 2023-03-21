package com.example.flendzzemp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    // creating variables for our ArrayList and context
    private ArrayList<EmployeeModel> coursesArrayList;
    private Context context;

    // creating constructor for our adapter class
    public EmployeeAdapter(ArrayList<EmployeeModel> coursesArrayList, Context context) {
        this.coursesArrayList = coursesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // passing our layout file for displaying our card item
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.employer_adpt, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        EmployeeModel courses = coursesArrayList.get(position);
        String camelCase=UpperCamel.convertString(courses.getName());
        holder.name.setText(camelCase);
        holder.email.setText(courses.getEmail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,EmployeeDetails.class);
                intent.putExtra("name",courses.getName().toString());
                intent.putExtra("email",courses.getEmail().toString().toLowerCase(Locale.ROOT));
                intent.putExtra("id",String.valueOf(courses.getId()));
                intent.putExtra("phone",courses.getPhone().toString());
                intent.putExtra("website",courses.getWebsite().toString());
                Map<String,Object> address=courses.getAddress();
                intent.putExtra("address",address.get("street").toString());
                Map<String,Object> cAdd=courses.getCompanyAddress();

                intent.putExtra("companyAddress",cAdd.get("name").toString());

                context.startActivity(intent);
            }
        });






    }

    @Override
    public int getItemCount() {
        // returning the size of our array list.
        return coursesArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
       TextView name,email;
       CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views.
            name=itemView.findViewById(R.id.nameadpt);
            email=itemView.findViewById(R.id.emailadpt);
            cardView=itemView.findViewById(R.id.cardadpt);
//            stdName = itemView.findViewById(R.id.stdName);
//            stdclasssection = itemView.findViewById(R.id.stdclasssection);
//            stdimg = itemView.findViewById(R.id.stdimg);
          //  imageView11 = itemView.findViewById(R.id.imageView11);
        }
    }
}

