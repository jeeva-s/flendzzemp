package com.example.flendzzemp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<EmployeeModel> employeeModels=new ArrayList<>();
    private EmployeeAdapter courseRVAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle);

        getData();





    }

    private void getData() {

        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonplaceolderApi jsonplaceolderApi=retrofit.create(JsonplaceolderApi.class);

        Call<List<EmployeeModel>> call=jsonplaceolderApi.getPost();
        call.enqueue(new Callback<List<EmployeeModel>>() {
            @Override
            public void onResponse(Call<List<EmployeeModel>> call, Response<List<EmployeeModel>> response) {
                if(response.isSuccessful()){
                    employeeModels=response.body();
                    recyclerView.setHasFixedSize(true);

                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                    // adding our array list to our recycler view adapter class.
                    courseRVAdapter = new EmployeeAdapter((ArrayList<EmployeeModel>) employeeModels, MainActivity.this);

                    // setting adapter to our recycler view.
                    recyclerView.setAdapter(courseRVAdapter);
                    Toast.makeText(MainActivity.this, ""+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<EmployeeModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}