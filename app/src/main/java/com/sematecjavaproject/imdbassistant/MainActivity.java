package com.sematecjavaproject.imdbassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtEnterTitle = findViewById(R.id.edtEnterTitle);
        Button btnSearchTitle = findViewById(R.id.btnSearchTitle);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        btnSearchTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userMovie;
                userMovie = edtEnterTitle.getText().toString();
            }
        });
    }
}
