package com.example.taskprofutenti.adapter;

import android.app.AlertDialog;
import android.content.Context;
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

        holder.nome.setText(users.get(position).getName());
        holder.cognome.setText(users.get(position).getLastName());
        holder.eta.setText(users.get(position).getAge());
        holder.itemView.setOnLongClickListener(view -> {
            PopupMenu popup = new PopupMenu(context, view);
            popup.getMenuInflater().inflate(R.menu.menu_popup, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.modify:
/*
                        u.awesomeDialog(,context);
*/
                        break;

                    case R.id.delete:
                        UserDatabase.getInstance(context).userDAO().delete(users.get(position));
                        users.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, users.size());

                        break;
                }
                return true;
            });
            popup.show();
            return true;
        });
        holder.edit.setOnClickListener(view->{
            u.awesomeDialog((Button) ,context);

        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        MyRowBinding binding;
        TextView nome, cognome, eta;
        ImageButton edit;
        public MyViewHolder(@NonNull MyRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            nome = binding.nome;
            cognome = binding.cognome;
            eta = binding.eta;
            edit= binding.edit;

        }
    }
}
