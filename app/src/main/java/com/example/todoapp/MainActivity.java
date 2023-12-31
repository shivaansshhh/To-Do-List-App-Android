package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnAdd;
    EditText edtTask;
    RecyclerView recyclerView;
    ViewAdapter adapter;
    ArrayList<ViewModel> arrView = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ViewModel model = new ViewModel("hello");
        arrView.add(model);


        adapter = new ViewAdapter(this, arrView);
        recyclerView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = edtTask.getText().toString();
                arrView.add(new ViewModel(task));
                adapter.notifyItemInserted(arrView.size()-1);
                edtTask.setText("");
            }
        });


    }
    public void init(){
        btnAdd = findViewById(R.id.btnAdd);
        edtTask = findViewById(R.id.edtTask);
        recyclerView = findViewById(R.id.recyclerView);

    }
}