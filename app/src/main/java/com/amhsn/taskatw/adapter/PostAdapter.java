package com.amhsn.taskatw.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amhsn.taskatw.R;
import com.amhsn.taskatw.data.json.Hit;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Hit> list = new ArrayList<>();
    private Context context;

    public PostAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_post, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.txtVw_userName.setText(list.get(position).getUser());
        holder.txtVw_postLikes.setText(String.valueOf(list.get(position).getLikes()));
        Picasso.with(context).load(list.get(position).getLargeImageURL()).fit().centerInside().into(holder.img_postImg);
        Picasso.with(context).load(list.get(position).getUserImageURL()).fit().centerInside().into(holder.img_userImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Hit> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        TextView txtVw_userName, txtVw_postLikes;
        ImageView img_postImg, img_userImg;

        PostViewHolder(@NonNull View itemView) {
            super(itemView);
            txtVw_userName = itemView.findViewById(R.id.postItem_txtVw_userName);
            txtVw_postLikes = itemView.findViewById(R.id.postItem_txtVw_postLikes);
            img_postImg = itemView.findViewById(R.id.postItem_img_postImg);
            img_userImg = itemView.findViewById(R.id.postItem_img_userImg);
        }
    }
}
