package com.example.taskprofutenti.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.taskprofutenti.databinding.ActivityMainBinding;
import com.example.taskprofutenti.db.User;
import com.example.taskprofutenti.db.UserDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        buttonInserts();

    }



    private void buttonInserts() {
        binding.insert.setOnClickListener(v -> {
            User u = new User(binding.name.getText().toString(),binding.cognome.getText().toString(),binding.eta.getText().toString());
            UserDatabase.getInstance(getApplicationContext()).userDAO().insertAll(u);
            binding.name.setText("");
            binding.cognome.setText("");
            binding.eta.setText("");
            startActivity(new Intent(this,RecyclerActivity.class));

        });
        binding.accedi.setOnClickListener(view->startActivity(new Intent(this,RecyclerActivity.class)));


    }


}