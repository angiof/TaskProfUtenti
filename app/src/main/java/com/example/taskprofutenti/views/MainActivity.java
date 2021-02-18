package com.example.taskprofutenti.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.flatdialoglibrary.dialog.FlatDialog;
import com.example.taskprofutenti.R;
import com.example.taskprofutenti.databinding.ActivityMainBinding;
import com.example.taskprofutenti.db.User;
import com.example.taskprofutenti.db.UserDatabase;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import cn.refactor.lib.colordialog.PromptDialog;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        getSupportActionBar().hide();




        homeInsert();


    }

    private void homeInsert() {
        final FlatDialog flatDialog= new FlatDialog(this);
        flatDialog.setIcon(R.drawable.ic_baseline_person_24)
               /* .setTitle("Salva utenti")
                .setTitleColor(Color.parseColor("#078fc9"))*/
                .setBackgroundColor(Color.parseColor("#f2f2f2"))
                .setFirstTextFieldHint("email")
                .setFirstTextFieldInputType(InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS)
                .setFirstTextFieldHintColor(Color.parseColor("#078fc9"))
                .setFirstTextFieldTextColor(Color.parseColor("#078fc9"))
                .setFirstTextFieldBorderColor(Color.parseColor("#078fc9"))
                .setSecondTextFieldHint("password")
                .setSecondTextFieldInputType(InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD)
                .setSecondTextFieldHintColor(Color.parseColor("#078fc9"))
                .setSecondTextFieldTextColor(Color.parseColor("#078fc9"))
                .setSecondTextFieldBorderColor(Color.parseColor("#078fc9"))
                .setFirstButtonText("Inserisci")
                .setFirstButtonColor(Color.parseColor("#078fc9"))
                .setSecondButtonText("Accedi")
                .setSecondButtonColor(Color.parseColor("#078fc9"))
                .withFirstButtonListner(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(flatDialog.getFirstTextField().isEmpty()||flatDialog.getSecondTextField().isEmpty()){
                            new PromptDialog(MainActivity.this)
                                    .setDialogType(PromptDialog.DIALOG_TYPE_HELP)
                                    .setAnimationEnable(true)
                                    .setTitleText("Ops...")
                                    .setContentText("Riempire tutti i campi")
                                    .setPositiveListener(getString(R.string.ok), new PromptDialog.OnPositiveListener() {
                                        @Override
                                        public void onClick(PromptDialog dialog) {
                                            dialog.dismiss();
                                        }
                                    }).show();
                        }else {
                            User u = new User(flatDialog.getFirstTextField(), flatDialog.getSecondTextField());
                            UserDatabase.getInstance(getApplicationContext()).userDAO().insertAll(u);


                            startActivity(new Intent(MainActivity.this, RecyclerActivity.class));
                        }

                    }
                })
                .withSecondButtonListner(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this,RecyclerActivity.class));
                    }
                })
                .show();

    }





}