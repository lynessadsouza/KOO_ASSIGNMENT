package com.example.posts.RetrofitInstance;


import com.example.posts.ModelClass.PostModelClass;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {



  //String BASE_URL = "https://gorest.co.in/";
  //Endpoints
  @GET("public/v1/posts")
  Call<PostModelClass> getData();


}