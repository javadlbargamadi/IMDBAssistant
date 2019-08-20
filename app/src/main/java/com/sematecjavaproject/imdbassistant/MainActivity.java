package com.sematecjavaproject.imdbassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.sematecjavaproject.imdbassistant.IMDBClass.IMDBMovieClass;
import com.sematecjavaproject.imdbassistant.IMDBClass.Search;

import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtEnterTitle = findViewById(R.id.edtEnterTitle);
        Button btnSearchTitle = findViewById(R.id.btnSearchTitle);
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);

        btnSearchTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userMovie;
                String urlMovieSearch;

                userMovie = edtEnterTitle.getText().toString();

                urlMovieSearch = "http://www.omdbapi.com/?s=" + userMovie + "&apikey=71d684d9";
                AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
                asyncHttpClient.get(urlMovieSearch, new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);

                        Gson gson = new Gson();

                        IMDBMovieClass imdbClass = gson.fromJson(response.toString(), IMDBMovieClass.class);
                        List<Search> searchList = imdbClass.getSearch();


                        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(searchList);
                        recyclerView.setAdapter(recyclerAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                    }
                });
            }
        });
    }
}
