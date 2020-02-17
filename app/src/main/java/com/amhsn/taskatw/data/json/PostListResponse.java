package com.amhsn.taskatw.data.json;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostListResponse {

    @SerializedName("total")
    @Expose
    private int total;
    @SerializedName("totalHits")
    @Expose
    private int totalHits;
    @SerializedName("hits")
    @Expose
    private List<Hit> hits = null;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

}
