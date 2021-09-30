package com.itbrain.catalogmovie.activity;

import androidx.appcompat.widget.SearchView;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itbrain.catalogmovie.R;
import com.itbrain.catalogmovie.adapter.MovieAdapter;
import com.itbrain.catalogmovie.model.Responses;
import com.itbrain.catalogmovie.model.Result;
import com.itbrain.catalogmovie.rest.ApiClient;
import com.itbrain.catalogmovie.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter adapter;
    private SearchView searchView;
    String API_KEY="20f2bfce62bcd57e7152b27052e49941";
    String language = "en-US";
    String CATEGORY = "popular";
    int page = 1;
    RecyclerView recyclerview;
    List<Result> LList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.rvMovie);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new MovieAdapter(this,LList);
//        recyclerview.setAdapter(adapter);
//        mList = new ArrayList<Result>();
        CallRetrofit();
//        CRetrofit();
    }

    private void CRetrofit() {
        ApiClient.getRetrofitClient().getMovie(CATEGORY,API_KEY,language,page).enqueue(new Callback<Responses>() {
            @Override
            public void onResponse(Call<Responses> call, Response<Responses> response) {
//
                if (response.isSuccessful() && response.body() != null) {
//                    mList = re
                    List<Result> mLists ;
                    mLists = response.body().getResults();
                    adapter = new MovieAdapter(MainActivity.this,mLists);
                    recyclerview.setAdapter(adapter);
                }
//
            }

            @Override
            public void onFailure(Call<Responses> call, Throwable t) {

            }
        });
    }

    private void CallRetrofit() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Responses> call = apiInterface.getMovie(CATEGORY,API_KEY,language,page);
        call.enqueue(new Callback<Responses>() {
            @Override
            public void onResponse(Call<Responses> call, Response<Responses> response) {
//
                if (response.isSuccessful() && response.body() != null) {
//
                    List<Result> mList = response.body().getResults();
                    adapter = new MovieAdapter(MainActivity.this,mList);
                    recyclerview.setAdapter(adapter);
                }
//
            }

            @Override
            public void onFailure(Call<Responses> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.length() > 1){
                    ApiInterface apiInterface =ApiClient.getClient().create(ApiInterface.class);
                    Call<Responses> call = apiInterface.getQuery(API_KEY,language,newText,page);
                    call.enqueue(new Callback<Responses>() {
                        @Override
                        public void onResponse(Call<Responses> call, Response<Responses> response) {
                            if (response.isSuccessful() && response.body() != null) {
//                    mList = re
                                List<Result> mList = response.body().getResults();
                                adapter = new MovieAdapter(MainActivity.this,mList);
                                recyclerview.setAdapter(adapter);
                            }
                        }

                        @Override
                        public void onFailure(Call<Responses> call, Throwable t) {

                        }
                    });
                }
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}