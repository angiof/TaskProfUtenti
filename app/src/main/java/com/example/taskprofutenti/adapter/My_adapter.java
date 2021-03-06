package com.example.taskprofutenti.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flatdialoglibrary.dialog.FlatDialog;
import com.example.taskprofutenti.R;
import com.example.taskprofutenti.Utility.Utility;
import com.example.taskprofutenti.databinding.MyRowBinding;
import com.example.taskprofutenti.db.User;
import com.example.taskprofutenti.db.UserDatabase;
import com.example.taskprofutenti.views.MainActivity;
import com.example.taskprofutenti.views.RecyclerActivity;

import java.util.List;

public class My_adapter extends RecyclerView.Adapter<My_adapter.MyViewHolder> {
    Utility u = new Utility();
    List<User> users;
    Context context;


    public My_adapter(Context ct, List<User> u) {
        context = ct;
        users = u;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(MyRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.email.setText(users.get(position).getEmail());
        holder.password.setText(users.get(position).getPassword());

        holder.itemView.setOnLongClickListener(view -> {
            PopupMenu popup = new PopupMenu(context, view);
            popup.getMenuInflater().inflate(R.menu.menu_popup, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.modify:
                        final FlatDialog flatDialog = new FlatDialog(context);
                        flatDialog.setTitle("Modifica")
                                .setTitleColor(Color.parseColor("#078fc9"))
                                .setBackgroundColor(Color.parseColor("#f2f2f2"))
                                .setFirstTextFieldHint(users.get(position).getEmail())
                                .setFirstTextFieldHintColor(Color.parseColor("#078fc9"))
                                .setFirstTextFieldTextColor(Color.parseColor("#078fc9"))
                                .setFirstTextFieldBorderColor(Color.parseColor("#078fc9"))
                                .setSecondTextFieldHint(users.get(position).getPassword())
                                .setSecondTextFieldHintColor(Color.parseColor("#078fc9"))
                                .setSecondTextFieldTextColor(Color.parseColor("#078fc9"))
                                .setSecondTextFieldBorderColor(Color.parseColor("#078fc9"))
                                .setFirstButtonText("modifica")
                                .setFirstButtonColor(Color.parseColor("#078fc9"))
                                .setSecondButtonText("esci")
                                .setSecondButtonColor(Color.parseColor("#078fc9"))
                                .withFirstButtonListner(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        User u = new User( flatDialog.getFirstTextField(),flatDialog.getSecondTextField());
                                        UserDatabase.getInstance(context).userDAO().updateUser(flatDialog.getFirstTextField(),flatDialog.getSecondTextField(),users.get(position).getID());
                                        users.set(position,u);
                                        notifyItemChanged(position);
                                        flatDialog.dismiss();
                                        /*users.set(position,)*/
                                    }
                                })
                                .withSecondButtonListner(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        flatDialog.dismiss();
                                    }
                                })
                                .show();
                        break;

                    case R.id.delete:
                        UserDatabase.getInstance(context).userDAO().delete(users.get(position));
                        users.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, users.size());
                         u.awesomeDialogDelete(context);
                        break;
                }
                return true;
            });
            popup.show();
            return true;
        });



    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        MyRowBinding binding;
        TextView email, password;



        public MyViewHolder(@NonNull MyRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            email = binding.email1;
            password = binding.password1;



        }
    }


}
