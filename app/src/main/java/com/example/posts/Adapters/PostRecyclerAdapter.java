package com.example.posts.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.posts.ModelClass.PostDModelClass;
import com.example.posts.R;

import java.util.ArrayList;


public class PostRecyclerAdapter extends RecyclerView.Adapter<PostRecyclerAdapter.ViewHolder> {

    public ArrayList<PostDModelClass> postDModelClass__list;
    private RecyclerViewClickListener listener;

    public PostRecyclerAdapter(ArrayList<PostDModelClass> postDModelClass__list, RecyclerViewClickListener listener) {
        this.postDModelClass__list = postDModelClass__list;
        this.listener = listener;
    }


    @NonNull
    @Override
    public PostRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.post_itemlist, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull PostRecyclerAdapter.ViewHolder holder, int position) {

       holder.post_title.setText(postDModelClass__list.get(position).getTitle() );
         holder.post_body.setText(postDModelClass__list.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return postDModelClass__list.size();
    }


    public interface RecyclerViewClickListener {
        void onClick(View v, int position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView post_title, post_body;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            post_title = itemView.findViewById(R.id.post_title);
            post_body = itemView.findViewById(R.id.post_body);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            Log.d("You clicked", "" + getAdapterPosition());
            listener.onClick(view, getAdapterPosition());
        }
    }



}
