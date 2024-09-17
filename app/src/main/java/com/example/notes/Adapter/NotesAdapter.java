package com.example.notes.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.recyclerview.widget.RecyclerView;

import com.example.notes.AddNewTask;
import com.example.notes.MainActivity;
import com.example.notes.Model.NotesModel;
import com.example.notes.R;
import com.example.notes.Utils.DatabaseHandler;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private  DatabaseHandler db;
    private List<NotesModel> notesList;
    private MainActivity activity;
    public NotesAdapter(DatabaseHandler db,MainActivity activity){
        this.db = db;
        this.activity=activity;
    }

    public NotesAdapter(MainActivity activity){
        this.activity = activity;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout,parent,false);
        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        db.openDatabase();
        NotesModel item = notesList.get(position);
        holder.task.setText(item.getTask());
        holder.task.setChecked(toBoolean(item.getStatus()));
        holder.task.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    db.updateStatus(item.getId(),1);
                }else{
                    db.updateStatus(item.getId(),0);
                }
            }
        });
    }
    public int getItemCount(){
        return notesList.size();
    }
    public boolean toBoolean(int n){
        return n!=0;
    }
    public Context getContext() {
        return activity;
    }
    public void setTasks(List<NotesModel> notesList){
        this.notesList = notesList;
        notifyDataSetChanged();
    }
    public void deleteItem(int position) {
        NotesModel item = notesList.get(position);
        db.deleteTask(item.getId());
        notesList.remove(position);
        notifyItemRemoved(position);
    }
    public void editItem(int position){
        NotesModel item = notesList.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("id",item.getId());
        bundle.putString("task",item.getTask());
        AddNewTask fragments = new AddNewTask();
        fragments.setArguments(bundle);
        fragments.show(activity.getSupportFragmentManager(),AddNewTask.TAG);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox task;
        ViewHolder(View view){
            super(view);
            task = view.findViewById(R.id.notesCheckBox);
        }
    }
}
