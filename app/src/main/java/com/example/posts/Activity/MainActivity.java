package com.example.posts.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.posts.Adapters.PostRecyclerAdapter;
import com.example.posts.ModelClass.PostModelClass;
import com.example.posts.ModelClass.PostDModelClass;
import com.example.posts.R;
import com.example.posts.RetrofitInstance.Api;
import com.example.posts.RetrofitInstance.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    public ArrayList<PostDModelClass> postDlist = new ArrayList<>();
    private PostRecyclerAdapter.RecyclerViewClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.recview);

        ListPosts();


    }

    private void ListPosts() {
        Api api = RetrofitClient.getRetrofitInstance().create(Api.class);
        Call<PostModelClass> call = api.getData();

        call.enqueue(new Callback<PostModelClass>() {
            @Override
            public void onResponse(Call<PostModelClass> call, Response<PostModelClass> response) {
                Log.d("Response Code", "" + response.code());
                Log.d("Response body", "" + response.body());
                Log.d("Response Headers", "" + response.headers());
                Log.d("Response Message", "" + response.message());

                ArrayList<PostModelClass.data> data = response.body().getData();
                Log.d("Data is ", "" + data);

                for (PostModelClass.data data1 : data) {

                    Log.d("hi ", "" + data1.getId());
                    Log.d("hi ", "" + data1.getId());
                    Log.d("hi ", "" + data1.getTitle());
                    Log.d("hi the data is  ", "" + data1);
                    postDlist.add(new PostDModelClass(data1.getId(),
                            data1.getUser_id(),
                            data1.getTitle(),
                            data1.getBody()
                    ));

                }
                setOnClickListner(postDlist);
                PostRecyclerAdapter postRecyclerAdapter = new PostRecyclerAdapter(postDlist, listener);

                rv.setAdapter(postRecyclerAdapter);

                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv
                        .getContext(), DividerItemDecoration.VERTICAL);
                rv.addItemDecoration(dividerItemDecoration);

                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));

            }


            @Override
            public void onFailure(Call<PostModelClass> call, Throwable t) {
                Log.d("Error", "" + t.getMessage());
            }
        });
    }

    public void setOnClickListner(ArrayList<PostDModelClass> postDlist) {
        listener = new PostRecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent i = new Intent(getApplicationContext(), PostDetails.class);
                i.putExtra("post_title", postDlist.get(position).getTitle());
                i.putExtra("post_body", postDlist.get(position).getBody());

                startActivity(i);
            }
        };
    }


}
