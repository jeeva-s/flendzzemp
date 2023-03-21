package com.example.flendzzemp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonplaceolderApi {
    @GET("users")
    Call<List<EmployeeModel>> getPost();
}
