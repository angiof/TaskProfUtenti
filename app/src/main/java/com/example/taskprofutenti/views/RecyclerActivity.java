package com.example.taskprofutenti.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;

import com.example.taskprofutenti.adapter.My_adapter;
import com.example.taskprofutenti.databinding.ActivityRecyclerBinding;
import com.example.taskprofutenti.db.User;
import com.example.taskprofutenti.db.UserDatabase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    ActivityRecyclerBinding binding;
    private static List<User> lista = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecyclerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbRecived();
        adapterRecyc();


    }


    void dbRecived() {

       lista=UserDatabase.getInstance(getApplicationContext()).userDAO().getAll();
    }


    private void adapterRecyc() {
        My_adapter my_adapter = new My_adapter(this, lista);
        binding.recyclerview.setAdapter(my_adapter);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }


}