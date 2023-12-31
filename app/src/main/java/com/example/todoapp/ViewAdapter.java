package com.example.todoapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {
    Context context;
    ArrayList<ViewModel> arrModel;
    ViewAdapter(Context context, ArrayList<ViewModel> arrModel){
        this.context = context;
        this.arrModel = arrModel;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =LayoutInflater.from(context).inflate(R.layout.view_layout, parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtView.setText(arrModel.get(position).task);

        holder.imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete task")
                        .setMessage("Are you sure  ?")
                        .setIcon(R.drawable.baseline_delete_24)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrModel.remove(position);
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position, arrModel.size());
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                builder.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtView;
        ImageButton imgBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtView = itemView.findViewById(R.id.txtView);
            imgBtn = itemView.findViewById(R.id.imgBtn);


        }
    }
}
