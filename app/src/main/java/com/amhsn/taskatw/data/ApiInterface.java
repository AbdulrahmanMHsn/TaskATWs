package com.amhsn.taskatw.data;

import com.amhsn.taskatw.data.json.PostListResponse;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/")
    Call<PostListResponse> getAllPosts(@Query("key") String key,
                                            @Query("q") String q,
                                            @Query("image_type") String image_type);
}
