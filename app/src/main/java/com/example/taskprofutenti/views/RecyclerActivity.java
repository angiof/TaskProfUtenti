package com.example.taskprofutenti.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.flatdialoglibrary.dialog.FlatDialog;
import com.example.taskprofutenti.R;
import com.example.taskprofutenti.adapter.My_adapter;
import com.example.taskprofutenti.databinding.ActivityRecyclerBinding;
import com.example.taskprofutenti.db.User;
import com.example.taskprofutenti.db.UserDatabase;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.refactor.lib.colordialog.PromptDialog;


public class RecyclerActivity extends AppCompatActivity {
    ActivityRecyclerBinding binding;
    private static List<User> lista = new LinkedList<>();
    My_adapter my_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecyclerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        getSupportActionBar().hide();


        dbRecived();
        adapterRecyc();
        buttonRicerca();

    }

    private void buttonRicerca() {
        final FlatDialog flatDialog= new FlatDialog(this);
        binding.ricerca.setOnClickListener(v -> {

            flatDialog
                    .setTitle("Ricerca!")
                    .setTitleColor(Color.parseColor("#078fc9"))
                    .setBackgroundColor(Color.parseColor("#f2f2f2"))
                    .setFirstTextFieldHint("email")
                    .setFirstTextFieldHintColor(Color.parseColor("#078fc9"))
                    .setFirstTextFieldTextColor(Color.parseColor("#078fc9"))
                    .setFirstTextFieldBorderColor(Color.parseColor("#078fc9"))
                    .setFirstButtonText("Inserisci")
                    .setFirstButtonColor(Color.parseColor("#078fc9"))
                    .setSecondButtonText("Esci")
                    .setSecondButtonColor(Color.parseColor("#078fc9"))
                    .withFirstButtonListner(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                          User u=UserDatabase.getInstance(getApplicationContext()).userDAO().get(flatDialog.getFirstTextField());
                            flatDialog.dismiss();
                          try {
                            new PromptDialog(RecyclerActivity.this)
                                    .setDialogType(PromptDialog.DIALOG_TYPE_SUCCESS)
                                    .setAnimationEnable(true)
                                    .setTitleText("Trovato")
                                    .setContentText(u.getEmail()+"\n"+u.getPassword())
                                    .setPositiveListener(getString(R.string.ok), new PromptDialog.OnPositiveListener() {
                                        @Override
                                        public void onClick(PromptDialog dialog) {
                                            dialog.dismiss();
                                        }
                                    }).show();
                          }catch (Exception e){
                              new PromptDialog(RecyclerActivity.this)
                                      .setDialogType(PromptDialog.DIALOG_TYPE_HELP)
                                      .setAnimationEnable(true)
                                      .setTitleText("Ops...")
                                      .setContentText("L'utente non è stato trovato")
                                      .setPositiveListener(getString(R.string.ok), new PromptDialog.OnPositiveListener() {
                                          @Override
                                          public void onClick(PromptDialog dialog) {
                                              dialog.dismiss();
                                          }
                                      }).show();


                          }

                        }
                    })
                    .withSecondButtonListner(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            flatDialog.dismiss();
                        }
                    })
                    .show();
        });
    }


    void dbRecived() {

        lista = UserDatabase.getInstance(getApplicationContext()).userDAO().getAll();
    }


    private void adapterRecyc() {
        my_adapter = new My_adapter(this, lista);
        binding.recyclerview.setAdapter(my_adapter);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));

    }


}