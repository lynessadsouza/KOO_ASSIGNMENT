package com.example.posts.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.posts.R;
import com.google.android.material.textview.MaterialTextView;
import com.squareup.picasso.Picasso;

public class PostDetails extends AppCompatActivity {

    MaterialTextView posttitle, postbody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        posttitle = (MaterialTextView) findViewById(R.id.posttitle);

        postbody = (MaterialTextView) findViewById(R.id.postbody);

        String information = "Not set";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            posttitle.setText(extras.getString("post_title"));
            postbody.setText(extras.getString("post_body"));

        } else {
            Log.d("name is ", "" + information);
        }

    }
}