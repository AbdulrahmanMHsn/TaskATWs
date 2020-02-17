package com.amhsn.taskatw.ui;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.amhsn.taskatw.R;
import com.amhsn.taskatw.adapter.PostAdapter;
import com.amhsn.taskatw.data.ApiClient;
import com.amhsn.taskatw.data.json.Hit;
import com.amhsn.taskatw.data.json.PostListResponse;
import com.amhsn.taskatw.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class PostPresenter {

    private static final String TAG = "PostPresenter";
    private PostView postView;
    private Context context;
    List<PostModel> listOfPosts;
    PostAdapter adapter;

     PostPresenter(PostView postView, Context context) {
        this.postView = postView;
        this.context = context;
    }

    /*
     * get data from database
     * */
     void setupCallAPI() {
        Call<PostListResponse> call = ApiClient
                .getINSTANCE()
                .getAPI()
                .getAllPosts("11778875-bd18dbcb72c8cc6ad02f06b46", "animal+love", "photo");

        call.enqueue(new Callback<PostListResponse>() {
            @Override
            public void onResponse(Call<PostListResponse> call, Response<PostListResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(context, context.getString(R.string.code) + response.code() + context.getString(R.string.message) + response.message(), Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "API Posts" + context.getString(R.string.code) + response.code() + context.getString(R.string.message) + response.message());
                    return;
                }

                PostListResponse postResponse = response.body();

                assert postResponse != null;
                List<Hit> posts = postResponse.getHits();
                postView.setList(posts);
            }

            @Override
            public void onFailure(Call<PostListResponse> call, Throwable t) {
                Toast.makeText(context, context.getString(R.string.error) + t.getMessage() , Toast.LENGTH_SHORT).show();
                Log.d(TAG, "API Posts" + context.getString(R.string.code) + t.getMessage());
            }
        });

    }

}
